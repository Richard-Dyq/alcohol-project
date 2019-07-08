package com.csci3130.project.team1;

import com.csci3130.project.team1.model.CannabisIntake;
import com.csci3130.project.team1.model.CannabisProduct;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CannabisTHCTest {

    @Test
    public void getCannaisLevelRep_isCorrect() {
        CannabisProduct cannabis = new CannabisProduct("a","b",1.2);
        double level = cannabis.getTHC();
        boolean flag = level > 0 & level < 100;
        assertTrue(flag);

        cannabis = new CannabisProduct("a","b",121.2);
        level = cannabis.getTHC();
        flag = level > 0 & level < 100;
        assertFalse(flag);
    }
}
