/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Handler
 *  com.lianhezhuli.btnotification.event.FindPhoneEvent
 *  com.lianhezhuli.btnotification.event.FindWatchEvent
 *  com.lianhezhuli.btnotification.event.RemoteAlarmEvent
 *  com.lianhezhuli.btnotification.event.SyncDataEvent
 *  com.lianhezhuli.btnotification.mtk.CommandUtil
 *  com.lianhezhuli.btnotification.mtk.DataUtils
 *  com.lianhezhuli.btnotification.mtk.btconnection.BluetoothConnection
 *  com.lianhezhuli.btnotification.mtk.btconnection.BluetoothManager$1
 *  com.lianhezhuli.btnotification.mtk.btconnection.BluetoothManager$MessageHandler
 *  com.lianhezhuli.btnotification.mtk.btconnection.MessageDataList
 *  com.lianhezhuli.btnotification.mtk.data.Util
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 *  com.lianhezhuli.btnotification.mtk.service.RemoteCameraService
 *  com.lianhezhuli.btnotification.utils.SpUtils
 *  com.lianhezhuli.btnotification.utils.StringUtils
 *  com.mediatek.wearable.LoadJniFunction
 *  com.orhanobut.logger.Logger
 *  org.greenrobot.eventbus.EventBus
 */
package com.lianhezhuli.btnotification.mtk.btconnection;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.lianhezhuli.btnotification.event.FindPhoneEvent;
import com.lianhezhuli.btnotification.event.FindWatchEvent;
import com.lianhezhuli.btnotification.event.RemoteAlarmEvent;
import com.lianhezhuli.btnotification.event.SyncDataEvent;
import com.lianhezhuli.btnotification.mtk.CommandUtil;
import com.lianhezhuli.btnotification.mtk.DataUtils;
import com.lianhezhuli.btnotification.mtk.btconnection.BluetoothConnection;
import com.lianhezhuli.btnotification.mtk.btconnection.BluetoothManager;
import com.lianhezhuli.btnotification.mtk.btconnection.MessageDataList;
import com.lianhezhuli.btnotification.mtk.data.Util;
import com.lianhezhuli.btnotification.mtk.service.MainService;
import com.lianhezhuli.btnotification.mtk.service.RemoteCameraService;
import com.lianhezhuli.btnotification.utils.SpUtils;
import com.lianhezhuli.btnotification.utils.StringUtils;
import com.mediatek.wearable.LoadJniFunction;
import com.orhanobut.logger.Logger;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;

public class BluetoothManager {
    public static final int BLOCKED = 1;
    public static final int BLUETOOTH_CONNECT_SUCCESS = 0;
    public static final int BLUETOOTH_NOT_CONNECT = -3;
    public static final int BLUETOOTH_NOT_ENABLE = -2;
    public static final int BLUETOOTH_NOT_SUPPORT = -1;
    public static final String BT_BROADCAST_ACTION = "com.lianhezhuli.connection.BT_CONNECTION_CHANGED";
    public static final String DEVICE_NAME = "device_name";
    public static final String EXTRA_DATA = "EXTRA_DATA";
    public static final String EXTRA_TYPE = "EXTRA_TYPE";
    public static final int FAILED = -1;
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_TOAST = 5;
    public static final int MESSAGE_WRITE = 3;
    public static final int READ_CMD = 2;
    public static final int READ_DATA = 3;
    public static final int READ_IDLE = 0;
    public static final int READ_PRE = 1;
    public static final int SUCCESS = 0;
    public static final String TOAST = "toast";
    public static final int TYPE_BT_CONNECTED = 1;
    public static final int TYPE_BT_CONNECTION_LOST = 2;
    public static final int TYPE_DATA_ARRIVE = 4;
    public static final int TYPE_DATA_SENT = 3;
    public static final int TYPE_MAPCMD_ARRIVE = 5;
    public static int cmdBufferLenth = 0;
    public static byte[] commandBuffer;
    public static byte[] dataBuffer;
    public static int dataBufferLenth = 0;
    private static boolean isHandshake = false;
    private static boolean isOlderThanVersionTow = true;
    private static MainService mService;
    public static final byte[] reciveBuffer;
    public static int reciveBufferLenth;
    private static int synchronizationNumber;
    private static int synchronizationNumberBin;
    public int CMD_TYPE = 1;
    public int READBUFFERSTATE = 0;
    private final BroadcastReceiver mBTReceiver;
    private BluetoothAdapter mBluetoothAdapter = null;
    private BluetoothConnection mBluetoothConnection = null;
    private String mConnectedDeviceName = null;
    private Context mContext = null;
    private MessageHandler mHandler = null;
    private LoadJniFunction mLoadJniFunction = null;
    private MessageDataList mMessageDataList = null;
    public Timer mTimer = new Timer(true);

