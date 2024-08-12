/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$CheckableDialogBuilder
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MenuBaseDialogBuilder$ItemViewFactory
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView$MarkItemView
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView;

class QMUIDialog.CheckableDialogBuilder.1
implements QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory {
    final QMUIDialog.CheckableDialogBuilder this$0;
    final CharSequence val$item;

    QMUIDialog.CheckableDialogBuilder.1(QMUIDialog.CheckableDialogBuilder checkableDialogBuilder, CharSequence charSequence) {
        this.this$0 = checkableDialogBuilder;
        this.val$item = charSequence;
    }

    public QMUIDialogMenuItemView createItemView(Context context) {
        return new QMUIDialogMenuItemView.MarkItemView(context, this.val$item);
    }
}
