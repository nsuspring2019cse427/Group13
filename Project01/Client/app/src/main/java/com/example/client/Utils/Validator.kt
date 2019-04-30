package com.example.client.Utils

import org.apache.commons.validator.routines.EmailValidator


class Validator {

    fun validateUserInfo(username: String, email: String, password: String, confirmPassword: String): Boolean {


        if (username.isNullOrEmpty() || username.length < 5) {
            return false
        }


        if (username.contains("@") || username.contains(">") || username.contains("<") || username.contains("-")) {
            return false
        }


        if (password.isNullOrEmpty() || password.length < 8) {
            return false
        }


        if (confirmPassword.isNullOrEmpty() || confirmPassword.length < 8) {

            return true
        }


        if (email.isNullOrEmpty()) {
            return false
        }


        if (password != confirmPassword) {
            return false
        }


        if (!EmailValidator.getInstance().isValid(email)) {
            return false
        }

        return true

    }

}