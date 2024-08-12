/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzffz
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.ads.zzffz;

public final class zzfhj {
    public static void zza(String string, Exception exception) {
        if (zzffz.zza.booleanValue()) {
            TextUtils.isEmpty((CharSequence)string);
        }
        Log.e((String)"OMIDLIB", (String)string, (Throwable)exception);
    }
}
