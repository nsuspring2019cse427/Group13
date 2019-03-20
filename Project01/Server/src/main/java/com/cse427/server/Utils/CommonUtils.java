package com.cse427.server.Utils;

import com.cse427.server.Model.User;

public class CommonUtils {

    public boolean validateUserName(User user) {

        return !user.getUserName().isEmpty();
    }

    public boolean validateUserPassword(User user) {


        return user.getPassword() == null || !user.getPassword().isEmpty() || user.getPassword().length() >= 7;
    }
}
