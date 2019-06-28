package com.csci3130.project.team1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CannabisIntake {
    private double c_level;
    private Date date;


    public CannabisIntake(double c_level, Date date) {
        this.c_level = c_level;
        this.date = date;
    }

    public CannabisIntake() {}

    public double getC_level() {
        return c_level;
    }

    public String getC_level_Literal(){
        return "LEVEL:" + getC_level();
    }

    public String getDate_literal(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(getDate());
    }

    public void setC_level(double c_level) {
        this.c_level = c_level;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
