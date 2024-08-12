/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  androidx.swiperefreshlayout.widget.CircularProgressDrawable
 *  androidx.swiperefreshlayout.widget.CircularProgressDrawable$Ring
 */
package androidx.swiperefreshlayout.widget;

import android.animation.ValueAnimator;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

class CircularProgressDrawable.1
implements ValueAnimator.AnimatorUpdateListener {
    final CircularProgressDrawable this$0;
    final CircularProgressDrawable.Ring val$ring;

    CircularProgressDrawable.1(CircularProgressDrawable circularProgressDrawable, CircularProgressDrawable.Ring ring) {
        this.this$0 = circularProgressDrawable;
        this.val$ring = ring;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f = ((Float)valueAnimator.getAnimatedValue()).floatValue();
        this.this$0.updateRingColor(f, this.val$ring);
        this.this$0.applyTransformation(f, this.val$ring, false);
        this.this$0.invalidateSelf();
    }
}
