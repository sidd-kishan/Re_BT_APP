/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.motion.utils.CurveFit
 */
package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.utils.CurveFit;

public class MonotonicCurveFit
extends CurveFit {
    private static final String TAG = "MonotonicCurveFit";
    private double[] mT;
    private double[][] mTangent;
    private double[][] mY;

    public MonotonicCurveFit(double[] dArray, double[][] dArray2) {
        double d;
        double d2;
        int n;
        int n2;
        int n3 = dArray.length;
        int n4 = dArray2[0].length;
        int n5 = n3 - 1;
        double[][] dArray3 = new double[n5][n4];
        double[][] dArray4 = new double[n3][n4];
        int n6 = 0;
        while (true) {
            if (n6 >= n4) break;
            n2 = 0;
            while (n2 < n5) {
                n = n2 + 1;
                d2 = dArray[n];
                d = dArray[n2];
                dArray3[n2][n6] = (dArray2[n][n6] - dArray2[n2][n6]) / (d2 - d);
                dArray4[n2][n6] = n2 == 0 ? dArray3[n2][n6] : (dArray3[n2 - 1][n6] + dArray3[n2][n6]) * 0.5;
                n2 = n;
            }
            dArray4[n5][n6] = dArray3[n3 - 2][n6];
            ++n6;
        }
        n6 = 0;
        while (true) {
            if (n6 >= n5) {
                this.mT = dArray;
                this.mY = dArray2;
                this.mTangent = dArray4;
                return;
            }
            for (n2 = 0; n2 < n4; ++n2) {
                if (dArray3[n6][n2] == 0.0) {
                    dArray4[n6][n2] = 0.0;
                    dArray4[n6 + 1][n2] = 0.0;
                    continue;
                }
                d = dArray4[n6][n2] / dArray3[n6][n2];
                n = n6 + 1;
                d2 = dArray4[n][n2] / dArray3[n6][n2];
                double d3 = Math.hypot(d, d2);
                if (!(d3 > 9.0)) continue;
                d3 = 3.0 / d3;
                dArray4[n6][n2] = d * d3 * dArray3[n6][n2];
                dArray4[n][n2] = d3 * d2 * dArray3[n6][n2];
            }
            ++n6;
        }
    }

    private static double diff(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d2 * d2;
        double d8 = d2 * 6.0;
        double d9 = 3.0 * d;
        return -6.0 * d7 * d4 + d8 * d4 + 6.0 * d7 * d3 - d8 * d3 + d9 * d6 * d7 + d9 * d5 * d7 - 2.0 * d * d6 * d2 - 4.0 * d * d5 * d2 + d * d5;
    }

    private static double interpolate(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d2 * d2;
        double d8 = d7 * d2;
        double d9 = 3.0 * d7;
        double d10 = d * d6;
        d6 = d * d5;
        return -2.0 * d8 * d4 + d9 * d4 + d8 * 2.0 * d3 - d9 * d3 + d3 + d10 * d8 + d8 * d6 - d10 * d7 - d * 2.0 * d5 * d7 + d6 * d2;
    }

    public double getPos(double d, int n) {
        Object object = this.mT;
        int n2 = ((double[])object).length;
        int n3 = 0;
        if (d <= object[0]) {
            return this.mY[0][n];
        }
        int n4 = n2 - 1;
        if (d >= object[n4]) {
            return this.mY[n4][n];
        }
        while (n3 < n4) {
            object = this.mT;
            if (d == object[n3]) {
                return this.mY[n3][n];
            }
            n2 = n3 + 1;
            if (d < object[n2]) {
                double d2 = object[n2] - object[n3];
                d = (d - object[n3]) / d2;
                object = this.mY;
                void var8_8 = object[n3][n];
                void var6_9 = object[n2][n];
                object = this.mTangent;
                return MonotonicCurveFit.interpolate(d2, d, (double)var8_8, (double)var6_9, (double)object[n3][n], (double)object[n2][n]);
            }
            n3 = n2;
        }
        return 0.0;
    }

    public void getPos(double d, double[] dArray) {
        double[] dArray2 = this.mT;
        int n = dArray2.length;
        Object object = this.mY;
        int n2 = 0;
        int n3 = 0;
        int n4 = object[0].length;
        if (d <= dArray2[0]) {
            n3 = 0;
            while (n3 < n4) {
                dArray[n3] = this.mY[0][n3];
                ++n3;
            }
            return;
        }
        int n5 = n - 1;
        if (d >= dArray2[n5]) {
            while (n3 < n4) {
                dArray[n3] = this.mY[n5][n3];
                ++n3;
            }
            return;
        }
        n3 = 0;
        while (n3 < n5) {
            int n6;
            if (d == this.mT[n3]) {
                for (n = 0; n < n4; ++n) {
                    dArray[n] = this.mY[n3][n];
                }
            }
            if (d < (object = (Object)this.mT)[n6 = n3 + 1]) {
                reference var4_11 = object[n6] - object[n3];
                double d2 = (d - object[n3]) / var4_11;
                n = n2;
                while (n < n4) {
                    object = this.mY;
                    double d3 = object[n3][n];
                    d = object[n6][n];
                    object = this.mTangent;
                    dArray[n] = MonotonicCurveFit.interpolate((double)var4_11, d2, d3, d, object[n3][n], object[n6][n]);
                    ++n;
                }
                return;
            }
            n3 = n6;
        }
    }

    public void getPos(double d, float[] fArray) {
        Object object = this.mT;
        int n = ((double[])object).length;
        double[][] dArray = this.mY;
        int n2 = 0;
        int n3 = 0;
        int n4 = dArray[0].length;
        if (d <= object[0]) {
            n3 = 0;
            while (n3 < n4) {
                fArray[n3] = (float)this.mY[0][n3];
                ++n3;
            }
            return;
        }
        int n5 = n - 1;
        if (d >= object[n5]) {
            while (n3 < n4) {
                fArray[n3] = (float)this.mY[n5][n3];
                ++n3;
            }
            return;
        }
        n3 = 0;
        while (n3 < n5) {
            int n6;
            if (d == this.mT[n3]) {
                for (n = 0; n < n4; ++n) {
                    fArray[n] = (float)this.mY[n3][n];
                }
            }
            if (d < (object = this.mT)[n6 = n3 + 1]) {
                double d2 = object[n6] - object[n3];
                double d3 = (d - object[n3]) / d2;
                n = n2;
                while (n < n4) {
                    object = this.mY;
                    d = object[n3][n];
                    void var6_13 = object[n6][n];
                    object = this.mTangent;
                    fArray[n] = (float)MonotonicCurveFit.interpolate(d2, d3, d, (double)var6_13, (double)object[n3][n], (double)object[n6][n]);
                    ++n;
                }
                return;
            }
            n3 = n6;
        }
    }

    public double getSlope(double d, int n) {
        int n2;
        Object object = this.mT;
        int n3 = ((double[])object).length;
        int n4 = 0;
        if (d < object[0]) {
            d = object[0];
        } else {
            n2 = n3 - 1;
            if (d >= object[n2]) {
                d = object[n2];
            }
        }
        while (n4 < n3 - 1) {
            object = this.mT;
            n2 = n4 + 1;
            if (d <= object[n2]) {
                double d2 = object[n2] - object[n4];
                double d3 = (d - object[n4]) / d2;
                object = this.mY;
                d = object[n4][n];
                void var8_9 = object[n2][n];
                object = this.mTangent;
                return MonotonicCurveFit.diff(d2, d3, d, (double)var8_9, (double)object[n4][n], (double)object[n2][n]) / d2;
            }
            n4 = n2;
        }
        return 0.0;
    }

    public void getSlope(double d, double[] dArray) {
        int n;
        Object object = this.mT;
        int n2 = ((double[])object).length;
        double[][] dArray2 = this.mY;
        int n3 = 0;
        int n4 = dArray2[0].length;
        if (d <= object[0]) {
            d = object[0];
        } else {
            n = n2 - 1;
            if (d >= object[n]) {
                d = object[n];
            }
        }
        n = 0;
        while (n < n2 - 1) {
            object = this.mT;
            int n5 = n + 1;
            if (d <= object[n5]) {
                double d2 = object[n5] - object[n];
                double d3 = (d - object[n]) / d2;
                while (n3 < n4) {
                    object = this.mY;
                    d = object[n][n3];
                    void var8_12 = object[n5][n3];
                    object = this.mTangent;
                    dArray[n3] = MonotonicCurveFit.diff(d2, d3, d, (double)var8_12, (double)object[n][n3], (double)object[n5][n3]) / d2;
                    ++n3;
                }
                break block0;
                return;
            }
            n = n5;
        }
    }

    public double[] getTimePoints() {
        return this.mT;
    }
}
