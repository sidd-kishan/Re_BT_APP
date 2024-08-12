/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl.utils;

class ExifTag {
    public final String name;
    public final int number;
    public final int primaryFormat;
    public final int secondaryFormat;

    ExifTag(String string, int n, int n2) {
        this.name = string;
        this.number = n;
        this.primaryFormat = n2;
        this.secondaryFormat = -1;
    }

    ExifTag(String string, int n, int n2, int n3) {
        this.name = string;
        this.number = n;
        this.primaryFormat = n2;
        this.secondaryFormat = n3;
    }

    boolean isFormatCompatible(int n) {
        boolean bl;
        int n2 = this.primaryFormat;
        boolean bl2 = bl = true;
        if (n2 == 7) return bl2;
        if (n == 7) {
            bl2 = bl;
        } else {
            bl2 = bl;
            if (n2 == n) return bl2;
            int n3 = this.secondaryFormat;
            if (n3 == n) {
                bl2 = bl;
            } else {
                if ((n2 == 4 || n3 == 4) && n == 3) {
                    return true;
                }
                if ((this.primaryFormat == 9 || this.secondaryFormat == 9) && n == 8) {
                    return true;
                }
                bl2 = (this.primaryFormat == 12 || this.secondaryFormat == 12) && n == 11 ? bl : false;
            }
        }
        return bl2;
    }
}
