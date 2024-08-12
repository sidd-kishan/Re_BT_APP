/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothSocket
 *  com.lianhezhuli.btnotification.mtk.btconnection.BluetoothConnection
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.mtk.btconnection;

import android.bluetooth.BluetoothSocket;
import com.lianhezhuli.btnotification.mtk.btconnection.BluetoothConnection;
import com.orhanobut.logger.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 * Exception performing whole class analysis ignored.
 */
private class BluetoothConnection.WorkThread
extends Thread {
    private final InputStream mInStream;
    private final OutputStream mOutStream;
    private final BluetoothSocket mSocket;
    final BluetoothConnection this$0;

    public BluetoothConnection.WorkThread(BluetoothConnection object, BluetoothSocket object2) {
        block5: {
            Object var3_5;
            block4: {
                this.this$0 = object;
                Logger.i((String)"WorkThread(), create WorkThread", (Object[])new Object[0]);
                this.mSocket = object2;
                var3_5 = null;
                try {
                    object = object2.getInputStream();
                }
                catch (IOException iOException) {
                    object = null;
                    break block4;
                }
                try {
                    object2 = object2.getOutputStream();
                    break block5;
                }
                catch (IOException iOException) {}
            }
            Logger.w((String)"temp sockets not created", (Object[])new Object[]{object2});
            object2 = var3_5;
        }
        this.mInStream = object;
        this.mOutStream = object2;
    }

    public void cancel() {
        Logger.i((String)"cancel(),  WorkThread is canceled", (Object[])new Object[0]);
        try {
            this.mSocket.close();
        }
        catch (IOException iOException) {
            Logger.w((String)"close connected socket failed", (Object[])new Object[]{iOException});
        }
    }

    @Override
    public void run() {
        Logger.i((String)"WorkThread BEGIN", (Object[])new Object[0]);
        try {
            while (true) {
                byte[] byArray = new byte[5120];
                int n = this.mInStream.read(byArray);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("read data frome smart client, the lenth is ");
                stringBuilder.append(n);
                Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
                BluetoothConnection.access$500((BluetoothConnection)this.this$0).obtainMessage(2, n, -1, (Object)byArray).sendToTarget();
            }
        }
        catch (IOException iOException) {
            Logger.w((String)"disconnected", (Object[])new Object[]{iOException});
            BluetoothConnection.access$600((BluetoothConnection)this.this$0);
            return;
        }
    }

    public void write(byte[] byArray) {
        try {
            this.mOutStream.write(byArray);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Write to Feature Phone SPP");
            stringBuilder.append(byArray.length);
            Logger.w((String)stringBuilder.toString(), (Object[])new Object[0]);
            BluetoothConnection.access$500((BluetoothConnection)this.this$0).obtainMessage(3, -1, -1, (Object)byArray).sendToTarget();
        }
        catch (IOException iOException) {
            Logger.w((String)"Exception during write", (Object[])new Object[]{iOException});
        }
    }
}
