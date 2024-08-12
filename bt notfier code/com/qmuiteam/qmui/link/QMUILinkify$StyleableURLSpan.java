/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.style.URLSpan
 *  android.view.View
 *  com.qmuiteam.qmui.link.ITouchableSpan
 *  com.qmuiteam.qmui.span.QMUIOnSpanClickListener
 */
package com.qmuiteam.qmui.link;

import android.text.style.URLSpan;
import android.view.View;
import com.qmuiteam.qmui.link.ITouchableSpan;
import com.qmuiteam.qmui.span.QMUIOnSpanClickListener;

private static abstract class QMUILinkify.StyleableURLSpan
extends URLSpan
implements ITouchableSpan {
    protected QMUIOnSpanClickListener mOnSpanClickListener;
    protected boolean mPressed = false;
    protected String mUrl;

    public QMUILinkify.StyleableURLSpan(String string, QMUIOnSpanClickListener qMUIOnSpanClickListener) {
        super(string);
        this.mUrl = string;
        this.mOnSpanClickListener = qMUIOnSpanClickListener;
    }

    public void onClick(View view) {
        if (this.mOnSpanClickListener.onSpanClick(this.mUrl)) {
            return;
        }
        super.onClick(view);
    }

    public void setPressed(boolean bl) {
        this.mPressed = bl;
    }
}
