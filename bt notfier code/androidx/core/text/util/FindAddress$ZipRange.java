/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.text.util;

private static class FindAddress.ZipRange {
    int mException1;
    int mException2;
    int mHigh;
    int mLow;

    FindAddress.ZipRange(int n, int n2, int n3, int n4) {
        this.mLow = n;
        this.mHigh = n2;
        this.mException1 = n3;
        this.mException2 = n4;
    }

    boolean matches(String string) {
        boolean bl = false;
        int n = Integer.parseInt(string.substring(0, 2));
        if ((this.mLow > n || n > this.mHigh) && n != this.mException1) {
            if (n != this.mException2) return bl;
        }
        bl = true;
        return bl;
    }
}
