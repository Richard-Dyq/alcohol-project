/**
 * @Author: Yizhao He & Jiutian Zhang
 */
package com.csci3130.project.team1.model;


public class AlcoholDetail {
    private String brand;
    private String alcoholAmount;
    private String description;
    private String type;

    /**
     * alcohol details constructor
     * @param brand
     * @param alcoholAmount
     * @param description
     */
    public AlcoholDetail(String brand, String alcoholAmount, String description, String type) {
        this.brand = brand;
        this.alcoholAmount = alcoholAmount;
        this.description = description;
        this.type = type;

    }

    public AlcoholDetail() {}

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
