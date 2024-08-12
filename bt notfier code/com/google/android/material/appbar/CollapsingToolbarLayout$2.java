/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  com.google.android.material.appbar.CollapsingToolbarLayout
 */
package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import com.google.android.material.appbar.CollapsingToolbarLayout;

class CollapsingToolbarLayout.2
implements ValueAnimator.AnimatorUpdateListener {
    final CollapsingToolbarLayout this$0;

    CollapsingToolbarLayout.2(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.this$0 = collapsingToolbarLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.this$0.setScrimAlpha(((Integer)valueAnimator.getAnimatedValue()).intValue());
    }
}
