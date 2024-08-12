/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  androidx.recyclerview.widget.FastScroller
 */
package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.recyclerview.widget.FastScroller;

private class FastScroller.AnimatorListener
extends AnimatorListenerAdapter {
    private boolean mCanceled;
    final FastScroller this$0;

    FastScroller.AnimatorListener(FastScroller fastScroller) {
        this.this$0 = fastScroller;
        this.mCanceled = false;
    }

    public void onAnimationCancel(Animator animator) {
        this.mCanceled = true;
    }

    public void onAnimationEnd(Animator animator) {
        if (this.mCanceled) {
            this.mCanceled = false;
            return;
        }
        if (((Float)this.this$0.mShowHideAnimator.getAnimatedValue()).floatValue() == 0.0f) {
            this.this$0.mAnimationState = 0;
            this.this$0.setState(0);
        } else {
            this.this$0.mAnimationState = 2;
            this.this$0.requestRedraw();
        }
    }
}
