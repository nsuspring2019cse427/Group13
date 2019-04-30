package com.cse427.server.Controller;


import com.cse427.server.Model.ResponseCommon;
import com.cse427.server.Model.User;
import com.cse427.server.Repository.UserRepository;
import com.cse427.server.Utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/public")
public class UserController {


    UserRepository userRepository;


    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/signUp")
    public ResponseCommon<User> signUpUser(@RequestBody User user) {
        try {

            boolean userNameValid = new CommonUtils().validateUserName(user);
            boolean userPassValid = new CommonUtils().validateUserPassword(user);


            if (userNameValid && userPassValid) {

                Optional<User> userByUserNameAndActive = userRepository.getUserByUserName(user.getUserName());
                if (userByUserNameAndActive.isPresent()) {
                    return new ResponseCommon<User>(false, "UserName Already Exits", null);
                } else {
                    User savedUser = userRepository.save(user);
                    return new ResponseCommon<User>(true, "", savedUser);
                }

            } else {

                String result = "";
                if (userNameValid) {
                    result = "User Name Not Valid";

                } else if (userPassValid) {
                    result = "User Pass Not Valid";
                }
                return new ResponseCommon<User>(false, result, null);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseCommon<User>(true, ex.getMessage(), null);
        }
    }


    @GetMapping("/getAll")
    public List<User> getAllActiveUser() {
        return userRepository.getUserByActiveIsTrue();
    }


}
