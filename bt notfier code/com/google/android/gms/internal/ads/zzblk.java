/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbkn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbkn;

public final class zzblk {
    public static final zzbkn<Boolean> zza = zzbkn.zza((String)"gads:always_collect_trustless_token_at_native_side", (boolean)true);
    public static final zzbkn<Boolean> zzb = zzbkn.zza((String)"gms:expose_token_for_gma:enabled", (boolean)false);
    public static final zzbkn<Long> zzc = zzbkn.zzb((String)"gads:timeout_for_trustless_token:millis", (long)2000L);
    public static final zzbkn<Long> zzd = zzbkn.zzb((String)"gads:cached_token:ttl_millis", (long)10800000L);
}
