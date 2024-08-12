/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.ViewPropertyAnimator
 *  androidx.appcompat.widget.ScrollingTabContainerView
 */
package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;
import androidx.appcompat.widget.ScrollingTabContainerView;

protected class ScrollingTabContainerView.VisibilityAnimListener
extends AnimatorListenerAdapter {
    private boolean mCanceled;
    private int mFinalVisibility;
    final ScrollingTabContainerView this$0;

    protected ScrollingTabContainerView.VisibilityAnimListener(ScrollingTabContainerView scrollingTabContainerView) {
        this.this$0 = scrollingTabContainerView;
        this.mCanceled = false;
    }

    public void onAnimationCancel(Animator animator) {
        this.mCanceled = true;
    }

    public void onAnimationEnd(Animator animator) {
        if (this.mCanceled) {
            return;
        }
        this.this$0.mVisibilityAnim = null;
        this.this$0.setVisibility(this.mFinalVisibility);
    }

    public void onAnimationStart(Animator animator) {
        this.this$0.setVisibility(0);
        this.mCanceled = false;
    }

    public ScrollingTabContainerView.VisibilityAnimListener withFinalVisibility(ViewPropertyAnimator viewPropertyAnimator, int n) {
        this.mFinalVisibility = n;
        this.this$0.mVisibilityAnim = viewPropertyAnimator;
        return this;
    }
}
