/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification$Builder
 *  android.app.Service
 *  android.content.BroadcastReceiver
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.database.ContentObserver
 *  android.media.AudioManager
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  android.provider.CallLog$Calls
 *  android.service.notification.StatusBarNotification
 *  com.lianhezhuli.btnotification.MApplication
 *  com.lianhezhuli.btnotification.mtk.btconnection.BluetoothManager
 *  com.lianhezhuli.btnotification.mtk.data.AppList
 *  com.lianhezhuli.btnotification.mtk.data.BlockList
 *  com.lianhezhuli.btnotification.mtk.data.CallMessageBody
 *  com.lianhezhuli.btnotification.mtk.data.MessageBody
 *  com.lianhezhuli.btnotification.mtk.data.MessageHeader
 *  com.lianhezhuli.btnotification.mtk.data.MessageObj
 *  com.lianhezhuli.btnotification.mtk.data.NoDataException
 *  com.lianhezhuli.btnotification.mtk.data.NotificationMessageBody
 *  com.lianhezhuli.btnotification.mtk.data.PreferenceData
 *  com.lianhezhuli.btnotification.mtk.data.SmsMessageBody
 *  com.lianhezhuli.btnotification.mtk.data.Util
 *  com.lianhezhuli.btnotification.mtk.map.BTMapService
 *  com.lianhezhuli.btnotification.mtk.map.SmsController
 *  com.lianhezhuli.btnotification.mtk.service.CallService
 *  com.lianhezhuli.btnotification.mtk.service.RemoteCameraService
 *  com.lianhezhuli.btnotification.mtk.service.SmsService
 *  com.lianhezhuli.btnotification.mtk.service.SystemNotificationService
 *  com.lianhezhuli.btnotification.utils.ToastUtils
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.mtk.service;

