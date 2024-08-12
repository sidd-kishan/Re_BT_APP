/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Trace
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.os.Trace;
import com.google.android.gms.internal.ads.zzamq;

public final class zzamo {
    public static void zza(String string) {
        if (zzamq.zza < 18) return;
        Trace.beginSection((String)string);
    }

    public static void zzb() {
        if (zzamq.zza < 18) return;
        Trace.endSection();
    }
}
