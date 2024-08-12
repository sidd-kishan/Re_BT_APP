/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.graphics.Bitmap
 *  android.os.Build$VERSION
 *  android.service.notification.NotificationListenerService
 *  android.service.notification.StatusBarNotification
 *  android.text.TextUtils
 *  android.widget.RemoteViews
 *  com.lianhezhuli.btnotification.mtk.data.AppList
 *  com.lianhezhuli.btnotification.mtk.data.BlockList
 *  com.lianhezhuli.btnotification.mtk.data.IgnoreList
 *  com.lianhezhuli.btnotification.mtk.data.MessageBody
 *  com.lianhezhuli.btnotification.mtk.data.MessageHeader
 *  com.lianhezhuli.btnotification.mtk.data.MessageObj
 *  com.lianhezhuli.btnotification.mtk.data.NotificationMessageBody
 *  com.lianhezhuli.btnotification.mtk.data.PreferenceData
 *  com.lianhezhuli.btnotification.mtk.data.Util
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 *  com.lianhezhuli.btnotification.mtk.service.SmsService
 *  com.lianhezhuli.btnotification.utils.NotificationMsgUtil
 *  com.lianhezhuli.btnotification.utils.ToastUtils
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.mtk.service;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.os.Build;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.lianhezhuli.btnotification.mtk.data.AppList;
import com.lianhezhuli.btnotification.mtk.data.BlockList;
import com.lianhezhuli.btnotification.mtk.data.IgnoreList;
import com.lianhezhuli.btnotification.mtk.data.MessageBody;
import com.lianhezhuli.btnotification.mtk.data.MessageHeader;
import com.lianhezhuli.btnotification.mtk.data.MessageObj;
import com.lianhezhuli.btnotification.mtk.data.NotificationMessageBody;
import com.lianhezhuli.btnotification.mtk.data.PreferenceData;
import com.lianhezhuli.btnotification.mtk.data.Util;
import com.lianhezhuli.btnotification.mtk.service.MainService;
import com.lianhezhuli.btnotification.mtk.service.SmsService;
import com.lianhezhuli.btnotification.utils.NotificationMsgUtil;
import com.lianhezhuli.btnotification.utils.ToastUtils;
import com.orhanobut.logger.Logger;
import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public final class NPNotificationService
extends NotificationListenerService {
    private static final int NOTIFICATION_CONTENT_TYPE = 10;
    private static final int NOTIFICATION_TITLE_TYPE = 9;
    private static String lastMsgStr;
    private Notification notification;

    private NotificationMessageBody createNotificationBody(String string) {
        Object object;
        Object object2;
        Object object3 = Util.getAppInfo((Context)this.getBaseContext(), (CharSequence)string);
        String string2 = Util.getAppName((Context)this.getBaseContext(), (ApplicationInfo)object3);
        Bitmap bitmap = Util.getMessageIcon((Context)this.getBaseContext(), (ApplicationInfo)object3);
        int n = System.currentTimeMillis() - this.notification.when > 3600000L ? Util.getUtcTime((long)System.currentTimeMillis()) : Util.getUtcTime((long)this.notification.when);
        object3 = AppList.getInstance().getAppList();
        if (object3 == null) {
            ToastUtils.showLong((Context)this, (int)2131755124);
            return null;
        }
        if (!object3.containsValue(string)) {
            int n2 = Integer.parseInt(object3.get("MaxApp").toString());
            object3.remove("MaxApp");
            object3.put("MaxApp", ++n2);
            object3.put(n2, string);
            AppList.getInstance().saveAppList((Map)object3);
        }
        Object object4 = this.getNotificationText();
        String string3 = "";
        if (object4 != null) {
            object3 = ((String[])object4).length > 0 && object4[0] != null ? object4[0] : "";
            object4 = ((String[])object4).length > 1 && object4[1] != null ? object4[1] : "";
            object2 = object3;
            if (((String)object3).length() > 128) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(((String)object3).substring(0, 128));
                ((StringBuilder)object2).append("...");
                object2 = ((StringBuilder)object2).toString();
            }
            object3 = object4;
            object = object2;
            if (((String)object4).length() > 256) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(((String)object4).substring(0, 256));
                ((StringBuilder)object3).append("...");
                object3 = ((StringBuilder)object3).toString();
                object = object2;
            }
        } else {
            object3 = "";
            object = "";
        }
        object2 = string3;
        if (this.notification.tickerText != null) {
            object2 = this.notification.tickerText.toString();
        }
        object4 = object2;
        if (((String)object2).length() > 128) {
            object4 = new StringBuilder();
            ((StringBuilder)object4).append(((String)object2).substring(0, 128));
            ((StringBuilder)object4).append("...");
            object4 = ((StringBuilder)object4).toString();
        }
        object2 = object4;
        if (((String)object4).length() > 0) {
            object2 = "[".concat((String)object4).concat("]");
        }
        AppList.getInstance().getAppList();
        object4 = Util.getKeyFromValue((CharSequence)string);
        string = new NotificationMessageBody();
        string.setSender(string2);
        string.setAppID((String)object4);
        string.setTitle((String)object);
        string.setContent((String)object3);
        string.setTickerText((String)object2);
        string.setTimestamp(n);
        string.setIcon(bitmap);
        return string;
    }

    private MessageHeader createNotificationHeader() {
        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setCategory("notification");
        messageHeader.setSubType("text");
        messageHeader.setMsgId(Util.genMessageId());
        messageHeader.setAction("add");
        return messageHeader;
    }

    /*
     * WARNING - combined exceptions agressively - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    private String[] getNotificationText() {
        RemoteViews remoteViews = this.notification.contentView;
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        try {
            Object object;
            int n;
            int n2;
            Object object2;
            block17: {
                object2 = Class.forName(RemoteViews.class.getName()).getDeclaredFields();
                n2 = ((Field[])object2).length;
                n = 0;
                while (n < n2) {
                    object = object2[n];
                    if (!((Field)object).getName().equals("mActions")) {
                        ++n;
                        continue;
                    }
                    break block17;
                }
                return null;
            }
            if (object == null) {
                return null;
            }
            ((AccessibleObject)object).setAccessible(true);
            if (remoteViews == null) return hashMap.values().toArray(new String[0]);
            Iterator iterator = ((ArrayList)((Field)object).get(remoteViews)).iterator();
            while (iterator.hasNext()) {
                Object e = iterator.next();
                Field[] fieldArray = e.getClass().getDeclaredFields();
                n2 = fieldArray.length;
                remoteViews = null;
                object = null;
                for (n = 0; n < n2; ++n) {
                    Object object3;
                    Field field = fieldArray[n];
                    field.setAccessible(true);
                    if (field.getName().equals("value")) {
                        object3 = field.get(e);
                        object2 = remoteViews;
                    } else if (field.getName().equals("type")) {
                        object2 = field.getInt(e);
                        object3 = object;
                    } else {
                        object2 = remoteViews;
                        object3 = object;
                        if (field.getName().equals("methodName")) {
                            object2 = remoteViews;
                            object3 = object;
                            if (((String)field.get(e)).equals("setProgress")) {
                                return null;
                            }
                        }
                    }
                    remoteViews = object2;
                    object = object3;
                }
                if (remoteViews == null || remoteViews.intValue() != 9 && remoteViews.intValue() != 10 || object == null) continue;
                hashMap.put(1, object.toString());
            }
            return hashMap.values().toArray(new String[0]);
        }
        catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
            return hashMap.values().toArray(new String[0]);
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
            return hashMap.values().toArray(new String[0]);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
        }
        return hashMap.values().toArray(new String[0]);
    }

    private void sendNotifiMessage(String string) {
        MessageObj messageObj = new MessageObj();
        messageObj.setDataHeader(this.createNotificationHeader());
        messageObj.setDataBody((MessageBody)this.createNotificationBody(string));
        String string2 = messageObj.getDataBody().getContent();
        string = ((NotificationMessageBody)messageObj.getDataBody()).getTitle();
        String string3 = ((NotificationMessageBody)messageObj.getDataBody()).getTickerText();
        if (string2.length() == 0 && string.length() == 0 && string3.length() == 0) {
            return;
        }
        string = MainService.getInstance();
        if (string == null) return;
        string.sendNotiMessage(messageObj);
    }

    public void handMsg(String string, String object, String object2) {
        Serializable serializable = new StringBuilder();
        ((StringBuilder)serializable).append(string);
        ((StringBuilder)serializable).append("/from:");
        ((StringBuilder)serializable).append((String)object);
        ((StringBuilder)serializable).append("/msgContent:");
        ((StringBuilder)serializable).append((String)object2);
        object = ((StringBuilder)serializable).toString();
        if (!TextUtils.isEmpty((CharSequence)lastMsgStr)) {
            if (((String)object).equals(lastMsgStr)) return;
        }
        lastMsgStr = object;
        if (!PreferenceData.isNeedPush()) return;
        if ("com.android.mms".equals(string)) {
            if (!PreferenceData.isSmsServiceEnable()) return;
            if (SmsService.canReceiveSms) return;
            this.sendNotifiMessage(string);
            return;
        }
        serializable = BlockList.getInstance().getBlockList();
        object = IgnoreList.getInstance().getIgnoreList();
        object2 = IgnoreList.getInstance().getExclusionList();
        if (((HashSet)serializable).contains(string)) return;
        if (((HashSet)object).contains(string)) return;
        if (((HashSet)object2).contains(string)) return;
        this.sendNotifiMessage(string);
    }

    public void onCreate() {
        super.onCreate();
        Logger.e((String)"onCreate", (Object[])new Object[0]);
        if (Build.VERSION.SDK_INT >= 26) return;
        this.startForeground(121, new Notification());
    }

    public void onListenerConnected() {
        super.onListenerConnected();
    }

    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        super.onNotificationPosted(statusBarNotification);
        if (statusBarNotification == null) {
            return;
        }
        Object object = statusBarNotification.getNotification().extras;
        if (object == null) {
            return;
        }
        String string = object.getString("android.title");
        if (TextUtils.isEmpty((CharSequence)string)) {
            return;
        }
        String string2 = statusBarNotification.getPackageName();
        try {
            object = object.getCharSequence("android.text").toString();
        }
        catch (NullPointerException nullPointerException) {
            object = "";
        }
        if (TextUtils.isEmpty((CharSequence)string)) return;
        if (TextUtils.isEmpty((CharSequence)object)) return;
        this.notification = statusBarNotification.getNotification();
        this.handMsg(string2, string, (String)object);
    }

    public void onNotificationRemoved(StatusBarNotification statusBarNotification) {
        super.onNotificationRemoved(statusBarNotification);
    }

    public int onStartCommand(Intent intent, int n, int n2) {
        if (Build.VERSION.SDK_INT < 26) {
            this.startForeground(121, new Notification());
        }
        NotificationMsgUtil.reBindService((Context)this);
        return super.onStartCommand(intent, n, n2);
    }
}
