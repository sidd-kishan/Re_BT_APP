/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  android.view.ViewGroup
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MenuBaseDialogBuilder
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MenuBaseDialogBuilder$ItemViewFactory
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.ViewGroup;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView;
import java.util.ArrayList;

public static class QMUIDialog.MultiCheckableDialogBuilder
extends QMUIDialog.MenuBaseDialogBuilder<QMUIDialog.MultiCheckableDialogBuilder> {
    private int mCheckedItems;

    public QMUIDialog.MultiCheckableDialogBuilder(Context context) {
        super(context);
    }

    public QMUIDialog.MultiCheckableDialogBuilder addItem(QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory itemViewFactory, DialogInterface.OnClickListener onClickListener) {
        if (this.mMenuItemViewsFactoryList.size() >= 32) throw new RuntimeException("there are more than 32 items, please use LiseView to improve performance!!");
        return (QMUIDialog.MultiCheckableDialogBuilder)super.addItem(itemViewFactory, onClickListener);
    }

    public QMUIDialog.MultiCheckableDialogBuilder addItem(QMUIDialogMenuItemView qMUIDialogMenuItemView, DialogInterface.OnClickListener onClickListener) {
        if (this.mMenuItemViewsFactoryList.size() >= 32) throw new RuntimeException("there are more than 32 items, please use LiseView to improve performance!!");
        return (QMUIDialog.MultiCheckableDialogBuilder)super.addItem(qMUIDialogMenuItemView, onClickListener);
    }

    public QMUIDialog.MultiCheckableDialogBuilder addItems(CharSequence[] charSequenceArray, DialogInterface.OnClickListener onClickListener) {
        int n = charSequenceArray.length;
        int n2 = 0;
        while (n2 < n) {
            this.addItem((QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory)new /* Unavailable Anonymous Inner Class!! */, onClickListener);
            ++n2;
        }
        return this;
    }

    protected boolean existCheckedItem() {
        boolean bl = this.getCheckedItemRecord() <= 0;
        return bl;
    }

    public int[] getCheckedItemIndexes() {
        Object object;
        int n;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n2 = this.mMenuItemViews.size();
        int n3 = 0;
        for (n = 0; n < n2; ++n) {
            object = (QMUIDialogMenuItemView)this.mMenuItemViews.get(n);
            if (!object.isChecked()) continue;
            arrayList.add(object.getMenuIndex());
        }
        object = new int[arrayList.size()];
        n = n3;
        while (n < arrayList.size()) {
            object[n] = (Integer)arrayList.get(n);
            ++n;
        }
        return object;
    }

    public int getCheckedItemRecord() {
        int n = this.mMenuItemViews.size();
        int n2 = 0;
        int n3 = 0;
        while (true) {
            if (n2 >= n) {
                this.mCheckedItems = n3;
                return n3;
            }
            QMUIDialogMenuItemView qMUIDialogMenuItemView = (QMUIDialogMenuItemView)this.mMenuItemViews.get(n2);
            int n4 = n3;
            if (qMUIDialogMenuItemView.isChecked()) {
                n4 = n3 + (2 << qMUIDialogMenuItemView.getMenuIndex());
            }
            ++n2;
            n3 = n4;
        }
    }

    protected void onCreateContent(QMUIDialog qMUIDialog, ViewGroup viewGroup, Context context) {
        super.onCreateContent(qMUIDialog, viewGroup, context);
        int n = 0;
        while (n < this.mMenuItemViews.size()) {
            qMUIDialog = (QMUIDialogMenuItemView)this.mMenuItemViews.get(n);
            int n2 = 2 << n;
            boolean bl = (this.mCheckedItems & n2) == n2;
            qMUIDialog.setChecked(bl);
            ++n;
        }
    }

    protected void onItemClick(int n) {
        QMUIDialogMenuItemView qMUIDialogMenuItemView = (QMUIDialogMenuItemView)this.mMenuItemViews.get(n);
        qMUIDialogMenuItemView.setChecked(qMUIDialogMenuItemView.isChecked() ^ true);
    }

    public QMUIDialog.MultiCheckableDialogBuilder setCheckedItems(int n) {
        this.mCheckedItems = n;
        return this;
    }

    public QMUIDialog.MultiCheckableDialogBuilder setCheckedItems(int[] nArray) {
        int n = 0;
        int n2 = 0;
        int n3 = n;
        if (nArray == null) return this.setCheckedItems(n3);
        n3 = n;
        if (nArray.length <= 0) return this.setCheckedItems(n3);
        n = nArray.length;
        n3 = 0;
        while (n2 < n) {
            n3 += 2 << nArray[n2];
            ++n2;
        }
        return this.setCheckedItems(n3);
    }
}
