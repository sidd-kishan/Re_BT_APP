/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 *  com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo
 *  com.google.android.material.math.MathUtils
 */
package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.math.MathUtils;

public static class CircularRevealWidget.CircularRevealEvaluator
implements TypeEvaluator<CircularRevealWidget.RevealInfo> {
    public static final TypeEvaluator<CircularRevealWidget.RevealInfo> CIRCULAR_REVEAL = new CircularRevealWidget.CircularRevealEvaluator();
    private final CircularRevealWidget.RevealInfo revealInfo = new CircularRevealWidget.RevealInfo(null);

    public CircularRevealWidget.RevealInfo evaluate(float f, CircularRevealWidget.RevealInfo revealInfo, CircularRevealWidget.RevealInfo revealInfo2) {
        this.revealInfo.set(MathUtils.lerp((float)revealInfo.centerX, (float)revealInfo2.centerX, (float)f), MathUtils.lerp((float)revealInfo.centerY, (float)revealInfo2.centerY, (float)f), MathUtils.lerp((float)revealInfo.radius, (float)revealInfo2.radius, (float)f));
        return this.revealInfo;
    }
}
