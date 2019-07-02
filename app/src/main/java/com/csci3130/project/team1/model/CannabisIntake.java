/**
 * @Author: Yizhao He & Jiutian Zhang
 */
package com.csci3130.project.team1.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CannabisIntake {
    private double c_level;
    private Date date;

    /**
     * Cannabis constructor
     * @param c_level
     * @param date
     */
    public CannabisIntake(double c_level, Date date) {
        this.c_level = c_level;
        this.date = date;
    }

    public CannabisIntake() {}

    /**
     * get Cannabis level
     * @return Cannabis level
     */
    public double getC_level() {
        return c_level;
    }
    /**
     * get Cannabis level Literal
     * @return Cannabis level Literal
     */
    public String getC_level_Literal(){
        return "LEVEL:" + getC_level();
    }
    /**
     * get date literal
     * @return date literal
     */
    public String getDate_literal(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(getDate());
    }

    /**
     * set Cannabis level
     * @param c_level Cannabis level
     */
    public void setC_level(double c_level) {
        this.c_level = c_level;
    }

    /**
     * get Cannabis level
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * set date
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
