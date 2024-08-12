/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.utils.StringUtils
 */
package com.lianhezhuli.btnotification;

import com.lianhezhuli.btnotification.utils.StringUtils;
import java.util.HashMap;
import java.util.Map;

public final class Constants {
    public static final String ADVERT_INTERSTITIAL_HIDE_TIME = "advert_interstitial_hide_time";
    public static final String ADVERT_INTERSTITIAL_NEXT_TIME = "advert_interstitial_next_time";
    public static final String ADVERT_LIMIT_INTERSTITIAL_FAST_CYCLE = "interstitial_fast_cycle";
    public static final String ADVERT_LIMIT_INTERSTITIAL_FAST_TIMES = "interstitial_fast_times";
    public static final String ADVERT_LIMIT_INTERSTITIAL_TOTAL_CYCLE = "interstitial_total_cycle";
    public static final String ADVERT_LIMIT_INTERSTITIAL_TOTAL_TIMES = "interstitial_total_times";
    public static final String ANONYMOUS_ACCOUNT = "anonymous_account";
    public static final String ANONYMOUS_AUTH_CODE = "anonymous_auth_code";
    public static final String ANONYMOUS_LAST_LOGIN_TIME = "anonymous_last_login_time";
    public static final String ANONYMOUS_LOGIN_EXPIRE_TIME = "anonymous_login_expire_time";
    public static final String ANONYMOUS_PASSWORD = "anonymous_password";
    public static final String ANONYMOUS_USER_ID = "anonymous_user_id";
    public static final int APP_ICON_HEIGHT = 40;
    public static final int APP_ICON_WIDTH = 40;
    public static final String CAN_AUTOMATIC = "can_automatic";
    public static final String DEVICE_ID = "device_id";
    public static final String DEVICE_MAC_ADD = "device_mac_add";
    public static final String DEVICE_NAME = "device_name";
    public static final String HAVE_HEART_RATE = "have_heart_rate";
    public static final String IS_DEVICE_NEW = "is_device_new";
    public static final int NOTIFYMINIHEADERLENTH = 8;
    public static final int NOTIFYSYNCLENTH = 4;
    public static final String NULL_TEXT_NAME = "(unknown)";
    public static final String PRIVACY_SHOW = "privacy_show";
    public static final String REMOTE_ALARM_DATA = "remote_alarm_data";
    public static final String SHAREDPREFERENCESFILENAME = "lianhezhuli_device_info";
    public static final String SIGN_KEY = "key=192006250b4c09247ec02edce69f6a2d";
    public static final String SYNCHRONIZATION_TIME = "synchronization_time";
    public static final int TEXT_MAX_LENGH = 256;
    public static final String TEXT_POSTFIX = "...";
    public static final int TICKER_TEXT_MAX_LENGH = 128;
    public static final int TITLE_TEXT_MAX_LENGH = 128;
    public static final String USER_ID = "user_id";
    public static final String USER_INFO = "user_info";

    public static Map<String, String> getPubQueryMap() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("appid", "ald930ea5d5a258f4f");
        hashMap.put("nonce", StringUtils.getRandomNum());
        return hashMap;
    }
}
