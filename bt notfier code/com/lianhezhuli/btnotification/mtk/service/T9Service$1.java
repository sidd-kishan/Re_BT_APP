/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 *  com.lianhezhuli.btnotification.mtk.service.T9Service
 */
package com.lianhezhuli.btnotification.mtk.service;

import android.os.Handler;
import android.os.Message;
import com.lianhezhuli.btnotification.mtk.service.T9Service;

class T9Service.1
extends Handler {
    final T9Service this$0;

    T9Service.1(T9Service t9Service) {
        this.this$0 = t9Service;
    }

    public void handleMessage(Message message) {
        if (message.what == 7) {
            System.out.println("begin to sort out t9");
        }
        super.handleMessage(message);
    }
}
