/**
 * @Author: Yizhao He & Jiutian Zhang
 */
package com.csci3130.project.team1.model;


public class AlcoholProduct {
    private String name;
    private double level;
    private String url;
    private double type;
    private String Description;


    public AlcoholProduct(String name, double level, String url, double type, String description) {
        this.name = name;
        this.level = level;
        this.url = url;
        this.type = type;
        Description = description;
    }


    public AlcoholProduct() {
    }

    /**
     * get alcohol title
     * @return title
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getType() {
        return type;
    }

    public void setType(double type) {
        this.type = type;
    }

    public String getTypeLiteral(){
        return AlcoholType.getInstance().types.get((int)type);
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
