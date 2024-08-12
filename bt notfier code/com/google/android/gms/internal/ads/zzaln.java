/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;
import org.checkerframework.dataflow.qual.Pure;

public final class zzaln {
    @Pure
    public static void zza(String string, String string2, Throwable throwable) {
        Log.w((String)string, (String)zzaln.zzc(string2, throwable));
    }

    @Pure
    public static void zzb(String string, String string2, Throwable throwable) {
        Log.e((String)string, (String)zzaln.zzc(string2, throwable));
    }

    @Pure
    private static String zzc(String string, Throwable object) {
        Object object2;
        block3: {
            if (object == null) {
                object = null;
            } else {
                for (object2 = object; object2 != null; object2 = ((Throwable)object2).getCause()) {
                    if (!(object2 instanceof UnknownHostException)) continue;
                    object = "UnknownHostException (no network)";
                    break block3;
                }
                object = Log.getStackTraceString((Throwable)object).trim().replace("\t", "    ");
            }
        }
        object2 = string;
        if (TextUtils.isEmpty((CharSequence)object)) return object2;
        string = String.valueOf(string);
        object2 = ((String)object).replace("\n", "\n  ");
        object = new StringBuilder(String.valueOf(string).length() + 4 + String.valueOf(object2).length());
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append("\n  ");
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append('\n');
        object2 = ((StringBuilder)object).toString();
        return object2;
    }
}
