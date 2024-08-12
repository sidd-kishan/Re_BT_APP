/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.View
 *  androidx.core.view.ViewCompat
 *  com.google.android.material.snackbar.BaseTransientBottomBar
 */
package com.google.android.material.snackbar;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/*
 * Exception performing whole class analysis ignored.
 */
class BaseTransientBottomBar.11
implements ValueAnimator.AnimatorUpdateListener {
    private int previousAnimatedIntValue;
    final BaseTransientBottomBar this$0;

    BaseTransientBottomBar.11(BaseTransientBottomBar baseTransientBottomBar) {
        this.this$0 = baseTransientBottomBar;
        this.previousAnimatedIntValue = 0;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int n = (Integer)valueAnimator.getAnimatedValue();
        if (BaseTransientBottomBar.access$200()) {
            ViewCompat.offsetTopAndBottom((View)this.this$0.view, (int)(n - this.previousAnimatedIntValue));
        } else {
            this.this$0.view.setTranslationY((float)n);
        }
        this.previousAnimatedIntValue = n;
    }
}
