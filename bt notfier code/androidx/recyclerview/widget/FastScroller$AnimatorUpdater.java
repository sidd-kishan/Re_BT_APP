/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  androidx.recyclerview.widget.FastScroller
 */
package androidx.recyclerview.widget;

import android.animation.ValueAnimator;
import androidx.recyclerview.widget.FastScroller;

private class FastScroller.AnimatorUpdater
implements ValueAnimator.AnimatorUpdateListener {
    final FastScroller this$0;

    FastScroller.AnimatorUpdater(FastScroller fastScroller) {
        this.this$0 = fastScroller;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int n = (int)(((Float)valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
        this.this$0.mVerticalThumbDrawable.setAlpha(n);
        this.this$0.mVerticalTrackDrawable.setAlpha(n);
        this.this$0.requestRedraw();
    }
}
