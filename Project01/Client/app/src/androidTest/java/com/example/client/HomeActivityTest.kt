package com.example.client

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.client.Activity.HomeActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class HomeActivityTest {
    @Rule
    @JvmField
    val rule = ActivityTestRule(HomeActivity::class.java)


    @Test
    fun isInitialComponentVisibleTest() {

        onView(withId(R.id.loginButton)).check(matches(isDisplayed()))
        onView(withId(R.id.signUpButton)).check(matches(isDisplayed()))

    }



    @Test
    fun loginButtonClickTest(){

        onView(withId(R.id.loginButton)).check(matches(isClickable()))
        onView(withId(R.id.loginButton)).perform(click())
    }

    @Test
    fun signUpButtonClickTest(){
        onView(withId(R.id.signUpButton)).check(matches(isClickable()))
        onView(withId(R.id.signUpButton)).perform(click())
    }


}