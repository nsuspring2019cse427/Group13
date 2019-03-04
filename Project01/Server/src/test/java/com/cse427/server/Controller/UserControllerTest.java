package com.cse427.server.Controller;

import com.cse427.server.Model.ResponseCommon;
import com.cse427.server.Model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;


public class UserControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserController service;

    @Test
    public void signUpUser() throws Exception {


        User user = new User();
        user.setUserName("M");


        User result = new User();
        result.setUserName("M");
        result.setId(Long.parseLong(1 + ""));

        ResponseCommon<User> methodCall = service.signUpUser(user);
        given(methodCall).willReturn(new ResponseCommon<User>(true, "", result));


    }
}