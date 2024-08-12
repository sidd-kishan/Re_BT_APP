/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
 *  com.google.android.material.shadow.ShadowDrawableWrapper
 */
package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
import com.google.android.material.shadow.ShadowDrawableWrapper;

private abstract class FloatingActionButtonImpl.ShadowAnimatorImpl
extends AnimatorListenerAdapter
implements ValueAnimator.AnimatorUpdateListener {
    private float shadowSizeEnd;
    private float shadowSizeStart;
    final FloatingActionButtonImpl this$0;
    private boolean validValues;

    private FloatingActionButtonImpl.ShadowAnimatorImpl(FloatingActionButtonImpl floatingActionButtonImpl) {
        this.this$0 = floatingActionButtonImpl;
    }

    protected abstract float getTargetShadowSize();

    public void onAnimationEnd(Animator animator) {
        this.this$0.shadowDrawable.setShadowSize(this.shadowSizeEnd);
        this.validValues = false;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (!this.validValues) {
            this.shadowSizeStart = this.this$0.shadowDrawable.getShadowSize();
            this.shadowSizeEnd = this.getTargetShadowSize();
            this.validValues = true;
        }
        ShadowDrawableWrapper shadowDrawableWrapper = this.this$0.shadowDrawable;
        float f = this.shadowSizeStart;
        shadowDrawableWrapper.setShadowSize(f + (this.shadowSizeEnd - f) * valueAnimator.getAnimatedFraction());
    }
}
