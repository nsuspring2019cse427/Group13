package com.cse427.server.Controller;

import com.cse427.server.Model.User;
import com.cse427.server.Repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;
    private User user;


    @Before
    public void setUp() {
        user = new User("Majedur.rahman.mmr@NorthSouth.edu", "MajedurRahman", "81237287s8d", true);

    }

    @Test
    public void signUpUser() throws Exception {
        given(userRepository.getUserByUserNameAndActive("MajedurRahman", true)).willReturn(Optional.of(user));
        given(userRepository.save(user)).willReturn(user);

        mockMvc.perform(post("/public/signUp").param("email", user.getEmail())
                .param("userName", user.getUserName()).param("password", user.getPassword()).param("isActive", "true"))
                .andExpect(status().isOk())
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    public void getAllActiveUser() throws Exception {
        System.out.println(user.toString());
        List<User> userArrayList = new ArrayList<>();
        userArrayList.add(user);
        given(userRepository.getUserByActiveIsTrue()).willReturn(userArrayList);


        mockMvc.perform(get("/public/getAll"))
                .andExpect(status().isOk())
                .andExpect(status().is2xxSuccessful());

    }
}