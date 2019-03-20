package com.cse427.server.Utils;

import com.cse427.server.model.User;
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

    public static final String DEFAULT_EMAIL = "majedur.rahman@northsouth.edu";
    public static final String DEFAULT_PASSWORD = "PassWord";
    public static final String DEFAULT_USER_NAME = "MajedurRahman";

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
        user.setEmail(DEFAULT_EMAIL);
        user.setPassword(DEFAULT_PASSWORD);
        user.setActive(true);

        boolean result = commonUtils.validateUserName(user);

        assertEquals(expected, result);

    }


    /**
     * @params {password ,expected } will inject from Parameters Annotation Item value
     * ->  {"782787287 , true"} [0] -> PasswordParameter [1] -> expectedParameter
     */
    @Test
    @Parameters(value = {
            "289829829289 , true",
            "782787287 , true",
            "shjhjsoi2 , true",
            "123 , false",
            " , false",
            "as112 , false",
    })
    public void validateUserPassword(String password, boolean expected) {
        System.out.println("validateUserPasswordValidCondition : " + password);
        User user = new User();
        user.setUserName(DEFAULT_USER_NAME);
        user.setEmail(DEFAULT_EMAIL);
        user.setPassword(password);
        user.setActive(true);

        boolean result = commonUtils.validateUserPassword(user);
        assertEquals(expected, result);
    }


    /**
     * @params {email , expected} will inject from Parameters Annotation Item value
     * ->  {"1420497042@northsouth.edu , true"} [0] -> PasswordParameter [1] -> expectedParameter
     */
    @Test
    @Parameters(value = {
            "majedur.rahman@northsouth.edu , true",
            "majedurz@northsouth.edu , true",
            "1420497042@northsouth.edu , true",
            "majedur@gmail.com , false",
            "gmail.com , false",
            "majedur.rahman , false",
            " , false",
            "@, false",
            "northsouth.edu, false",
            "@northsouth.edu, false",
            "maj;edur@northsouth.edu, false",
            "majedur@northsouth.edu.bd, false",
            DEFAULT_USER_NAME + ", false",
            DEFAULT_PASSWORD + ", false",
            DEFAULT_EMAIL + ", true",

    })
    public void validateUserEmail(String email, boolean expected) {

        System.out.println("validateUserEmail : " + email);

        User user = new User();
        user.setUserName(DEFAULT_USER_NAME);
        user.setPassword(DEFAULT_PASSWORD);
        user.setEmail(email);
        user.setActive(true);

        boolean result = commonUtils.validateUserEmail(user);

        assertEquals(expected, result);

    }


}