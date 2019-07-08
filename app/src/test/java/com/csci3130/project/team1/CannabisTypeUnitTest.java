package com.csci3130.project.team1;

import com.csci3130.project.team1.model.CannabisIntake;
import com.csci3130.project.team1.model.CannabisType;

import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.*;


public class CannabisTypeUnitTest {
    @Test
    public void CannabisTypeTest() {
        String type;
        type = CannabisType.ourInstance.allTypes.get(0);
        assertEquals(type, "Indica");

        type = CannabisType.ourInstance.allTypes.get(1);
        assertEquals(type, "Sativa");

        type = CannabisType.ourInstance.allTypes.get(2);
        assertEquals(type, "Hybrid");
    }
}
