package com.cse427.server.Repository;

import com.cse427.server.Model.User;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;


@RunWith(JUnitParamsRunner.class)
public class UserRepositoryTest {


    @Mock
    private UserRepository userRepository;
    @Mock
    private RestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        initMocks(this);


    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    @Parameters(value = {
            "MajedurRahman , true , Majedur.Rahman.mmr@gmail.com , asd89sa9d8s",
            "Majedur.Rahman , false , Majedur.Rahman.mmr@Northsouth.edu , 2323232",
            "Monit , true , mmr@gmail.com , smdsnmd",
    })
    public void getUserByUserNameAndActive(String nameUser, boolean isActive, String eamil, String pass) {
        User user = new User(eamil, nameUser, pass, isActive);
        System.out.println(user.toString());
        given(userRepository.getUserByUserNameAndActive(nameUser, isActive)).willReturn(Optional.of(user));


        Optional<User> userByUserNameAndActive = userRepository.getUserByUserNameAndActive(nameUser, isActive);

        assertEquals(userByUserNameAndActive, Optional.of(user));

    }
}