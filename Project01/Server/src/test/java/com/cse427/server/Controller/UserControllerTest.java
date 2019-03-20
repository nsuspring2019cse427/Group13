package com.cse427.server.Controller;

import com.cse427.server.Model.User;
import com.cse427.server.Repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void signUpUser() throws Exception {
        User value = new User("Majedur.rahman.mmr@NorthSouth.edu", "MajedurRahman", "81237287s8d", true);
        given(userRepository.getUserByUserNameAndActive("MajedurRahman", true)).willReturn(Optional.of(value));
        given(userRepository.save(value)).willReturn(value);

        mockMvc.perform(post("/public/signUp").param("email", value.getEmail())
                .param("userName", value.getUserName()).param("password", value.getPassword()).param("isActive", "true"))
                .andExpect(status().isOk())
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    public void getAllActiveUser() {
    }
}