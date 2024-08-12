/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogAction
 */
package com.qmuiteam.qmui.widget.dialog;

import android.view.View;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIDialogAction.1
implements View.OnClickListener {
    final QMUIDialogAction this$0;
    final QMUIDialog val$dialog;
    final int val$index;

    QMUIDialogAction.1(QMUIDialogAction qMUIDialogAction, QMUIDialog qMUIDialog, int n) {
        this.this$0 = qMUIDialogAction;
        this.val$dialog = qMUIDialog;
        this.val$index = n;
    }

    public void onClick(View view) {
        if (QMUIDialogAction.access$000((QMUIDialogAction)this.this$0) == null) return;
        if (!QMUIDialogAction.access$100((QMUIDialogAction)this.this$0).isEnabled()) return;
        QMUIDialogAction.access$000((QMUIDialogAction)this.this$0).onClick(this.val$dialog, this.val$index);
    }
}
