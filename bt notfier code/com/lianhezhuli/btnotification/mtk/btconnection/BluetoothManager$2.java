/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  com.lianhezhuli.btnotification.mtk.btconnection.BluetoothManager
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.mtk.btconnection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.lianhezhuli.btnotification.mtk.btconnection.BluetoothManager;
import com.orhanobut.logger.Logger;

class BluetoothManager.2
extends BroadcastReceiver {
    final BluetoothManager this$0;

    BluetoothManager.2(BluetoothManager bluetoothManager) {
        this.this$0 = bluetoothManager;
    }

    public void onReceive(Context object, Intent intent) {
        if (!"android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) return;
        int n = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
        object = new StringBuilder();
        ((StringBuilder)object).append("onReceive(), action=");
        ((StringBuilder)object).append(intent.getAction());
        Logger.i((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        if (n == 12) {
            this.this$0.setupConnection();
        } else {
            if (n != 10) return;
            this.this$0.removeConnection();
        }
    }
}
