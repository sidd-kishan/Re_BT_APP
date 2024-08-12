/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzddr
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzddr;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcvg
implements zzgla<zzddr> {
    private final zzgln<ScheduledExecutorService> zza;
    private final zzgln<Clock> zzb;

    public zzcvg(zzgln<ScheduledExecutorService> zzgln2, zzgln<Clock> zzgln3) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
    }

    public final zzddr zza() {
        return new zzddr((ScheduledExecutorService)this.zza.zzb(), (Clock)this.zzb.zzb());
    }
}
