/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.util.Log
 *  com.google.android.gms.common.GooglePlayServicesUtilLight
 */
package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

public final class zzb {
    private SharedPreferences zzs;

    public zzb(Context object) {
        try {
            object = GooglePlayServicesUtilLight.getRemoteContext((Context)object);
            object = object == null ? null : object.getSharedPreferences("google_ads_flags", 0);
            this.zzs = object;
            return;
        }
        catch (Throwable throwable) {
            Log.w((String)"GmscoreFlag", (String)"Error while getting SharedPreferences ", (Throwable)throwable);
            this.zzs = null;
            return;
        }
    }

    public final boolean getBoolean(String string, boolean bl) {
        try {
            if (this.zzs == null) {
                return false;
            }
            bl = this.zzs.getBoolean(string, false);
            return bl;
        }
        catch (Throwable throwable) {
            Log.w((String)"GmscoreFlag", (String)"Error while reading from SharedPreferences ", (Throwable)throwable);
            return false;
        }
    }

    final float getFloat(String string, float f) {
        try {
            if (this.zzs == null) {
                return 0.0f;
            }
            f = this.zzs.getFloat(string, 0.0f);
            return f;
        }
        catch (Throwable throwable) {
            Log.w((String)"GmscoreFlag", (String)"Error while reading from SharedPreferences ", (Throwable)throwable);
            return 0.0f;
        }
    }

    final String getString(String string, String string2) {
        try {
            if (this.zzs == null) {
                return string2;
            }
            string = this.zzs.getString(string, string2);
            return string;
        }
        catch (Throwable throwable) {
            Log.w((String)"GmscoreFlag", (String)"Error while reading from SharedPreferences ", (Throwable)throwable);
            return string2;
        }
    }
}
