/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 *  com.contrarywind.view.WheelView
 *  com.contrarywind.view.WheelView$ACTION
 */
package com.contrarywind.timer;

import android.os.Handler;
import android.os.Message;
import com.contrarywind.view.WheelView;

public final class MessageHandler
extends Handler {
    public static final int WHAT_INVALIDATE_LOOP_VIEW = 1000;
    public static final int WHAT_ITEM_SELECTED = 3000;
    public static final int WHAT_SMOOTH_SCROLL = 2000;
    private final WheelView wheelView;

    public MessageHandler(WheelView wheelView) {
        this.wheelView = wheelView;
    }

    public final void handleMessage(Message message) {
        int n = message.what;
        if (n != 1000) {
            if (n != 2000) {
                if (n != 3000) return;
                this.wheelView.onItemSelected();
            } else {
                this.wheelView.smoothScroll(WheelView.ACTION.FLING);
            }
        } else {
            this.wheelView.invalidate();
        }
    }
}
