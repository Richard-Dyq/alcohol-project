package com.csci3130.project.team1;



import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;



import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;



@RunWith(AndroidJUnit4.class)
public class LoginTest {

//    @Rule
//    public ActivityTestRule<LoginActivity> activityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Rule
    public IntentsTestRule<LoginActivity> mLoginActivityActivityTestRule =
            new IntentsTestRule<>(LoginActivity.class);


    @Test
    public void passWdInCorrect(){
        onView(withId(R.id.editTextEmail)).perform(typeText("test@dal.ca"), closeSoftKeyboard());
        onView(withId(R.id.editTextPassword)).perform(typeText("123456"), closeSoftKeyboard());
        onView(withId(R.id.cirLoginButton)).perform(click());
//        intended(hasComponent(LoginActivity.class.getName()));
    }

}
