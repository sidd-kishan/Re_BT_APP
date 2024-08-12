/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.motion.utils;

public static class HyperSpline.Cubic {
    public static final double HALF = 0.5;
    public static final double THIRD = 0.3333333333333333;
    double mA;
    double mB;
    double mC;
    double mD;

    public HyperSpline.Cubic(double d, double d2, double d3, double d4) {
        this.mA = d;
        this.mB = d2;
        this.mC = d3;
        this.mD = d4;
    }

    public double eval(double d) {
        return ((this.mD * d + this.mC) * d + this.mB) * d + this.mA;
    }

    public double vel(double d) {
        return (this.mD * 0.3333333333333333 * d + this.mC * 0.5) * d + this.mB;
    }
}
