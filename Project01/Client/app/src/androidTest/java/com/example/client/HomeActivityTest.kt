package com.example.client

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.concurrent.thread


@RunWith(AndroidJUnit4::class)
@LargeTest
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
        onView(withId(R.id.loginButton)).check(matches(isClickable()))
        onView(withId(R.id.signUpButton)).perform(click())
    }


}