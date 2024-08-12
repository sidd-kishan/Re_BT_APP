/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  com.qmuiteam.qmui.widget.popup.QMUIBasePopup
 */
package com.qmuiteam.qmui.widget.popup;

import android.view.MotionEvent;
import android.view.View;
import com.qmuiteam.qmui.widget.popup.QMUIBasePopup;

class QMUIBasePopup.1
implements View.OnTouchListener {
    final QMUIBasePopup this$0;

    QMUIBasePopup.1(QMUIBasePopup qMUIBasePopup) {
        this.this$0 = qMUIBasePopup;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 4) return false;
        this.this$0.mWindow.dismiss();
        return false;
    }
}
