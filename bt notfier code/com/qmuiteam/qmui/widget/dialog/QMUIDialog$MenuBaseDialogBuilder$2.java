/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MenuBaseDialogBuilder
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MenuBaseDialogBuilder$ItemViewFactory
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView;

class QMUIDialog.MenuBaseDialogBuilder.2
implements QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory {
    final QMUIDialog.MenuBaseDialogBuilder this$0;
    final QMUIDialogMenuItemView val$itemView;

    QMUIDialog.MenuBaseDialogBuilder.2(QMUIDialog.MenuBaseDialogBuilder menuBaseDialogBuilder, QMUIDialogMenuItemView qMUIDialogMenuItemView) {
        this.this$0 = menuBaseDialogBuilder;
        this.val$itemView = qMUIDialogMenuItemView;
    }

    public QMUIDialogMenuItemView createItemView(Context context) {
        return this.val$itemView;
    }
}
