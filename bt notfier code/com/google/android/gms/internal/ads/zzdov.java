/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzbr
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzdou
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzdou;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;
import java.util.concurrent.Executor;

public final class zzdov
implements zzgla<zzdou> {
    private final zzgln<zzbr> zza;
    private final zzgln<Clock> zzb;
    private final zzgln<Executor> zzc;

    public zzdov(zzgln<zzbr> zzgln2, zzgln<Clock> zzgln3, zzgln<Executor> zzgln4) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
        this.zzc = zzgln4;
    }
}
