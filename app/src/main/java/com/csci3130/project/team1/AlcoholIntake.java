package com.csci3130.project.team1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AlcoholIntake {
    private double a_level;
    private Date date;


    public AlcoholIntake(double a_level, Date date) {
        this.a_level = a_level;
        this.date = date;
    }

    public AlcoholIntake() {}

    public double getA_level() {
        return a_level;
    }

    public void setA_level(double a_level) {
        this.a_level = a_level;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getALevel_Literial(){
        return "LEVEL: " + getA_level();
    }

    public String getDate_Literial(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(getDate());
    }
}
