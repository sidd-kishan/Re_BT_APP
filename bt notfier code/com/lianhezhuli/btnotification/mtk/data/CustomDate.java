/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.utils.DateUtil
 */
package com.lianhezhuli.btnotification.mtk.data;

import com.lianhezhuli.btnotification.utils.DateUtil;
import java.io.Serializable;

public class CustomDate
implements Serializable {
    private static final long serialVersionUID = 1L;
    public int day;
    public int month;
    public int week;
    public int year;

    public CustomDate() {
        this.year = DateUtil.getYear();
        this.month = DateUtil.getMonth();
        this.day = DateUtil.getCurrentMonthDay();
    }

    public CustomDate(int n, int n2, int n3) {
        int n4;
        int n5;
        if (n2 > 12) {
            n5 = n + 1;
            n4 = 1;
        } else {
            n5 = n;
            n4 = n2;
            if (n2 < 1) {
                n5 = n - 1;
                n4 = 12;
            }
        }
        this.year = n5;
        this.month = n4;
        this.day = n3;
    }

    public static CustomDate modifiDayForObject(CustomDate customDate, int n) {
        return new CustomDate(customDate.year, customDate.month, n);
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getWeek() {
        return this.week;
    }

    public int getYear() {
        return this.year;
    }

    public void setDay(int n) {
        this.day = n;
    }

    public void setMonth(int n) {
        this.month = n;
    }

    public void setWeek(int n) {
        this.week = n;
    }

    public void setYear(int n) {
        this.year = n;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.year);
        stringBuilder.append("-");
        stringBuilder.append(this.month);
        stringBuilder.append("-");
        stringBuilder.append(this.day);
        return stringBuilder.toString();
    }
}
