/*
 * Decompiled with CFR 0.152.
 */
package androidx.exifinterface.media;

static class ExifInterface.ExifTag {
    public final String name;
    public final int number;
    public final int primaryFormat;
    public final int secondaryFormat;

    ExifInterface.ExifTag(String string, int n, int n2) {
        this.name = string;
        this.number = n;
        this.primaryFormat = n2;
        this.secondaryFormat = -1;
    }

    ExifInterface.ExifTag(String string, int n, int n2, int n3) {
        this.name = string;
        this.number = n;
        this.primaryFormat = n2;
        this.secondaryFormat = n3;
    }

    boolean isFormatCompatible(int n) {
        int n2 = this.primaryFormat;
        if (n2 == 7) return true;
        if (n == 7) return true;
        if (n2 == n) return true;
        int n3 = this.secondaryFormat;
        if (n3 == n) return true;
        if ((n2 == 4 || n3 == 4) && n == 3) {
            return true;
        }
        if ((this.primaryFormat == 9 || this.secondaryFormat == 9) && n == 8) {
            return true;
        }
        if (this.primaryFormat != 12) {
            if (this.secondaryFormat != 12) return false;
        }
        if (n != 11) return false;
        return true;
    }
}
