/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet$BottomListSheetBuilder
 *  com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet$BottomListSheetBuilder$BottomSheetListItemData
 *  com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet$BottomListSheetBuilder$ListAdapter
 *  com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet$BottomListSheetBuilder$ViewHolder
 */
package com.qmuiteam.qmui.widget.dialog;

import android.view.View;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIBottomSheet.BottomListSheetBuilder.ListAdapter.1
implements View.OnClickListener {
    final QMUIBottomSheet.BottomListSheetBuilder.ListAdapter this$1;
    final QMUIBottomSheet.BottomListSheetBuilder.BottomSheetListItemData val$data;
    final QMUIBottomSheet.BottomListSheetBuilder.ViewHolder val$holder;
    final int val$position;

    QMUIBottomSheet.BottomListSheetBuilder.ListAdapter.1(QMUIBottomSheet.BottomListSheetBuilder.ListAdapter listAdapter, QMUIBottomSheet.BottomListSheetBuilder.BottomSheetListItemData bottomSheetListItemData, QMUIBottomSheet.BottomListSheetBuilder.ViewHolder viewHolder, int n) {
        this.this$1 = listAdapter;
        this.val$data = bottomSheetListItemData;
        this.val$holder = viewHolder;
        this.val$position = n;
    }

    public void onClick(View view) {
        if (this.val$data.hasRedPoint) {
            this.val$data.hasRedPoint = false;
            this.val$holder.redPoint.setVisibility(8);
        }
        if (QMUIBottomSheet.BottomListSheetBuilder.access$900((QMUIBottomSheet.BottomListSheetBuilder)this.this$1.this$0)) {
            this.this$1.this$0.setCheckedIndex(this.val$position);
            this.this$1.notifyDataSetChanged();
        }
        if (QMUIBottomSheet.BottomListSheetBuilder.access$1000((QMUIBottomSheet.BottomListSheetBuilder)this.this$1.this$0) == null) return;
        QMUIBottomSheet.BottomListSheetBuilder.access$1000((QMUIBottomSheet.BottomListSheetBuilder)this.this$1.this$0).onClick(QMUIBottomSheet.BottomListSheetBuilder.access$1100((QMUIBottomSheet.BottomListSheetBuilder)this.this$1.this$0), view, this.val$position, this.val$data.tag);
    }
}
