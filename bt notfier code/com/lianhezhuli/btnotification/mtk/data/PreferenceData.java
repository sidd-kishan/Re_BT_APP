/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.preference.PreferenceManager
 *  com.lianhezhuli.btnotification.MApplication
 *  com.lianhezhuli.btnotification.mtk.data.Util
 */
package com.lianhezhuli.btnotification.mtk.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.lianhezhuli.btnotification.MApplication;
import com.lianhezhuli.btnotification.mtk.data.Util;

public final class PreferenceData {
    private static final String LOG_TAG = "PreferenceData";
    public static final String PREFERENCE_HOT_APP = "select_app";
    public static final String PREFERENCE_HOT_KEY = "enable_hot_service_preference";
    public static final String PREFERENCE_KEY_ACCESSIBILITY = "show_accessibility_menu_preference";
    public static final String PREFERENCE_KEY_ALWAYS_FORWARD = "always_forward_preference";
    public static final String PREFERENCE_KEY_APP_INFO = "app_info";
    public static final String PREFERENCE_KEY_CALL = "enable_call_service_preference";
    public static final String PREFERENCE_KEY_CURRENT_VERSION = "current_version_preference";
    public static final String PREFERENCE_KEY_NOTIFI = "enable_notifi_service_preference";
    public static final String PREFERENCE_KEY_SELECT_BLOCKS = "select_blocks_preference";
    public static final String PREFERENCE_KEY_SELECT_NOTIFICATIONS = "select_notifi_preference";
    public static final String PREFERENCE_KEY_SHOW_CONNECTION_STATUS = "show_connection_status_preference";
    public static final String PREFERENCE_KEY_SMS = "enable_sms_service_preference";
    private static final Context sContext;
    public static final SharedPreferences sSharedPreferences;

    static {
        Context context;
        sContext = context = MApplication.getInstance().getApplicationContext();
        sSharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)context);
    }

    public static boolean isAlwaysForward() {
        return sSharedPreferences.getBoolean(PREFERENCE_KEY_ALWAYS_FORWARD, true);
    }

    public static boolean isCallServiceEnable() {
        return sSharedPreferences.getBoolean(PREFERENCE_KEY_CALL, true);
    }

    public static boolean isNeedPush() {
        boolean bl = PreferenceData.isAlwaysForward() || Util.isScreenLocked((Context)sContext);
        return bl;
    }

    public static boolean isNotificationServiceEnable() {
        return sSharedPreferences.getBoolean(PREFERENCE_KEY_NOTIFI, true);
    }

    public static boolean isShowConnectionStatus() {
        return sSharedPreferences.getBoolean(PREFERENCE_KEY_SHOW_CONNECTION_STATUS, true);
    }

    public static boolean isSmsServiceEnable() {
        return sSharedPreferences.getBoolean(PREFERENCE_KEY_SMS, true);
    }

    public static void setAlwaysForward(boolean bl) {
        sSharedPreferences.edit().putBoolean(PREFERENCE_KEY_ALWAYS_FORWARD, bl).commit();
    }

    public static void setCallServiceEnable(boolean bl) {
        sSharedPreferences.edit().putBoolean(PREFERENCE_KEY_CALL, bl).commit();
    }

    public static void setNotificationServiceEnable(boolean bl) {
        sSharedPreferences.edit().putBoolean(PREFERENCE_KEY_NOTIFI, bl).commit();
    }

    public static void setSmsServiceEnable(boolean bl) {
        sSharedPreferences.edit().putBoolean(PREFERENCE_KEY_SMS, bl).commit();
    }
}
