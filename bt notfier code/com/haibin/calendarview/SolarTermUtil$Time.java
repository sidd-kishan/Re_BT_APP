/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.haibin.calendarview.SolarTermUtil
 */
package com.haibin.calendarview;

import com.haibin.calendarview.SolarTermUtil;

/*
 * Exception performing whole class analysis ignored.
 */
private static class SolarTermUtil.Time {
    private double day;
    private double hour;
    private double minute;
    private double month;
    private double second;
    private double year;

    private SolarTermUtil.Time() {
    }

    static /* synthetic */ double access$000(SolarTermUtil.Time time) {
        return time.year;
    }

    static /* synthetic */ double access$002(SolarTermUtil.Time time, double d) {
        time.year = d;
        return d;
    }

    static /* synthetic */ double access$008(SolarTermUtil.Time time) {
        double d = time.year;
        time.year = 1.0 + d;
        return d;
    }

    static /* synthetic */ double access$100(SolarTermUtil.Time time) {
        return time.month;
    }

    static /* synthetic */ double access$102(SolarTermUtil.Time time, double d) {
        time.month = d;
        return d;
    }

    static /* synthetic */ double access$110(SolarTermUtil.Time time) {
        double d = time.month;
        time.month = d - 1.0;
        return d;
    }

    static /* synthetic */ double access$200(SolarTermUtil.Time time) {
        return time.day;
    }

    static /* synthetic */ double access$202(SolarTermUtil.Time time, double d) {
        time.day = d;
        return d;
    }

    static /* synthetic */ double access$300(SolarTermUtil.Time time) {
        return time.second;
    }

    static /* synthetic */ double access$302(SolarTermUtil.Time time, double d) {
        time.second = d;
        return d;
    }

    static /* synthetic */ double access$400(SolarTermUtil.Time time) {
        return time.minute;
    }

    static /* synthetic */ double access$402(SolarTermUtil.Time time, double d) {
        time.minute = d;
        return d;
    }

    static /* synthetic */ double access$500(SolarTermUtil.Time time) {
        return time.hour;
    }

    static /* synthetic */ double access$502(SolarTermUtil.Time time, double d) {
        time.hour = d;
        return d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SolarTermUtil.access$1000((double)this.year));
        stringBuilder.append(SolarTermUtil.access$1000((double)this.month));
        stringBuilder.append(SolarTermUtil.access$1000((double)this.day));
        return stringBuilder.toString();
    }
}
