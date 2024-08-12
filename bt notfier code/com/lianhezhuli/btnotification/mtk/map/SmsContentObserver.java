/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.ContentObserver
 *  android.os.Handler
 *  android.util.Log
 *  com.lianhezhuli.btnotification.MApplication
 *  com.lianhezhuli.btnotification.mtk.map.SmsContentObserver$DatabaseMonitor
 *  com.lianhezhuli.btnotification.mtk.map.SmsController
 */
package com.lianhezhuli.btnotification.mtk.map;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;
import com.lianhezhuli.btnotification.MApplication;
import com.lianhezhuli.btnotification.mtk.map.SmsContentObserver;
import com.lianhezhuli.btnotification.mtk.map.SmsController;
import java.util.HashMap;

public class SmsContentObserver
extends ContentObserver {
    private static final String TAG = "MessageObserver";
    private static final Context sContext = MApplication.getInstance().getApplicationContext();
    private final String HEADER;
    private SmsController mSmsController = null;
    private HashMap<Long, Integer> previousMessage;

    public SmsContentObserver(SmsController smsController) {
        super(new Handler());
        this.HEADER = "telecom/msg/";
        this.mSmsController = smsController;
        this.previousMessage = new HashMap();
        new DatabaseMonitor(this, 0).start();
    }

    static /* synthetic */ HashMap access$000(SmsContentObserver smsContentObserver) {
        return smsContentObserver.previousMessage;
    }

    static /* synthetic */ HashMap access$002(SmsContentObserver smsContentObserver, HashMap hashMap) {
        smsContentObserver.previousMessage = hashMap;
        return hashMap;
    }

    static /* synthetic */ SmsController access$100(SmsContentObserver smsContentObserver) {
        return smsContentObserver.mSmsController;
    }

    static /* synthetic */ Context access$200() {
        return sContext;
    }

    public void onChange(boolean bl) {
        super.onChange(bl);
        Log.i((String)TAG, (String)"DataBase State Changed");
        new DatabaseMonitor(this, 1).start();
    }
}
