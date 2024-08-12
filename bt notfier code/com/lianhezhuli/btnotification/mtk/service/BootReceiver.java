/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  com.lianhezhuli.btnotification.mtk.data.PreferenceData
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 */
package com.lianhezhuli.btnotification.mtk.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.lianhezhuli.btnotification.mtk.data.PreferenceData;
import com.lianhezhuli.btnotification.mtk.service.MainService;

public class BootReceiver
extends BroadcastReceiver {
    private static final String LOG_TAG = "BootReceiver";

    public void onReceive(Context context, Intent intent) {
        boolean bl = PreferenceData.isNotificationServiceEnable() || PreferenceData.isSmsServiceEnable();
        if (!bl) return;
        context.startService(new Intent(context, MainService.class));
    }
}
