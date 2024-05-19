package com.example.mosquelocalizationapplication;

import android.content.Context;

// user data model
public class User extends DatabaseHelper {
    private int id;
    private String name;
    private String password;

    public User(Context context) {
        super(context);
    }

    // getters and setters for aech field

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public String getPassword() {
        return password;
    }
}
