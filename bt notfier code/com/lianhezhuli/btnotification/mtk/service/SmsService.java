/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.database.Cursor
 *  android.net.Uri
 *  com.lianhezhuli.btnotification.mtk.data.MessageBody
 *  com.lianhezhuli.btnotification.mtk.data.MessageHeader
 *  com.lianhezhuli.btnotification.mtk.data.MessageObj
 *  com.lianhezhuli.btnotification.mtk.data.PreferenceData
 *  com.lianhezhuli.btnotification.mtk.data.SmsMessageBody
 *  com.lianhezhuli.btnotification.mtk.data.Util
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.mtk.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.lianhezhuli.btnotification.mtk.data.MessageBody;
import com.lianhezhuli.btnotification.mtk.data.MessageHeader;
import com.lianhezhuli.btnotification.mtk.data.MessageObj;
import com.lianhezhuli.btnotification.mtk.data.PreferenceData;
import com.lianhezhuli.btnotification.mtk.data.SmsMessageBody;
import com.lianhezhuli.btnotification.mtk.data.Util;
import com.lianhezhuli.btnotification.mtk.service.MainService;
import com.orhanobut.logger.Logger;

public class SmsService
extends BroadcastReceiver {
    private static final String LOG_TAG = "SmsService";
    public static final String SMS_ACTION = "SenderSMSFromeFP";
    private static final String SMS_RECEIVED = "com.lianhezhuli.btnotification.SMS_RECEIVED";
    public static boolean canReceiveSms;
    private static String preID;
    private Context mContext = null;

    public SmsService() {
        Logger.e((String)"SmsReceiver(), SmsReceiver created!", (Object[])new Object[0]);
    }

    private SmsMessageBody createSmsBody(String charSequence, String string) {
        String string2 = Util.getContactName((Context)this.mContext, (String)charSequence);
        int n = Util.getUtcTime((long)System.currentTimeMillis());
        SmsMessageBody smsMessageBody = new SmsMessageBody();
        smsMessageBody.setSender(string2);
        smsMessageBody.setNumber((String)charSequence);
        smsMessageBody.setContent(string);
        smsMessageBody.setTimestamp(n);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("createSmsBody(), body=");
        ((StringBuilder)charSequence).append(smsMessageBody);
        Logger.e((String)((StringBuilder)charSequence).toString(), (Object[])new Object[0]);
        return smsMessageBody;
    }

    private MessageHeader createSmsHeader() {
        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setCategory("notification");
        messageHeader.setSubType("sms");
        messageHeader.setMsgId(Util.genMessageId());
        messageHeader.setAction("add");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("createSmsHeader(), header=");
        stringBuilder.append(messageHeader);
        Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
        return messageHeader;
    }

    private void sendSmsMessage(String charSequence, String string) {
        MessageObj messageObj = new MessageObj();
        messageObj.setDataHeader(this.createSmsHeader());
        messageObj.setDataBody((MessageBody)this.createSmsBody(string, (String)charSequence));
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("sendSmsMessage(), smsMessageData=");
        ((StringBuilder)charSequence).append(messageObj);
        Logger.e((String)((StringBuilder)charSequence).toString(), (Object[])new Object[0]);
        charSequence = MainService.getInstance();
        if (charSequence == null) return;
        charSequence.sendSmsMessage(messageObj);
    }

    public void onReceive(Context context, Intent intent) {
        canReceiveSms = true;
        Logger.e((String)"onReceive()", (Object[])new Object[0]);
        boolean bl = PreferenceData.isSmsServiceEnable();
        boolean bl2 = PreferenceData.isNeedPush();
        if (!bl) return;
        if (!bl2) return;
        this.mContext = context;
        if (!intent.getAction().equals(SMS_RECEIVED)) return;
        this.sendSms();
    }

    void sendSms() {
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            Cursor cursor3;
            block5: {
                cursor3 = this.mContext.getContentResolver().query(Uri.parse((String)"content://sms/inbox"), null, null, null, "_id desc");
                if (cursor3 != null) {
                    String string;
                    String string2;
                    do {
                        cursor2 = cursor3;
                        cursor = cursor3;
                        if (!cursor3.moveToNext()) break block5;
                        cursor2 = cursor3;
                        cursor = cursor3;
                        string2 = cursor3.getString(cursor3.getColumnIndex("body"));
                        cursor2 = cursor3;
                        cursor = cursor3;
                        string = cursor3.getString(cursor3.getColumnIndex("address"));
                        cursor2 = cursor3;
                        cursor = cursor3;
                        String string3 = cursor3.getString(cursor3.getColumnIndex("_id"));
                        cursor2 = cursor3;
                        cursor = cursor3;
                        if (string3.equals(preID)) break block5;
                        cursor2 = cursor3;
                        cursor = cursor3;
                        preID = string3;
                    } while (string2 == null || string == null);
                    cursor2 = cursor3;
                    cursor = cursor3;
                    this.sendSmsMessage(string2, string);
                }
            }
            if (cursor3 == null) return;
            cursor = cursor3;
        }
        catch (Throwable throwable) {
            if (cursor2 == null) throw throwable;
            cursor2.close();
            throw throwable;
        }
        catch (Exception exception) {
            if (cursor == null) return;
        }
        cursor.close();
    }
}
