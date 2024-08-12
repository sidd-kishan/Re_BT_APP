/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.qqface.QMUIQQFaceView$SpanInfo
 */
package com.qmuiteam.qmui.qqface;

import com.qmuiteam.qmui.qqface.QMUIQQFaceView;
import java.lang.ref.WeakReference;

public static class QMUIQQFaceView.PressCancelAction
implements Runnable {
    private WeakReference<QMUIQQFaceView.SpanInfo> mWeakReference;

    public QMUIQQFaceView.PressCancelAction(QMUIQQFaceView.SpanInfo spanInfo) {
        this.mWeakReference = new WeakReference<QMUIQQFaceView.SpanInfo>(spanInfo);
    }

    @Override
    public void run() {
        QMUIQQFaceView.SpanInfo spanInfo = (QMUIQQFaceView.SpanInfo)this.mWeakReference.get();
        if (spanInfo == null) return;
        spanInfo.setPressed(false);
        spanInfo.invalidateSpan();
    }
}
