/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MenuBaseDialogBuilder$3
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView$MenuItemViewListener
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.DialogInterface;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView;

class QMUIDialog.MenuBaseDialogBuilder.1
implements QMUIDialogMenuItemView.MenuItemViewListener {
    final QMUIDialog.MenuBaseDialogBuilder.3 this$1;

    QMUIDialog.MenuBaseDialogBuilder.1(QMUIDialog.MenuBaseDialogBuilder.3 var1_1) {
        this.this$1 = var1_1;
    }

    public void onClick(int n) {
        this.this$1.this$0.onItemClick(n);
        if (this.this$1.val$listener == null) return;
        this.this$1.val$listener.onClick((DialogInterface)this.this$1.this$0.mDialog, n);
    }
}
