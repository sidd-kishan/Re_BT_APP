/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MenuBaseDialogBuilder$ItemViewFactory
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MultiCheckableDialogBuilder
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView$CheckItemView
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView;

class QMUIDialog.MultiCheckableDialogBuilder.1
implements QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory {
    final QMUIDialog.MultiCheckableDialogBuilder this$0;
    final CharSequence val$item;

    QMUIDialog.MultiCheckableDialogBuilder.1(QMUIDialog.MultiCheckableDialogBuilder multiCheckableDialogBuilder, CharSequence charSequence) {
        this.this$0 = multiCheckableDialogBuilder;
        this.val$item = charSequence;
    }

    public QMUIDialogMenuItemView createItemView(Context context) {
        return new QMUIDialogMenuItemView.CheckItemView(context, true, this.val$item);
    }
}
