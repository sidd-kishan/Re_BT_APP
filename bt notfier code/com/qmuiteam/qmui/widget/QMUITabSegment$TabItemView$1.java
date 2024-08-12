/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  com.qmuiteam.qmui.widget.QMUITabSegment
 *  com.qmuiteam.qmui.widget.QMUITabSegment$Tab
 *  com.qmuiteam.qmui.widget.QMUITabSegment$TabItemView
 */
package com.qmuiteam.qmui.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.qmuiteam.qmui.widget.QMUITabSegment;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUITabSegment.TabItemView.1
extends GestureDetector.SimpleOnGestureListener {
    final QMUITabSegment.TabItemView this$1;
    final QMUITabSegment val$this$0;

    QMUITabSegment.TabItemView.1(QMUITabSegment.TabItemView tabItemView, QMUITabSegment qMUITabSegment) {
        this.this$1 = tabItemView;
        this.val$this$0 = qMUITabSegment;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (QMUITabSegment.access$2200((QMUITabSegment)this.this$1.this$0).isEmpty()) {
            return false;
        }
        int n = (Integer)this.this$1.getTag();
        if ((QMUITabSegment.Tab)QMUITabSegment.access$200((QMUITabSegment)this.this$1.this$0).getItem(n) == null) return false;
        QMUITabSegment.access$2300((QMUITabSegment)this.this$1.this$0, (int)n);
        return true;
    }
}
