/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MenuBaseDialogBuilder
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MenuBaseDialogBuilder$ItemViewFactory
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;

public static class QMUIDialog.MenuDialogBuilder
extends QMUIDialog.MenuBaseDialogBuilder<QMUIDialog.MenuDialogBuilder> {
    public QMUIDialog.MenuDialogBuilder(Context context) {
        super(context);
    }

    public QMUIDialog.MenuDialogBuilder addItem(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.addItem((QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory)new /* Unavailable Anonymous Inner Class!! */, onClickListener);
        return this;
    }

    public QMUIDialog.MenuDialogBuilder addItems(CharSequence[] charSequenceArray, DialogInterface.OnClickListener onClickListener) {
        int n = charSequenceArray.length;
        int n2 = 0;
        while (n2 < n) {
            this.addItem(charSequenceArray[n2], onClickListener);
            ++n2;
        }
        return this;
    }
}
