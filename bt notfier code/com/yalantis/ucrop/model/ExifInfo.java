/*
 * Decompiled with CFR 0.152.
 */
package com.yalantis.ucrop.model;

public class ExifInfo {
    private int mExifDegrees;
    private int mExifOrientation;
    private int mExifTranslation;

    public ExifInfo(int n, int n2, int n3) {
        this.mExifOrientation = n;
        this.mExifDegrees = n2;
        this.mExifTranslation = n3;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (ExifInfo)object;
        if (this.mExifOrientation != ((ExifInfo)object).mExifOrientation) {
            return false;
        }
        if (this.mExifDegrees != ((ExifInfo)object).mExifDegrees) {
            return false;
        }
        if (this.mExifTranslation == ((ExifInfo)object).mExifTranslation) return bl;
        bl = false;
        return bl;
    }

    public int getExifDegrees() {
        return this.mExifDegrees;
    }

    public int getExifOrientation() {
        return this.mExifOrientation;
    }

    public int getExifTranslation() {
        return this.mExifTranslation;
    }

    public int hashCode() {
        return (this.mExifOrientation * 31 + this.mExifDegrees) * 31 + this.mExifTranslation;
    }

    public void setExifDegrees(int n) {
        this.mExifDegrees = n;
    }

    public void setExifOrientation(int n) {
        this.mExifOrientation = n;
    }

    public void setExifTranslation(int n) {
        this.mExifTranslation = n;
    }
}
