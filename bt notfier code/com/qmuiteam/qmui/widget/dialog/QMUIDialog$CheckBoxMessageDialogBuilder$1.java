/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$CheckBoxMessageDialogBuilder
 */
package com.qmuiteam.qmui.widget.dialog;

import android.view.View;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIDialog.CheckBoxMessageDialogBuilder.1
implements View.OnClickListener {
    final QMUIDialog.CheckBoxMessageDialogBuilder this$0;

    QMUIDialog.CheckBoxMessageDialogBuilder.1(QMUIDialog.CheckBoxMessageDialogBuilder checkBoxMessageDialogBuilder) {
        this.this$0 = checkBoxMessageDialogBuilder;
    }

    public void onClick(View view) {
        view = this.this$0;
        view.setChecked(QMUIDialog.CheckBoxMessageDialogBuilder.access$000((QMUIDialog.CheckBoxMessageDialogBuilder)view) ^ true);
    }
}
