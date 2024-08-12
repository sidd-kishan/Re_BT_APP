/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzcdz
 *  com.google.android.gms.internal.ads.zzcea
 *  com.google.android.gms.internal.ads.zzceb
 *  com.google.android.gms.internal.ads.zzcec
 *  com.google.android.gms.internal.ads.zzced
 *  com.google.android.gms.internal.ads.zzcee
 *  com.google.android.gms.internal.ads.zzceg
 *  com.google.android.gms.internal.ads.zzcfa
 *  com.google.android.gms.internal.ads.zzcfb
 *  com.google.android.gms.internal.ads.zzcfg
 *  com.google.android.gms.internal.ads.zzcfh
 *  com.google.android.gms.internal.ads.zzgkz
 *  com.google.android.gms.internal.ads.zzglb
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzcdz;
import com.google.android.gms.internal.ads.zzcea;
import com.google.android.gms.internal.ads.zzceb;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzced;
import com.google.android.gms.internal.ads.zzcee;
import com.google.android.gms.internal.ads.zzceg;
import com.google.android.gms.internal.ads.zzcfa;
import com.google.android.gms.internal.ads.zzcfb;
import com.google.android.gms.internal.ads.zzcfg;
import com.google.android.gms.internal.ads.zzcfh;
import com.google.android.gms.internal.ads.zzgkz;
import com.google.android.gms.internal.ads.zzglb;
import com.google.android.gms.internal.ads.zzgln;

public final class zzceh
extends zzcfb {
    private final Clock zzb;
    private final zzceh zzc = this;
    private final zzgln<Context> zzd;
    private final zzgln<zzg> zze;
    private final zzgln<zzcfa> zzf;
    private final zzgln<zzcdz> zzg;
    private final zzgln<Clock> zzh;
    private final zzgln<zzceb> zzi;
    private final zzgln<zzced> zzj;
    private final zzgln<zzcfg> zzk;

    /* synthetic */ zzceh(Context context, Clock clock, zzg zzg2, zzcfa zzcfa2, zzceg zzceg2) {
        this.zzb = clock;
        this.zzd = zzglb.zza((Object)context);
        this.zze = zzglb.zza((Object)zzg2);
        this.zzf = context = zzglb.zza((Object)zzcfa2);
        this.zzg = zzgkz.zza((zzgln)new zzcea(this.zzd, this.zze, (zzgln)context));
        this.zzh = context = zzglb.zza((Object)clock);
        this.zzi = context = zzgkz.zza((zzgln)new zzcec((zzgln)context, this.zze, this.zzf));
        this.zzj = context = new zzcee(this.zzh, (zzgln)context);
        this.zzk = zzgkz.zza((zzgln)new zzcfh(this.zzd, (zzgln)context));
    }

    final zzcdz zza() {
        return (zzcdz)this.zzg.zzb();
    }

    final zzced zzb() {
        return new zzced(this.zzb, (zzceb)this.zzi.zzb());
    }

    final zzcfg zzc() {
        return (zzcfg)this.zzk.zzb();
    }
}
