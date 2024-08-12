/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.inputmethod.InputMethodManager
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$EditTextDialogBuilder
 */
package com.qmuiteam.qmui.widget.dialog;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;

class QMUIDialog.EditTextDialogBuilder.2
implements Runnable {
    final QMUIDialog.EditTextDialogBuilder this$0;
    final InputMethodManager val$inputMethodManager;

    QMUIDialog.EditTextDialogBuilder.2(QMUIDialog.EditTextDialogBuilder editTextDialogBuilder, InputMethodManager inputMethodManager) {
        this.this$0 = editTextDialogBuilder;
        this.val$inputMethodManager = inputMethodManager;
    }

    @Override
    public void run() {
        this.this$0.mEditText.requestFocus();
        this.val$inputMethodManager.showSoftInput((View)this.this$0.mEditText, 0);
    }
}
