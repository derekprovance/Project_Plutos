package com.derekprovance.data;

import com.derekprovance.data.models.User;

public class UserSingleton {
    private static UserSingleton instance = null;
    private static User user = null;

    protected UserSingleton() {}

    public static UserSingleton getInstance() {
        if(instance == null) {
            instance = new UserSingleton();
        }

        return instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        UserSingleton.user = user;
    }
}
