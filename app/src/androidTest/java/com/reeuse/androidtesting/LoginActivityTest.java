package com.reeuse.androidtesting;

import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;

import com.reeuse.androidtesting.view.activities.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Rajiv M.
 */
@RunWith(JUnit4.class)
@LargeTest
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> loginActivityActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void onSubmitClick() {
        onView(withId(R.id.login_username_et)).perform(typeText("android"));
        onView(withId(R.id.login_password_et)).perform(typeText("android"));
        onView(withId(R.id.login_sign_in_btn)).perform(click());
    }
}


