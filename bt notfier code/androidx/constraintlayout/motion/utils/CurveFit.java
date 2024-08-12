/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.motion.utils.ArcCurveFit
 *  androidx.constraintlayout.motion.utils.CurveFit$Constant
 *  androidx.constraintlayout.motion.utils.LinearCurveFit
 *  androidx.constraintlayout.motion.utils.MonotonicCurveFit
 */
package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.utils.ArcCurveFit;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.LinearCurveFit;
import androidx.constraintlayout.motion.utils.MonotonicCurveFit;

public abstract class CurveFit {
    public static final int CONSTANT = 2;
    public static final int LINEAR = 1;
    public static final int SPLINE = 0;

    public static CurveFit get(int n, double[] dArray, double[][] dArray2) {
        if (dArray.length == 1) {
            n = 2;
        }
        if (n == 0) return new MonotonicCurveFit(dArray, dArray2);
        if (n == 2) return new Constant(dArray[0], dArray2[0]);
        return new LinearCurveFit(dArray, dArray2);
    }

    public static CurveFit getArc(int[] nArray, double[] dArray, double[][] dArray2) {
        return new ArcCurveFit(nArray, dArray, dArray2);
    }

    public abstract double getPos(double var1, int var3);

    public abstract void getPos(double var1, double[] var3);

    public abstract void getPos(double var1, float[] var3);

    public abstract double getSlope(double var1, int var3);

    public abstract void getSlope(double var1, double[] var3);

    public abstract double[] getTimePoints();
}
