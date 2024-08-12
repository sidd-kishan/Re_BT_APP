/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Trace
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import android.os.Trace;
import com.google.android.gms.internal.ads.zzave;

public final class zzavc {
    public static void zza(String string) {
        if (zzave.zza < 18) return;
        Trace.beginSection((String)string);
    }

    public static void zzb() {
        if (zzave.zza < 18) return;
        Trace.endSection();
    }
}
