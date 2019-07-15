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
        AlcoholProduct product = new AlcoholProduct("a",50,"fack_url",0,"des");
        String BRAND = product.getName();
        assertTrue(BRAND.contains("a"));
    }

    @Test
    public void getAlcoholamount_isCorrect() {
        AlcoholProduct product = new AlcoholProduct("a",50,"fack_url",0,"des");
        double AlcoholAmount = product.getLevel();
        assertTrue(AlcoholAmount == 50);
    }
    @Test
    public void getAlcoholdes_isCorrect() {
        AlcoholProduct product = new AlcoholProduct("a",50,"fack_url",0,"des");
        String Description = product.getDescription();
        assertTrue(Description.contains("des"));
    }
    @Test
    public void getAlcoholtype_isCorrect() {
        AlcoholProduct product = new AlcoholProduct("a",50,"fack_url",0,"des");
        String Type = product.getTypeLiteral();
        assertTrue(Type.equals("Beer"));
    }
}
