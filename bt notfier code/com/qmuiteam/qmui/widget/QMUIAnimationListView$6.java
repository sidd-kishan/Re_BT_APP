/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.view.View
 *  com.qmuiteam.qmui.widget.QMUIAnimationListView
 *  com.qmuiteam.qmui.widget.QMUIAnimationListView$ManipulateAnimatorListener
 */
package com.qmuiteam.qmui.widget;

import android.animation.Animator;
import android.view.View;
import com.qmuiteam.qmui.widget.QMUIAnimationListView;
import java.lang.ref.WeakReference;

class QMUIAnimationListView.6
extends QMUIAnimationListView.ManipulateAnimatorListener {
    final QMUIAnimationListView this$0;
    final boolean val$fadeIn;
    final WeakReference val$wr;

    QMUIAnimationListView.6(QMUIAnimationListView qMUIAnimationListView, WeakReference weakReference, boolean bl) {
        this.this$0 = qMUIAnimationListView;
        this.val$wr = weakReference;
        this.val$fadeIn = bl;
        super(qMUIAnimationListView, null);
    }

    public void onAnimationEnd(Animator animator) {
        if (this.val$wr.get() == null) return;
        animator = (View)this.val$wr.get();
        float f = this.val$fadeIn ? 0.0f : 1.0f;
        animator.setAlpha(f);
    }
}
