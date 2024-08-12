/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.text.TextUtils
 *  android.util.Log
 *  com.qmuiteam.qmui.widget.textview.QMUILinkTextView
 */
package com.qmuiteam.qmui.widget.textview;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.qmuiteam.qmui.widget.textview.QMUILinkTextView;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUILinkTextView.1
extends Handler {
    final QMUILinkTextView this$0;

    QMUILinkTextView.1(QMUILinkTextView qMUILinkTextView, Looper looper) {
        this.this$0 = qMUILinkTextView;
        super(looper);
    }

    public void handleMessage(Message object) {
        if (1000 != ((Message)object).what) {
            return;
        }
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("handleMessage: ");
        ((StringBuilder)charSequence).append(((Message)object).obj);
        Log.d((String)"LinkTextView", (String)((StringBuilder)charSequence).toString());
        if (!(((Message)object).obj instanceof String)) return;
        object = (String)((Message)object).obj;
        if (QMUILinkTextView.access$000((QMUILinkTextView)this.this$0) == null) return;
        if (TextUtils.isEmpty((CharSequence)object)) return;
        charSequence = ((String)object).toLowerCase();
        if (((String)charSequence).startsWith("tel:")) {
            object = Uri.parse((String)object).getSchemeSpecificPart();
            QMUILinkTextView.access$000((QMUILinkTextView)this.this$0).onTelLinkClick((String)object);
        } else if (((String)charSequence).startsWith("mailto:")) {
            object = Uri.parse((String)object).getSchemeSpecificPart();
            QMUILinkTextView.access$000((QMUILinkTextView)this.this$0).onMailLinkClick((String)object);
        } else {
            if (!((String)charSequence).startsWith("http")) {
                if (!((String)charSequence).startsWith("https")) return;
            }
            QMUILinkTextView.access$000((QMUILinkTextView)this.this$0).onWebUrlLinkClick((String)object);
        }
    }
}
