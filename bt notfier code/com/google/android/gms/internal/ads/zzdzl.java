/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzdzk
 *  com.google.android.gms.internal.ads.zzeac
 *  com.google.android.gms.internal.ads.zzead
 *  com.google.android.gms.internal.ads.zzebq
 *  com.google.android.gms.internal.ads.zzfsn
 *  com.google.android.gms.internal.ads.zzgkz
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgli
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzdzk;
import com.google.android.gms.internal.ads.zzeac;
import com.google.android.gms.internal.ads.zzead;
import com.google.android.gms.internal.ads.zzebq;
import com.google.android.gms.internal.ads.zzfsn;
import com.google.android.gms.internal.ads.zzgkz;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgli;
import com.google.android.gms.internal.ads.zzgln;
import java.util.concurrent.ScheduledExecutorService;

public final class zzdzl
implements zzgla<zzdzk> {
    private final zzgln<ScheduledExecutorService> zza;
    private final zzgln<zzfsn> zzb;
    private final zzgln<zzeac> zzc;
    private final zzgln<zzebq> zzd;

    public zzdzl(zzgln<ScheduledExecutorService> zzgln2, zzgln<zzfsn> zzgln3, zzgln<zzeac> zzgln4, zzgln<zzebq> zzgln5) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
        this.zzc = zzgln4;
        this.zzd = zzgln5;
    }

    public final zzdzk zza() {
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService)this.zza.zzb();
        zzfsn zzfsn2 = zzchg.zza;
        zzgli.zzb((Object)zzfsn2);
        return new zzdzk(scheduledExecutorService, zzfsn2, ((zzead)this.zzc).zza(), zzgkz.zzc(this.zzd));
    }
}
