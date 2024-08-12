/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accessibilityservice.AccessibilityService
 *  android.accessibilityservice.AccessibilityServiceInfo
 *  android.app.Notification
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.graphics.Bitmap
 *  android.os.Build$VERSION
 *  android.view.accessibility.AccessibilityEvent
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
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.mtk.service;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
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
import com.orhanobut.logger.Logger;
import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class NotificationService
extends AccessibilityService {
    private static final long EVENT_NOTIFICATION_TIMEOUT_MILLIS = 0L;
    private static final String LOG_TAG = "NotifiService";
    private static final int NOTIFICATION_CONTENT_TYPE = 10;
    private static final int NOTIFICATION_TITLE_TYPE = 9;
    private AccessibilityEvent mAccessibilityEvent = null;
    private Notification mNotification = null;

    public NotificationService() {
        Logger.e((String)"NotifiService(), NotifiService created!", (Object[])new Object[0]);
    }

    private NotificationMessageBody createNotificationBody() {
        Object object;
        Object object2;
        Object object3 = Util.getAppInfo((Context)this.getBaseContext(), (CharSequence)this.mAccessibilityEvent.getPackageName());
        String string = Util.getAppName((Context)this.getBaseContext(), (ApplicationInfo)object3);
        Bitmap bitmap = Util.getMessageIcon((Context)this.getBaseContext(), (ApplicationInfo)object3);
        int n = System.currentTimeMillis() - this.mNotification.when > 3600000L ? Util.getUtcTime((long)System.currentTimeMillis()) : Util.getUtcTime((long)this.mNotification.when);
        object3 = AppList.getInstance().getAppList();
        if (!object3.containsValue(this.mAccessibilityEvent.getPackageName())) {
            int n2 = Integer.parseInt(object3.get("MaxApp").toString());
            object3.remove("MaxApp");
            object3.put("MaxApp", ++n2);
            object3.put(n2, this.mAccessibilityEvent.getPackageName());
            AppList.getInstance().saveAppList((Map)object3);
        }
        Object object4 = this.getNotificationText();
        String string2 = "";
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
        object4 = string2;
        if (this.mNotification.tickerText != null) {
            object4 = this.mNotification.tickerText.toString();
        }
        object2 = object4;
        if (((String)object4).length() > 128) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(((String)object4).substring(0, 128));
            ((StringBuilder)object2).append("...");
            object2 = ((StringBuilder)object2).toString();
        }
        object4 = object2;
        if (((String)object2).length() > 0) {
            object4 = "[".concat((String)object2).concat("]");
        }
        AppList.getInstance().getAppList();
        string2 = Util.getKeyFromValue((CharSequence)this.mAccessibilityEvent.getPackageName());
        object2 = new NotificationMessageBody();
        object2.setSender(string);
        object2.setAppID(string2);
        object2.setTitle((String)object);
        object2.setContent((String)object3);
        object2.setTickerText((String)object4);
        object2.setTimestamp(n);
        object2.setIcon(bitmap);
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("createNotificationBody(), body=");
        ((StringBuilder)object3).append(object2.toString().substring(0, 20));
        Logger.e((String)((StringBuilder)object3).toString(), (Object[])new Object[0]);
        return object2;
    }

    private MessageHeader createNotificationHeader() {
        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setCategory("notification");
        messageHeader.setSubType("text");
        messageHeader.setMsgId(Util.genMessageId());
        messageHeader.setAction("add");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("createNotificationHeader(), header=");
        stringBuilder.append(messageHeader);
        Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
        return messageHeader;
    }

    /*
     * WARNING - combined exceptions agressively - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    private String[] getNotificationText() {
        RemoteViews remoteViews = this.mNotification.contentView;
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

    private void sendNotifiMessage() {
        Logger.e((String)"sendNotifiMessage()", (Object[])new Object[0]);
        MessageObj messageObj = new MessageObj();
        messageObj.setDataHeader(this.createNotificationHeader());
        messageObj.setDataBody((MessageBody)this.createNotificationBody());
        String string = messageObj.getDataBody().getContent();
        String string2 = ((NotificationMessageBody)messageObj.getDataBody()).getTitle();
        String string3 = ((NotificationMessageBody)messageObj.getDataBody()).getTickerText();
        if (string.length() == 0 && string2.length() == 0 && string3.length() == 0) {
            return;
        }
        string = MainService.getInstance();
        if (string == null) return;
        string.sendNotiMessage(messageObj);
    }

    private void setAccessibilityServiceInfo() {
        Logger.e((String)"setAccessibilityServiceInfo()", (Object[])new Object[0]);
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        accessibilityServiceInfo.eventTypes = 64;
        accessibilityServiceInfo.feedbackType = 16;
        accessibilityServiceInfo.notificationTimeout = 0L;
        this.setServiceInfo(accessibilityServiceInfo);
    }

    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Serializable serializable = new StringBuilder();
        ((StringBuilder)serializable).append("onAccessibilityEvent(), eventType=");
        ((StringBuilder)serializable).append(accessibilityEvent.getEventType());
        Logger.e((String)((StringBuilder)serializable).toString(), (Object[])new Object[0]);
        if (accessibilityEvent.getEventType() != 64) {
            return;
        }
        Logger.e((String)"getEventType == TYPE_NOTIFICATION_STATE_CHANGED", (Object[])new Object[0]);
        this.mAccessibilityEvent = accessibilityEvent;
        serializable = (Notification)accessibilityEvent.getParcelableData();
        this.mNotification = serializable;
        if (serializable == null) {
            return;
        }
        boolean bl = PreferenceData.isNotificationServiceEnable();
        boolean bl2 = PreferenceData.isNeedPush();
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("needForward == ");
        ((StringBuilder)serializable).append(bl2);
        Logger.e((String)((StringBuilder)serializable).toString(), (Object[])new Object[0]);
        if (!bl) return;
        if (!bl2) return;
        HashSet hashSet = BlockList.getInstance().getBlockList();
        HashSet hashSet2 = IgnoreList.getInstance().getIgnoreList();
        serializable = IgnoreList.getInstance().getExclusionList();
        if (!(hashSet.contains(accessibilityEvent.getPackageName()) || hashSet2.contains(accessibilityEvent.getPackageName()) || ((HashSet)serializable).contains(accessibilityEvent.getPackageName()))) {
            this.sendNotifiMessage();
        } else {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("Notice: This notification received!, package name=");
            ((StringBuilder)serializable).append((Object)this.mAccessibilityEvent.getPackageName());
            Logger.e((String)((StringBuilder)serializable).toString(), (Object[])new Object[0]);
            if (!accessibilityEvent.getPackageName().equals("com.android.mms")) return;
            bl2 = PreferenceData.isSmsServiceEnable();
            bl = PreferenceData.isNeedPush();
            if (!bl2) return;
            if (!bl) return;
            this.sendNotifiMessage();
        }
    }

    public void onInterrupt() {
        Logger.e((String)"onInterrupt()", (Object[])new Object[0]);
    }

    public void onServiceConnected() {
        Logger.e((String)"onServiceConnected()", (Object[])new Object[0]);
        if (Build.VERSION.SDK_INT >= 14) return;
        this.setAccessibilityServiceInfo();
    }

    public boolean onUnbind(Intent intent) {
        Logger.e((String)"onUnbind()", (Object[])new Object[0]);
        return false;
    }
}
