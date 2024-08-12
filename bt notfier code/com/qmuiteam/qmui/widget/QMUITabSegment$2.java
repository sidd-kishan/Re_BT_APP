/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  com.qmuiteam.qmui.util.QMUIColorHelper
 *  com.qmuiteam.qmui.widget.QMUITabSegment
 *  com.qmuiteam.qmui.widget.QMUITabSegment$Tab
 *  com.qmuiteam.qmui.widget.QMUITabSegment$TabItemView
 */
package com.qmuiteam.qmui.widget;

import android.animation.ValueAnimator;
import com.qmuiteam.qmui.util.QMUIColorHelper;
import com.qmuiteam.qmui.widget.QMUITabSegment;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUITabSegment.2
implements ValueAnimator.AnimatorUpdateListener {
    final QMUITabSegment this$0;
    final QMUITabSegment.Tab val$nowModel;
    final QMUITabSegment.TabItemView val$nowView;
    final QMUITabSegment.Tab val$prevModel;
    final QMUITabSegment.TabItemView val$prevView;

    QMUITabSegment.2(QMUITabSegment qMUITabSegment, QMUITabSegment.Tab tab, QMUITabSegment.Tab tab2, QMUITabSegment.TabItemView tabItemView, QMUITabSegment.TabItemView tabItemView2) {
        this.this$0 = qMUITabSegment;
        this.val$prevModel = tab;
        this.val$nowModel = tab2;
        this.val$prevView = tabItemView;
        this.val$nowView = tabItemView2;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f = ((Float)valueAnimator.getAnimatedValue()).floatValue();
        int n = QMUIColorHelper.computeColor((int)QMUITabSegment.access$500((QMUITabSegment)this.this$0, (QMUITabSegment.Tab)this.val$prevModel), (int)QMUITabSegment.access$600((QMUITabSegment)this.this$0, (QMUITabSegment.Tab)this.val$prevModel), (float)f);
        int n2 = QMUIColorHelper.computeColor((int)QMUITabSegment.access$600((QMUITabSegment)this.this$0, (QMUITabSegment.Tab)this.val$nowModel), (int)QMUITabSegment.access$500((QMUITabSegment)this.this$0, (QMUITabSegment.Tab)this.val$nowModel), (float)f);
        this.val$prevView.setColorInTransition(this.val$prevModel, n);
        this.val$nowView.setColorInTransition(this.val$nowModel, n2);
        QMUITabSegment.access$700((QMUITabSegment)this.this$0, (QMUITabSegment.Tab)this.val$prevModel, (QMUITabSegment.Tab)this.val$nowModel, (float)f);
    }
}
