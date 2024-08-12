/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.qqface.QMUIQQFaceView
 */
package com.qmuiteam.qmui.qqface;

import com.qmuiteam.qmui.qqface.QMUIQQFaceView;

class QMUIQQFaceView.1
implements Runnable {
    final QMUIQQFaceView this$0;
    final String val$text;

    QMUIQQFaceView.1(QMUIQQFaceView qMUIQQFaceView, String string) {
        this.this$0 = qMUIQQFaceView;
        this.val$text = string;
    }

    @Override
    public void run() {
        this.this$0.setText((CharSequence)this.val$text);
    }
}
