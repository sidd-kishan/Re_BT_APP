/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow$OnDismissListener
 *  com.qmuiteam.qmui.widget.popup.QMUIBasePopup
 */
package com.qmuiteam.qmui.widget.popup;

import android.widget.PopupWindow;
import com.qmuiteam.qmui.widget.popup.QMUIBasePopup;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIBasePopup.3
implements PopupWindow.OnDismissListener {
    final QMUIBasePopup this$0;

    QMUIBasePopup.3(QMUIBasePopup qMUIBasePopup) {
        this.this$0 = qMUIBasePopup;
    }

    public void onDismiss() {
        this.this$0.onDismiss();
        if (QMUIBasePopup.access$000((QMUIBasePopup)this.this$0) == null) return;
        QMUIBasePopup.access$000((QMUIBasePopup)this.this$0).onDismiss();
    }
}
