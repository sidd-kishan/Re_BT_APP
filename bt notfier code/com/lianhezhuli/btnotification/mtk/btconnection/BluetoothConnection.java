/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.BluetoothProfile$ServiceListener
 *  android.bluetooth.BluetoothSocket
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Message
 *  android.text.TextUtils
 *  androidx.core.app.ActivityCompat
 *  com.lianhezhuli.btnotification.MApplication
 *  com.lianhezhuli.btnotification.event.DeviceFirstConnectEvent
 *  com.lianhezhuli.btnotification.event.SyncDataEvent
 *  com.lianhezhuli.btnotification.greendao.manager.ManagerFactory
 *  com.lianhezhuli.btnotification.mtk.btconnection.BluetoothConnection$ClientThread
 *  com.lianhezhuli.btnotification.mtk.btconnection.BluetoothConnection$ServerThread
 *  com.lianhezhuli.btnotification.mtk.btconnection.BluetoothConnection$WorkThread
 *  com.lianhezhuli.btnotification.utils.SpUtils
 *  com.lianhezhuli.btnotification.utils.StringUtils
 *  com.lianhezhuli.btnotification.utils.ToastUtils
 *  com.orhanobut.logger.Logger
 *  org.greenrobot.eventbus.EventBus
 */
package com.lianhezhuli.btnotification.mtk.btconnection;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.lianhezhuli.btnotification.MApplication;
import com.lianhezhuli.btnotification.event.DeviceFirstConnectEvent;
import com.lianhezhuli.btnotification.event.SyncDataEvent;
import com.lianhezhuli.btnotification.greendao.manager.ManagerFactory;
import com.lianhezhuli.btnotification.mtk.btconnection.BluetoothConnection;
import com.lianhezhuli.btnotification.utils.SpUtils;
import com.lianhezhuli.btnotification.utils.StringUtils;
import com.lianhezhuli.btnotification.utils.ToastUtils;
import com.orhanobut.logger.Logger;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.greenrobot.eventbus.EventBus;

public class BluetoothConnection {
    public static final String LOG_TAG = "BluetoothConnection";
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static final String NAME = "BTNotification";
    public static final int STATE_CONNECTED = 3;
    public static final int STATE_CONNECTING = 2;
    public static final int STATE_CONNECT_LOST = 4;
    public static final int STATE_LISTEN = 1;
    public static final int STATE_NONE = 0;
    private final BluetoothAdapter mAdapter;
    private ClientThread mClientThread;
    private int mConnectState;
    private final Handler mMessageHandler;
    private BluetoothProfile.ServiceListener mProxyListener = new /* Unavailable Anonymous Inner Class!! */;
    private ServerThread mServerThread;
    private WorkThread mWorkThread;

    public BluetoothConnection(Handler handler) {
        Logger.i((String)"BluetoothConnection(), BluetoothConnection created!", (Object[])new Object[0]);
        this.mAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mConnectState = 0;
        this.mMessageHandler = handler;
    }

    static /* synthetic */ UUID access$000() {
        return MY_UUID;
    }

    static /* synthetic */ BluetoothAdapter access$100(BluetoothConnection bluetoothConnection) {
        return bluetoothConnection.mAdapter;
    }

    static /* synthetic */ int access$200(BluetoothConnection bluetoothConnection) {
        return bluetoothConnection.mConnectState;
    }

    static /* synthetic */ void access$300(BluetoothConnection bluetoothConnection) {
        bluetoothConnection.connectionFailed();
    }

    static /* synthetic */ ClientThread access$402(BluetoothConnection bluetoothConnection, ClientThread clientThread) {
        bluetoothConnection.mClientThread = clientThread;
        return clientThread;
    }

    static /* synthetic */ Handler access$500(BluetoothConnection bluetoothConnection) {
        return bluetoothConnection.mMessageHandler;
    }

    static /* synthetic */ void access$600(BluetoothConnection bluetoothConnection) {
        bluetoothConnection.connectionLost();
    }

    private void connectionFailed() {
        Logger.i((String)"connectionFailed()", (Object[])new Object[0]);
        this.setState(1);
        Message message = this.mMessageHandler.obtainMessage(5);
        Bundle bundle = new Bundle();
        bundle.putString("toast", "Unable to connect device");
        message.setData(bundle);
        this.mMessageHandler.sendMessage(message);
        this.startAccept();
    }

    private void connectionLost() {
        Logger.i((String)"connectionLost()", (Object[])new Object[0]);
        this.setState(4);
        this.startAccept();
        Logger.i((String)"connectionLost(), ServerThread restart!", (Object[])new Object[0]);
    }

