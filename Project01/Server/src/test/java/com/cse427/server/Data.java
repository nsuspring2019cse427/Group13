package com.cse427.server;

import com.cse427.server.Model.User;

import java.util.List;

public class Data {
    List<User> users;

    public Data() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
