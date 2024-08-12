/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView
 *  com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView$Section
 */
package com.qmuiteam.qmui.widget.grouplist;

import android.view.View;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

class QMUIGroupListView.Section.1
implements View.OnClickListener {
    final QMUIGroupListView.Section this$0;
    final QMUICommonListItemView val$itemView;

    QMUIGroupListView.Section.1(QMUIGroupListView.Section section, QMUICommonListItemView qMUICommonListItemView) {
        this.this$0 = section;
        this.val$itemView = qMUICommonListItemView;
    }

    public void onClick(View view) {
        this.val$itemView.getSwitch().toggle();
    }
}