    static {
        reciveBuffer = new byte[51200];
    }

    public BluetoothManager(Context context) {
        this.mBTReceiver = new /* Unavailable Anonymous Inner Class!! */;
        Logger.i((String)"BluetoothManager(), BluetoothManager created!", (Object[])new Object[0]);
        this.mHandler = new MessageHandler(this);
        this.mContext = context;
        this.mLoadJniFunction = new LoadJniFunction();
        context = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        this.mContext.registerReceiver(this.mBTReceiver, (IntentFilter)context);
        this.mMessageDataList = new MessageDataList(this.mContext);
    }

    static /* synthetic */ boolean access$000() {
        return isHandshake;
    }

    static /* synthetic */ boolean access$002(boolean bl) {
        isHandshake = bl;
        return bl;
    }

    static /* synthetic */ boolean access$100() {
        return isOlderThanVersionTow;
    }

    static /* synthetic */ boolean access$102(boolean bl) {
        isOlderThanVersionTow = bl;
        return bl;
    }

    static /* synthetic */ void access$200(BluetoothManager bluetoothManager, int n, byte[] byArray) {
        bluetoothManager.sendBroadcast(n, byArray);
    }

    static /* synthetic */ void access$300(BluetoothManager bluetoothManager) throws IOException {
        bluetoothManager.sendSyncTime();
    }

    static /* synthetic */ void access$400(BluetoothManager bluetoothManager) {
        bluetoothManager.runningSyncTimer();
    }

    static /* synthetic */ void access$500(String string) {
        BluetoothManager.getCommand(string);
    }

    static /* synthetic */ void access$600(BluetoothManager bluetoothManager) {
        bluetoothManager.runningReadFSM();
    }

