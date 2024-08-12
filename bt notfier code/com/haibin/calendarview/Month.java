/*
 * Decompiled with CFR 0.152.
 */
package com.haibin.calendarview;

import java.io.Serializable;

final class Month
implements Serializable {
    private int count;
    private int diff;
    private int month;
    private int year;

    Month() {
    }

    int getCount() {
        return this.count;
    }

    int getDiff() {
        return this.diff;
    }

    int getMonth() {
        return this.month;
    }

    int getYear() {
        return this.year;
    }

    void setCount(int n) {
        this.count = n;
    }

    void setDiff(int n) {
        this.diff = n;
    }

    void setMonth(int n) {
        this.month = n;
    }

    void setYear(int n) {
        this.year = n;
    }
}
