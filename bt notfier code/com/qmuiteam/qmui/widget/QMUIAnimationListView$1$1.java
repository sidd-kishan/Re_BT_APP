/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  com.qmuiteam.qmui.widget.QMUIAnimationListView
 *  com.qmuiteam.qmui.widget.QMUIAnimationListView$1
 */
package com.qmuiteam.qmui.widget;

import android.view.ViewTreeObserver;
import com.qmuiteam.qmui.widget.QMUIAnimationListView;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIAnimationListView.1
implements ViewTreeObserver.OnPreDrawListener {
    final QMUIAnimationListView.1 this$1;

    QMUIAnimationListView.1(QMUIAnimationListView.1 var1_1) {
        this.this$1 = var1_1;
    }

    public boolean onPreDraw() {
        this.this$1.this$0.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
        QMUIAnimationListView.access$200((QMUIAnimationListView)this.this$1.this$0);
        return true;
    }
}
