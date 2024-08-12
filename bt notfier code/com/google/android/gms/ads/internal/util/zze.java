/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzbla
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.ads.internal.util;

import android.util.Log;
import com.google.android.gms.internal.ads.zzbla;
import com.google.android.gms.internal.ads.zzcgt;
import java.util.Iterator;

public final class zze
extends zzcgt {
    public static void zza(String string) {
        if (!zze.zzc()) return;
        if (string == null || string.length() <= 4000) {
            Log.v((String)"Ads", (String)string);
            return;
        }
        Iterator iterator = zza.zzd((CharSequence)string).iterator();
        boolean bl = true;
        while (iterator.hasNext()) {
            string = (String)iterator.next();
            if (bl) {
                Log.v((String)"Ads", (String)string);
            } else {
                Log.v((String)"Ads-cont", (String)string);
            }
            bl = false;
        }
    }

    public static void zzb(String string, Throwable throwable) {
        if (!zze.zzc()) return;
        Log.v((String)"Ads", (String)string, (Throwable)throwable);
    }

    public static boolean zzc() {
        if (!zze.zzm((int)2)) return false;
        if ((Boolean)zzbla.zza.zze() == false) return false;
        return true;
    }
}
