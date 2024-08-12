/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  com.google.android.material.circularreveal.CircularRevealWidget
 */
package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.circularreveal.CircularRevealWidget;

static final class CircularRevealCompat.1
extends AnimatorListenerAdapter {
    final CircularRevealWidget val$view;

    CircularRevealCompat.1(CircularRevealWidget circularRevealWidget) {
        this.val$view = circularRevealWidget;
    }

    public void onAnimationEnd(Animator animator) {
        this.val$view.destroyCircularRevealCache();
    }

    public void onAnimationStart(Animator animator) {
        this.val$view.buildCircularRevealCache();
    }
}
