package com.example.ashish.fetchingwithretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by admin on 4/21/2018.
 */

public interface UsersApi {
    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("users")
    Call<List<UsersModel>> getUsers();
}
