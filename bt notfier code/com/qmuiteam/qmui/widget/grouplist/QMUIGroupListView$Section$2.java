/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.RelativeLayout$LayoutParams
 *  com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView$LayoutParamConfig
 *  com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView$Section
 */
package com.qmuiteam.qmui.widget.grouplist;

import android.widget.RelativeLayout;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIGroupListView.Section.2
implements QMUICommonListItemView.LayoutParamConfig {
    final QMUIGroupListView.Section this$0;

    QMUIGroupListView.Section.2(QMUIGroupListView.Section section) {
        this.this$0 = section;
    }

    public RelativeLayout.LayoutParams onConfig(RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = QMUIGroupListView.Section.access$000((QMUIGroupListView.Section)this.this$0);
        layoutParams.height = QMUIGroupListView.Section.access$100((QMUIGroupListView.Section)this.this$0);
        return layoutParams;
    }
}
