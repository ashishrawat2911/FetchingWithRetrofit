package com.example.ashish.fetchingwithretrofit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<UsersModel> usersModelsList;
    Retrofit retrofit;
    RecyclerView recyclerView;
    UsersRecyclerViewAdaptor usersRecyclerViewAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usersModelsList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getUsers();
    }

    private void getUsers() {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();
        retrofit = new Retrofit
                .Builder()
                .baseUrl(UsersApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UsersApi api = retrofit.create(UsersApi.class);
        Call<List<UsersModel>> call = api.getUsers();
        call.enqueue(new Callback<List<UsersModel>>() {
            @Override
            public void onResponse(Call<List<UsersModel>> call, Response<List<UsersModel>> response) {

                pd.dismiss();
                List<UsersModel> usersModels = response.body();
                assert usersModels != null;
                for (UsersModel u : usersModels) {
                    UsersModel model = new UsersModel(u.getId(), u.getName(), u.getUsername());
                    usersModelsList.add(model);
                }
                usersRecyclerViewAdaptor = new UsersRecyclerViewAdaptor(getApplicationContext(), usersModelsList);
                recyclerView.setAdapter(usersRecyclerViewAdaptor);

            }

            @Override
            public void onFailure(Call<List<UsersModel>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
