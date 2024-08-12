/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  com.qmuiteam.qmui.widget.popup.QMUIBasePopup
 */
package com.qmuiteam.qmui.widget.popup;

import android.view.View;
import com.qmuiteam.qmui.widget.popup.QMUIBasePopup;

class QMUIBasePopup.2
implements View.OnAttachStateChangeListener {
    final QMUIBasePopup this$0;

    QMUIBasePopup.2(QMUIBasePopup qMUIBasePopup) {
        this.this$0 = qMUIBasePopup;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        if (!this.this$0.isShowing()) return;
        this.this$0.dismiss();
    }
}
