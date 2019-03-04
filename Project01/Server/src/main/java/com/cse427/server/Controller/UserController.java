package com.cse427.server.Controller;


import com.cse427.server.Model.ResponseCommon;
import com.cse427.server.Model.User;
import com.cse427.server.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/public")
public class UserController {


    @Autowired
    UserRepository userRepository;


    @PostMapping("/signUp")
    public ResponseCommon<User> signUpUser(User user) {

        try {

            Optional<User> userByUserNameAndActive = userRepository.getUserByUserNameAndActive(user.getUserName(), true);

            if (userByUserNameAndActive.isPresent()) {
                return new ResponseCommon<User>(false, "UserName Already Exits", null);

            } else {

                User savedUser = userRepository.save(user);
                return new ResponseCommon<User>(true, "", savedUser);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseCommon<User>(true, ex.getMessage(), null);
        }


    }
}