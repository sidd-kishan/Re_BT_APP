/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MenuBaseDialogBuilder$ItemViewFactory
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MenuDialogBuilder
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView$TextItemView
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView;

class QMUIDialog.MenuDialogBuilder.1
implements QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory {
    final QMUIDialog.MenuDialogBuilder this$0;
    final CharSequence val$item;

    QMUIDialog.MenuDialogBuilder.1(QMUIDialog.MenuDialogBuilder menuDialogBuilder, CharSequence charSequence) {
        this.this$0 = menuDialogBuilder;
        this.val$item = charSequence;
    }

    public QMUIDialogMenuItemView createItemView(Context context) {
        return new QMUIDialogMenuItemView.TextItemView(context, this.val$item);
    }
}
