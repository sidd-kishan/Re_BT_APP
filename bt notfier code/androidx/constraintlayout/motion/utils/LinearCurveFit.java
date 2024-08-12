/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.motion.utils.CurveFit
 */
package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.utils.CurveFit;

public class LinearCurveFit
extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private double[] mT;
    private double mTotalLength = Double.NaN;
    private double[][] mY;

    public LinearCurveFit(double[] dArray, double[][] dArray2) {
        int n = dArray.length;
        n = dArray2[0].length;
        this.mT = dArray;
        this.mY = dArray2;
        if (n <= 2) return;
        double d = 0.0;
        double d2 = 0.0;
        n = 0;
        while (true) {
            if (n >= dArray.length) {
                this.mTotalLength = 0.0;
                return;
            }
            double d3 = dArray2[n][0];
            double d4 = dArray2[n][0];
            if (n > 0) {
                Math.hypot(d3 - d, d4 - d2);
            }
            ++n;
            d = d3;
            d2 = d4;
        }
    }

    private double getLength2D(double d) {
        double d2;
        if (Double.isNaN(this.mTotalLength)) {
            return 0.0;
        }
        Object object = this.mT;
        int n = ((double[])object).length;
        if (d <= object[0]) {
            return 0.0;
        }
        int n2 = n - 1;
        if (d >= object[n2]) {
            return this.mTotalLength;
        }
        double d3 = 0.0;
        double d4 = d2 = 0.0;
        n = 0;
        while (n < n2) {
            object = this.mY;
            void var13_11 = object[n][0];
            void var11_10 = object[n][1];
            double d5 = d3;
            if (n > 0) {
                d5 = d3 + Math.hypot((double)(var13_11 - d2), (double)(var11_10 - d4));
            }
            if (d == (object = this.mT)[n]) {
                return d5;
            }
            int n3 = n + 1;
            if (d < object[n3]) {
                d3 = object[n3];
                d4 = object[n];
                d = (d - object[n]) / (d3 - d4);
                object = this.mY;
                void var15_12 = object[n][0];
                d4 = object[n3][0];
                d2 = object[n][1];
                d3 = object[n3][1];
                double d6 = 1.0 - d;
                return d5 + Math.hypot((double)(var11_10 - (d2 * d6 + d3 * d)), (double)(var13_11 - (var15_12 * d6 + d4 * d)));
            }
            n = n3;
            d2 = var13_11;
            d4 = var11_10;
            d3 = d5;
        }
        return 0.0;
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
                double d2 = object[n2];
                double d3 = object[n3];
                d = (d - object[n3]) / (d2 - d3);
                object = this.mY;
                return (double)(object[n3][n] * (1.0 - d) + object[n2][n] * d);
            }
            n3 = n2;
        }
        return 0.0;
    }

    public void getPos(double d, double[] dArray) {
        Object object = this.mT;
        int n = ((double[])object).length;
        double[][] dArray2 = this.mY;
        int n2 = 0;
        int n3 = 0;
        int n4 = dArray2[0].length;
        if (d <= object[0]) {
            n3 = 0;
            while (n3 < n4) {
                dArray[n3] = this.mY[0][n3];
                ++n3;
            }
            return;
        }
        int n5 = n - 1;
        if (d >= object[n5]) {
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
            if (d < (object = this.mT)[n6 = n3 + 1]) {
                double d2 = object[n6];
                double d3 = object[n3];
                d = (d - object[n3]) / (d2 - d3);
                n = n2;
                while (n < n4) {
                    object = this.mY;
                    dArray[n] = object[n3][n] * (1.0 - d) + object[n6][n] * d;
                    ++n;
                }
                return;
            }
            n3 = n6;
        }
    }

    public void getPos(double d, float[] fArray) {
        double[] dArray = this.mT;
        int n = dArray.length;
        Object object = this.mY;
        int n2 = 0;
        int n3 = 0;
        int n4 = object[0].length;
        if (d <= dArray[0]) {
            n3 = 0;
            while (n3 < n4) {
                fArray[n3] = (float)this.mY[0][n3];
                ++n3;
            }
            return;
        }
        int n5 = n - 1;
        if (d >= dArray[n5]) {
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
            if (d < (object = (Object)this.mT)[n6 = n3 + 1]) {
                double[] dArray2 = object[n6];
                double[] dArray3 = object[n3];
                d = (d - object[n3]) / (dArray2 - dArray3);
                n = n2;
                while (n < n4) {
                    object = this.mY;
                    fArray[n] = (float)(object[n3][n] * (1.0 - d) + object[n6][n] * d);
                    ++n;
                }
                return;
            }
            n3 = n6;
        }
    }

    public double getSlope(double d, int n) {
        int n2;
        double d2;
        Object object = this.mT;
        int n3 = ((double[])object).length;
        int n4 = 0;
        if (d < object[0]) {
            d2 = object[0];
            n2 = n4;
        } else {
            int n5 = n3 - 1;
            n2 = n4;
            d2 = d;
            if (d >= object[n5]) {
                d2 = object[n5];
                n2 = n4;
            }
        }
        while (n2 < n3 - 1) {
            object = this.mT;
            n4 = n2 + 1;
            if (d2 <= object[n4]) {
                d = object[n4];
                d2 = object[n2];
                double d3 = object[n2];
                object = this.mY;
                d3 = object[n2][n];
                return (double)((object[n4][n] - d3) / (d - d2));
            }
            n2 = n4;
        }
        return 0.0;
    }

    public void getSlope(double object, double[] dArray) {
        int n;
        Object object2;
        double[] dArray2 = this.mT;
        int n2 = dArray2.length;
        Object object3 = this.mY;
        int n3 = 0;
        int n4 = object3[0].length;
        if (object <= dArray2[0]) {
            object2 = dArray2[0];
        } else {
            n = n2 - 1;
            object2 = object;
            if (object >= dArray2[n]) {
                object2 = dArray2[n];
            }
        }
        n = 0;
        while (n < n2 - 1) {
            object3 = this.mT;
            int n5 = n + 1;
            if (object2 <= object3[n5]) {
                object2 = object3[n5];
                object = object3[n];
                Object object4 = object3[n];
                while (n3 < n4) {
                    object3 = this.mY;
                    object4 = object3[n][n3];
                    dArray[n3] = (object3[n5][n3] - object4) / (object2 - object);
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
