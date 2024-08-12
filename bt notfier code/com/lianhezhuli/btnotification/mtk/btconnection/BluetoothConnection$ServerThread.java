/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothServerSocket
 *  android.bluetooth.BluetoothSocket
 *  android.content.Context
 *  android.os.Build$VERSION
 *  androidx.core.app.ActivityCompat
 *  com.lianhezhuli.btnotification.MApplication
 *  com.lianhezhuli.btnotification.mtk.btconnection.BluetoothConnection
 *  com.lianhezhuli.btnotification.utils.ToastUtils
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.mtk.btconnection;

import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import com.lianhezhuli.btnotification.MApplication;
import com.lianhezhuli.btnotification.mtk.btconnection.BluetoothConnection;
import com.lianhezhuli.btnotification.utils.ToastUtils;
import com.orhanobut.logger.Logger;
import java.io.IOException;

/*
 * Exception performing whole class analysis ignored.
 */
private class BluetoothConnection.ServerThread
extends Thread {
    private BluetoothServerSocket mServerSocket;
    final BluetoothConnection this$0;

    public BluetoothConnection.ServerThread(BluetoothConnection bluetoothConnection) {
        this.this$0 = bluetoothConnection;
        Object var2_3 = null;
        this.mServerSocket = null;
        Logger.e((String)"ServerThread", (Object[])new Object[0]);
        try {
            if (Build.VERSION.SDK_INT >= 31 && ActivityCompat.checkSelfPermission((Context)MApplication.getInstance(), (String)"android.permission.BLUETOOTH_CONNECT") != 0) {
                ToastUtils.showLong((Context)MApplication.getInstance(), (int)2131755125);
                return;
            }
            bluetoothConnection = BluetoothConnection.access$100((BluetoothConnection)bluetoothConnection).listenUsingRfcommWithServiceRecord("BTNotification", BluetoothConnection.access$000());
        }
        catch (IOException iOException) {
            Logger.w((String)"ServerThread listen() failed", (Object[])new Object[]{iOException});
            bluetoothConnection = var2_3;
        }
        this.mServerSocket = bluetoothConnection;
    }

    public void cancel() {
        Logger.i((String)"cancel(),  ServerThread is canceled", (Object[])new Object[0]);
        try {
            if (this.mServerSocket == null) return;
            this.mServerSocket.close();
        }
        catch (Exception exception) {
            Logger.w((String)"mServerSocket is exception", (Object[])new Object[]{exception});
        }
        catch (IOException iOException) {
            Logger.w((String)"close server socket failed", (Object[])new Object[]{iOException});
        }
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    @Override
    public void run() {
        Logger.i((String)"ServerThread BEGIN", (Object[])new Object[0]);
        this.setName("ServerThread");
        if (this.mServerSocket == null) {
            return;
        }
        while (BluetoothConnection.access$200((BluetoothConnection)this.this$0) != 3) {
            block11: {
                BluetoothSocket bluetoothSocket;
                block9: {
                    block10: {
                        bluetoothSocket = this.mServerSocket.accept();
                        Logger.e((String)"socket != null", (Object[])new Object[0]);
                        if (bluetoothSocket == null) continue;
                        BluetoothConnection bluetoothConnection = this.this$0;
                        // MONITORENTER : bluetoothConnection
                        int n = BluetoothConnection.access$200((BluetoothConnection)this.this$0);
                        if (n == 0) break block9;
                        if (n == 1 || n == 2) break block10;
                        if (n == 3) break block9;
                        break block11;
                    }
                    this.this$0.connected(bluetoothSocket, bluetoothSocket.getRemoteDevice());
                    break block11;
                }
                Logger.e((String)"STATE_CONNECTED", (Object[])new Object[]{"STATE_CONNECTED"});
                try {
                    bluetoothSocket.close();
                }
                catch (IOException iOException) {
                    Logger.w((String)"ServerThread Could not close unwanted socket", (Object[])new Object[]{iOException});
                }
            }
            // MONITOREXIT : bluetoothConnection
            continue;
            catch (Exception exception) {
                Logger.w((String)"mServerSocket is exception", (Object[])new Object[0]);
                break;
            }
            catch (IOException iOException) {
                Logger.w((String)"ServerThread accept() failed", (Object[])new Object[0]);
                break;
            }
        }
        Logger.i((String)"ServerThread END", (Object[])new Object[0]);
    }
}
