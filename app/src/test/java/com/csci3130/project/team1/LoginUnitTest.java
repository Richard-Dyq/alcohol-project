package com.csci3130.project.team1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginUnitTest {
    @Test
    /**
     * JUnit test for user name and password validation.
     */
    public void isUserNameAndPasswordValid_iscorrect() {
        LoginActivity loginActivity = new LoginActivity();

        assertTrue(loginActivity.isUserNameAndPasswordValid("james@dal.ca", "123333"));
        assertFalse(loginActivity.isUserNameAndPasswordValid("dal.ca", "123333"));
        assertFalse(loginActivity.isUserNameAndPasswordValid("james@dal.ca", ""));
    }
}
