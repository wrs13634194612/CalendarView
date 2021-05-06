package com.example.myapplication30;


/**
 * Created 2018/4/13.
 *
 * @author HongTao
 */
public class SignDate {
    private int year;
    private int month;
    private int day;
    private boolean isSign;

    public SignDate(int year, int month, int day, boolean isSign) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.isSign = isSign;
    }

    public SignDate() {
    }

    public boolean isSign() {
        return isSign;
    }

    public void setSign(boolean sign) {
        isSign = sign;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public boolean getIsSign() {
        return this.isSign;
    }

    public void setIsSign(boolean isSign) {
        this.isSign = isSign;
    }

}
