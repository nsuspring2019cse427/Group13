package com.cse427.server.Utils;

import com.cse427.server.Model.User;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CommonUtilsTest {

    CommonUtils commonUtils;

    @DataPoints
    public static String[] Data_User_Name = {"Majed", "Rahman", "Jhon"};

    @Before
    public void setUp() {
        commonUtils = new CommonUtils();

    }


    /**
     * @params {name} will come from Params values with expected result
     * ->  {"MajedurRahman , false"} [0] -> NameParameter [1] -> expectedParameter
     */
    @Test
    @Parameters(value = {
            "MajedurRahman , true",
            "Majedur , true",
            " , false",
            "Majedur , true",
    })
    public void validateUserName(String name, boolean expected) {
        System.out.println("validateUserName : " + name);
        User user = new User();
        user.setUserName(name);
        user.setPassword("PassWord");
        user.setActive(true);

        boolean result = commonUtils.validateUserName(user);

        assertEquals(expected, result);

    }


    /**
     * @params {password} will inject from Parameters Annotation Item value
     */
    @Test
    @Parameters(value = {
            "289829829289",
            "782787287",
            "shjhjsoi2"

    })
    public void validateUserPasswordValidCondition(String password) {
        System.out.println("validateUserPasswordValidCondition : " + password);
        User user = new User();
        user.setUserName("Majedur");
        user.setPassword(password);
        user.setActive(true);

        boolean result = commonUtils.validateUserPassword(user);
        assertEquals(true, result);
    }


}