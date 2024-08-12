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

public static class QMUIDialog.CheckableDialogBuilder
extends QMUIDialog.MenuBaseDialogBuilder<QMUIDialog.CheckableDialogBuilder> {
    private int mCheckedIndex = -1;

    public QMUIDialog.CheckableDialogBuilder(Context context) {
        super(context);
    }

    public QMUIDialog.CheckableDialogBuilder addItems(CharSequence[] charSequenceArray, DialogInterface.OnClickListener onClickListener) {
        int n = charSequenceArray.length;
        int n2 = 0;
        while (n2 < n) {
            this.addItem((QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory)new /* Unavailable Anonymous Inner Class!! */, onClickListener);
            ++n2;
        }
        return this;
    }

    public int getCheckedIndex() {
        return this.mCheckedIndex;
    }

    protected void onCreateContent(QMUIDialog qMUIDialog, ViewGroup viewGroup, Context context) {
        super.onCreateContent(qMUIDialog, viewGroup, context);
        int n = this.mCheckedIndex;
        if (n <= -1) return;
        if (n >= this.mMenuItemViews.size()) return;
        ((QMUIDialogMenuItemView)this.mMenuItemViews.get(this.mCheckedIndex)).setChecked(true);
    }

    protected void onItemClick(int n) {
        int n2 = 0;
        while (n2 < this.mMenuItemViews.size()) {
            QMUIDialogMenuItemView qMUIDialogMenuItemView = (QMUIDialogMenuItemView)this.mMenuItemViews.get(n2);
            if (n2 == n) {
                qMUIDialogMenuItemView.setChecked(true);
                this.mCheckedIndex = n;
            } else {
                qMUIDialogMenuItemView.setChecked(false);
            }
            ++n2;
        }
    }

    public QMUIDialog.CheckableDialogBuilder setCheckedIndex(int n) {
        this.mCheckedIndex = n;
        return this;
    }
}
