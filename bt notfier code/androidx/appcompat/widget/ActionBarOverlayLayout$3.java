/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  androidx.appcompat.widget.ActionBarOverlayLayout
 */
package androidx.appcompat.widget;

import android.animation.Animator;
import androidx.appcompat.widget.ActionBarOverlayLayout;

class ActionBarOverlayLayout.3
implements Runnable {
    final ActionBarOverlayLayout this$0;

    ActionBarOverlayLayout.3(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.this$0 = actionBarOverlayLayout;
    }

    @Override
    public void run() {
        this.this$0.haltActionBarHideOffsetAnimations();
        ActionBarOverlayLayout actionBarOverlayLayout = this.this$0;
        actionBarOverlayLayout.mCurrentActionBarTopAnimator = actionBarOverlayLayout.mActionBarTop.animate().translationY((float)(-this.this$0.mActionBarTop.getHeight())).setListener((Animator.AnimatorListener)this.this$0.mTopAnimatorListener);
    }
}
