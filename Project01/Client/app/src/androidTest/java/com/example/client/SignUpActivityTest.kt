package com.example.client

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.EditText
import com.example.client.Activity.SignUpActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
 class SignUpActivityTest {

    @Rule
    @JvmField
    val rule = ActivityTestRule(SignUpActivity::class.java)


    private val userName: String = "MajedurMmr"
    private val email: String = "Rahman@Northsouth.edu"
    private val password: String = "s3cretPa5s"


    @Test
    fun isInitialComponentVisibleTest() {
        Espresso.onView(ViewMatchers.withId(R.id.userNameET)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.emailET)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.passwordET)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.confirmPasswordEt)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.signUpBtn)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


    @Test
    fun loginButtonPressedTest() {


        Espresso.onView(ViewMatchers.withId(R.id.userNameET)).check(ViewAssertions.matches(ViewMatchers.isFocusable()))
        Espresso.onView(ViewMatchers.withId(R.id.userNameET)).perform(ViewActions.typeText(userName), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.emailET)).check(ViewAssertions.matches(ViewMatchers.isFocusable()))
        Espresso.onView(ViewMatchers.withId(R.id.emailET)).perform(ViewActions.typeText(email), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.passwordET)).perform(ViewActions.typeText(password), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.passwordET)).check(ViewAssertions.matches(isPasswordHidden()))


        Espresso.onView(ViewMatchers.withId(R.id.confirmPasswordEt)).perform(ViewActions.typeText(password), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.confirmPasswordEt)).check(ViewAssertions.matches(isPasswordHidden()))


        val confirmEt: EditText? = rule.activity.findViewById<EditText>(R.id.confirmPasswordEt)
        Espresso.onView(ViewMatchers.withId(R.id.passwordET)).check(ViewAssertions.matches(ViewMatchers.withText(confirmEt!!.text.toString())))

        Espresso.onView(ViewMatchers.withId(R.id.signUpBtn)).perform(ViewActions.click())
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