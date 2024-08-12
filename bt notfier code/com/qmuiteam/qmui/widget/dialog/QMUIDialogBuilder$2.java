/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
 */
package com.qmuiteam.qmui.widget.dialog;

import android.view.View;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder;

class QMUIDialogBuilder.2
implements View.OnClickListener {
    final QMUIDialogBuilder this$0;

    QMUIDialogBuilder.2(QMUIDialogBuilder qMUIDialogBuilder) {
        this.this$0 = qMUIDialogBuilder;
    }

    public void onClick(View view) {
        this.this$0.mDialog.cancelOutSide();
    }
}
