/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  com.yalantis.ucrop.view.OverlayView
 */
package com.yalantis.ucrop.view;

import android.animation.Animator;
import com.yalantis.ucrop.view.OverlayView;

/*
 * Exception performing whole class analysis ignored.
 */
class OverlayView.2
implements Animator.AnimatorListener {
    final OverlayView this$0;

    OverlayView.2(OverlayView overlayView) {
        this.this$0 = overlayView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        if (OverlayView.access$200((OverlayView)this.this$0) == null) return;
        OverlayView.access$200((OverlayView)this.this$0).onCropRectUpdated(OverlayView.access$000((OverlayView)this.this$0));
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
