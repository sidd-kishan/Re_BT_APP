/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.Spannable
 *  com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler
 *  com.qmuiteam.qmui.span.QMUITouchableSpan
 */
package com.qmuiteam.qmui.qqface;

import android.text.Spannable;
import com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler;
import com.qmuiteam.qmui.span.QMUITouchableSpan;
import java.util.Comparator;

class QMUIQQFaceCompiler.1
implements Comparator<QMUITouchableSpan> {
    final QMUIQQFaceCompiler this$0;
    final Spannable val$spannable;

    QMUIQQFaceCompiler.1(QMUIQQFaceCompiler qMUIQQFaceCompiler, Spannable spannable) {
        this.this$0 = qMUIQQFaceCompiler;
        this.val$spannable = spannable;
    }

    @Override
    public int compare(QMUITouchableSpan qMUITouchableSpan, QMUITouchableSpan qMUITouchableSpan2) {
        int n;
        int n2 = this.val$spannable.getSpanStart((Object)qMUITouchableSpan);
        if (n2 > (n = this.val$spannable.getSpanStart((Object)qMUITouchableSpan2))) {
            return 1;
        }
        if (n2 != n) return -1;
        return 0;
    }
}
