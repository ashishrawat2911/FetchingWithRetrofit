package com.example.ashish.fetchingwithretrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 4/21/2018.
 */

public class UsersRecyclerViewAdaptor extends RecyclerView.Adapter<UsersRecyclerViewAdaptor.MyViewHolder> {
    Context ctx;
    private List<UsersModel> modelsList;

    public UsersRecyclerViewAdaptor(Context ctx, List<UsersModel> modelsList) {
        this.ctx = ctx;
        this.modelsList = modelsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(ctx).inflate(R.layout.users_item_list, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.id.setText(modelsList.get(position).getId());
        holder.name.setText(modelsList.get(position).getName());
        holder.username.setText(modelsList.get(position).getUsername());

    }

    @Override
    public int getItemCount() {
        return modelsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView id, name, username;

        public MyViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            username = itemView.findViewById(R.id.username);
        }
    }
}
