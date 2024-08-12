/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.widget.TextView
 *  com.qmuiteam.qmui.widget.QMUITabSegment
 *  com.qmuiteam.qmui.widget.QMUITabSegment$Tab
 *  com.qmuiteam.qmui.widget.QMUITabSegment$TabItemView
 */
package com.qmuiteam.qmui.widget;

import android.animation.Animator;
import android.widget.TextView;
import com.qmuiteam.qmui.widget.QMUITabSegment;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUITabSegment.3
implements Animator.AnimatorListener {
    final QMUITabSegment this$0;
    final int val$index;
    final QMUITabSegment.Tab val$nowModel;
    final QMUITabSegment.TabItemView val$nowView;
    final int val$prev;
    final QMUITabSegment.Tab val$prevModel;
    final QMUITabSegment.TabItemView val$prevView;

    QMUITabSegment.3(QMUITabSegment qMUITabSegment, QMUITabSegment.TabItemView tabItemView, QMUITabSegment.Tab tab, QMUITabSegment.TabItemView tabItemView2, QMUITabSegment.Tab tab2, int n, int n2) {
        this.this$0 = qMUITabSegment;
        this.val$prevView = tabItemView;
        this.val$prevModel = tab;
        this.val$nowView = tabItemView2;
        this.val$nowModel = tab2;
        this.val$index = n;
        this.val$prev = n2;
    }

    public void onAnimationCancel(Animator animator) {
        QMUITabSegment.access$002((QMUITabSegment)this.this$0, null);
        this.val$prevView.updateDecoration(this.val$prevModel, true);
        this.val$nowView.updateDecoration(this.val$nowModel, false);
        QMUITabSegment.access$1400((QMUITabSegment)this.this$0, (QMUITabSegment.Tab)this.val$prevModel, (boolean)true);
        QMUITabSegment.access$1202((QMUITabSegment)this.this$0, (boolean)false);
    }

    public void onAnimationEnd(Animator animator) {
        QMUITabSegment.access$002((QMUITabSegment)this.this$0, null);
        this.val$prevView.updateDecoration(this.val$prevModel, false);
        this.val$nowView.updateDecoration(this.val$nowModel, true);
        QMUITabSegment.access$800((QMUITabSegment)this.this$0, (int)this.val$index);
        QMUITabSegment.access$900((QMUITabSegment)this.this$0, (int)this.val$prev);
        QMUITabSegment.access$1000((QMUITabSegment)this.this$0, (TextView)this.val$prevView.getTextView(), (boolean)false);
        QMUITabSegment.access$1000((QMUITabSegment)this.this$0, (TextView)this.val$nowView.getTextView(), (boolean)true);
        QMUITabSegment.access$1102((QMUITabSegment)this.this$0, (int)this.val$index);
        QMUITabSegment.access$1202((QMUITabSegment)this.this$0, (boolean)false);
        if (QMUITabSegment.access$1300((QMUITabSegment)this.this$0) == -1) return;
        if (QMUITabSegment.access$100((QMUITabSegment)this.this$0) != 0) return;
        animator = this.this$0;
        animator.selectTab(QMUITabSegment.access$1300((QMUITabSegment)animator), true, false);
        QMUITabSegment.access$1302((QMUITabSegment)this.this$0, (int)-1);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        QMUITabSegment.access$002((QMUITabSegment)this.this$0, (Animator)animator);
    }
}
