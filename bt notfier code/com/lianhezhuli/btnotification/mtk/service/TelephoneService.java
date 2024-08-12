/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.telephony.TelephonyManager
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.mtk.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.lianhezhuli.btnotification.mtk.service.MainService;
import com.orhanobut.logger.Logger;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class TelephoneService
extends BroadcastReceiver {
    private WeakReference<Context> mApp;
    private MainService service;
    private TelephonyManager tm;

    public void onReceive(Context object, Intent intent) {
        this.mApp = object = new WeakReference<Context>((Context)object);
        this.tm = (TelephonyManager)((Context)((Reference)object).get()).getSystemService("phone");
        this.service = MainService.getInstance();
        if (this.tm.getCallState() != 0) return;
        object = this.service;
        if (object != null && object.getFlag()) {
            this.service.setAudiodial();
            this.service.setFlag(false);
        } else {
            Logger.e((String)"TelephoneService \u5f00\u673a\u4e0d\u5f02\u5e38", (Object[])new Object[0]);
        }
    }
}
