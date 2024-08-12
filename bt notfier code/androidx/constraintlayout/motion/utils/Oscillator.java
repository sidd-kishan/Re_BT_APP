/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.motion.utils;

import java.util.Arrays;

public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double PI2;
    double[] mArea;
    private boolean mNormalized = false;
    float[] mPeriod = new float[0];
    double[] mPosition = new double[0];
    int mType;

    public Oscillator() {
        this.PI2 = Math.PI * 2;
    }

    public void addPoint(double d, float f) {
        int n;
        int n2 = this.mPeriod.length + 1;
        int n3 = n = Arrays.binarySearch(this.mPosition, d);
        if (n < 0) {
            n3 = -n - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, n2);
        this.mPeriod = Arrays.copyOf(this.mPeriod, n2);
        this.mArea = new double[n2];
        double[] dArray = this.mPosition;
        System.arraycopy(dArray, n3, dArray, n3 + 1, n2 - n3 - 1);
        this.mPosition[n3] = d;
        this.mPeriod[n3] = f;
        this.mNormalized = false;
    }

    double getDP(double d) {
        double d2;
        double d3 = 0.0;
        if (d <= 0.0) {
            d2 = 1.0E-5;
        } else {
            d2 = d;
            if (d >= 1.0) {
                d2 = 0.999999;
            }
        }
        int n = Arrays.binarySearch(this.mPosition, d2);
        if (n > 0) {
            return 0.0;
        }
        d = d3;
        if (n == 0) return d;
        n = -n - 1;
        float[] fArray = this.mPeriod;
        float f = fArray[n];
        int n2 = n - 1;
        d = f - fArray[n2];
        double[] dArray = this.mPosition;
        d3 = dArray[n];
        double d4 = dArray[n2];
        Double.isNaN(d);
        d /= d3 - d4;
        d3 = fArray[n2];
        d4 = dArray[n2];
        Double.isNaN(d3);
        d = d3 - d * d4 + d2 * d;
        return d;
    }

    double getP(double d) {
        double d2;
        double d3 = 1.0;
        if (d < 0.0) {
            d2 = 0.0;
        } else {
            d2 = d;
            if (d > 1.0) {
                d2 = 1.0;
            }
        }
        int n = Arrays.binarySearch(this.mPosition, d2);
        if (n > 0) {
            d = d3;
        } else if (n != 0) {
            n = -n - 1;
            float[] fArray = this.mPeriod;
            float f = fArray[n];
            int n2 = n - 1;
            d3 = f - fArray[n2];
            double[] dArray = this.mPosition;
            d = dArray[n];
            double d4 = dArray[n2];
            Double.isNaN(d3);
            double d5 = d3 / (d - d4);
            d3 = this.mArea[n2];
            d4 = fArray[n2];
            d = dArray[n2];
            Double.isNaN(d4);
            d = d3 + (d4 - d * d5) * (d2 - dArray[n2]) + d5 * (d2 * d2 - dArray[n2] * dArray[n2]) / 2.0;
        } else {
            d = 0.0;
        }
        return d;
    }

    /*
     * Enabled force condition propagation
     */
    public double getSlope(double d) {
        switch (this.mType) {
            default: {
                double d2 = this.PI2 * this.getDP(d);
                double d3 = Math.cos(this.PI2 * this.getP(d));
                d = d2;
                return d * d3;
            }
            case 6: {
                double d4 = this.getDP(d) * 4.0;
                double d5 = (this.getP(d) * 4.0 + 2.0) % 4.0 - 2.0;
                d = d4;
                return d * d5;
            }
            case 5: {
                double d3 = -this.PI2 * this.getDP(d);
                double d6 = Math.sin(this.PI2 * this.getP(d));
                d = d3;
                d3 = d6;
                return d * d3;
            }
            case 4: {
                d = -this.getDP(d);
                return d * 2.0;
            }
            case 3: {
                d = this.getDP(d);
                return d * 2.0;
            }
            case 2: {
                double d7 = this.getDP(d) * 4.0;
                double d5 = Math.signum((this.getP(d) * 4.0 + 3.0) % 4.0 - 2.0);
                d = d7;
                return d * d5;
            }
            case 1: 
        }
        return 0.0;
    }

    /*
     * Enabled force condition propagation
     */
    public double getValue(double d) {
        switch (this.mType) {
            default: {
                return Math.sin(this.PI2 * this.getP(d));
            }
            case 6: {
                d = 1.0 - Math.abs(this.getP(d) * 4.0 % 4.0 - 2.0);
                d *= d;
                return 1.0 - d;
            }
            case 5: {
                return Math.cos(this.PI2 * this.getP(d));
            }
            case 4: {
                d = (this.getP(d) * 2.0 + 1.0) % 2.0;
                return 1.0 - d;
            }
            case 3: {
                return (this.getP(d) * 2.0 + 1.0) % 2.0 - 1.0;
            }
            case 2: {
                d = Math.abs((this.getP(d) * 4.0 + 1.0) % 4.0 - 2.0);
                return 1.0 - d;
            }
            case 1: 
        }
        return Math.signum(0.5 - this.getP(d) % 1.0);
    }

    public void normalize() {
        float f;
        int n;
        double d;
        double d2;
        float f2;
        Object[] objectArray;
        int n2;
        double d3;
        double d4 = 0.0;
        for (n2 = 0; n2 < (objectArray = this.mPeriod).length; d4 += d3, ++n2) {
            d3 = objectArray[n2];
            Double.isNaN(d3);
        }
        d3 = 0.0;
        for (n2 = 1; n2 < (objectArray = this.mPeriod).length; d3 += (f2 - d2) * d, ++n2) {
            n = n2 - 1;
            f = (objectArray[n] + objectArray[n2]) / 2.0f;
            objectArray = this.mPosition;
            f2 = objectArray[n2];
            d2 = objectArray[n];
            d = f;
            Double.isNaN(d);
        }
        for (n2 = 0; n2 < (objectArray = this.mPeriod).length; ++n2) {
            d = objectArray[n2];
            d2 = d4 / d3;
            Double.isNaN(d);
            objectArray[n2] = (float)(d * d2);
        }
        this.mArea[0] = 0.0;
        n2 = 1;
        while (true) {
            if (n2 >= (objectArray = this.mPeriod).length) {
                this.mNormalized = true;
                return;
            }
            n = n2 - 1;
            f = (objectArray[n] + objectArray[n2]) / 2.0f;
            objectArray = this.mPosition;
            d4 = objectArray[n2];
            d = objectArray[n];
            objectArray = this.mArea;
            d3 = objectArray[n];
            d2 = f;
            Double.isNaN(d2);
            objectArray[n2] = (float)(d3 + (d4 - d) * d2);
            ++n2;
        }
    }

    public void setType(int n) {
        this.mType = n;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("pos =");
        stringBuilder.append(Arrays.toString(this.mPosition));
        stringBuilder.append(" period=");
        stringBuilder.append(Arrays.toString(this.mPeriod));
        return stringBuilder.toString();
    }
}