import android.app.Notification;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.provider.CallLog;
import android.service.notification.StatusBarNotification;
import com.lianhezhuli.btnotification.MApplication;
import com.lianhezhuli.btnotification.mtk.btconnection.BluetoothManager;
import com.lianhezhuli.btnotification.mtk.data.AppList;
import com.lianhezhuli.btnotification.mtk.data.BlockList;
import com.lianhezhuli.btnotification.mtk.data.CallMessageBody;
import com.lianhezhuli.btnotification.mtk.data.MessageBody;
import com.lianhezhuli.btnotification.mtk.data.MessageHeader;
import com.lianhezhuli.btnotification.mtk.data.MessageObj;
import com.lianhezhuli.btnotification.mtk.data.NoDataException;
import com.lianhezhuli.btnotification.mtk.data.NotificationMessageBody;
import com.lianhezhuli.btnotification.mtk.data.PreferenceData;
import com.lianhezhuli.btnotification.mtk.data.SmsMessageBody;
import com.lianhezhuli.btnotification.mtk.data.Util;
import com.lianhezhuli.btnotification.mtk.map.BTMapService;
import com.lianhezhuli.btnotification.mtk.map.SmsController;
import com.lianhezhuli.btnotification.mtk.service.CallService;
import com.lianhezhuli.btnotification.mtk.service.RemoteCameraService;
import com.lianhezhuli.btnotification.mtk.service.SmsService;
import com.lianhezhuli.btnotification.mtk.service.SystemNotificationService;
import com.lianhezhuli.btnotification.utils.ToastUtils;
import com.orhanobut.logger.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public final class MainService
extends Service {
    public static int code = 0;
    public static final boolean mIsNeedStartBTMapService = true;
    private static final Context sContext = MApplication.getInstance().getApplicationContext();
    private static MainService sInstance;
    private final BroadcastReceiver mBTManagerReceiver;
    private BTMapService mBTMapService = null;
    private BluetoothManager mBluetoothManager;
    private final ContentObserver mCallLoggerObserver = new /* Unavailable Anonymous Inner Class!! */;
    private CallService mCallService = null;
    private boolean mIsMainServiceActive = false;
    private RemoteCameraService mRemoteCameraService = null;
    private SmsService mSmsService = null;
    private SystemNotificationService mSystemNotificationService = null;
    private AudioManager myAudioManager = null;
    public int ringerEnd;
    public boolean ringerFlag = false;
    public int ringerMode;

    static {
        code = 0;
    }

    public MainService() {
        this.mBluetoothManager = new BluetoothManager(sContext);
        this.mBTManagerReceiver = new /* Unavailable Anonymous Inner Class!! */;
        Logger.i((String)"MainService(), MainService in construction!", (Object[])new Object[0]);
    }

    static /* synthetic */ int access$000(MainService mainService) {
        return mainService.getMissedCallCount();
    }

    static /* synthetic */ Context access$100() {
        return sContext;
    }

    static /* synthetic */ void access$200(MainService mainService, byte[] byArray) throws IOException {
        mainService.parseReadBuffer(byArray);
    }

    static /* synthetic */ BTMapService access$300(MainService mainService) {
        return mainService.mBTMapService;
    }

    private void addBlockList(MessageObj object) {
        object = ((NotificationMessageBody)object.getDataBody()).getAppID();
        object = (CharSequence)AppList.getInstance().getAppList().get(Integer.parseInt((String)object));
        HashSet hashSet = BlockList.getInstance().getBlockList();
        if (hashSet.contains(object)) return;
        if (object == null) return;
        hashSet.add(object);
        BlockList.getInstance().saveBlockList(hashSet);
    }

    private void destoryBluetoothManager() {
        this.mBluetoothManager.saveData();
        this.mBluetoothManager.removeConnection();
        sContext.unregisterReceiver(this.mBTManagerReceiver);
    }

    private byte[] genBytesFromObject(MessageObj object) {
        block7: {
            Object var2_7 = null;
            if (object == null) {
                return null;
            }
            try {
                object = object.genXmlBuff();
                break block7;
            }
            catch (IllegalStateException illegalStateException) {
            }
            catch (IOException iOException) {
            }
            catch (XmlPullParserException xmlPullParserException) {
            }
            catch (NoDataException noDataException) {
            }
            catch (IllegalArgumentException illegalArgumentException) {
                // empty catch block
            }
            ((Throwable)object).printStackTrace();
            object = var2_7;
        }
        return object;
    }

    public static MainService getInstance() {
        if (sInstance != null) return sInstance;
        Logger.i((String)"getInstance(), Main service is null.", (Object[])new Object[0]);
        MainService.startMainService();
        return sInstance;
    }

    private int getMissedCallCount() {
        int n;
        CharSequence charSequence = new StringBuilder("type = ");
        charSequence.append(3);
        charSequence.append(" AND new = 1");
        ContentResolver contentResolver = sContext.getContentResolver();
        Uri uri = CallLog.Calls.CONTENT_URI;
        charSequence = charSequence.toString();
        contentResolver = contentResolver.query(uri, new String[]{"_id"}, (String)charSequence, null, "date DESC");
        if (contentResolver != null) {
            n = contentResolver.getCount();
            contentResolver.close();
        } else {
            n = 0;
        }
        return n;
    }

    private void initBluetoothManager() {
        this.mBluetoothManager.setupConnection();
        IntentFilter intentFilter = new IntentFilter("com.lianhezhuli.connection.BT_CONNECTION_CHANGED");
        sContext.registerReceiver(this.mBTManagerReceiver, intentFilter);
    }

    private boolean isAllServiceDisable() {
        boolean bl = !PreferenceData.isNotificationServiceEnable() && !PreferenceData.isSmsServiceEnable() && !PreferenceData.isCallServiceEnable();
        return bl;
    }

    /*
     * WARNING - void declaration
     */
    private void parseReadBuffer(byte[] object) throws IOException {
        block5: {
            void var1_4;
            Object object2 = new FileOutputStream(new File(this.getFilesDir(), "ReadData"), true);
            ((FileOutputStream)object2).write((byte[])object);
            ((FileOutputStream)object2).close();
            object2 = new MessageObj();
            new MessageHeader();
            try {
                object = object2.parseXml(object);
                object2 = object.getDataHeader().getSubType();
                if (((String)object2).equals("block_sender")) {
                    this.addBlockList((MessageObj)object);
                } else {
                    if (!((String)object2).equals("sms")) return;
                    this.sendSMS((MessageObj)object);
                }
                break block5;
            }
            catch (IOException iOException) {
            }
            catch (XmlPullParserException xmlPullParserException) {
                // empty catch block
            }
            var1_4.printStackTrace();
        }
    }

    private void registerService() {
        this.startSystemNotificationService();
        this.startRemoteCameraService();
        this.startMapService();
        this.startSmsService();
    }

    private void sendData(MessageObj object) {
        if ((object = (Object)this.genBytesFromObject((MessageObj)object)) == null) {
            return;
        }
        this.mBluetoothManager.sendData((byte[])object);
    }

    private static void startMainService() {
        if (Build.VERSION.SDK_INT >= 26) {
            sContext.startForegroundService(new Intent(sContext, MainService.class));
        } else {
            sContext.startService(new Intent(sContext, MainService.class));
        }
    }

    public int getAudio() {
        int n;
        this.ringerMode = n = this.myAudioManager.getRingerMode();
        return n;
    }

    public boolean getFlag() {
        return this.ringerFlag;
    }

    public boolean isBtConnect() {
        return this.mBluetoothManager.isBTConnected();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        int n;
        this.myAudioManager = (AudioManager)this.getSystemService("audio");
        super.onCreate();
        sInstance = this;
        this.mIsMainServiceActive = true;
        Map map = AppList.getInstance().getAppList();
        if (map.size() == 0) {
            map.put("MaxApp", 3);
            map.put(3, AppList.BETTRYLOW_APPID);
            map.put(3, AppList.SMSRESULT_APPID);
            AppList.getInstance().saveAppList(map);
        }
        if (!map.containsValue(AppList.BETTRYLOW_APPID)) {
            n = Integer.parseInt(map.get("MaxApp").toString());
            map.remove("MaxApp");
            map.put("MaxApp", ++n);
            map.put(n, AppList.BETTRYLOW_APPID);
            AppList.getInstance().saveAppList(map);
        }
        if (!map.containsValue(AppList.SMSRESULT_APPID)) {
            n = Integer.parseInt(map.get("MaxApp").toString());
            map.remove("MaxApp");
            map.put("MaxApp", ++n);
            map.put(n, AppList.SMSRESULT_APPID);
            AppList.getInstance().saveAppList(map);
        }
        this.initBluetoothManager();
        this.registerService();
    }

    public void onDestroy() {
        this.mIsMainServiceActive = false;
        this.unregisterReceiver((BroadcastReceiver)this.mSystemNotificationService);
        this.mSystemNotificationService = null;
        this.getContentResolver().unregisterContentObserver(this.mCallLoggerObserver);
        this.stopRemoteCameraService();
        this.stopMapService();
        this.stopSmsService();
        this.destoryBluetoothManager();
    }

    public int onStartCommand(Intent intent, int n, int n2) {
        if (Build.VERSION.SDK_INT < 26) return super.onStartCommand(intent, n, n2);
        Notification.Builder builder = (Notification.Builder)this.getSystemService("notification");
        if (builder == null) return super.onStartCommand(intent, n, n2);
        builder = builder.getActiveNotifications();
        int n3 = ((StatusBarNotification[])builder).length;
        int n4 = 0;
        boolean bl = false;
        while (true) {
            if (n4 >= n3) {
                if (bl) return super.onStartCommand(intent, n, n2);
                builder = new Notification.Builder((Context)this, "com.lianhezhuli.btnotification.notification");
                builder.setContentTitle((CharSequence)this.getString(2131755040)).setSmallIcon(2131623985);
                this.startForeground(10000, builder.build());
                return super.onStartCommand(intent, n, n2);
            }
            if (builder[n4].getId() == 10000) {
                bl = true;
            }
            ++n4;
        }
    }

    public void sendCAPCData(byte[] byArray) {
        this.mBluetoothManager.sendCAPCData(byArray);
    }

    public void sendCAPCResult(String string) {
        this.mBluetoothManager.sendCAPCResult(string);
    }

    public void sendCallMessage(MessageObj messageObj) {
        this.sendData(messageObj);
    }

    public void sendMapDResult(String string) {
        this.mBluetoothManager.sendMapDResult(string);
    }

    public void sendMapData(byte[] byArray) {
        this.mBluetoothManager.sendMAPData(byArray);
    }

    public void sendMapResult(String string) {
        this.mBluetoothManager.sendMapResult(string);
    }

    public void sendNotiMessage(MessageObj messageObj) {
        this.sendData(messageObj);
    }

    public boolean sendPhoneData(String object) {
        boolean bl = this.mBluetoothManager.sendMREEData((byte[])(object = (Object)((String)object).getBytes()));
        if (bl) return bl;
        ToastUtils.showShort((Context)this, (int)2131755043);
        return bl;
    }

    void sendReadMissedCallData() {
        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setCategory("call");
        messageHeader.setSubType("missed_call");
        messageHeader.setMsgId(Util.genMessageId());
        messageHeader.setAction("add");
        int n = Util.getUtcTime((long)Calendar.getInstance().getTimeInMillis());
        CallMessageBody callMessageBody = new CallMessageBody();
        callMessageBody.setSender("");
        callMessageBody.setNumber("");
        callMessageBody.setContent("");
        callMessageBody.setMissedCallCount(0);
        callMessageBody.setTimestamp(n);
        MessageObj messageObj = new MessageObj();
        messageObj.setDataHeader(messageHeader);
        messageObj.setDataBody((MessageBody)callMessageBody);
        MainService.getInstance().sendCallMessage(messageObj);
    }

    void sendSMS(MessageObj object) {
        String string = ((SmsMessageBody)object.getDataBody()).getNumber();
        String string2 = object.getDataBody().getContent();
        String string3 = "\n";
        object = string2;
        if (string2 == null) {
            object = "\n";
        }
        if ("".equals(object)) {
            object = string3;
        }
        string3 = new Intent();
        string3.setAction("SmsController.action.SEND_MESSAGE");
        string3.putExtra("ADDRESS", string);
        string3.putExtra("MESSAGE", (String)object);
        sContext.sendBroadcast((Intent)string3);
    }

    public void sendSmsMessage(MessageObj messageObj) {
        this.sendData(messageObj);
    }

    public void sendSystemNotiMessage(MessageObj messageObj) {
        this.sendData(messageObj);
    }

    public void setAudio() {
        this.myAudioManager.setRingerMode(0);
    }

    public void setAudiodial() {
        this.myAudioManager.setRingerMode(this.ringerEnd);
        this.ringerMode = this.ringerEnd;
    }

    public void setFlag(boolean bl) {
        this.ringerFlag = bl;
    }

    public void setringEnd(int n) {
        this.ringerEnd = n;
    }

    void startMapService() {
        if (!this.mIsMainServiceActive) {
            MainService.startMainService();
        }
        if (this.mBTMapService != null) return;
        this.mBTMapService = new BTMapService();
        IntentFilter intentFilter = new IntentFilter("com.lianhezhuli.map.BT_MAP_COMMAND_ARRIVE");
        this.registerReceiver((BroadcastReceiver)this.mBTMapService, intentFilter);
    }

    void startRemoteCameraService() {
        if (!this.mIsMainServiceActive) {
            MainService.startMainService();
        }
        if (this.mRemoteCameraService != null) return;
        this.mRemoteCameraService = new RemoteCameraService();
        IntentFilter intentFilter = new IntentFilter("com.lianhezhuli.RemoteCamera");
        this.registerReceiver((BroadcastReceiver)this.mRemoteCameraService, intentFilter);
    }

    public void startSmsService() {
        if (!this.mIsMainServiceActive) {
            MainService.startMainService();
        }
        this.mSmsService = new SmsService();
        IntentFilter intentFilter = new IntentFilter("com.lianhezhuli.btnotification.SMS_RECEIVED");
        this.registerReceiver((BroadcastReceiver)this.mSmsService, intentFilter);
    }

    void startSystemNotificationService() {
        this.mSystemNotificationService = new SystemNotificationService();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_LOW");
        this.registerReceiver((BroadcastReceiver)this.mSystemNotificationService, intentFilter);
        intentFilter = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
        this.registerReceiver((BroadcastReceiver)this.mSystemNotificationService, intentFilter);
        intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        this.registerReceiver((BroadcastReceiver)this.mSystemNotificationService, intentFilter);
        intentFilter = new IntentFilter();
        intentFilter.addAction("SenderSMSFromeFP");
        this.registerReceiver((BroadcastReceiver)this.mSystemNotificationService, intentFilter);
    }

    void stopMapService() {
        if (this.mBTMapService == null) return;
        new SmsController(sContext).clearDeletedMessage();
        this.unregisterReceiver((BroadcastReceiver)this.mBTMapService);
        this.mBTMapService = null;
    }

    void stopRemoteCameraService() {
        RemoteCameraService remoteCameraService = this.mRemoteCameraService;
        if (remoteCameraService == null) return;
        this.unregisterReceiver((BroadcastReceiver)remoteCameraService);
        this.mRemoteCameraService = null;
    }

    public void stopSmsService() {
        SmsService smsService = this.mSmsService;
        if (smsService == null) return;
        this.unregisterReceiver((BroadcastReceiver)smsService);
        this.mSmsService = null;
    }
}
