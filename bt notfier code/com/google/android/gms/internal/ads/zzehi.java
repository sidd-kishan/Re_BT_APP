/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.ViewGroup
 *  com.google.android.gms.internal.ads.zzcoj
 *  com.google.android.gms.internal.ads.zzcve
 *  com.google.android.gms.internal.ads.zzcvh
 *  com.google.android.gms.internal.ads.zzcwd
 *  com.google.android.gms.internal.ads.zzcxa
 *  com.google.android.gms.internal.ads.zzdam
 *  com.google.android.gms.internal.ads.zzddr
 *  com.google.android.gms.internal.ads.zzdgp
 *  com.google.android.gms.internal.ads.zzdkw
 *  com.google.android.gms.internal.ads.zzehh
 *  com.google.android.gms.internal.ads.zzejq
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzcoj;
import com.google.android.gms.internal.ads.zzcve;
import com.google.android.gms.internal.ads.zzcvh;
import com.google.android.gms.internal.ads.zzcwd;
import com.google.android.gms.internal.ads.zzcxa;
import com.google.android.gms.internal.ads.zzdam;
import com.google.android.gms.internal.ads.zzddr;
import com.google.android.gms.internal.ads.zzdgp;
import com.google.android.gms.internal.ads.zzdkw;
import com.google.android.gms.internal.ads.zzehh;
import com.google.android.gms.internal.ads.zzejq;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfsm;

public final class zzehi
extends zzehh<zzcvh> {
    private final zzcoj zza;
    private final zzdam zzb;
    private final zzejq zzc;
    private final zzdgp zzd;
    private final zzdkw zze;
    private final zzddr zzf;
    private final ViewGroup zzg;

    public zzehi(zzcoj zzcoj2, zzdam zzdam2, zzejq zzejq2, zzdgp zzdgp2, zzdkw zzdkw2, zzddr zzddr2, ViewGroup viewGroup) {
        this.zza = zzcoj2;
        this.zzb = zzdam2;
        this.zzc = zzejq2;
        this.zzd = zzdgp2;
        this.zze = zzdkw2;
        this.zzf = zzddr2;
        this.zzg = viewGroup;
    }

    protected final zzfsm<zzcvh> zzc(zzfar zzfar2, Bundle bundle) {
        zzcwd zzcwd2 = this.zza.zzk();
        zzdam zzdam2 = this.zzb;
        zzdam2.zzf(zzfar2);
        zzdam2.zzg(bundle);
        zzcwd2.zzi(zzdam2.zzh());
        zzcwd2.zzj(this.zzd);
        zzcwd2.zze(this.zzc);
        zzcwd2.zzb(this.zze);
        zzcwd2.zzd(new zzcxa(this.zzf));
        zzcwd2.zzc(new zzcve(this.zzg));
        zzfar2 = zzcwd2.zza().zzY();
        return zzfar2.zzd(zzfar2.zzc());
    }
}
