/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.graphics.RectF
 *  com.yalantis.ucrop.view.OverlayView
 */
package com.yalantis.ucrop.view;

import android.animation.ValueAnimator;
import android.graphics.RectF;
import com.yalantis.ucrop.view.OverlayView;

/*
 * Exception performing whole class analysis ignored.
 */
class OverlayView.1
implements ValueAnimator.AnimatorUpdateListener {
    float lastAnimationValue;
    final OverlayView this$0;
    final RectF val$before;
    final int val$offsetX;
    final int val$offsetY;

    OverlayView.1(OverlayView overlayView, int n, int n2, RectF rectF) {
        this.this$0 = overlayView;
        this.val$offsetX = n;
        this.val$offsetY = n2;
        this.val$before = rectF;
        this.lastAnimationValue = 0.0f;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f = (float)this.val$offsetX * ((Float)valueAnimator.getAnimatedValue()).floatValue();
        float f2 = (float)this.val$offsetY * ((Float)valueAnimator.getAnimatedValue()).floatValue();
        OverlayView.access$000((OverlayView)this.this$0).set(new RectF(this.val$before.left + f, this.val$before.top + f2, this.val$before.right + f, this.val$before.bottom + f2));
        OverlayView.access$100((OverlayView)this.this$0);
        this.this$0.postInvalidate();
        if (OverlayView.access$200((OverlayView)this.this$0) != null) {
            OverlayView.access$200((OverlayView)this.this$0).postTranslate((float)this.val$offsetX * (((Float)valueAnimator.getAnimatedValue()).floatValue() - this.lastAnimationValue), (float)this.val$offsetY * (((Float)valueAnimator.getAnimatedValue()).floatValue() - this.lastAnimationValue));
        }
        this.lastAnimationValue = ((Float)valueAnimator.getAnimatedValue()).floatValue();
    }
}
