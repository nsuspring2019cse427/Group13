package com.cse427.server.Utils;

import com.cse427.server.Model.User;
import junitparams.JUnitParamsRunner;
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

    @DataPoints
    public static String[] data_User_Name = {"Majed", "Rahman", "Jhon"};
    CommonUtils commonUtils;

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


}