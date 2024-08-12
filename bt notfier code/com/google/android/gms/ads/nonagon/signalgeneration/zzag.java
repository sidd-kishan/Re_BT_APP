/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzaf
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzdzk
 *  com.google.android.gms.internal.ads.zzdzl
 *  com.google.android.gms.internal.ads.zzfsn
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgli
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.nonagon.signalgeneration.zzaf;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzdzk;
import com.google.android.gms.internal.ads.zzdzl;
import com.google.android.gms.internal.ads.zzfsn;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgli;
import com.google.android.gms.internal.ads.zzgln;
import java.util.concurrent.Executor;

public final class zzag
implements zzgla<zzaf> {
    private final zzgln<Executor> zza;
    private final zzgln<zzdzk> zzb;

    public zzag(zzgln<Executor> zzgln2, zzgln<zzdzk> zzgln3) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
    }

    public final zzaf zza() {
        zzfsn zzfsn2 = zzchg.zza;
        zzgli.zzb((Object)zzfsn2);
        return new zzaf((Executor)zzfsn2, ((zzdzl)this.zzb).zza());
    }
}
