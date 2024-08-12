/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  android.view.inputmethod.InputMethodManager
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$EditTextDialogBuilder
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.DialogInterface;
import android.view.inputmethod.InputMethodManager;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;

class QMUIDialog.EditTextDialogBuilder.1
implements DialogInterface.OnDismissListener {
    final QMUIDialog.EditTextDialogBuilder this$0;
    final InputMethodManager val$inputMethodManager;

    QMUIDialog.EditTextDialogBuilder.1(QMUIDialog.EditTextDialogBuilder editTextDialogBuilder, InputMethodManager inputMethodManager) {
        this.this$0 = editTextDialogBuilder;
        this.val$inputMethodManager = inputMethodManager;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.val$inputMethodManager.hideSoftInputFromWindow(this.this$0.mEditText.getWindowToken(), 0);
    }
}
