package com.example.client

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.EditText
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @Rule
    @JvmField
    val rule = ActivityTestRule(LoginActivity::class.java)


    val email: String = "Majedur.Rahman@Northsouth.edu"
    val password: String = "secretPass"


    @Test
    fun isInitialComponentVisibleTest() {
        onView(withId(R.id.emailEdittext)).check(matches(isDisplayed()))
        onView(withId(R.id.passwordEdittext)).check(matches(isDisplayed()))
        onView(withId(R.id.signInButton)).check(matches(isDisplayed()))
    }


    @Test
    fun loginButtonPressedTest() {


        onView(withId(R.id.emailEdittext)).check(matches(isFocusable()))
        onView(withId(R.id.emailEdittext)).perform(typeText(email), closeSoftKeyboard())

        onView(withId(R.id.passwordEdittext)).perform(typeText(password), closeSoftKeyboard())
        onView(withId(R.id.passwordEdittext)).check(matches(isPasswordHidden()))


        onView(withId(R.id.signInButton)).perform(click())
        val data: EditText? = rule.activity.findViewById<EditText>(R.id.emailEdittext)



        onView(withId(R.id.emailEdittext)).check(matches(withText(data!!.text.toString())))
        onView(withId(R.id.emailEdittext)).check(matches(withText(email)))
    }

    private fun isPasswordHidden(): Matcher<View> {
        return object : BoundedMatcher<View, EditText>(EditText::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("Password is hidden")
            }

            public override fun matchesSafely(editText: EditText): Boolean {
                return editText.transformationMethod is PasswordTransformationMethod
            }
        }
    }
}