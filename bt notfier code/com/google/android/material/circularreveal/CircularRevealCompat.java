/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.TypeEvaluator
 *  android.os.Build$VERSION
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewAnimationUtils
 *  com.google.android.material.circularreveal.CircularRevealWidget
 *  com.google.android.material.circularreveal.CircularRevealWidget$CircularRevealEvaluator
 *  com.google.android.material.circularreveal.CircularRevealWidget$CircularRevealProperty
 *  com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo
 */
package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import com.google.android.material.circularreveal.CircularRevealWidget;

public final class CircularRevealCompat {
    private CircularRevealCompat() {
    }

    public static Animator createCircularReveal(CircularRevealWidget circularRevealWidget, float f, float f2, float f3) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofObject((Object)circularRevealWidget, (Property)CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, (TypeEvaluator)CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, (Object[])new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(f, f2, f3)});
        if (Build.VERSION.SDK_INT < 21) return objectAnimator;
        CircularRevealWidget.RevealInfo revealInfo = circularRevealWidget.getRevealInfo();
        if (revealInfo == null) throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        float f4 = revealInfo.radius;
        circularRevealWidget = ViewAnimationUtils.createCircularReveal((View)((View)circularRevealWidget), (int)((int)f), (int)((int)f2), (float)f4, (float)f3);
        revealInfo = new AnimatorSet();
        revealInfo.playTogether(new Animator[]{objectAnimator, circularRevealWidget});
        return revealInfo;
    }

    public static Animator createCircularReveal(CircularRevealWidget circularRevealWidget, float f, float f2, float f3, float f4) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofObject((Object)circularRevealWidget, (Property)CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, (TypeEvaluator)CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, (Object[])new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(f, f2, f3), new CircularRevealWidget.RevealInfo(f, f2, f4)});
        if (Build.VERSION.SDK_INT < 21) return objectAnimator;
        circularRevealWidget = ViewAnimationUtils.createCircularReveal((View)((View)circularRevealWidget), (int)((int)f), (int)((int)f2), (float)f3, (float)f4);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{objectAnimator, circularRevealWidget});
        return animatorSet;
    }

    public static Animator.AnimatorListener createCircularRevealListener(CircularRevealWidget circularRevealWidget) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }
}
