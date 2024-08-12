/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewStub
 *  android.widget.BaseAdapter
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.qmuiteam.qmui.R$id
 *  com.qmuiteam.qmui.R$layout
 *  com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet$BottomListSheetBuilder
 *  com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet$BottomListSheetBuilder$BottomSheetListItemData
 *  com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet$BottomListSheetBuilder$ViewHolder
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;

/*
 * Exception performing whole class analysis ignored.
 */
private class QMUIBottomSheet.BottomListSheetBuilder.ListAdapter
extends BaseAdapter {
    final QMUIBottomSheet.BottomListSheetBuilder this$0;

    private QMUIBottomSheet.BottomListSheetBuilder.ListAdapter(QMUIBottomSheet.BottomListSheetBuilder bottomListSheetBuilder) {
        this.this$0 = bottomListSheetBuilder;
    }

    public int getCount() {
        return QMUIBottomSheet.BottomListSheetBuilder.access$600((QMUIBottomSheet.BottomListSheetBuilder)this.this$0).size();
    }

    public QMUIBottomSheet.BottomListSheetBuilder.BottomSheetListItemData getItem(int n) {
        return (QMUIBottomSheet.BottomListSheetBuilder.BottomSheetListItemData)QMUIBottomSheet.BottomListSheetBuilder.access$600((QMUIBottomSheet.BottomListSheetBuilder)this.this$0).get(n);
    }

    public long getItemId(int n) {
        return 0L;
    }

    public View getView(int n, View view, ViewGroup viewGroup) {
        QMUIBottomSheet.BottomListSheetBuilder.BottomSheetListItemData bottomSheetListItemData = this.getItem(n);
        if (view == null) {
            view = LayoutInflater.from((Context)QMUIBottomSheet.BottomListSheetBuilder.access$700((QMUIBottomSheet.BottomListSheetBuilder)this.this$0)).inflate(R.layout.qmui_bottom_sheet_list_item, viewGroup, false);
            viewGroup = new QMUIBottomSheet.BottomListSheetBuilder.ViewHolder(null);
            viewGroup.imageView = (ImageView)view.findViewById(R.id.bottom_dialog_list_item_img);
            viewGroup.textView = (TextView)view.findViewById(R.id.bottom_dialog_list_item_title);
            viewGroup.markView = view.findViewById(R.id.bottom_dialog_list_item_mark_view_stub);
            viewGroup.redPoint = view.findViewById(R.id.bottom_dialog_list_item_point);
            view.setTag((Object)viewGroup);
        } else {
            viewGroup = (QMUIBottomSheet.BottomListSheetBuilder.ViewHolder)view.getTag();
        }
        if (bottomSheetListItemData.image != null) {
            viewGroup.imageView.setVisibility(0);
            viewGroup.imageView.setImageDrawable(bottomSheetListItemData.image);
        } else {
            viewGroup.imageView.setVisibility(8);
        }
        viewGroup.textView.setText((CharSequence)bottomSheetListItemData.text);
        if (bottomSheetListItemData.hasRedPoint) {
            viewGroup.redPoint.setVisibility(0);
        } else {
            viewGroup.redPoint.setVisibility(8);
        }
        if (bottomSheetListItemData.isDisabled) {
            viewGroup.textView.setEnabled(false);
            view.setEnabled(false);
        } else {
            viewGroup.textView.setEnabled(true);
            view.setEnabled(true);
        }
        if (QMUIBottomSheet.BottomListSheetBuilder.access$900((QMUIBottomSheet.BottomListSheetBuilder)this.this$0)) {
            if (viewGroup.markView instanceof ViewStub) {
                viewGroup.markView = ((ViewStub)viewGroup.markView).inflate();
            }
            if (QMUIBottomSheet.BottomListSheetBuilder.access$300((QMUIBottomSheet.BottomListSheetBuilder)this.this$0) == n) {
                viewGroup.markView.setVisibility(0);
            } else {
                viewGroup.markView.setVisibility(8);
            }
        } else {
            viewGroup.markView.setVisibility(8);
        }
        view.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        return view;
    }
}
