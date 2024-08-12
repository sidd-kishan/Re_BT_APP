/*
 * Decompiled with CFR 0.152.
 */
package androidx.exifinterface.media;

private static class ExifInterface.Rational {
    public final long denominator;
    public final long numerator;

    ExifInterface.Rational(double d) {
        this((long)(d * 10000.0), 10000L);
    }

    ExifInterface.Rational(long l, long l2) {
        if (l2 == 0L) {
            this.numerator = 0L;
            this.denominator = 1L;
            return;
        }
        this.numerator = l;
        this.denominator = l2;
    }

    public double calculate() {
        double d = this.numerator;
        double d2 = this.denominator;
        Double.isNaN(d);
        Double.isNaN(d2);
        return d / d2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.numerator);
        stringBuilder.append("/");
        stringBuilder.append(this.denominator);
        return stringBuilder.toString();
    }
}
