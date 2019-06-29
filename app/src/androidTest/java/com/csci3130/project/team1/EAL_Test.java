package com.csci3130.project.team1;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class EAL_Test {
    @Rule
    public ActivityTestRule<EAL_Activity> activityRule
            = new ActivityTestRule<>(EAL_Activity.class);

    /**
     * @author: Yuanyuan Deng & Longhao Gao
     * Enter in a input number (based on each test)as the alcohol intake,
     * then press Button SUBMIT;
     * check the return message
     * based on th following rules:
     * 0-20 -> safe, 20-40 -> moderate, 40-60 -> excess, 60-80 -> danger
     * 80+ -> very danger
     */

    @Test
    public void test1() {
        onView(withId(R.id.ecl_button)).perform(click());
        onView(withId(R.id.inputLevel)).perform(typeText("0"), closeSoftKeyboard());
        onView(withId(R.id.button_sub)).perform(click());
        onView(withId(R.id.message)).check(matches(withText("Please input a positive number")));

    }
    @Test
    public void test2() {
        onView(withId(R.id.ecl_button)).perform(click());
        onView(withId(R.id.inputLevel)).perform(typeText("20"), closeSoftKeyboard());
        onView(withId(R.id.button_sub)).perform(click());
        onView(withId(R.id.message)).check(matches(withText("Your intake is safe")));
    }

    @Test
    public void test3() {
        onView(withId(R.id.ecl_button)).perform(click());
        onView(withId(R.id.inputLevel)).perform(typeText("40"), closeSoftKeyboard());
        onView(withId(R.id.button_sub)).perform(click());
        onView(withId(R.id.message)).check(matches(withText("Your intake is moderate")));
    }

    @Test
    public void test4() {
        onView(withId(R.id.ecl_button)).perform(click());
        onView(withId(R.id.inputLevel)).perform(typeText("60"), closeSoftKeyboard());
        onView(withId(R.id.button_sub)).perform(click());
        onView(withId(R.id.message)).check(matches(withText("Your intake is excess")));
    }

    @Test
    public void test5() {
        onView(withId(R.id.ecl_button)).perform(click());
        onView(withId(R.id.inputLevel)).perform(typeText("80"), closeSoftKeyboard());
        onView(withId(R.id.button_sub)).perform(click());
        onView(withId(R.id.message)).check(matches(withText("Your intake is danger")));
    }

    @Test
    public void test6() {
        onView(withId(R.id.ecl_button)).perform(click());
        onView(withId(R.id.inputLevel)).perform(typeText("100"), closeSoftKeyboard());
        onView(withId(R.id.button_sub)).perform(click());
        onView(withId(R.id.message)).check(matches(withText("Your intake is very danger\nplease consider emergency measures")));
    }

}
