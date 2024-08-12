/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzbup
 *  com.google.android.gms.internal.ads.zzctl
 *  com.google.android.gms.internal.ads.zzctm
 *  com.google.android.gms.internal.ads.zzctq
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzbup;
import com.google.android.gms.internal.ads.zzctl;
import com.google.android.gms.internal.ads.zzctm;
import com.google.android.gms.internal.ads.zzctq;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;
import java.util.concurrent.Executor;

public final class zzctr
implements zzgla<zzctq> {
    private final zzgln<zzbup> zza;
    private final zzgln<zzctm> zzb;
    private final zzgln<Executor> zzc;
    private final zzgln<zzctl> zzd;
    private final zzgln<Clock> zze;

    public zzctr(zzgln<zzbup> zzgln2, zzgln<zzctm> zzgln3, zzgln<Executor> zzgln4, zzgln<zzctl> zzgln5, zzgln<Clock> zzgln6) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
        this.zzc = zzgln4;
        this.zzd = zzgln5;
        this.zze = zzgln6;
    }
}
