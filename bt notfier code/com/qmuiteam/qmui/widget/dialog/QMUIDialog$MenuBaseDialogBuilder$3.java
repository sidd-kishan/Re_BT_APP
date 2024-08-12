/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MenuBaseDialogBuilder
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MenuBaseDialogBuilder$ItemViewFactory
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView$MenuItemViewListener
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView;

class QMUIDialog.MenuBaseDialogBuilder.3
implements QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory {
    final QMUIDialog.MenuBaseDialogBuilder this$0;
    final QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory val$itemViewFactory;
    final DialogInterface.OnClickListener val$listener;

    QMUIDialog.MenuBaseDialogBuilder.3(QMUIDialog.MenuBaseDialogBuilder menuBaseDialogBuilder, QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory itemViewFactory, DialogInterface.OnClickListener onClickListener) {
        this.this$0 = menuBaseDialogBuilder;
        this.val$itemViewFactory = itemViewFactory;
        this.val$listener = onClickListener;
    }

    public QMUIDialogMenuItemView createItemView(Context context) {
        context = this.val$itemViewFactory.createItemView(context);
        context.setMenuIndex(this.this$0.mMenuItemViewsFactoryList.indexOf(this));
        context.setListener((QMUIDialogMenuItemView.MenuItemViewListener)new /* Unavailable Anonymous Inner Class!! */);
        return context;
    }
}
