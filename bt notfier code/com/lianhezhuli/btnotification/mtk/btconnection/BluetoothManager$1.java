/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.mtk.btconnection.BluetoothManager
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.mtk.btconnection;

import com.lianhezhuli.btnotification.mtk.btconnection.BluetoothManager;
import com.orhanobut.logger.Logger;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.TimerTask;

/*
 * Exception performing whole class analysis ignored.
 */
class BluetoothManager.1
extends TimerTask {
    final BluetoothManager this$0;

    BluetoothManager.1(BluetoothManager bluetoothManager) {
        this.this$0 = bluetoothManager;
    }

    @Override
    public void run() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Timer Task Run ... isHandshake = ");
        stringBuilder.append(BluetoothManager.access$000());
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        if (BluetoothManager.access$100()) {
            BluetoothManager.access$002((boolean)true);
            BluetoothManager.access$200((BluetoothManager)this.this$0, (int)1, null);
            this.this$0.sendDataFromFile();
            this.cancel();
            Logger.i((String)"mTimer is canceled version is old", (Object[])new Object[0]);
        } else {
            try {
                BluetoothManager.access$300((BluetoothManager)this.this$0);
                this.cancel();
                Logger.i((String)"mTimer is canceled version is new", (Object[])new Object[0]);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                unsupportedEncodingException.printStackTrace();
            }
        }
    }
}
