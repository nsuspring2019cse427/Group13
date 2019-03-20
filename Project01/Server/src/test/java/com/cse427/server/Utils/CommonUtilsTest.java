package com.cse427.server.Utils;

import com.cse427.server.Model.User;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CommonUtilsTest {

    CommonUtils commonUtils;

    @DataPoints
    public static String[] data_User_Name = {"Majed", "Rahman", "Jhon"};

    @Parameterized.Parameters
    public static Iterable<? extends Object> data() {
        return Arrays.asList("first test", "second test");
    }

    @Before
    public void setUp() {
        commonUtils = new CommonUtils();

    }

    @Test
    @Theory
    public void validateUserName(String name) {
        System.out.println(name);
        User user = new User();
        user.setUserName(name);
        user.setPassword("PassWord");
        user.setActive(true);

        boolean result = commonUtils.validateUserName(user);

        assertEquals(true, result);

    }

    @Test
    @Parameters({
            "289829829289",
            "782787287",
            "shjhjsoi2"
    })
    public void validateUserPasswordValidCondition(String pass) {
        System.out.println(pass);
        User user = new User();
        user.setUserName("Majedur");
        user.setPassword(pass);
        user.setActive(true);

        boolean result = commonUtils.validateUserPassword(user);

        assertEquals(true, result);

    }
}