/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  com.qmuiteam.qmui.widget.QMUIAnimationListView
 *  com.qmuiteam.qmui.widget.QMUIAnimationListView$ManipulateAnimatorListener
 */
package com.qmuiteam.qmui.widget;

import android.animation.Animator;
import com.qmuiteam.qmui.widget.QMUIAnimationListView;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIAnimationListView.4
extends QMUIAnimationListView.ManipulateAnimatorListener {
    final QMUIAnimationListView this$0;

    QMUIAnimationListView.4(QMUIAnimationListView qMUIAnimationListView) {
        this.this$0 = qMUIAnimationListView;
        super(qMUIAnimationListView, null);
    }

    public void onAnimationEnd(Animator animator) {
        QMUIAnimationListView.access$400((QMUIAnimationListView)this.this$0);
    }
}
