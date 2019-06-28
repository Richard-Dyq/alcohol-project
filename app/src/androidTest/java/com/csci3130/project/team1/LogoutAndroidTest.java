package com.csci3130.project.team1;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LogoutAndroidTest {
    @Rule
    public ActivityTestRule<HomeActivity> activityRule
            = new ActivityTestRule<>(HomeActivity.class);
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.csci3130.project.team1", appContext.getPackageName());
    }

    /**
     * This method tests if the logout function is correct
     */
    @Test
    public void logoutTest() {

        onView(withId(R.id.logout)).perform(click());
        onView(withId(R.id.logout)).perform(click());
        onView(withId(R.id.logout)).check(matches(withText("login")));

    }
}


