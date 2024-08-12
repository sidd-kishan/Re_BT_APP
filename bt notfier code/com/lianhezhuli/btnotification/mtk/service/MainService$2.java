/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 */
package com.lianhezhuli.btnotification.mtk.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.lianhezhuli.btnotification.mtk.service.MainService;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/*
 * Exception performing whole class analysis ignored.
 */
class MainService.2
extends BroadcastReceiver {
    final MainService this$0;

    MainService.2(MainService mainService) {
        this.this$0 = mainService;
    }

    public void onReceive(Context object, Intent intent) {
        if (!"com.lianhezhuli.connection.BT_CONNECTION_CHANGED".equals(intent.getAction())) return;
        int n = intent.getIntExtra("EXTRA_TYPE", 0);
        byte[] byArray = intent.getByteArrayExtra("EXTRA_DATA");
        if (n != 2) {
            if (n != 4) {
                if (n != 5) return;
                try {
                    object = new String(intent.getByteArrayExtra("EXTRA_DATA"), "UTF-8");
                    if (Integer.valueOf(((String)object).split(" ")[0]) != 8) return;
                    this.this$0.sendMapResult(String.valueOf(1));
                    if (MainService.access$300((MainService)this.this$0) != null) return;
                    this.this$0.startMapService();
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    unsupportedEncodingException.printStackTrace();
                }
            } else {
                try {
                    MainService.access$200((MainService)this.this$0, (byte[])byArray);
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
        } else {
            intent = new Intent();
            intent.setAction("com.lianhezhuli.map.BT_MAP_COMMAND_ARRIVE");
            intent.putExtra("DISCONNECT", "DISCONNECT");
            MainService.access$100().sendBroadcast(intent);
            intent = new Intent();
            intent.setAction("com.lianhezhuli.RemoteCamera.EXIT");
            object.sendBroadcast(intent);
        }
    }
}
