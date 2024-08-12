/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.motion.utils;

import java.util.Arrays;

private static class ArcCurveFit.Arc {
    private static final double EPSILON = 0.001;
    private static final String TAG = "Arc";
    private static double[] ourPercent = new double[91];
    boolean linear;
    double mArcDistance;
    double mArcVelocity;
    double mEllipseA;
    double mEllipseB;
    double mEllipseCenterX;
    double mEllipseCenterY;
    double[] mLut;
    double mOneOverDeltaTime;
    double mTime1;
    double mTime2;
    double mTmpCosAngle;
    double mTmpSinAngle;
    boolean mVertical;
    double mX1;
    double mX2;
    double mY1;
    double mY2;

    ArcCurveFit.Arc(int n, double d, double d2, double d3, double d4, double d5, double d6) {
        boolean bl = false;
        this.linear = false;
        if (n == 1) {
            bl = true;
        }
        this.mVertical = bl;
        this.mTime1 = d;
        this.mTime2 = d2;
        this.mOneOverDeltaTime = 1.0 / (d2 - d);
        if (3 == n) {
            this.linear = true;
        }
        d2 = d5 - d3;
        d = d6 - d4;
        if (!(this.linear || Math.abs(d2) < 0.001 || Math.abs(d) < 0.001)) {
            this.mLut = new double[101];
            n = this.mVertical ? -1 : 1;
            double d7 = n;
            Double.isNaN(d7);
            this.mEllipseA = d2 * d7;
            n = this.mVertical ? 1 : -1;
            d2 = n;
            Double.isNaN(d2);
            this.mEllipseB = d * d2;
            d = this.mVertical ? d5 : d3;
            this.mEllipseCenterX = d;
            d = this.mVertical ? d4 : d6;
            this.mEllipseCenterY = d;
            this.buildTable(d3, d4, d5, d6);
            this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
            return;
        }
        this.linear = true;
        this.mX1 = d3;
        this.mX2 = d5;
        this.mY1 = d4;
        this.mY2 = d6;
        this.mArcDistance = d3 = Math.hypot(d, d2);
        this.mArcVelocity = d3 * this.mOneOverDeltaTime;
        d3 = this.mTime2;
        d4 = this.mTime1;
        this.mEllipseCenterX = d2 / (d3 - d4);
        this.mEllipseCenterY = d / (d3 - d4);
    }

    private void buildTable(double d, double d2, double d3, double d4) {
        double[] dArray;
        int n;
        double d5 = 0.0;
        double d6 = 0.0;
        double d7 = 0.0;
        for (n = 0; n < (dArray = ourPercent).length; ++n) {
            double d8 = n;
            Double.isNaN(d8);
            double d9 = dArray.length - 1;
            Double.isNaN(d9);
            d9 = Math.toRadians(d8 * 90.0 / d9);
            d8 = Math.sin(d9);
            d9 = Math.cos(d9);
            d8 *= d3 - d;
            d9 *= d2 - d4;
            if (n > 0) {
                ArcCurveFit.Arc.ourPercent[n] = d5 += Math.hypot(d8 - d6, d9 - d7);
            }
            d7 = d9;
            d6 = d8;
        }
        this.mArcDistance = d5;
        for (n = 0; n < (dArray = ourPercent).length; ++n) {
            dArray[n] = dArray[n] / d5;
        }
        n = 0;
        while (n < (dArray = this.mLut).length) {
            d = n;
            d2 = dArray.length - 1;
            Double.isNaN(d);
            Double.isNaN(d2);
            d2 = d / d2;
            int n2 = Arrays.binarySearch(ourPercent, d2);
            if (n2 >= 0) {
                this.mLut[n] = n2 / (ourPercent.length - 1);
            } else if (n2 == -1) {
                this.mLut[n] = 0.0;
            } else {
                n2 = -n2;
                int n3 = n2 - 2;
                d = n3;
                dArray = ourPercent;
                d3 = (d2 - dArray[n3]) / (dArray[n2 - 1] - dArray[n3]);
                Double.isNaN(d);
                d2 = dArray.length - 1;
                Double.isNaN(d2);
                this.mLut[n] = d = (d + d3) / d2;
            }
            ++n;
        }
    }

    double getDX() {
        double d = this.mEllipseA * this.mTmpCosAngle;
        double d2 = -this.mEllipseB;
        double d3 = this.mTmpSinAngle;
        d3 = this.mArcVelocity / Math.hypot(d, d2 * d3);
        d2 = d;
        if (!this.mVertical) return d2 * d3;
        d2 = -d;
        return d2 * d3;
    }

    double getDY() {
        double d = this.mEllipseA;
        double d2 = this.mTmpCosAngle;
        double d3 = -this.mEllipseB * this.mTmpSinAngle;
        d2 = this.mArcVelocity / Math.hypot(d * d2, d3);
        d3 = this.mVertical ? -d3 * d2 : (d3 *= d2);
        return d3;
    }

    public double getLinearDX(double d) {
        return this.mEllipseCenterX;
    }

    public double getLinearDY(double d) {
        return this.mEllipseCenterY;
    }

    public double getLinearX(double d) {
        double d2 = this.mTime1;
        double d3 = this.mOneOverDeltaTime;
        double d4 = this.mX1;
        return d4 + (d - d2) * d3 * (this.mX2 - d4);
    }

    public double getLinearY(double d) {
        double d2 = this.mTime1;
        double d3 = this.mOneOverDeltaTime;
        double d4 = this.mY1;
        return d4 + (d - d2) * d3 * (this.mY2 - d4);
    }

    double getX() {
        return this.mEllipseCenterX + this.mEllipseA * this.mTmpSinAngle;
    }

    double getY() {
        return this.mEllipseCenterY + this.mEllipseB * this.mTmpCosAngle;
    }

    double lookup(double d) {
        if (d <= 0.0) {
            return 0.0;
        }
        if (d >= 1.0) {
            return 1.0;
        }
        double[] dArray = this.mLut;
        double d2 = dArray.length - 1;
        Double.isNaN(d2);
        int n = (int)(d *= d2);
        d2 = n;
        Double.isNaN(d2);
        return dArray[n] + (d - d2) * (dArray[n + 1] - dArray[n]);
    }

    void setPoint(double d) {
        d = this.mVertical ? this.mTime2 - d : (d -= this.mTime1);
        d = this.lookup(d * this.mOneOverDeltaTime) * 1.5707963267948966;
        this.mTmpSinAngle = Math.sin(d);
        this.mTmpCosAngle = Math.cos(d);
    }
}
