/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzcoj
 *  com.google.android.gms.internal.ads.zzdam
 *  com.google.android.gms.internal.ads.zzdgp
 *  com.google.android.gms.internal.ads.zzdji
 *  com.google.android.gms.internal.ads.zzdke
 *  com.google.android.gms.internal.ads.zzehh
 *  com.google.android.gms.internal.ads.zzejq
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzcoj;
import com.google.android.gms.internal.ads.zzdam;
import com.google.android.gms.internal.ads.zzdgp;
import com.google.android.gms.internal.ads.zzdji;
import com.google.android.gms.internal.ads.zzdke;
import com.google.android.gms.internal.ads.zzehh;
import com.google.android.gms.internal.ads.zzejq;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfsm;

public final class zzehk
extends zzehh<zzdji> {
    private final zzcoj zza;
    private final zzdam zzb;
    private final zzejq zzc;
    private final zzdgp zzd;

    public zzehk(zzcoj zzcoj2, zzdam zzdam2, zzejq zzejq2, zzdgp zzdgp2) {
        this.zza = zzcoj2;
        this.zzb = zzdam2;
        this.zzc = zzejq2;
        this.zzd = zzdgp2;
    }

    protected final zzfsm<zzdji> zzc(zzfar zzfar2, Bundle bundle) {
        zzdke zzdke2 = this.zza.zzp();
        zzdam zzdam2 = this.zzb;
        zzdam2.zzf(zzfar2);
        zzdam2.zzg(bundle);
        zzdke2.zzc(zzdam2.zzh());
        zzdke2.zzd(this.zzd);
        zzdke2.zzb(this.zzc);
        zzfar2 = zzdke2.zza().zzP();
        return zzfar2.zzd(zzfar2.zzc());
    }
}
