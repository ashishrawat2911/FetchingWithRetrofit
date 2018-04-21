package com.example.ashish.fetchingwithretrofit;

/**
 * Created by ashish on 4/21/2018.
 */

public class UsersModel {
    private String id;
    private String name;
    private String username;

    public UsersModel(String id, String name, String username) {
        this.id = id;
        this.name = name;
        this.username = username;

    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }


}
