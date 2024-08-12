/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.common.images;

public final class Size {
    private final int zaa;
    private final int zab;

    public Size(int n, int n2) {
        this.zaa = n;
        this.zab = n2;
    }

    public static Size parseSize(String string) throws NumberFormatException {
        int n;
        if (string == null) throw new IllegalArgumentException("string must not be null");
        int n2 = n = string.indexOf(42);
        if (n < 0) {
            n2 = string.indexOf(120);
        }
        if (n2 < 0) throw Size.zaa(string);
        try {
            Size size = new Size(Integer.parseInt(string.substring(0, n2)), Integer.parseInt(string.substring(n2 + 1)));
            return size;
        }
        catch (NumberFormatException numberFormatException) {
            throw Size.zaa(string);
        }
    }

    private static NumberFormatException zaa(String string) {
        StringBuilder stringBuilder = new StringBuilder(string.length() + 16);
        stringBuilder.append("Invalid Size: \"");
        stringBuilder.append(string);
        stringBuilder.append("\"");
        throw new NumberFormatException(stringBuilder.toString());
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!(object instanceof Size)) return false;
        object = (Size)object;
        if (this.zaa != ((Size)object).zaa) return false;
        if (this.zab != ((Size)object).zab) return false;
        return true;
    }

    public int getHeight() {
        return this.zab;
    }

    public int getWidth() {
        return this.zaa;
    }

    public int hashCode() {
        int n = this.zab;
        int n2 = this.zaa;
        return n ^ (n2 >>> 16 | n2 << 16);
    }

    public String toString() {
        int n = this.zaa;
        int n2 = this.zab;
        StringBuilder stringBuilder = new StringBuilder(23);
        stringBuilder.append(n);
        stringBuilder.append("x");
        stringBuilder.append(n2);
        return stringBuilder.toString();
    }
}
