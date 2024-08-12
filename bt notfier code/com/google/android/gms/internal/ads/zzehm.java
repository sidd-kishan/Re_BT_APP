/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzcoj
 *  com.google.android.gms.internal.ads.zzdam
 *  com.google.android.gms.internal.ads.zzdgp
 *  com.google.android.gms.internal.ads.zzdrw
 *  com.google.android.gms.internal.ads.zzdsa
 *  com.google.android.gms.internal.ads.zzehh
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzcoj;
import com.google.android.gms.internal.ads.zzdam;
import com.google.android.gms.internal.ads.zzdgp;
import com.google.android.gms.internal.ads.zzdrw;
import com.google.android.gms.internal.ads.zzdsa;
import com.google.android.gms.internal.ads.zzehh;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfsm;

public final class zzehm
extends zzehh<zzdrw> {
    private final zzcoj zza;
    private final zzdam zzb;
    private final zzdgp zzc;

    public zzehm(zzcoj zzcoj2, zzdam zzdam2, zzdgp zzdgp2) {
        this.zza = zzcoj2;
        this.zzb = zzdam2;
        this.zzc = zzdgp2;
    }

    protected final zzfsm<zzdrw> zzc(zzfar zzfar2, Bundle bundle) {
        zzdsa zzdsa2 = this.zza.zzs();
        zzdam zzdam2 = this.zzb;
        zzdam2.zzf(zzfar2);
        zzdam2.zzg(bundle);
        zzdsa2.zzb(zzdam2.zzh());
        zzdsa2.zzc(this.zzc);
        zzfar2 = zzdsa2.zza().zzP();
        return zzfar2.zzd(zzfar2.zzc());
    }
}
