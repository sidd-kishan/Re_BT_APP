/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningServiceInfo
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  androidx.core.app.NotificationManagerCompat
 *  com.lianhezhuli.btnotification.mtk.service.NPNotificationService
 */
package com.lianhezhuli.btnotification.utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationManagerCompat;
import com.lianhezhuli.btnotification.mtk.service.NPNotificationService;

public class NotificationMsgUtil {
    private static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";

    public static void closeService(Context context) {
        ComponentName componentName = new ComponentName(context, NPNotificationService.class);
        context.getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
    }

    public static void goToSettingAccessibility(Context context) {
        try {
            Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
            intent.addFlags(0x10000000);
            context.startActivity(intent);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void goToSettingNotificationAccess(Context context) {
        try {
            Intent intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
            intent.addFlags(0x10000000);
            context.startActivity(intent);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static boolean isEnabled(Context context) {
        return NotificationManagerCompat.getEnabledListenerPackages((Context)context).contains(context.getPackageName());
    }

    public static boolean isServiceExisted(Context object, Class object2) {
        object2 = ((Class)object2).getName();
        if ((object = ((ActivityManager)object.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)).size() <= 0) {
            return false;
        }
        int n = 0;
        while (n < object.size()) {
            if (((ActivityManager.RunningServiceInfo)object.get((int)n)).service.getClassName().equals(object2)) {
                return true;
            }
            ++n;
        }
        return false;
    }

    public static void reBindService(Context context) {
        ComponentName componentName = new ComponentName(context, NPNotificationService.class);
        context = context.getPackageManager();
        context.setComponentEnabledSetting(componentName, 2, 1);
        context.setComponentEnabledSetting(componentName, 1, 1);
    }
}
