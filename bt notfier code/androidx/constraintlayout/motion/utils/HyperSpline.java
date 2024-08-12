/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.motion.utils.HyperSpline$Cubic
 */
package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.utils.HyperSpline;

public class HyperSpline {
    double[][] mCtl;
    Cubic[][] mCurve;
    double[] mCurveLength;
    int mDimensionality;
    int mPoints;
    double mTotalLength;

    public HyperSpline() {
    }

    public HyperSpline(double[][] dArray) {
        this.setup(dArray);
    }

    static Cubic[] calcNaturalCubic(int n, double[] dArray) {
        double d;
        double[] dArray2 = new double[n];
        Object[] objectArray = new double[n];
        double[] dArray3 = new double[n];
        int n2 = n - 1;
        int n3 = 0;
        dArray2[0] = 0.5;
        int n4 = 1;
        for (n = 1; n < n2; ++n) {
            dArray2[n] = 1.0 / (4.0 - dArray2[n - 1]);
        }
        int n5 = n2 - 1;
        dArray2[n2] = 1.0 / (2.0 - dArray2[n5]);
        objectArray[0] = (dArray[1] - dArray[0]) * 3.0 * dArray2[0];
        n = n4;
        while (n < n2) {
            n4 = n + 1;
            d = dArray[n4];
            int n6 = n - 1;
            objectArray[n] = ((d - dArray[n6]) * 3.0 - objectArray[n6]) * dArray2[n];
            n = n4;
        }
        objectArray[n2] = ((dArray[n2] - dArray[n5]) * 3.0 - objectArray[n5]) * dArray2[n2];
        dArray3[n2] = objectArray[n2];
        for (n = n5; n >= 0; --n) {
            dArray3[n] = objectArray[n] - dArray2[n] * dArray3[n + 1];
        }
        objectArray = new Cubic[n2];
        n = n3;
        while (n < n2) {
            d = (float)dArray[n];
            double d2 = dArray3[n];
            n3 = n + 1;
            objectArray[n] = (double)new Cubic(d, d2, (dArray[n3] - dArray[n]) * 3.0 - dArray3[n] * 2.0 - dArray3[n3], (dArray[n] - dArray[n3]) * 2.0 + dArray3[n] + dArray3[n3]);
            n = n3;
        }
        return objectArray;
    }

    public double approxLength(Cubic[] cubicArray) {
        int n = cubicArray.length;
        double[] dArray = new double[cubicArray.length];
        double d = 0.0;
        double d2 = 0.0;
        double d3 = 0.0;
        while (true) {
            double d4;
            n = 0;
            int n2 = 0;
            double d5 = d;
            if (!(d2 < 1.0)) {
                while (n < cubicArray.length) {
                    d2 = dArray[n];
                    dArray[n] = d4 = cubicArray[n].eval(1.0);
                    d5 += (d2 -= d4) * d2;
                    ++n;
                }
                return d3 + Math.sqrt(d5);
            }
            d5 = 0.0;
            for (n = n2; n < cubicArray.length; d5 += d4 * d4, ++n) {
                double d6 = dArray[n];
                dArray[n] = d4 = cubicArray[n].eval(d2);
                d4 = d6 - d4;
            }
            d4 = d3;
            if (d2 > 0.0) {
                d4 = d3 + Math.sqrt(d5);
            }
            d2 += 0.1;
            d3 = d4;
        }
    }

    public double getPos(double d, int n) {
        double[] dArray;
        d *= this.mTotalLength;
        int n2 = 0;
        while (n2 < (dArray = this.mCurveLength).length - 1) {
            if (!(dArray[n2] < d)) return this.mCurve[n][n2].eval(d / this.mCurveLength[n2]);
            d -= dArray[n2];
            ++n2;
        }
        return this.mCurve[n][n2].eval(d / this.mCurveLength[n2]);
    }

    public void getPos(double d, double[] dArray) {
        int n;
        d *= this.mTotalLength;
        int n2 = 0;
        int n3 = 0;
        while (true) {
            double[] dArray2 = this.mCurveLength;
            n = n2;
            if (n3 >= dArray2.length - 1) break;
            n = n2;
            if (!(dArray2[n3] < d)) break;
            d -= dArray2[n3];
            ++n3;
        }
        while (n < dArray.length) {
            dArray[n] = this.mCurve[n][n3].eval(d / this.mCurveLength[n3]);
            ++n;
        }
    }

    public void getPos(double d, float[] fArray) {
        int n;
        d *= this.mTotalLength;
        int n2 = 0;
        int n3 = 0;
        while (true) {
            double[] dArray = this.mCurveLength;
            n = n2;
            if (n3 >= dArray.length - 1) break;
            n = n2;
            if (!(dArray[n3] < d)) break;
            d -= dArray[n3];
            ++n3;
        }
        while (n < fArray.length) {
            fArray[n] = (float)this.mCurve[n][n3].eval(d / this.mCurveLength[n3]);
            ++n;
        }
    }

    public void getVelocity(double d, double[] dArray) {
        int n;
        d *= this.mTotalLength;
        int n2 = 0;
        int n3 = 0;
        while (true) {
            double[] dArray2 = this.mCurveLength;
            n = n2;
            if (n3 >= dArray2.length - 1) break;
            n = n2;
            if (!(dArray2[n3] < d)) break;
            d -= dArray2[n3];
            ++n3;
        }
        while (n < dArray.length) {
            dArray[n] = this.mCurve[n][n3].vel(d / this.mCurveLength[n3]);
            ++n;
        }
    }

    public void setup(double[][] object) {
        Object object2;
        int n;
        int n2;
        this.mDimensionality = n2 = object[0].length;
        this.mPoints = n = ((double[][])object).length;
        this.mCtl = new double[n2][n];
        this.mCurve = new Cubic[this.mDimensionality][];
        for (n2 = 0; n2 < this.mDimensionality; ++n2) {
            for (n = 0; n < this.mPoints; ++n) {
                this.mCtl[n2][n] = object[n][n2];
            }
        }
        for (n2 = 0; n2 < (n = this.mDimensionality); ++n2) {
            object = this.mCurve;
            object2 = this.mCtl;
            object[n2] = (double[])HyperSpline.calcNaturalCubic(object2[n2].length, object2[n2]);
        }
        this.mCurveLength = new double[this.mPoints - 1];
        this.mTotalLength = 0.0;
        object2 = new Cubic[n];
        n2 = 0;
        while (n2 < this.mCurveLength.length) {
            for (n = 0; n < this.mDimensionality; ++n) {
                object2[n] = (double[])this.mCurve[n][n2];
            }
            double d = this.mTotalLength;
            object = this.mCurveLength;
            double d2 = this.approxLength((Cubic[])object2);
            object[n2] = (double[])d2;
            this.mTotalLength = d + d2;
            ++n2;
        }
    }
}
