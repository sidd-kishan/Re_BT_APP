/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.graphics.Bitmap
 *  com.lianhezhuli.btnotification.mtk.data.AppList
 *  com.lianhezhuli.btnotification.mtk.data.BlockList
 *  com.lianhezhuli.btnotification.mtk.data.MessageBody
 *  com.lianhezhuli.btnotification.mtk.data.MessageHeader
 *  com.lianhezhuli.btnotification.mtk.data.MessageObj
 *  com.lianhezhuli.btnotification.mtk.data.NotificationMessageBody
 *  com.lianhezhuli.btnotification.mtk.data.Util
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.mtk.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import com.lianhezhuli.btnotification.mtk.data.AppList;
import com.lianhezhuli.btnotification.mtk.data.BlockList;
import com.lianhezhuli.btnotification.mtk.data.MessageBody;
import com.lianhezhuli.btnotification.mtk.data.MessageHeader;
import com.lianhezhuli.btnotification.mtk.data.MessageObj;
import com.lianhezhuli.btnotification.mtk.data.NotificationMessageBody;
import com.lianhezhuli.btnotification.mtk.data.Util;
import com.lianhezhuli.btnotification.mtk.service.MainService;
import com.orhanobut.logger.Logger;
import java.util.HashSet;

public class SystemNotificationService
extends BroadcastReceiver {
    private static final String LOG_TAG = "SystemNotificationService";
    private static float mBettryCapacity;
    private static float mLastBettryCapacity;
    private Context mContext = null;

    public SystemNotificationService() {
        Logger.i((String)"SystemNotificationService(), SystemNotificationService created!", (Object[])new Object[0]);
    }

    private NotificationMessageBody createNotificationBody(String charSequence, String string) {
        ApplicationInfo applicationInfo = this.mContext.getApplicationInfo();
        String string2 = Util.getAppName((Context)this.mContext, (ApplicationInfo)applicationInfo);
        Bitmap bitmap = Util.getMessageIcon((Context)this.mContext, (ApplicationInfo)applicationInfo);
        int n = Util.getUtcTime((long)System.currentTimeMillis());
        applicationInfo = new NotificationMessageBody();
        if (charSequence == this.mContext.getResources().getString(2131755042)) {
            applicationInfo.setAppID(Util.getKeyFromValue((CharSequence)AppList.BETTRYLOW_APPID));
        } else if (charSequence == this.mContext.getResources().getString(2131755218)) {
            applicationInfo.setAppID(Util.getKeyFromValue((CharSequence)AppList.SMSRESULT_APPID));
        }
        applicationInfo.setSender(string2);
        applicationInfo.setTitle((String)charSequence);
        applicationInfo.setContent(string);
        applicationInfo.setTickerText("");
        applicationInfo.setTimestamp(n);
        applicationInfo.setIcon(bitmap);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("createLowBatteryBody(), body=");
        ((StringBuilder)charSequence).append(applicationInfo.toString().substring(0, 20));
        Logger.i((String)((StringBuilder)charSequence).toString(), (Object[])new Object[0]);
        return applicationInfo;
    }

    private MessageHeader createNotificationHeader() {
        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setCategory("notification");
        messageHeader.setSubType("text");
        messageHeader.setMsgId(Util.genMessageId());
        messageHeader.setAction("add");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("createSmsHeader(), header=");
        stringBuilder.append(messageHeader);
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        return messageHeader;
    }

    private void sendLowBatteryMessage(String string) {
        Logger.i((String)"sendLowBatteryMessage()", (Object[])new Object[0]);
        Object object = this.mContext.getResources().getString(2131755042);
        String string2 = this.mContext.getResources().getString(2131755197);
        CharSequence charSequence = new StringBuilder();
        charSequence.append(string2);
        charSequence.append(":");
        charSequence.append(string);
        charSequence.append("%");
        charSequence = charSequence.toString();
        string = new MessageObj();
        string.setDataHeader(this.createNotificationHeader());
        string.setDataBody((MessageBody)this.createNotificationBody((String)object, (String)charSequence));
        object = new StringBuilder();
        ((StringBuilder)object).append("sendSmsMessage(), smsMessageData=");
        ((StringBuilder)object).append((Object)string);
        Logger.i((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        object = BlockList.getInstance().getBlockList();
        charSequence = MainService.getInstance();
        if (charSequence == null) return;
        if (((HashSet)object).contains(AppList.BETTRYLOW_APPID)) return;
        charSequence.sendSystemNotiMessage((MessageObj)string);
    }

    private void sendSMSFailMessage() {
        String string = this.mContext.getResources().getString(2131755218);
        String string2 = this.mContext.getResources().getString(2131755219);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sendSMSFailMessage()");
        stringBuilder.append(string);
        stringBuilder.append(string2);
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        stringBuilder = new MessageObj();
        stringBuilder.setDataHeader(this.createNotificationHeader());
        stringBuilder.setDataBody((MessageBody)this.createNotificationBody(string, string2));
        string = MainService.getInstance();
        if (string == null) return;
        string.sendSystemNotiMessage((MessageObj)stringBuilder);
    }

    private void sendSMSSuccessMessage() {
        String string = this.mContext.getResources().getString(2131755218);
        String string2 = this.mContext.getResources().getString(2131755220);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sendSMSSuccessMessage()");
        stringBuilder.append(string);
        stringBuilder.append(string2);
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        stringBuilder = new MessageObj();
        stringBuilder.setDataHeader(this.createNotificationHeader());
        stringBuilder.setDataBody((MessageBody)this.createNotificationBody(string, string2));
        string = MainService.getInstance();
        if (string == null) return;
        string.sendSystemNotiMessage((MessageObj)stringBuilder);
    }

    public void onReceive(Context object, Intent intent) {
        this.mContext = object;
        object = intent.getAction();
        if ("android.intent.action.BATTERY_LOW".equalsIgnoreCase((String)object)) {
            float f = mLastBettryCapacity;
            if (f == 0.0f) {
                Logger.i((String)"mLastBettryCapacity = 0", (Object[])new Object[0]);
                this.sendLowBatteryMessage(String.valueOf(mBettryCapacity * 100.0f));
                mLastBettryCapacity = mBettryCapacity;
            } else {
                float f2 = mBettryCapacity;
                if (f == f2) return;
                this.sendLowBatteryMessage(String.valueOf((int)(f2 * 100.0f)));
                mLastBettryCapacity = mBettryCapacity;
            }
        } else if ("android.intent.action.BATTERY_CHANGED".equalsIgnoreCase((String)object)) {
            int n = intent.getIntExtra("level", -1);
            int n2 = intent.getIntExtra("scale", -1);
            mBettryCapacity = (float)n / (float)n2;
        } else if ("android.intent.action.ACTION_POWER_CONNECTED".equalsIgnoreCase((String)object)) {
            mLastBettryCapacity = 0.0f;
        } else {
            if (!"SenderSMSFromeFP".equals(object)) return;
            if (BlockList.getInstance().getBlockList().contains(AppList.SMSRESULT_APPID)) return;
            if (this.getResultCode() == -1) {
                this.sendSMSSuccessMessage();
            } else {
                this.sendSMSFailMessage();
            }
        }
    }
}
