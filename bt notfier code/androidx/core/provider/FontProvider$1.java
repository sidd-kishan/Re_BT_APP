/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.provider;

import java.util.Comparator;

class FontProvider.1
implements Comparator<byte[]> {
    FontProvider.1() {
    }

    /*
     * Enabled force condition propagation
     */
    @Override
    public int compare(byte[] byArray, byte[] byArray2) {
        int n;
        int n2;
        if (byArray.length != byArray2.length) {
            n2 = byArray.length;
            n = byArray2.length;
            return n2 - n;
        }
        n = 0;
        while (n < byArray.length) {
            if (byArray[n] != byArray2[n]) {
                n2 = byArray[n];
                n = byArray2[n];
                return n2 - n;
            }
            ++n;
        }
        return 0;
    }
}
