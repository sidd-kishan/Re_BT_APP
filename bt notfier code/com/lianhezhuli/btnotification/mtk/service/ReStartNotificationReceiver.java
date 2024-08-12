/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  com.lianhezhuli.btnotification.mtk.service.NPNotificationService
 *  com.lianhezhuli.btnotification.mtk.service.PushAiderHelper
 *  com.lianhezhuli.btnotification.utils.NotificationMsgUtil
 */
package com.lianhezhuli.btnotification.mtk.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.lianhezhuli.btnotification.mtk.service.NPNotificationService;
import com.lianhezhuli.btnotification.mtk.service.PushAiderHelper;
import com.lianhezhuli.btnotification.utils.NotificationMsgUtil;

class ReStartNotificationReceiver
extends BroadcastReceiver {
    ReStartNotificationReceiver() {
    }

    public static IntentFilter createIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_TICK");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        return intentFilter;
    }

    public void onReceive(Context context, Intent intent) {
        if (NotificationMsgUtil.isServiceExisted((Context)context, NPNotificationService.class)) return;
        PushAiderHelper.getAiderHelper().start(context);
    }
}