    private void setState(int n) {
        synchronized (this) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setState(), state=");
            stringBuilder.append(n);
            Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
            this.mConnectState = n;
            this.mMessageHandler.obtainMessage(1, n, -1).sendToTarget();
            return;
        }
    }

    public void connectRemoteDevice(BluetoothDevice bluetoothDevice) {
        synchronized (this) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("connectRemoteDevice(), device=");
            stringBuilder.append(bluetoothDevice);
            Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
            if (this.mConnectState == 2 && this.mClientThread != null) {
                this.mClientThread.cancel();
                this.mClientThread = null;
            }
            if (this.mWorkThread != null) {
                this.mWorkThread.cancel();
                this.mWorkThread = null;
            }
            stringBuilder = new ClientThread(this, bluetoothDevice);
            this.mClientThread = stringBuilder;
            stringBuilder.start();
            this.setState(2);
            return;
        }
    }

    public void connected(BluetoothSocket bluetoothSocket, BluetoothDevice bluetoothDevice) {
        synchronized (this) {
            Object object;
            Object object2 = new StringBuilder();
            ((StringBuilder)object2).append("connected(), socket=");
            ((StringBuilder)object2).append(bluetoothSocket);
            ((StringBuilder)object2).append(", device=");
            ((StringBuilder)object2).append(bluetoothDevice);
            Logger.i((String)((StringBuilder)object2).toString(), (Object[])new Object[0]);
            object2 = (String)SpUtils.getData((String)"device_mac_add", (Object)"");
            if (!TextUtils.isEmpty((CharSequence)object2)) {
                if (!((String)object2).equalsIgnoreCase(bluetoothDevice.getAddress())) {
                    SpUtils.saveData((String)"device_mac_add", (Object)bluetoothDevice.getAddress());
                    Logger.e((String)"clear data", (Object[])new Object[0]);
                    object2 = StringUtils.yyyy_M_d;
                    object = new Date();
                    object2 = ((DateFormat)object2).format((Date)object);
                    object = ManagerFactory.getInstance().getStepManager().queryByDate((String)SpUtils.getData((String)"user_id", (Object)""), (String)object2);
                    if (object != null && object.size() > 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("beans size == ");
                        stringBuilder.append(object.size());
                        Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
                        ManagerFactory.getInstance().getStepManager().delete((List)object);
                    }
                    if ((object2 = ManagerFactory.getInstance().getSleepManager().queryByDate((String)SpUtils.getData((String)"user_id", (Object)""), (String)object2)) != null && object2.size() > 0) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("sleepBeans size == ");
                        ((StringBuilder)object).append(object2.size());
                        Logger.e((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
                        ManagerFactory.getInstance().getSleepManager().delete((List)object2);
                    }
                    object = EventBus.getDefault();
                    object2 = new SyncDataEvent(true);
                    object.post(object2);
                }
            } else {
                SpUtils.saveData((String)"device_mac_add", (Object)bluetoothDevice.getAddress());
            }
            if (Build.VERSION.SDK_INT >= 31 && ActivityCompat.checkSelfPermission((Context)MApplication.getInstance(), (String)"android.permission.BLUETOOTH_CONNECT") != 0) {
                ToastUtils.showLong((Context)MApplication.getInstance(), (int)2131755125);
            } else {
                object2 = EventBus.getDefault();
                object = new DeviceFirstConnectEvent(bluetoothDevice.getName(), bluetoothDevice.getAddress());
                object2.post(object);
            }
            if (this.mClientThread != null) {
                this.mClientThread.cancel();
                this.mClientThread = null;
            }
            if (this.mWorkThread != null) {
                this.mWorkThread.cancel();
                this.mWorkThread = null;
            }
            if (this.mServerThread != null) {
                this.mServerThread.cancel();
                this.mServerThread = null;
            }
            object2 = new WorkThread(this, bluetoothSocket);
            this.mWorkThread = object2;
            object2.start();
            object2 = this.mMessageHandler.obtainMessage(4);
            bluetoothSocket = new Bundle();
            bluetoothSocket.putString("device_name", bluetoothDevice.getName());
            object2.setData((Bundle)bluetoothSocket);
            this.mMessageHandler.sendMessage((Message)object2);
            this.setState(3);
            return;
        }
    }

    public int getState() {
        synchronized (this) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getState(), mConnectState=");
            stringBuilder.append(this.mConnectState);
            Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
            int n = this.mConnectState;
            return n;
        }
    }

    public void initBTProxy() {
        synchronized (this) {
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            boolean bl = false;
            if (bluetoothAdapter == null) {
                Logger.e((String)"null btAdapter", (Object[])new Object[0]);
                return;
            }
            if (Build.VERSION.SDK_INT >= 31 && ActivityCompat.checkSelfPermission((Context)MApplication.getInstance(), (String)"android.permission.BLUETOOTH_CONNECT") != 0) {
                ToastUtils.showLong((Context)MApplication.getInstance(), (int)2131755125);
                return;
            }
            int n = bluetoothAdapter.getProfileConnectionState(2);
            boolean bl2 = true;
            if (n == 2 || bluetoothAdapter.getProfileConnectionState(2) == 1) {
                bluetoothAdapter.getProfileProxy((Context)MApplication.getInstance(), this.mProxyListener, 2);
                bl = true;
            }
            if (bluetoothAdapter.getProfileConnectionState(1) == 2 || bluetoothAdapter.getProfileConnectionState(1) == 1) {
                bluetoothAdapter.getProfileProxy((Context)MApplication.getInstance(), this.mProxyListener, 1);
                bl = bl2;
            }
            if (bl) return;
            this.startAccept();
            return;
        }
    }

    public void startAccept() {
        synchronized (this) {
            Logger.i((String)"startAccept()", (Object[])new Object[0]);
            if (this.mClientThread != null) {
                this.mClientThread.cancel();
                this.mClientThread = null;
            }
            if (this.mWorkThread != null) {
                this.mWorkThread.cancel();
                this.mWorkThread = null;
            }
            if (this.mServerThread == null) {
                ServerThread serverThread;
                this.mServerThread = serverThread = new ServerThread(this);
                serverThread.start();
            }
            this.setState(1);
            return;
        }
    }

    public void stop() {
        synchronized (this) {
            Logger.i((String)"stop()", (Object[])new Object[0]);
            if (this.mClientThread != null) {
                this.mClientThread.cancel();
                this.mClientThread = null;
            }
            if (this.mWorkThread != null) {
                this.mWorkThread.cancel();
                this.mWorkThread = null;
            }
            if (this.mServerThread != null) {
                this.mServerThread.cancel();
                this.mServerThread = null;
            }
            this.setState(0);
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void write(byte[] byArray) {
        WorkThread workThread;
        synchronized (this) {
            if (this.mConnectState != 3) {
                return;
            }
            workThread = this.mWorkThread;
        }
        workThread.write(byArray);
    }
}
