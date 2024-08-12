/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  com.qmuiteam.qmui.widget.QMUIAnimationListView
 */
package com.qmuiteam.qmui.widget;

import android.animation.Animator;
import com.qmuiteam.qmui.widget.QMUIAnimationListView;

private abstract class QMUIAnimationListView.ManipulateAnimatorListener
implements Animator.AnimatorListener {
    final QMUIAnimationListView this$0;

    private QMUIAnimationListView.ManipulateAnimatorListener(QMUIAnimationListView qMUIAnimationListView) {
        this.this$0 = qMUIAnimationListView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
