/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import java.util.Locale;

public final class zzwo {
    public static final String zza = "Volley";
    public static final boolean zzb = Log.isLoggable((String)"Volley", (int)2);
    private static final String zzc = zzwo.class.getName();

    public static void zza(String string, Object ... objectArray) {
        if (!zzb) return;
        Log.v((String)zza, (String)zzwo.zze(string, objectArray));
    }

    public static void zzb(String string, Object ... objectArray) {
        Log.d((String)zza, (String)zzwo.zze(string, objectArray));
    }

    public static void zzc(String string, Object ... objectArray) {
        Log.e((String)zza, (String)zzwo.zze(string, objectArray));
    }

    public static void zzd(Throwable throwable, String string, Object ... objectArray) {
        Log.e((String)zza, (String)zzwo.zze(string, objectArray), (Throwable)throwable);
    }

    private static String zze(String string, Object ... object) {
        block1: {
            object = String.format(Locale.US, string, object);
            Object object2 = new Throwable().fillInStackTrace().getStackTrace();
            for (int i = 2; i < ((StackTraceElement[])object2).length; ++i) {
                if (object2[i].getClassName().equals(zzc)) continue;
                string = object2[i].getClassName();
                string = string.substring(string.lastIndexOf(46) + 1);
                string = string.substring(string.lastIndexOf(36) + 1);
                String string2 = object2[i].getMethodName();
                object2 = new StringBuilder(String.valueOf(string).length() + 1 + String.valueOf(string2).length());
                ((StringBuilder)object2).append(string);
                ((StringBuilder)object2).append(".");
                ((StringBuilder)object2).append(string2);
                string = ((StringBuilder)object2).toString();
                break block1;
            }
            string = "<unknown>";
        }
        return String.format(Locale.US, "[%d] %s: %s", Thread.currentThread().getId(), string, object);
    }
}
