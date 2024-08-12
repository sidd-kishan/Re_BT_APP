/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.BluetoothSocket
 *  com.lianhezhuli.btnotification.mtk.btconnection.BluetoothConnection
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.mtk.btconnection;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import com.lianhezhuli.btnotification.mtk.btconnection.BluetoothConnection;
import com.orhanobut.logger.Logger;
import java.io.IOException;

/*
 * Exception performing whole class analysis ignored.
 */
private class BluetoothConnection.ClientThread
extends Thread {
    private BluetoothSocket mClientSocket;
    private final BluetoothDevice mRemoteDevice;
    final BluetoothConnection this$0;

    public BluetoothConnection.ClientThread(BluetoothConnection bluetoothConnection, BluetoothDevice bluetoothDevice) {
        this.this$0 = bluetoothConnection;
        this.mRemoteDevice = bluetoothDevice;
        try {
            bluetoothConnection = bluetoothDevice.createRfcommSocketToServiceRecord(BluetoothConnection.access$000());
        }
        catch (IOException iOException) {
            Logger.w((String)"create client socket failed", (Object[])new Object[]{iOException});
            bluetoothConnection = null;
        }
        this.mClientSocket = bluetoothConnection;
    }

    public void cancel() {
        Logger.i((String)"cancel(), ClientThread is canceled", (Object[])new Object[0]);
        try {
            this.mClientSocket.close();
        }
        catch (IOException iOException) {
            Logger.w((String)"close connect socket failed", (Object[])new Object[]{iOException});
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        StringBuilder stringBuilder;
        Logger.i((String)"ClientThread BEGIN", (Object[])new Object[0]);
        this.setName("ClientThread");
        BluetoothConnection.access$100((BluetoothConnection)this.this$0).cancelDiscovery();
        try {
            this.mClientSocket.connect();
        }
        catch (IOException iOException) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("unable to connect ");
            stringBuilder.append(iOException.toString());
            Logger.w((String)stringBuilder.toString(), (Object[])new Object[0]);
            try {
                stringBuilder = (BluetoothSocket)this.mRemoteDevice.getClass().getMethod("createRfcommSocket", Integer.TYPE).invoke(this.mRemoteDevice, 1);
                this.mClientSocket = stringBuilder;
                stringBuilder.connect();
            }
            catch (Exception exception) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("unable to connect ");
                stringBuilder.append(exception.toString());
                Logger.w((String)stringBuilder.toString(), (Object[])new Object[0]);
                BluetoothConnection.access$300((BluetoothConnection)this.this$0);
                try {
                    this.mClientSocket.close();
                }
                catch (IOException iOException2) {
                    Logger.w((String)"unable to close socket during connection failure", (Object[])new Object[]{iOException2});
                }
                this.this$0.startAccept();
                return;
            }
        }
        stringBuilder = this.this$0;
        synchronized (stringBuilder) {
            BluetoothConnection.access$402((BluetoothConnection)this.this$0, null);
        }
        this.this$0.connected(this.mClientSocket, this.mRemoteDevice);
    }
}
