/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.Uri
 *  android.provider.CallLog$Calls
 *  android.telephony.PhoneStateListener
 *  com.lianhezhuli.btnotification.mtk.data.CallMessageBody
 *  com.lianhezhuli.btnotification.mtk.data.MessageBody
 *  com.lianhezhuli.btnotification.mtk.data.MessageHeader
 *  com.lianhezhuli.btnotification.mtk.data.MessageObj
 *  com.lianhezhuli.btnotification.mtk.data.PreferenceData
 *  com.lianhezhuli.btnotification.mtk.data.Util
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.mtk.service;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.CallLog;
import android.telephony.PhoneStateListener;
import com.lianhezhuli.btnotification.mtk.data.CallMessageBody;
import com.lianhezhuli.btnotification.mtk.data.MessageBody;
import com.lianhezhuli.btnotification.mtk.data.MessageHeader;
import com.lianhezhuli.btnotification.mtk.data.MessageObj;
import com.lianhezhuli.btnotification.mtk.data.PreferenceData;
import com.lianhezhuli.btnotification.mtk.data.Util;
import com.lianhezhuli.btnotification.mtk.service.MainService;
import com.orhanobut.logger.Logger;

public class CallService
extends PhoneStateListener {
    private static final String LOG_TAG = "CallService";
    private Context mContext = null;
    private String mIncomingNumber = null;
    private int mLastState = 0;

    public CallService(Context context) {
        Logger.e((String)"CallService(), CallService created!", (Object[])new Object[0]);
        this.mContext = context;
    }

    private CallMessageBody createCallBody() {
        String string = this.mIncomingNumber;
        CharSequence charSequence = Util.getContactName((Context)this.mContext, (String)string);
        String string2 = this.getMessageContent((String)charSequence);
        int n = Util.getUtcTime((long)System.currentTimeMillis());
        int n2 = this.getMissedCallCount();
        CallMessageBody callMessageBody = new CallMessageBody();
        callMessageBody.setSender((String)charSequence);
        callMessageBody.setNumber(string);
        callMessageBody.setContent(string2);
        callMessageBody.setMissedCallCount(n2);
        callMessageBody.setTimestamp(n);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("createCallBody(), body=");
        ((StringBuilder)charSequence).append(callMessageBody);
        Logger.i((String)((StringBuilder)charSequence).toString(), (Object[])new Object[0]);
        return callMessageBody;
    }

    private MessageHeader createCallHeader() {
        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setCategory("call");
        messageHeader.setSubType("missed_call");
        messageHeader.setMsgId(Util.genMessageId());
        messageHeader.setAction("add");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("createCallHeader(), header=");
        stringBuilder.append(messageHeader);
        Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
        return messageHeader;
    }

    private String getMessageContent(String charSequence) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mContext.getText(2131755100));
        stringBuilder.append(": ");
        stringBuilder.append((String)charSequence);
        stringBuilder.append("\r\n");
        stringBuilder.append("Missed Call Count:");
        stringBuilder.append(this.getMissedCallCount());
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("getMessageContent(), content=");
        ((StringBuilder)charSequence).append((Object)stringBuilder);
        Logger.i((String)((StringBuilder)charSequence).toString(), (Object[])new Object[0]);
        return stringBuilder.toString();
    }

    private int getMissedCallCount() {
        int n;
        CharSequence charSequence = new StringBuilder("type = ");
        charSequence.append(3);
        charSequence.append(" AND new = 1");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getMissedCallCount(), query string=");
        stringBuilder.append((Object)charSequence);
        Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
        ContentResolver contentResolver = this.mContext.getContentResolver();
        stringBuilder = CallLog.Calls.CONTENT_URI;
        charSequence = charSequence.toString();
        stringBuilder = contentResolver.query((Uri)stringBuilder, new String[]{"_id"}, (String)charSequence, null, "date DESC");
        if (stringBuilder != null) {
            n = stringBuilder.getCount() + 1;
            stringBuilder.close();
        } else {
            n = 0;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("getMissedCallCount(), missed call count=");
        stringBuilder.append(n);
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        return n;
    }

    private void sendCallMessage() {
        MessageObj messageObj = new MessageObj();
        messageObj.setDataHeader(this.createCallHeader());
        messageObj.setDataBody((MessageBody)this.createCallBody());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sendCallMessage(), callMessageData= ");
        stringBuilder.append(messageObj);
        Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
        stringBuilder = MainService.getInstance();
        if (stringBuilder == null) return;
        stringBuilder.sendCallMessage(messageObj);
    }

    public void onCallStateChanged(int n, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onCallStateChanged(), incomingNumber");
        stringBuilder.append(string);
        Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
        if (this.mLastState == 1 && n == 0) {
            this.mIncomingNumber = string;
            boolean bl = PreferenceData.isCallServiceEnable();
            boolean bl2 = PreferenceData.isNeedPush();
            if (bl && bl2) {
                this.sendCallMessage();
            }
        }
        this.mLastState = n;
    }
}
