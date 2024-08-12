/*
 * Decompiled with CFR 0.152.
 */
package com.haibin.calendarview;

private static class SolarTermUtil.Nutation {
    private double Lon;
    private double Obl;

    private SolarTermUtil.Nutation() {
    }

    static /* synthetic */ double access$800(SolarTermUtil.Nutation nutation) {
        return nutation.Lon;
    }

    static /* synthetic */ double access$802(SolarTermUtil.Nutation nutation, double d) {
        nutation.Lon = d;
        return d;
    }

    static /* synthetic */ double access$900(SolarTermUtil.Nutation nutation) {
        return nutation.Obl;
    }

    static /* synthetic */ double access$902(SolarTermUtil.Nutation nutation, double d) {
        nutation.Obl = d;
        return d;
    }
}
