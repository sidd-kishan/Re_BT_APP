/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  androidx.swiperefreshlayout.widget.CircularProgressDrawable
 *  androidx.swiperefreshlayout.widget.CircularProgressDrawable$Ring
 */
package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

class CircularProgressDrawable.2
implements Animator.AnimatorListener {
    final CircularProgressDrawable this$0;
    final CircularProgressDrawable.Ring val$ring;

    CircularProgressDrawable.2(CircularProgressDrawable circularProgressDrawable, CircularProgressDrawable.Ring ring) {
        this.this$0 = circularProgressDrawable;
        this.val$ring = ring;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
        this.this$0.applyTransformation(1.0f, this.val$ring, true);
        this.val$ring.storeOriginals();
        this.val$ring.goToNextColor();
        if (this.this$0.mFinishing) {
            this.this$0.mFinishing = false;
            animator.cancel();
            animator.setDuration(1332L);
            animator.start();
            this.val$ring.setShowArrow(false);
        } else {
            animator = this.this$0;
            animator.mRotationCount += 1.0f;
        }
    }

    public void onAnimationStart(Animator animator) {
        this.this$0.mRotationCount = 0.0f;
    }
}
