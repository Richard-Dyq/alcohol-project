/**
 * @Author: Yizhao He & Jiutian Zhang
 */
package com.csci3130.project.team1.model;


public class AlcoholProduct {
    private String brand;
    private String alcoholAmount;
    private String description;
    private int type;

    /**
     * alcohol details constructor
     * @param brand
     * @param alcoholAmount
     * @param description
     * @param type
     */
    public AlcoholProduct(String brand, String alcoholAmount, String description, int type) {
        this.brand = brand;
        this.alcoholAmount = alcoholAmount;
        this.description = description;
        this.type = type;

    }

    public AlcoholProduct() {}

    /**
     * get alcohol brand
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAlcoholAmount() {
        return alcoholAmount;
    }

    public void setAlcoholAmount(String alcoholAmount) {
        this.alcoholAmount = alcoholAmount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
