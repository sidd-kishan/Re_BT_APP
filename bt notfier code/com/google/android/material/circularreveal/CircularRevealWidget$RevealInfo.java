/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.material.circularreveal;

public static class CircularRevealWidget.RevealInfo {
    public static final float INVALID_RADIUS = Float.MAX_VALUE;
    public float centerX;
    public float centerY;
    public float radius;

    private CircularRevealWidget.RevealInfo() {
    }

    public CircularRevealWidget.RevealInfo(float f, float f2, float f3) {
        this.centerX = f;
        this.centerY = f2;
        this.radius = f3;
    }

    public CircularRevealWidget.RevealInfo(CircularRevealWidget.RevealInfo revealInfo) {
        this(revealInfo.centerX, revealInfo.centerY, revealInfo.radius);
    }

    public boolean isInvalid() {
        boolean bl = this.radius == Float.MAX_VALUE;
        return bl;
    }

    public void set(float f, float f2, float f3) {
        this.centerX = f;
        this.centerY = f2;
        this.radius = f3;
    }

    public void set(CircularRevealWidget.RevealInfo revealInfo) {
        this.set(revealInfo.centerX, revealInfo.centerY, revealInfo.radius);
    }
}
