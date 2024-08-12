/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  com.qmuiteam.qmui.widget.QMUIAnimationListView
 *  com.qmuiteam.qmui.widget.QMUIAnimationListView$ManipulateAnimatorListener
 */
package com.qmuiteam.qmui.widget;

import android.animation.Animator;
import android.view.ViewTreeObserver;
import com.qmuiteam.qmui.widget.QMUIAnimationListView;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIAnimationListView.1
extends QMUIAnimationListView.ManipulateAnimatorListener {
    final QMUIAnimationListView this$0;

    QMUIAnimationListView.1(QMUIAnimationListView qMUIAnimationListView) {
        this.this$0 = qMUIAnimationListView;
        super(qMUIAnimationListView, null);
    }

    public void onAnimationEnd(Animator animator) {
        QMUIAnimationListView.access$100((QMUIAnimationListView)this.this$0).notifyDataSetChanged();
        this.this$0.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new /* Unavailable Anonymous Inner Class!! */);
    }
}
