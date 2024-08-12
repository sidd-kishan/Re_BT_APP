/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 *  com.google.android.material.circularreveal.CircularRevealHelper$Delegate
 *  com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo
 */
package com.google.android.material.circularreveal;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;

public interface CircularRevealWidget
extends CircularRevealHelper.Delegate {
    public void buildCircularRevealCache();

    public void destroyCircularRevealCache();

    public void draw(Canvas var1);

    public Drawable getCircularRevealOverlayDrawable();

    public int getCircularRevealScrimColor();

    public RevealInfo getRevealInfo();

    public boolean isOpaque();

    public void setCircularRevealOverlayDrawable(Drawable var1);

    public void setCircularRevealScrimColor(int var1);

    public void setRevealInfo(RevealInfo var1);
}
