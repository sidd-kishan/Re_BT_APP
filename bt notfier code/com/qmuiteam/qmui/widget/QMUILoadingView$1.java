/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  com.qmuiteam.qmui.widget.QMUILoadingView
 */
package com.qmuiteam.qmui.widget;

import android.animation.ValueAnimator;
import com.qmuiteam.qmui.widget.QMUILoadingView;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUILoadingView.1
implements ValueAnimator.AnimatorUpdateListener {
    final QMUILoadingView this$0;

    QMUILoadingView.1(QMUILoadingView qMUILoadingView) {
        this.this$0 = qMUILoadingView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        QMUILoadingView.access$002((QMUILoadingView)this.this$0, (int)((Integer)valueAnimator.getAnimatedValue()));
        this.this$0.invalidate();
    }
}
