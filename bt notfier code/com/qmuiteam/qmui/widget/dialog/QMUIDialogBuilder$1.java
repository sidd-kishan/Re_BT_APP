/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.View$OnLayoutChangeListener
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.view.View;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIDialogBuilder.1
implements View.OnLayoutChangeListener {
    final QMUIDialogBuilder this$0;

    QMUIDialogBuilder.1(QMUIDialogBuilder qMUIDialogBuilder) {
        this.this$0 = qMUIDialogBuilder;
    }

    public void onLayoutChange(View view, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        n2 = this.this$0.mActionContainer.getChildCount();
        if (n2 <= 0) return;
        view = this.this$0.mActionContainer.getChildAt(n2 - 1);
        if (view.getRight() <= n3 - n) return;
        n3 = Math.max(0, view.getPaddingLeft() - QMUIDisplayHelper.dp2px((Context)QMUIDialogBuilder.access$000((QMUIDialogBuilder)this.this$0), (int)3));
        n = 0;
        while (n < n2) {
            this.this$0.mActionContainer.getChildAt(n).setPadding(n3, 0, n3, 0);
            ++n;
        }
    }
}
