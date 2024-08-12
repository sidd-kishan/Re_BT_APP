/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 *  com.lianhezhuli.btnotification.mtk.btconnection.BluetoothManager
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.mtk.btconnection;

import android.os.Handler;
import android.os.Message;
import com.lianhezhuli.btnotification.mtk.btconnection.BluetoothManager;
import com.orhanobut.logger.Logger;
import java.lang.ref.WeakReference;

/*
 * Exception performing whole class analysis ignored.
 */
private static final class BluetoothManager.MessageHandler
extends Handler {
    private WeakReference<BluetoothManager> mBluetoothManager;

    public BluetoothManager.MessageHandler(BluetoothManager bluetoothManager) {
        this.mBluetoothManager = new WeakReference<BluetoothManager>(bluetoothManager);
    }

    public void handleMessage(Message message) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("handleMessage(), msg.what=");
        stringBuilder.append(message.what);
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        stringBuilder = (BluetoothManager)this.mBluetoothManager.get();
        int n = message.what;
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) return;
                    stringBuilder.setConnectedDeviceName(message.getData().getString("device_name"));
                } else {
                    BluetoothManager.access$200((BluetoothManager)stringBuilder, (int)3, null);
                }
            } else {
                byte[] byArray = (byte[])message.obj;
                n = message.arg1;
                BluetoothManager.access$500((String)new String(byArray, 0, n));
                System.arraycopy(byArray, 0, BluetoothManager.reciveBuffer, BluetoothManager.reciveBufferLenth, n);
                BluetoothManager.reciveBufferLenth = n + 0;
                BluetoothManager.access$600((BluetoothManager)stringBuilder);
            }
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("MESSAGE_STATE_CHANGE: ");
            stringBuilder2.append(message.arg1);
            Logger.i((String)stringBuilder2.toString(), (Object[])new Object[0]);
            n = message.arg1;
            if (n != 3) {
                if (n != 4) return;
                BluetoothManager.access$200((BluetoothManager)stringBuilder, (int)2, null);
                BluetoothManager.cmdBufferLenth = 0;
                BluetoothManager.reciveBufferLenth = 0;
                BluetoothManager.dataBufferLenth = 0;
                BluetoothManager.access$002((boolean)false);
                BluetoothManager.access$102((boolean)true);
            } else {
                BluetoothManager.access$400((BluetoothManager)stringBuilder);
            }
        }
    }
}
