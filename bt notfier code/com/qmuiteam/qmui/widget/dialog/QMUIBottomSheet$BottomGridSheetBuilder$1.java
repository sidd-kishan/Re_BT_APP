/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet$BottomGridSheetBuilder
 */
package com.qmuiteam.qmui.widget.dialog;

import android.view.View;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIBottomSheet.BottomGridSheetBuilder.1
implements View.OnClickListener {
    final QMUIBottomSheet.BottomGridSheetBuilder this$0;

    QMUIBottomSheet.BottomGridSheetBuilder.1(QMUIBottomSheet.BottomGridSheetBuilder bottomGridSheetBuilder) {
        this.this$0 = bottomGridSheetBuilder;
    }

    public void onClick(View view) {
        QMUIBottomSheet.BottomGridSheetBuilder.access$1200((QMUIBottomSheet.BottomGridSheetBuilder)this.this$0).dismiss();
    }
}
