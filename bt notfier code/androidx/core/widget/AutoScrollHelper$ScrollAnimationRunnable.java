/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.view.ViewCompat
 *  androidx.core.widget.AutoScrollHelper
 *  androidx.core.widget.AutoScrollHelper$ClampedScroller
 */
package androidx.core.widget;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.widget.AutoScrollHelper;

private class AutoScrollHelper.ScrollAnimationRunnable
implements Runnable {
    final AutoScrollHelper this$0;

    AutoScrollHelper.ScrollAnimationRunnable(AutoScrollHelper autoScrollHelper) {
        this.this$0 = autoScrollHelper;
    }

    @Override
    public void run() {
        AutoScrollHelper.ClampedScroller clampedScroller;
        if (!this.this$0.mAnimating) {
            return;
        }
        if (this.this$0.mNeedsReset) {
            this.this$0.mNeedsReset = false;
            this.this$0.mScroller.start();
        }
        if (!(clampedScroller = this.this$0.mScroller).isFinished() && this.this$0.shouldAnimate()) {
            if (this.this$0.mNeedsCancel) {
                this.this$0.mNeedsCancel = false;
                this.this$0.cancelTargetTouch();
            }
            clampedScroller.computeScrollDelta();
            int n = clampedScroller.getDeltaX();
            int n2 = clampedScroller.getDeltaY();
            this.this$0.scrollTargetBy(n, n2);
            ViewCompat.postOnAnimation((View)this.this$0.mTarget, (Runnable)this);
            return;
        }
        this.this$0.mAnimating = false;
    }
}
