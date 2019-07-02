package com.csci3130.project.team1;

import com.csci3130.project.team1.model.CannabisIntake;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DataModelRepresentationTest {
    @Test
    public void getCannaisLevelRep_isCorrect() {
        CannabisIntake cannabisIntake = new CannabisIntake(12, new Date());
        String level_rep = cannabisIntake.getC_level_Literal();
        assertTrue(level_rep.contains("LEVEL:"));
    }

    @Test
    public void getCannaisDateRep_isCorrect() {
        CannabisIntake cannabisIntake = new CannabisIntake(12, new Date());
        assertTrue(cannabisIntake.getDate_literal().matches("\\d{4}-\\d{2}-\\d{2}"));
    }
}
