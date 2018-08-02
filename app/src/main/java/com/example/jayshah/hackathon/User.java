package com.example.jayshah.hackathon;

public class User {

    public String uid;
    public String username;

    public User(String uid,String username) {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
        this.uid=uid;
        this.username=username;
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


    public String getUsername() {
        return username;
    }


}
