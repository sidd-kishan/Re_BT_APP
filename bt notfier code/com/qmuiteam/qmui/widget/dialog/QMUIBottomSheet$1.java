/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.qmuiteam.qmui.QMUILog
 *  com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet
 */
package com.qmuiteam.qmui.widget.dialog;

import android.util.Log;
import com.qmuiteam.qmui.QMUILog;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIBottomSheet.1
implements Runnable {
    final QMUIBottomSheet this$0;

    QMUIBottomSheet.1(QMUIBottomSheet qMUIBottomSheet) {
        this.this$0 = qMUIBottomSheet;
    }

    @Override
    public void run() {
        try {
            QMUIBottomSheet.access$001((QMUIBottomSheet)this.this$0);
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("dismiss error\n");
            stringBuilder.append(Log.getStackTraceString((Throwable)exception));
            QMUILog.w((String)"QMUIBottomSheet", (String)stringBuilder.toString(), (Object[])new Object[0]);
        }
    }
}
