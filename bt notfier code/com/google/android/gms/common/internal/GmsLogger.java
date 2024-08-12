/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.internal;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;

public final class GmsLogger {
    private final String zza;
    private final String zzb;

    public GmsLogger(String string) {
        this(string, null);
    }

    public GmsLogger(String string, String string2) {
        Preconditions.checkNotNull((Object)string, (Object)"log tag cannot be null");
        boolean bl = string.length() <= 23;
        Preconditions.checkArgument((boolean)bl, (String)"tag \"%s\" is longer than the %d character maximum", (Object[])new Object[]{string, 23});
        this.zza = string;
        if (string2 != null && string2.length() > 0) {
            this.zzb = string2;
            return;
        }
        this.zzb = null;
    }

    private final String zza(String string) {
        String string2 = this.zzb;
        if (string2 != null) return string2.concat(string);
        return string;
    }

    private final String zzb(String string, Object ... object) {
        string = String.format(string, (Object[])object);
        object = this.zzb;
        if (object != null) return ((String)object).concat(string);
        return string;
    }

    public boolean canLog(int n) {
        return Log.isLoggable((String)this.zza, (int)n);
    }

    public boolean canLogPii() {
        return false;
    }

    public void d(String string, String string2) {
        if (!this.canLog(3)) return;
        Log.d((String)string, (String)this.zza(string2));
    }

    public void d(String string, String string2, Throwable throwable) {
        if (!this.canLog(3)) return;
        Log.d((String)string, (String)this.zza(string2), (Throwable)throwable);
    }

    public void e(String string, String string2) {
        if (!this.canLog(6)) return;
        Log.e((String)string, (String)this.zza(string2));
    }

    public void e(String string, String string2, Throwable throwable) {
        if (!this.canLog(6)) return;
        Log.e((String)string, (String)this.zza(string2), (Throwable)throwable);
    }

    public void efmt(String string, String string2, Object ... objectArray) {
        if (!this.canLog(6)) return;
        Log.e((String)string, (String)this.zzb(string2, objectArray));
    }

    public void i(String string, String string2) {
        if (!this.canLog(4)) return;
        Log.i((String)string, (String)this.zza(string2));
    }

    public void i(String string, String string2, Throwable throwable) {
        if (!this.canLog(4)) return;
        Log.i((String)string, (String)this.zza(string2), (Throwable)throwable);
    }

    public void pii(String string, String string2) {
    }

    public void pii(String string, String string2, Throwable throwable) {
    }

    public void v(String string, String string2) {
        if (!this.canLog(2)) return;
        Log.v((String)string, (String)this.zza(string2));
    }

    public void v(String string, String string2, Throwable throwable) {
        if (!this.canLog(2)) return;
        Log.v((String)string, (String)this.zza(string2), (Throwable)throwable);
    }

    public void w(String string, String string2) {
        if (!this.canLog(5)) return;
        Log.w((String)string, (String)this.zza(string2));
    }

    public void w(String string, String string2, Throwable throwable) {
        if (!this.canLog(5)) return;
        Log.w((String)string, (String)this.zza(string2), (Throwable)throwable);
    }

    public void wfmt(String string, String string2, Object ... objectArray) {
        if (!this.canLog(5)) return;
        Log.w((String)this.zza, (String)this.zzb(string2, objectArray));
    }

    public void wtf(String string, String string2, Throwable throwable) {
        if (!this.canLog(7)) return;
        Log.e((String)string, (String)this.zza(string2), (Throwable)throwable);
        Log.wtf((String)string, (String)this.zza(string2), (Throwable)throwable);
    }
}
