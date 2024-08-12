/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzfmg
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzfmg;
import java.util.Iterator;

public class zzcgt {
    protected static final zzfmg zza = zzfmg.zzc((int)4000);

    public static void zzd(String string) {
        if (!zzcgt.zzm(3)) return;
        if (string == null || string.length() <= 4000) {
            Log.d((String)"Ads", (String)string);
            return;
        }
        Iterator iterator = zza.zzd((CharSequence)string).iterator();
        boolean bl = true;
        while (iterator.hasNext()) {
            string = (String)iterator.next();
            if (bl) {
                Log.d((String)"Ads", (String)string);
            } else {
                Log.d((String)"Ads-cont", (String)string);
            }
            bl = false;
        }
    }

    public static void zze(String string, Throwable throwable) {
        if (!zzcgt.zzm(3)) return;
        Log.d((String)"Ads", (String)string, (Throwable)throwable);
    }

    public static void zzf(String string) {
        if (!zzcgt.zzm(6)) return;
        if (string == null || string.length() <= 4000) {
            Log.e((String)"Ads", (String)string);
            return;
        }
        Iterator iterator = zza.zzd((CharSequence)string).iterator();
        boolean bl = true;
        while (iterator.hasNext()) {
            string = (String)iterator.next();
            if (bl) {
                Log.e((String)"Ads", (String)string);
            } else {
                Log.e((String)"Ads-cont", (String)string);
            }
            bl = false;
        }
    }

    public static void zzg(String string, Throwable throwable) {
        if (!zzcgt.zzm(6)) return;
        Log.e((String)"Ads", (String)string, (Throwable)throwable);
    }

    public static void zzh(String string) {
        if (!zzcgt.zzm(4)) return;
        if (string == null || string.length() <= 4000) {
            Log.i((String)"Ads", (String)string);
            return;
        }
        Iterator iterator = zza.zzd((CharSequence)string).iterator();
        boolean bl = true;
        while (iterator.hasNext()) {
            string = (String)iterator.next();
            if (bl) {
                Log.i((String)"Ads", (String)string);
            } else {
                Log.i((String)"Ads-cont", (String)string);
            }
            bl = false;
        }
    }

    public static void zzi(String object) {
        if (!zzcgt.zzm(5)) return;
        if (object == null || ((String)object).length() <= 4000) {
            Log.w((String)"Ads", (String)object);
            return;
        }
        object = zza.zzd((CharSequence)object).iterator();
        boolean bl = true;
        while (object.hasNext()) {
            String string = (String)object.next();
            if (bl) {
                Log.w((String)"Ads", (String)string);
            } else {
                Log.w((String)"Ads-cont", (String)string);
            }
            bl = false;
        }
    }

    public static void zzj(String string, Throwable throwable) {
        if (!zzcgt.zzm(5)) return;
        Log.w((String)"Ads", (String)string, (Throwable)throwable);
    }

    static String zzk(String string) {
        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        CharSequence charSequence = string;
        if (stackTraceElementArray.length < 4) return charSequence;
        int n = stackTraceElementArray[3].getLineNumber();
        charSequence = new StringBuilder(string.length() + 13);
        ((StringBuilder)charSequence).append(string);
        ((StringBuilder)charSequence).append(" @");
        ((StringBuilder)charSequence).append(n);
        charSequence = ((StringBuilder)charSequence).toString();
        return charSequence;
    }

    public static void zzl(String string, Throwable throwable) {
        if (!zzcgt.zzm(5)) return;
        if (throwable != null) {
            zzcgt.zzj(zzcgt.zzk(string), throwable);
            return;
        }
        zzcgt.zzi(zzcgt.zzk(string));
    }

    public static boolean zzm(int n) {
        if (n >= 5) return true;
        if (!Log.isLoggable((String)"Ads", (int)n)) return false;
        return true;
    }
}
