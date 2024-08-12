/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.qmuiteam.qmui.widget.QMUITabSegment
 *  com.qmuiteam.qmui.widget.QMUITabSegment$Tab
 */
package com.qmuiteam.qmui.widget;

import android.view.View;
import com.qmuiteam.qmui.widget.QMUITabSegment;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUITabSegment.1
implements View.OnClickListener {
    final QMUITabSegment this$0;

    QMUITabSegment.1(QMUITabSegment qMUITabSegment) {
        this.this$0 = qMUITabSegment;
    }

    public void onClick(View view) {
        if (QMUITabSegment.access$000((QMUITabSegment)this.this$0) != null) return;
        if (QMUITabSegment.access$100((QMUITabSegment)this.this$0) != 0) return;
        int n = (Integer)view.getTag();
        QMUITabSegment.Tab tab = (QMUITabSegment.Tab)QMUITabSegment.access$200((QMUITabSegment)this.this$0).getItem(n);
        if (tab != null) {
            view = this.this$0;
            boolean bl = !QMUITabSegment.access$300((QMUITabSegment)view) && !tab.isDynamicChangeIconColor();
            view.selectTab(n, bl, true);
        }
        if (QMUITabSegment.access$400((QMUITabSegment)this.this$0) == null) return;
        QMUITabSegment.access$400((QMUITabSegment)this.this$0).onTabClick(n);
    }
}
