package com.csci3130.project.team1;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AlcoholLevelUnitTest {
    @Test
    public void UnitTestAlcoholLevel() {
        AlcoholIntake al = new AlcoholIntake();
        String rep = al.getALevel_Literial();
        assertTrue(rep.contains("LEVEL"));
    }

    @Test
    public void UnitTestAlcoholDate(){
        AlcoholIntake al = new AlcoholIntake();
        String rep = al.getDate_Literial();
        assertTrue(rep.matches("\\d{4}-\\d{2}-\\d{2}"));
    }
}
