/*
 * Decompiled with CFR 0.152.
 */
package com.haibin.calendarview;

import java.io.Serializable;

public static final class Calendar.Scheme
implements Serializable {
    private Object obj;
    private String other;
    private String scheme;
    private int shcemeColor;
    private int type;

    public Calendar.Scheme() {
    }

    public Calendar.Scheme(int n, int n2, String string) {
        this.type = n;
        this.shcemeColor = n2;
        this.scheme = string;
    }

    public Calendar.Scheme(int n, int n2, String string, String string2) {
        this.type = n;
        this.shcemeColor = n2;
        this.scheme = string;
        this.other = string2;
    }

    public Calendar.Scheme(int n, String string) {
        this.shcemeColor = n;
        this.scheme = string;
    }

    public Calendar.Scheme(int n, String string, String string2) {
        this.shcemeColor = n;
        this.scheme = string;
        this.other = string2;
    }

    public Object getObj() {
        return this.obj;
    }

    public String getOther() {
        return this.other;
    }

    public String getScheme() {
        return this.scheme;
    }

    public int getShcemeColor() {
        return this.shcemeColor;
    }

    public int getType() {
        return this.type;
    }

    public void setObj(Object object) {
        this.obj = object;
    }

    public void setOther(String string) {
        this.other = string;
    }

    public void setScheme(String string) {
        this.scheme = string;
    }

    public void setShcemeColor(int n) {
        this.shcemeColor = n;
    }

    public void setType(int n) {
        this.type = n;
    }
}