    private void getCmdAndDataLenth() {
        int n = reciveBufferLenth;
        int n2 = cmdBufferLenth;
        if (n < n2) {
            Logger.i((String)"getDataLenth():reciveBufferLenth < cmdBufferLenth", (Object[])new Object[0]);
            return;
        }
        Object object = new byte[n2];
        commandBuffer = object;
        System.arraycopy(reciveBuffer, 0, object, 0, n2);
        object = reciveBuffer;
        n2 = cmdBufferLenth;
        System.arraycopy(object, n2, object, 0, reciveBufferLenth - n2);
        object = reciveBuffer;
        n = reciveBufferLenth;
        n2 = cmdBufferLenth;
        object[n - n2] = 0;
        reciveBufferLenth = n - n2;
        object = new StringBuilder();
        ((StringBuilder)object).append("getDataLenth() :Get cmdBuffer Success cmdBufferLenth is ");
        ((StringBuilder)object).append(cmdBufferLenth);
        ((StringBuilder)object).append("reciveBufferLenth is ");
        ((StringBuilder)object).append(reciveBufferLenth);
        Logger.i((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        this.CMD_TYPE = this.mLoadJniFunction.getCmdType(commandBuffer, cmdBufferLenth);
        object = new StringBuilder();
        ((StringBuilder)object).append("Get data Success and the CMD_TYPE is ");
        ((StringBuilder)object).append(this.CMD_TYPE);
        Logger.i((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        if (!this.isBTConnected()) {
            if (this.mLoadJniFunction.getCmdType(commandBuffer, cmdBufferLenth) == 3) {
                isHandshake = true;
                Logger.i((String)"isHandshake = true", (Object[])new Object[0]);
                this.sendBroadcast(1, null);
                this.sendDataFromFile();
                this.READBUFFERSTATE = 0;
                this.runningReadFSM();
                return;
            }
            if (this.mLoadJniFunction.getCmdType(commandBuffer, cmdBufferLenth) == 4) {
                BluetoothManager.reciveBuffer[0] = 0;
                reciveBufferLenth = 0;
                isOlderThanVersionTow = false;
                this.READBUFFERSTATE = 0;
                Logger.i((String)"getDataLenth():Get the Version Success", (Object[])new Object[0]);
                return;
            }
            this.READBUFFERSTATE = 0;
            return;
        }
        n2 = this.CMD_TYPE;
        if (n2 != 1 && n2 != 5 && n2 != 6 && n2 != 7) {
            this.READBUFFERSTATE = 0;
            return;
        }
        dataBufferLenth = this.mLoadJniFunction.getDataLenth(commandBuffer, cmdBufferLenth);
        object = new StringBuilder();
        ((StringBuilder)object).append("getDataLenth():Get dataBufferLenth Success dataBufferLenth is ");
        ((StringBuilder)object).append(dataBufferLenth);
        Logger.i((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        if (dataBufferLenth == -1) {
            this.READBUFFERSTATE = 0;
            return;
        }
        this.READBUFFERSTATE = 2;
        this.runningReadFSM();
    }

    private byte[] getCmdBuffer(int n, String string) {
        return this.mLoadJniFunction.getDataCmd(n, string);
    }

    private static void getCommand(String stringArray) {
        Object object;
        String string;
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("readMessage=");
        ((StringBuilder)charSequence).append((String)stringArray);
        Logger.e((String)((StringBuilder)charSequence).toString(), (Object[])new Object[0]);
        int n = stringArray.length();
        if (stringArray.length() > 4) {
            string = stringArray.substring(0, 4);
            charSequence = stringArray.substring(4, n);
        } else {
            charSequence = "";
            string = "";
        }
        if (stringArray.startsWith(CommandUtil.SYNC_DATA)) {
            object = stringArray.split(",");
            if (((String[])object).length >= 8) {
                SpUtils.saveData((String)"is_device_new", (Object)"true");
                if (object[3].length() < 4) {
                    SpUtils.saveData((String)"can_automatic", (Object)"false");
                    SpUtils.saveData((String)"have_heart_rate", (Object)"false");
                    SpUtils.saveData((String)"device_id", (Object)object[2]);
                    if (Integer.parseInt((String)object[5]) + Integer.parseInt((String)object[6]) + Integer.parseInt((String)object[7]) != 0) {
                        MainService.getInstance().sendPhoneData(CommandUtil.SYNC_SPORT_SLEEP_DATA);
                    }
                } else if (!((String)object[3]).contains("A")) {
                    SpUtils.saveData((String)"can_automatic", (Object)"false");
                    if (!((String)object[3]).contains("H")) {
                        SpUtils.saveData((String)"have_heart_rate", (Object)"false");
                    } else {
                        SpUtils.saveData((String)"have_heart_rate", (Object)"true");
                    }
                    SpUtils.saveData((String)"device_id", (Object)object[2]);
                    if (Integer.parseInt((String)object[5]) + Integer.parseInt((String)object[6]) + Integer.parseInt((String)object[7]) != 0) {
                        MainService.getInstance().sendPhoneData(CommandUtil.SYNC_SPORT_SLEEP_DATA);
                    }
                } else if (!((String)object[3]).contains("H")) {
                    SpUtils.saveData((String)"can_automatic", (Object)"true");
                    SpUtils.saveData((String)"have_heart_rate", (Object)"false");
                    if (!((String)object[2]).equals(SpUtils.getData((String)"device_id", (Object)""))) {
                        SpUtils.saveData((String)"device_id", (Object)object[2]);
                        if (Integer.parseInt((String)object[5]) + Integer.parseInt((String)object[6]) + Integer.parseInt((String)object[7]) != 0) {
                            synchronizationNumber = 167;
                            synchronizationNumberBin = 0;
                            object = StringUtils.yyyy_MM_dd_HH.format(System.currentTimeMillis());
                            MainService mainService = MainService.getInstance();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("GET,2 ");
                            stringBuilder.append((String)object);
                            mainService.sendPhoneData(stringBuilder.toString());
                            SpUtils.saveData((String)"synchronization_time", (Object)object);
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("getCommand \u53d1\u9001 == ");
                            stringBuilder.append((String)object);
                            Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
                        }
                    } else if (Integer.parseInt((String)object[5]) + Integer.parseInt((String)object[6]) + Integer.parseInt((String)object[7]) != 0) {
                        object = (String)SpUtils.getData((String)"synchronization_time", (Object)"");
                        if (!((String)object).equals("")) {
                            try {
                                Serializable serializable = Calendar.getInstance();
                                ((Calendar)serializable).setTime(StringUtils.yyyy_MM_dd_HH.parse((String)object));
                                synchronizationNumber = (int)((System.currentTimeMillis() - ((Calendar)serializable).getTimeInMillis()) / 3600000L);
                                synchronizationNumberBin = 0;
                                object = StringUtils.yyyy_MM_dd_HH.format(System.currentTimeMillis());
                                MainService mainService = MainService.getInstance();
                                serializable = new StringBuilder();
                                ((StringBuilder)serializable).append("GET,2 ");
                                ((StringBuilder)serializable).append((String)object);
                                mainService.sendPhoneData(((StringBuilder)serializable).toString());
                                SpUtils.saveData((String)"synchronization_time", (Object)object);
                            }
                            catch (ParseException parseException) {
                                parseException.printStackTrace();
                            }
                        } else {
                            synchronizationNumber = 167;
                            synchronizationNumberBin = 0;
                            object = StringUtils.yyyy_MM_dd_HH.format(System.currentTimeMillis());
                            MainService mainService = MainService.getInstance();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("GET,2 ");
                            stringBuilder.append((String)object);
                            mainService.sendPhoneData(stringBuilder.toString());
                            SpUtils.saveData((String)"synchronization_time", (Object)object);
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("getCommand \u53d1\u9001 == ");
                            stringBuilder.append((String)object);
                            Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
                        }
                    }
                } else {
                    SpUtils.saveData((String)"can_automatic", (Object)"true");
                    SpUtils.saveData((String)"have_heart_rate", (Object)"true");
                    if (!((String)object[2]).equals(SpUtils.getData((String)"device_id", (Object)""))) {
                        SpUtils.saveData((String)"device_id", (Object)object[2]);
                        if (Integer.parseInt((String)object[5]) + Integer.parseInt((String)object[6]) + Integer.parseInt((String)object[7]) != 0) {
                            synchronizationNumber = 167;
                            synchronizationNumberBin = 0;
                            object = StringUtils.yyyy_MM_dd_HH.format(System.currentTimeMillis());
                            Object object2 = MainService.getInstance();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("GET,2 ");
                            stringBuilder.append((String)object);
                            object2.sendPhoneData(stringBuilder.toString());
                            SpUtils.saveData((String)"synchronization_time", (Object)object);
                            object2 = new StringBuilder();
                            ((StringBuilder)object2).append("getCommand \u53d1\u9001 == ");
                            ((StringBuilder)object2).append((String)object);
                            Logger.e((String)((StringBuilder)object2).toString(), (Object[])new Object[0]);
                        }
                    } else if (Integer.parseInt((String)object[5]) + Integer.parseInt((String)object[6]) + Integer.parseInt((String)object[7]) != 0) {
                        object = (String)SpUtils.getData((String)"synchronization_time", (Object)"");
                        if (!((String)object).equals("")) {
                            try {
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTime(StringUtils.yyyy_MM_dd_HH.parse((String)object));
                                synchronizationNumber = (int)((System.currentTimeMillis() - calendar.getTimeInMillis()) / 3600000L);
                                synchronizationNumberBin = 0;
                                String string2 = StringUtils.yyyy_MM_dd_HH.format(System.currentTimeMillis());
                                calendar = MainService.getInstance();
                                object = new StringBuilder();
                                ((StringBuilder)object).append("GET,2 ");
                                ((StringBuilder)object).append(string2);
                                calendar.sendPhoneData(((StringBuilder)object).toString());
                                SpUtils.saveData((String)"synchronization_time", (Object)string2);
                            }
                            catch (ParseException parseException) {
                                parseException.printStackTrace();
                            }
                        } else {
                            synchronizationNumber = 167;
                            synchronizationNumberBin = 0;
                            object = StringUtils.yyyy_MM_dd_HH.format(System.currentTimeMillis());
                            MainService mainService = MainService.getInstance();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("GET,2 ");
                            stringBuilder.append((String)object);
                            mainService.sendPhoneData(stringBuilder.toString());
                            SpUtils.saveData((String)"synchronization_time", (Object)object);
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("getCommand \u53d1\u9001 == ");
                            stringBuilder.append((String)object);
                            Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
                        }
                    }
                }
            } else if (((String[])object).length == 7) {
                SpUtils.saveData((String)"is_device_new", (Object)"false");
                SpUtils.saveData((String)"can_automatic", (Object)"false");
                SpUtils.saveData((String)"have_heart_rate", (Object)"false");
                if (Integer.parseInt((String)object[4]) + Integer.parseInt((String)object[5]) + Integer.parseInt((String)object[6]) != 0) {
                    MainService.getInstance().sendPhoneData(CommandUtil.SYNC_SPORT_SLEEP_DATA);
                } else {
                    EventBus.getDefault().post((Object)new SyncDataEvent(true));
                }
            } else {
                MainService.getInstance().sendPhoneData(CommandUtil.SYNC_DATA);
            }
        }
        if (stringArray.startsWith(CommandUtil.SYNC_SPORT_SLEEP_DATA) && stringArray.length() > 6) {
            object = new StringBuilder();
            ((StringBuilder)object).append("\u8fd4\u56de\u8fd0\u52a8\u8ba1\u6b65\u7761\u7720\u6570\u636e\uff1a");
            ((StringBuilder)object).append((String)stringArray);
            Logger.e((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
            DataUtils.handleGet1Data((String)stringArray);
        }
        if (stringArray.startsWith(CommandUtil.REMOTE_ALARM)) {
            stringArray = stringArray.split(",");
            EventBus.getDefault().post((Object)new RemoteAlarmEvent(stringArray[stringArray.length - 1].equals("1")));
        }
        if (string.equals("0012") && (n = MainService.getInstance().getAudio()) != 0) {
            MainService.getInstance().setFlag(true);
            MainService.getInstance().setringEnd(n);
            MainService.getInstance().setAudio();
        }
        if (!string.equals("0006")) return;
        if (((String)charSequence).equals("stop")) {
            EventBus.getDefault().post((Object)new FindPhoneEvent((String)charSequence));
        } else if (((String)charSequence).equals("success")) {
            Logger.e((String)" findWatchSuccess =========== success", (Object[])new Object[0]);
            EventBus.getDefault().post((Object)new FindWatchEvent(true));
        } else {
            EventBus.getDefault().post((Object)new FindPhoneEvent((String)charSequence));
        }
    }

    private void getCommandLenth() {
        int n;
        Object object;
        int n2;
        block5: {
            if (this.READBUFFERSTATE != 0) {
                return;
            }
            if (reciveBufferLenth < 8) {
                Logger.i((String)"getCommandLenth(): reciveBufferLenth < Constants.NOTIFYMINIHEADERLENTH", (Object[])new Object[0]);
                return;
            }
            for (n2 = 0; n2 < reciveBufferLenth - 4; ++n2) {
                object = reciveBuffer;
                if (object[n2] != -16 || object[n2 + 1] != -16 || object[n2 + 2] != -16 || object[n2 + 3] != -15) continue;
                Logger.i((String)"getCommandLenth(): Get F0F0F0F1 Success", (Object[])new Object[0]);
                n = n2;
                break block5;
            }
            n = -1;
        }
        if (n != -1) {
            object = reciveBuffer;
            byte by = object[n2 + 4];
            n = object[n2 + 5];
            byte by2 = object[n2 + 6];
            cmdBufferLenth = object[n2 + 7] | (by << 24 | n << 16 | by2 << 8);
            System.arraycopy(object, 8, object, 0, reciveBufferLenth - 8);
            reciveBufferLenth -= 8;
            this.READBUFFERSTATE = 1;
            object = new StringBuilder();
            object.append("getCommandLenth(): Get cmdBufferLenth Success cmdBufferLenth is ");
            object.append(cmdBufferLenth);
            object.append("reciveBufferLenth is ");
            object.append(reciveBufferLenth);
            Logger.i((String)object.toString(), (Object[])new Object[0]);
            this.runningReadFSM();
        } else {
            object = reciveBuffer;
            System.arraycopy(object, 8, object, 0, reciveBufferLenth - 8);
            reciveBufferLenth -= 8;
            this.READBUFFERSTATE = 0;
            object = new StringBuilder();
            object.append("getCommandLenth(): Get cmdBufferLenth Success cmdBufferLenth is ");
            object.append(cmdBufferLenth);
            object.append("reciveBufferLenth is ");
            object.append(reciveBufferLenth);
            Logger.i((String)object.toString(), (Object[])new Object[0]);
            this.runningReadFSM();
        }
    }

    private void getData() {
        int n = dataBufferLenth;
        if (n > reciveBufferLenth) return;
        Object object = new byte[n];
        dataBuffer = object;
        System.arraycopy(reciveBuffer, 0, object, 0, n);
        object = reciveBuffer;
        n = dataBufferLenth;
        System.arraycopy(object, n, object, 0, reciveBufferLenth - n);
        object = reciveBuffer;
        int n2 = reciveBufferLenth;
        n = dataBufferLenth;
        object[n2 - n] = 0;
        reciveBufferLenth = n2 - n;
        this.READBUFFERSTATE = 0;
        cmdBufferLenth = 0;
        dataBufferLenth = 0;
        n = this.CMD_TYPE;
        if (n == 1) {
            this.sendBroadcast(4, dataBuffer);
        } else if (n != 5 && n != 6) {
            if (n == 7) {
                this.sendBroadcasetToCapService(dataBuffer);
            }
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append("sendBroadcast of MAPX OR MAPD :");
            ((StringBuilder)object).append(this.CMD_TYPE);
            Logger.i((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
            Logger.i((String)"mIsNeedStartBTMapService is :true", (Object[])new Object[0]);
            this.sendBroadcasetToMapService(dataBuffer);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("reciveBufferLenth is ");
        ((StringBuilder)object).append(reciveBufferLenth);
        Logger.i((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        if (reciveBufferLenth == 0) {
            return;
        }
        this.runningReadFSM();
    }

    private void runningReadFSM() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("runningReadFSM() READBUFFERSTATE = ");
        stringBuilder.append(this.READBUFFERSTATE);
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        int n = this.READBUFFERSTATE;
        if (n != 0) {
            if (n != 1) {
                if (n != 2) return;
                this.getData();
            } else {
                this.getCmdAndDataLenth();
            }
        } else {
            this.getCommandLenth();
        }
    }

    private void runningSyncTimer() {
        1 var1_1 = new /* Unavailable Anonymous Inner Class!! */;
        this.mTimer.schedule((TimerTask)var1_1, 3000L);
    }

    private void sendBroadcast(int n, byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sendBroadcast(), extraType=");
        stringBuilder.append(n);
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        stringBuilder = new Intent();
        stringBuilder.setAction(BT_BROADCAST_ACTION);
        stringBuilder.putExtra(EXTRA_TYPE, n);
        if (byArray != null) {
            stringBuilder.putExtra(EXTRA_DATA, byArray);
        }
        this.mContext.sendBroadcast((Intent)stringBuilder);
    }

    private void sendCommandToRemote(int n, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Send Command to Remote: ");
        stringBuilder.append(string);
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        this.mBluetoothConnection.write(this.getCmdBuffer(n, string));
    }

    private void sendDataToRemote(int n, byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sendDataToRemote cmd and data()");
        stringBuilder.append(this.getCmdBuffer(n, String.valueOf(byArray.length)));
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        this.mBluetoothConnection.write(this.getCmdBuffer(n, String.valueOf(byArray.length)));
        this.mBluetoothConnection.write(byArray);
    }

    private void sendSyncTime() throws IOException {
        long l = System.currentTimeMillis();
        int n = Util.getUtcTime((long)l);
        int n2 = Util.getUtcTimeZone((long)l);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(n));
        stringBuilder.append(" ");
        stringBuilder.append(String.valueOf(n2));
        this.sendCommandToRemote(2, stringBuilder.toString());
        Logger.i((String)"sendSyncTime()", (Object[])new Object[0]);
    }

    public String getConnectedDeviceName() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getConnectedDeviceName(), mConnectedDeviceName=");
        stringBuilder.append(this.mConnectedDeviceName);
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        return this.mConnectedDeviceName;
    }

    public boolean isBTConnected() {
        BluetoothConnection bluetoothConnection = this.mBluetoothConnection;
        boolean bl = bluetoothConnection != null && isHandshake && bluetoothConnection.getState() == 3;
        return bl;
    }

    public int removeConnection() {
        Logger.i((String)"removeConnection(), Bluetooth connection is removed!", (Object[])new Object[0]);
        BluetoothConnection bluetoothConnection = this.mBluetoothConnection;
        if (bluetoothConnection == null) return 0;
        bluetoothConnection.stop();
        return 0;
    }

    public void saveData() {
        Logger.i((String)"saveData()", (Object[])new Object[0]);
        this.mMessageDataList.saveMessageDataList();
    }

    public void sendBroadcasetToCapService(byte[] byArray) {
        Intent intent = new Intent();
        intent.setAction("com.lianhezhuli.RemoteCamera");
        if (byArray != null) {
            intent.putExtra(EXTRA_DATA, byArray);
        }
        this.mContext.sendBroadcast(intent);
    }

    public void sendBroadcasetToMapService(byte[] byArray) {
        Intent intent = new Intent();
        intent.setAction("com.lianhezhuli.map.BT_MAP_COMMAND_ARRIVE");
        if (byArray != null) {
            intent.putExtra(EXTRA_DATA, byArray);
        }
        this.mContext.sendBroadcast(intent);
    }

    public boolean sendCAPCData(byte[] byArray) {
        if (this.isBTConnected()) {
            this.mBluetoothConnection.write(byArray);
            Logger.i((String)"sendCAPCData(), isDataSent=true", (Object[])new Object[0]);
            return true;
        }
        Logger.i((String)"sendCAPCData(), isDataSent=false", (Object[])new Object[0]);
        return false;
    }

    public void sendCAPCResult(String string) {
        if (!this.isBTConnected()) return;
        this.sendCommandToRemote(7, string);
    }

    public boolean sendData(byte[] byArray) {
        boolean bl;
        boolean bl2 = true;
        if (byArray != null && this.isBTConnected() && !RemoteCameraService.isLaunched) {
            this.sendDataToRemote(1, byArray);
            bl = bl2;
            if (this.mMessageDataList.getMessageDataList().size() <= 0) return bl;
            this.sendDataFromFile();
            Logger.i((String)"Notice!!!!, has message data not been sent.", (Object[])new Object[0]);
            bl = bl2;
        } else {
            this.mMessageDataList.saveMessageData(byArray);
            bl = false;
        }
        return bl;
    }

    public boolean sendDataFromFile() {
        List list = this.mMessageDataList.getMessageDataList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sendDataFromFile(), message count=");
        stringBuilder.append(list.size());
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        if (list.size() <= 0) return false;
        int n = list.size();
        int n2 = 0;
        while (n2 < n) {
            if (list.get(0) == null) return false;
            if (!this.isBTConnected()) return false;
            this.sendDataToRemote(1, (byte[])list.get(0));
            list.remove(0);
            stringBuilder = new StringBuilder();
            stringBuilder.append("sendDataFromFile(), message index=");
            stringBuilder.append(n2);
            Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
            ++n2;
        }
        return false;
    }

    public boolean sendMAPData(byte[] byArray) {
        if (this.isBTConnected() && !RemoteCameraService.isLaunched) {
            this.mBluetoothConnection.write(byArray);
            Logger.i((String)"sendMAPData(), isDataSent=true", (Object[])new Object[0]);
            return true;
        }
        Logger.i((String)"sendMAPData(), isDataSent=false", (Object[])new Object[0]);
        return false;
    }

    public boolean sendMREEData(byte[] byArray) {
        if (this.isBTConnected()) {
            this.mBluetoothConnection.write(byArray);
            Logger.i((String)"sendMREEData(), isDataSent=true", (Object[])new Object[0]);
            return true;
        }
        Logger.i((String)"sendMREEData(), isDataSent=false", (Object[])new Object[0]);
        return false;
    }

    public void sendMREEResult(String string) {
        if (!this.isBTConnected()) return;
        this.sendCommandToRemote(8, string);
    }

    public void sendMapDResult(String string) {
        if (!this.isBTConnected()) return;
        if (RemoteCameraService.isLaunched) return;
        this.sendCommandToRemote(6, string);
    }

    public void sendMapResult(String string) {
        if (!this.isBTConnected()) return;
        if (RemoteCameraService.isLaunched) return;
        this.sendCommandToRemote(5, string);
    }

    public void setConnectedDeviceName(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setConnectedDeviceName(), deviceName=");
        stringBuilder.append(string);
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        this.mConnectedDeviceName = string;
    }

    public int setupConnection() {
        BluetoothAdapter bluetoothAdapter;
        Logger.d((Object)"setupConnection()");
        this.mBluetoothAdapter = bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            return -1;
        }
        if (!bluetoothAdapter.isEnabled()) {
            return -2;
        }
        bluetoothAdapter = new BluetoothConnection((Handler)this.mHandler);
        this.mBluetoothConnection = bluetoothAdapter;
        bluetoothAdapter.startAccept();
        Logger.d((Object)"setupConnection(), setupConnection successfully!");
        return 0;
    }
}
