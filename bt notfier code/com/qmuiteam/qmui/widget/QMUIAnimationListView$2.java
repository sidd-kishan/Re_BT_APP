/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  com.qmuiteam.qmui.widget.QMUIAnimationListView
 */
package com.qmuiteam.qmui.widget;

import android.animation.ValueAnimator;
import com.qmuiteam.qmui.widget.QMUIAnimationListView;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIAnimationListView.2
implements ValueAnimator.AnimatorUpdateListener {
    final QMUIAnimationListView this$0;

    QMUIAnimationListView.2(QMUIAnimationListView qMUIAnimationListView) {
        this.this$0 = qMUIAnimationListView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        QMUIAnimationListView.access$302((QMUIAnimationListView)this.this$0, (long)valueAnimator.getCurrentPlayTime());
        this.this$0.invalidate();
    }
}
