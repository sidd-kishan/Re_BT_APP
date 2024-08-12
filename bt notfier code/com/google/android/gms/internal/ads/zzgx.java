/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzan
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzan;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class zzgx {
    private static final AtomicLong zzd = new AtomicLong();
    public final zzan zza;
    public final Uri zzb;
    public final Map<String, List<String>> zzc;

    public zzgx(long l, zzan zzan2, Uri uri, Map<String, List<String>> map, long l2, long l3, long l4) {
        this.zza = zzan2;
        this.zzb = uri;
        this.zzc = map;
    }

    public static long zza() {
        return zzd.getAndIncrement();
    }
}
