/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  com.google.android.material.textfield.TextInputLayout
 */
package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import com.google.android.material.textfield.TextInputLayout;

class TextInputLayout.3
implements ValueAnimator.AnimatorUpdateListener {
    final TextInputLayout this$0;

    TextInputLayout.3(TextInputLayout textInputLayout) {
        this.this$0 = textInputLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.this$0.collapsingTextHelper.setExpansionFraction(((Float)valueAnimator.getAnimatedValue()).floatValue());
    }
}
