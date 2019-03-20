package com.cse427.server.Utils;


import com.cse427.server.Model.User;
import org.apache.commons.validator.routines.EmailValidator;

public class CommonUtils {

    public boolean validateUserName(User user) {

        return !user.getUserName().isEmpty();
    }

    public boolean validateUserPassword(User user) {

        return user.getPassword() != null && !user.getPassword().isEmpty() && user.getPassword().length() > 7;
    }

    public boolean validateUserEmail(User user) {
        final String emailLastPart = "@northsouth.edu";

        if (user != null && user.getEmail() != null) {
            boolean valid = EmailValidator.getInstance().isValid(user.getEmail());
            if (valid) {
                return user.getEmail().toLowerCase().endsWith(emailLastPart);
            }
        }
        return false;
    }
}
