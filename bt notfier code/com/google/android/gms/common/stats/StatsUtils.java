/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.PowerManager$WakeLock
 *  android.os.Process
 *  android.text.TextUtils
 */
package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;

@Deprecated
public class StatsUtils {
    public static String getEventKey(Context context, Intent intent) {
        long l = System.identityHashCode(context);
        return String.valueOf((long)System.identityHashCode(intent) | l << 32);
    }

    public static String getEventKey(PowerManager.WakeLock object, String string) {
        object = String.valueOf(String.valueOf((long)Process.myPid() << 32 | (long)System.identityHashCode(object)));
        if (TextUtils.isEmpty((CharSequence)string)) {
            string = "";
        }
        string = String.valueOf(string);
        object = string.length() != 0 ? ((String)object).concat(string) : new String((String)object);
        return object;
    }
}
