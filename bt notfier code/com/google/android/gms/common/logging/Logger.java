/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.common.internal.GmsLogger
 */
package com.google.android.gms.common.logging;

import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

public class Logger {
    private final String zza;
    private final String zzb;
    private final GmsLogger zzc;
    private final int zzd;

    public Logger(String string, String ... object) {
        int n;
        int n2 = ((String[])object).length;
        if (n2 == 0) {
            object = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('[');
            for (n = 0; n < n2; ++n) {
                String string2 = object[n];
                if (stringBuilder.length() > 1) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(string2);
            }
            stringBuilder.append("] ");
            object = stringBuilder.toString();
        }
        this.zzb = object;
        this.zza = string;
        this.zzc = new GmsLogger(string);
        for (n = 2; n <= 7 && !Log.isLoggable((String)this.zza, (int)n); ++n) {
        }
        this.zzd = n;
    }

    public void d(String string, Throwable throwable, Object ... objectArray) {
        if (!this.isLoggable(3)) return;
        Log.d((String)this.zza, (String)this.format(string, objectArray), (Throwable)throwable);
    }

    public void d(String string, Object ... objectArray) {
        if (!this.isLoggable(3)) return;
        Log.d((String)this.zza, (String)this.format(string, objectArray));
    }

    public void e(String string, Throwable throwable, Object ... objectArray) {
        Log.e((String)this.zza, (String)this.format(string, objectArray), (Throwable)throwable);
    }

    public void e(String string, Object ... objectArray) {
        Log.e((String)this.zza, (String)this.format(string, objectArray));
    }

    protected String format(String string, Object ... objectArray) {
        String string2 = string;
        if (objectArray == null) return this.zzb.concat(string2);
        string2 = string;
        if (objectArray.length <= 0) return this.zzb.concat(string2);
        string2 = String.format(Locale.US, string, objectArray);
        return this.zzb.concat(string2);
    }

    public String getTag() {
        return this.zza;
    }

    public void i(String string, Object ... objectArray) {
        Log.i((String)this.zza, (String)this.format(string, objectArray));
    }

    public boolean isLoggable(int n) {
        if (this.zzd > n) return false;
        return true;
    }

    public void v(String string, Throwable throwable, Object ... objectArray) {
        if (!this.isLoggable(2)) return;
        Log.v((String)this.zza, (String)this.format(string, objectArray), (Throwable)throwable);
    }

    public void v(String string, Object ... objectArray) {
        if (!this.isLoggable(2)) return;
        Log.v((String)this.zza, (String)this.format(string, objectArray));
    }

    public void w(String string, Object ... objectArray) {
        Log.w((String)this.zza, (String)this.format(string, objectArray));
    }

    public void wtf(String string, Throwable throwable, Object ... objectArray) {
        Log.wtf((String)this.zza, (String)this.format(string, objectArray), (Throwable)throwable);
    }

    public void wtf(Throwable throwable) {
        Log.wtf((String)this.zza, (Throwable)throwable);
    }
}
