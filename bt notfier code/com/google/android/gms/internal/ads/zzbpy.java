/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzb
 *  com.google.android.gms.common.util.CollectionUtils
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbyj
 *  com.google.android.gms.internal.ads.zzbyq
 *  com.google.android.gms.internal.ads.zzcml
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbyj;
import com.google.android.gms.internal.ads.zzbyq;
import com.google.android.gms.internal.ads.zzcml;
import java.util.Map;

public final class zzbpy
implements zzbpr<zzcml> {
    static final Map<String, Integer> zza = CollectionUtils.mapOfKeyValueArrays((Object[])new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, (Object[])new Integer[]{1, 2, 3, 4, 5, 6, 7});
    private final zzb zzb;
    private final zzbyj zzc;
    private final zzbyq zzd;

    public zzbpy(zzb zzb2, zzbyj zzbyj2, zzbyq zzbyq2) {
        this.zzb = zzb2;
        this.zzc = zzbyj2;
        this.zzd = zzbyq2;
    }
}
