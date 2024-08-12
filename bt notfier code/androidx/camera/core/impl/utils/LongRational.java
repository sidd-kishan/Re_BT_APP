/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl.utils;

final class LongRational {
    private final long mDenominator;
    private final long mNumerator;

    LongRational(double d) {
        this((long)(d * 10000.0), 10000L);
    }

    LongRational(long l, long l2) {
        this.mNumerator = l;
        this.mDenominator = l2;
    }

    long getDenominator() {
        return this.mDenominator;
    }

    long getNumerator() {
        return this.mNumerator;
    }

    double toDouble() {
        double d = this.mNumerator;
        double d2 = this.mDenominator;
        Double.isNaN(d);
        Double.isNaN(d2);
        return d / d2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mNumerator);
        stringBuilder.append("/");
        stringBuilder.append(this.mDenominator);
        return stringBuilder.toString();
    }
}
