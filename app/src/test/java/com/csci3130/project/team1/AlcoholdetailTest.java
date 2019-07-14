package com.csci3130.project.team1;

import com.csci3130.project.team1.model.AlcoholProduct;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AlcoholdetailTest {
    @Test
    public void getAlcoholbrand_isCorrect() {
        AlcoholProduct product = new AlcoholProduct("Maotai", "50%vol", "Chinese famous liquor",0);
        String BRAND = product.getTitle();
        assertTrue(BRAND.contains("Maotai"));
    }

    @Test
    public void getAlcoholamount_isCorrect() {
        AlcoholProduct product = new AlcoholProduct("Maotai", "50%vol", "Chinese famous liquor",0);
        String AlcoholAmount = product.getAlcoholAmount();
        assertTrue(AlcoholAmount.contains("50%vol"));
    }
    @Test
    public void getAlcoholdes_isCorrect() {
        AlcoholProduct product = new AlcoholProduct("Maotai", "50%vol", "Chinese famous liquor",0);
        String Description = product.getDescription();
        assertTrue(Description.contains("Chinese famous liquor"));
    }
    @Test
    public void getAlcoholtype_isCorrect() {
        AlcoholProduct product = new AlcoholProduct("Maotai", "50%vol", "Chinese famous liquor",0);
        int Type = product.getType();
        assertTrue("white", Type == 0);
    }
}
