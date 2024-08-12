/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.motion.utils.Easing
 */
package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.utils.Easing;

static class Easing.CubicEasing
extends Easing {
    private static double d_error = 1.0E-4;
    private static double error = 0.01;
    double x1;
    double x2;
    double y1;
    double y2;

    public Easing.CubicEasing(double d, double d2, double d3, double d4) {
        this.setup(d, d2, d3, d4);
    }

    Easing.CubicEasing(String string) {
        this.str = string;
        int n = string.indexOf(40);
        int n2 = string.indexOf(44, n);
        this.x1 = Double.parseDouble(string.substring(n + 1, n2).trim());
        n = n2 + 1;
        n2 = string.indexOf(44, n);
        this.y1 = Double.parseDouble(string.substring(n, n2).trim());
        n = string.indexOf(44, ++n2);
        this.x2 = Double.parseDouble(string.substring(n2, n).trim());
        n2 = n + 1;
        this.y2 = Double.parseDouble(string.substring(n2, string.indexOf(41, n2)).trim());
    }

    private double getDiffX(double d) {
        double d2 = 1.0 - d;
        double d3 = this.x1;
        double d4 = this.x2;
        return d2 * 3.0 * d2 * d3 + d2 * 6.0 * d * (d4 - d3) + 3.0 * d * d * (1.0 - d4);
    }

    private double getDiffY(double d) {
        double d2 = 1.0 - d;
        double d3 = this.y1;
        double d4 = this.y2;
        return d2 * 3.0 * d2 * d3 + d2 * 6.0 * d * (d4 - d3) + 3.0 * d * d * (1.0 - d4);
    }

    private double getX(double d) {
        double d2 = 1.0 - d;
        double d3 = 3.0 * d2;
        return this.x1 * (d2 * d3 * d) + this.x2 * (d3 * d * d) + d * d * d;
    }

    private double getY(double d) {
        double d2 = 1.0 - d;
        double d3 = 3.0 * d2;
        return this.y1 * (d2 * d3 * d) + this.y2 * (d3 * d * d) + d * d * d;
    }

    public double get(double d) {
        if (d <= 0.0) {
            return 0.0;
        }
        if (d >= 1.0) {
            return 1.0;
        }
        double d2 = 0.5;
        double d3 = 0.5;
        while (true) {
            double d4;
            if (!(d2 > error)) {
                double d5 = d3 - d2;
                d4 = this.getX(d5);
                d3 += d2;
                d2 = this.getX(d3);
                d5 = this.getY(d5);
                return (this.getY(d3) - d5) * (d - d4) / (d2 - d4) + d5;
            }
            d4 = this.getX(d3);
            d2 *= 0.5;
            if (d4 < d) {
                d3 += d2;
                continue;
            }
            d3 -= d2;
        }
    }

    public double getDiff(double d) {
        double d2 = 0.5;
        double d3 = 0.5;
        while (true) {
            double d4;
            if (!(d2 > d_error)) {
                d4 = d3 - d2;
                d = this.getX(d4);
                d2 = d3 + d2;
                d3 = this.getX(d2);
                d4 = this.getY(d4);
                return (this.getY(d2) - d4) / (d3 - d);
            }
            d4 = this.getX(d3);
            d2 *= 0.5;
            if (d4 < d) {
                d3 += d2;
                continue;
            }
            d3 -= d2;
        }
    }

    void setup(double d, double d2, double d3, double d4) {
        this.x1 = d;
        this.y1 = d2;
        this.x2 = d3;
        this.y2 = d4;
    }
}
