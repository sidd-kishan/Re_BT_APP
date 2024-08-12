/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$AutoResizeDialogBuilder
 */
package com.qmuiteam.qmui.widget.dialog;

import android.view.View;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;

class QMUIDialog.AutoResizeDialogBuilder.2
implements View.OnClickListener {
    final QMUIDialog.AutoResizeDialogBuilder this$0;

    QMUIDialog.AutoResizeDialogBuilder.2(QMUIDialog.AutoResizeDialogBuilder autoResizeDialogBuilder) {
        this.this$0 = autoResizeDialogBuilder;
    }

    public void onClick(View view) {
        this.this$0.mDialog.dismiss();
    }
}
