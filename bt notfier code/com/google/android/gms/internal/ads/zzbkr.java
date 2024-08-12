/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbkn
 *  com.google.android.gms.internal.ads.zzbko
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbkn;
import com.google.android.gms.internal.ads.zzbko;

public final class zzbkr {
    public static final zzbkn<Boolean> zza = zzbko.zzf((String)"gads:consent:gmscore:dsid:enabled", (boolean)true);
    public static final zzbkn<Boolean> zzb = zzbko.zzf((String)"gads:consent:gmscore:lat:enabled", (boolean)true);
    public static final zzbkn<String> zzc = new zzbko("gads:consent:gmscore:backend_url", (Object)"https://adservice.google.com/getconfig/pubvendors", 4);
    public static final zzbkn<Long> zzd = new zzbko("gads:consent:gmscore:time_out", (Object)10000L, 2);
    public static final zzbkn<Boolean> zze = zzbko.zzf((String)"gads:consent:gmscore:enabled", (boolean)true);
}
