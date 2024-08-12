/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MenuBaseDialogBuilder
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView$MenuItemViewListener
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.DialogInterface;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView;

class QMUIDialog.MenuBaseDialogBuilder.1
implements QMUIDialogMenuItemView.MenuItemViewListener {
    final QMUIDialog.MenuBaseDialogBuilder this$0;
    final DialogInterface.OnClickListener val$listener;

    QMUIDialog.MenuBaseDialogBuilder.1(QMUIDialog.MenuBaseDialogBuilder menuBaseDialogBuilder, DialogInterface.OnClickListener onClickListener) {
        this.this$0 = menuBaseDialogBuilder;
        this.val$listener = onClickListener;
    }

    public void onClick(int n) {
        this.this$0.onItemClick(n);
        DialogInterface.OnClickListener onClickListener = this.val$listener;
        if (onClickListener == null) return;
        onClickListener.onClick((DialogInterface)this.this$0.mDialog, n);
    }
}
