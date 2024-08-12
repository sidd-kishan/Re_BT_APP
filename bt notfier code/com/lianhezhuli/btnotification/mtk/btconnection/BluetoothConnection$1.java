/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.BluetoothProfile
 *  android.bluetooth.BluetoothProfile$ServiceListener
 *  android.os.ParcelUuid
 *  com.lianhezhuli.btnotification.mtk.btconnection.BluetoothConnection
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.mtk.btconnection;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.os.ParcelUuid;
import com.lianhezhuli.btnotification.mtk.btconnection.BluetoothConnection;
import com.orhanobut.logger.Logger;

/*
 * Exception performing whole class analysis ignored.
 */
class BluetoothConnection.1
implements BluetoothProfile.ServiceListener {
    final BluetoothConnection this$0;

    BluetoothConnection.1(BluetoothConnection bluetoothConnection) {
        this.this$0 = bluetoothConnection;
    }

    /*
     * Enabled force condition propagation
     */
    public void onServiceConnected(int n, BluetoothProfile object) {
        if ((object = object.getConnectedDevices()) == null || object.size() <= 0) {
            this.this$0.startAccept();
            return;
        }
        object = object.iterator();
        block0: while (true) {
            boolean bl = object.hasNext();
            n = 0;
            if (!bl) {
                Logger.e((String)"no match", (Object[])new Object[0]);
                this.this$0.startAccept();
                return;
            }
            BluetoothDevice bluetoothDevice = (BluetoothDevice)object.next();
            ParcelUuid[] parcelUuidArray = bluetoothDevice.getUuids();
            int n2 = parcelUuidArray.length;
            while (true) {
                if (n >= n2) continue block0;
                if (parcelUuidArray[n].toString().equalsIgnoreCase(BluetoothConnection.access$000().toString())) {
                    this.this$0.connectRemoteDevice(bluetoothDevice);
                    return;
                }
                ++n;
            }
            break;
        }
    }

    public void onServiceDisconnected(int n) {
    }
}
