package com.csci3130.project.team1;

import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import org.junit.Test;

import java.util.Date;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CannabisModelRepresentationTest {
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
