/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet
 */
package com.qmuiteam.qmui.widget.dialog;

import android.view.animation.Animation;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIBottomSheet.2
implements Animation.AnimationListener {
    final QMUIBottomSheet this$0;
    final Runnable val$dismissTask;

    QMUIBottomSheet.2(QMUIBottomSheet qMUIBottomSheet, Runnable runnable) {
        this.this$0 = qMUIBottomSheet;
        this.val$dismissTask = runnable;
    }

    public void onAnimationEnd(Animation animation) {
        QMUIBottomSheet.access$102((QMUIBottomSheet)this.this$0, (boolean)false);
        QMUIBottomSheet.access$200((QMUIBottomSheet)this.this$0).post(this.val$dismissTask);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        QMUIBottomSheet.access$102((QMUIBottomSheet)this.this$0, (boolean)true);
    }
}
