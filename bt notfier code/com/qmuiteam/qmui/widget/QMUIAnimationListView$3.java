/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  com.qmuiteam.qmui.widget.QMUIAnimationListView
 */
package com.qmuiteam.qmui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.qmuiteam.qmui.widget.QMUIAnimationListView;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIAnimationListView.3
extends AnimatorListenerAdapter {
    final QMUIAnimationListView this$0;

    QMUIAnimationListView.3(QMUIAnimationListView qMUIAnimationListView) {
        this.this$0 = qMUIAnimationListView;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        QMUIAnimationListView.access$302((QMUIAnimationListView)this.this$0, (long)0L);
    }
}
