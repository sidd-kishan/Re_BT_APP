/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.motion.utils.CurveFit
 */
package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.utils.CurveFit;

static class CurveFit.Constant
extends CurveFit {
    double mTime;
    double[] mValue;

    CurveFit.Constant(double d, double[] dArray) {
        this.mTime = d;
        this.mValue = dArray;
    }

    public double getPos(double d, int n) {
        return this.mValue[n];
    }

    public void getPos(double d, double[] dArray) {
        double[] dArray2 = this.mValue;
        System.arraycopy(dArray2, 0, dArray, 0, dArray2.length);
    }

    public void getPos(double d, float[] fArray) {
        double[] dArray;
        int n = 0;
        while (n < (dArray = this.mValue).length) {
            fArray[n] = (float)dArray[n];
            ++n;
        }
    }

    public double getSlope(double d, int n) {
        return 0.0;
    }

    public void getSlope(double d, double[] dArray) {
        int n = 0;
        while (n < this.mValue.length) {
            dArray[n] = 0.0;
            ++n;
        }
    }

    public double[] getTimePoints() {
        return new double[]{this.mTime};
    }
}
