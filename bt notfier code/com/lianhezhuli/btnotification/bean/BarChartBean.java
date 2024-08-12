/*
 * Decompiled with CFR 0.152.
 */
package com.lianhezhuli.btnotification.bean;

public class BarChartBean {
    private String date;
    private String label;
    private int value;

    public BarChartBean() {
    }

    public BarChartBean(String string, String string2, int n) {
        this.label = string;
        this.date = string2;
        this.value = n;
    }

    public String getDate() {
        return this.date;
    }

    public String getLabel() {
        return this.label;
    }

    public int getValue() {
        return this.value;
    }

    public void setDate(String string) {
        this.date = string;
    }

    public void setLabel(String string) {
        this.label = string;
    }

    public void setValue(int n) {
        this.value = n;
    }
}
