/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Rational
 */
package androidx.camera.core;

import android.util.Rational;

public final class ViewPort {
    public static final int FILL_CENTER = 1;
    public static final int FILL_END = 2;
    public static final int FILL_START = 0;
    public static final int FIT = 3;
    private Rational mAspectRatio;
    private int mLayoutDirection;
    private int mRotation;
    private int mScaleType;

    ViewPort(int n, Rational rational, int n2, int n3) {
        this.mScaleType = n;
        this.mAspectRatio = rational;
        this.mRotation = n2;
        this.mLayoutDirection = n3;
    }

    public Rational getAspectRatio() {
        return this.mAspectRatio;
    }

    public int getLayoutDirection() {
        return this.mLayoutDirection;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public int getScaleType() {
        return this.mScaleType;
    }
}
