/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  com.lianhezhuli.btnotification.mtk.service.ReStartNotificationReceiver
 *  com.lianhezhuli.btnotification.utils.NotificationMsgUtil
 */
package com.lianhezhuli.btnotification.mtk.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import com.lianhezhuli.btnotification.mtk.service.ReStartNotificationReceiver;
import com.lianhezhuli.btnotification.utils.NotificationMsgUtil;

public final class PushAiderHelper {
    private static PushAiderHelper aiderHelper = new PushAiderHelper();
    private ReStartNotificationReceiver npLiveReceiver = new ReStartNotificationReceiver();

    private PushAiderHelper() {
    }

    public static PushAiderHelper getAiderHelper() {
        return aiderHelper;
    }

    public void goToSettingAccessibility(Context context) {
        NotificationMsgUtil.goToSettingAccessibility((Context)context);
    }

    public void goToSettingNotificationAccess(Context context) {
        NotificationMsgUtil.goToSettingNotificationAccess((Context)context);
    }

    public boolean isNotifyEnable(Context context) {
        return NotificationMsgUtil.isEnabled((Context)context);
    }

    public void start(Context context) {
        try {
            context.registerReceiver((BroadcastReceiver)this.npLiveReceiver, ReStartNotificationReceiver.createIntentFilter());
            NotificationMsgUtil.reBindService((Context)context);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void stop(Context context) {
        try {
            context.unregisterReceiver((BroadcastReceiver)this.npLiveReceiver);
            NotificationMsgUtil.closeService((Context)context);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
