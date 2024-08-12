/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  com.lianhezhuli.btnotification.mtk.map.SmsController
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.mtk.map;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.lianhezhuli.btnotification.mtk.map.SmsController;
import com.orhanobut.logger.Logger;

/*
 * Exception performing whole class analysis ignored.
 */
class SmsController.1
extends BroadcastReceiver {
    final SmsController this$0;

    SmsController.1(SmsController smsController) {
        this.this$0 = smsController;
    }

    public void onReceive(Context object, Intent object2) {
        object = object2.getAction();
        if (object == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("action: ");
        stringBuilder.append((String)object);
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        int n = this.getResultCode();
        if (((String)object).equals("SmsController.action.SENT_RESULT")) {
            SmsController.access$000((SmsController)this.this$0, (Intent)object2, (int)n);
        } else if (((String)object).equals("SmsController.action.DELIVERED_RESULT")) {
            try {
                SmsController.access$100((SmsController)this.this$0, (Intent)object2, (int)n);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (!((String)object).equals("SmsController.action.SEND_MESSAGE")) return;
        object = object2.getStringExtra("ADDRESS");
        object2 = object2.getStringExtra("MESSAGE");
        this.this$0.pushMessage((String)object, (String)object2);
    }
}
