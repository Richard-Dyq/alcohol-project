package com.csci3130.project.team1;

import com.csci3130.project.team1.model.*;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlcoholListViewTypeUnitTest {
    @Test
    public void getAlcoholType_isCorrect() {
        String type;

        type = AlcoholType.getInstance().types.get(0);
        assertEquals(type, "Beer");

        type = AlcoholType.getInstance().types.get(1);
        assertEquals(type, "Wine");

        type = AlcoholType.getInstance().types.get(2);
        assertEquals(type, "Icewine");

        type = AlcoholType.getInstance().types.get(3);
        assertEquals(type, "Noble rot wines");

        type = AlcoholType.getInstance().types.get(4);
        assertEquals(type, "Fortified Wine");

        type = AlcoholType.getInstance().types.get(5);
        assertEquals(type, "Sherry");

        type = AlcoholType.getInstance().types.get(6);
        assertEquals(type, "Port wine");

        type = AlcoholType.getInstance().types.get(7);
        assertEquals(type, "Sparkling wine");

        type = AlcoholType.getInstance().types.get(8);
        assertEquals(type, "Champagne");

        type = AlcoholType.getInstance().types.get(9);
        assertEquals(type, "Chinese rice wines");

        type = AlcoholType.getInstance().types.get(10);
        assertEquals(type, "Sake");

        type = AlcoholType.getInstance().types.get(11);
        assertEquals(type, "Chinese spirits");

        type = AlcoholType.getInstance().types.get(12);
        assertEquals(type, "Brandy");

        type = AlcoholType.getInstance().types.get(13);
        assertEquals(type, "Whisky");

        type = AlcoholType.getInstance().types.get(14);
        assertEquals(type, "Vodka");

        type = AlcoholType.getInstance().types.get(15);
        assertEquals(type, "Gin");

        type = AlcoholType.getInstance().types.get(16);
        assertEquals(type, "Liquor");

    }
}
