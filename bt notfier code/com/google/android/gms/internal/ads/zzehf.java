/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzcoj
 *  com.google.android.gms.internal.ads.zzcve
 *  com.google.android.gms.internal.ads.zzcxn
 *  com.google.android.gms.internal.ads.zzdam
 *  com.google.android.gms.internal.ads.zzdgp
 *  com.google.android.gms.internal.ads.zzdkw
 *  com.google.android.gms.internal.ads.zzdla
 *  com.google.android.gms.internal.ads.zzehh
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzcoj;
import com.google.android.gms.internal.ads.zzcve;
import com.google.android.gms.internal.ads.zzcxn;
import com.google.android.gms.internal.ads.zzdam;
import com.google.android.gms.internal.ads.zzdgp;
import com.google.android.gms.internal.ads.zzdkw;
import com.google.android.gms.internal.ads.zzdla;
import com.google.android.gms.internal.ads.zzehh;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfsm;

public final class zzehf
extends zzehh<zzcxn> {
    private final zzcoj zza;
    private final zzdkw zzb;
    private final zzdam zzc;
    private final zzdgp zzd;

    public zzehf(zzcoj zzcoj2, zzdkw zzdkw2, zzdam zzdam2, zzdgp zzdgp2) {
        this.zza = zzcoj2;
        this.zzb = zzdkw2;
        this.zzc = zzdam2;
        this.zzd = zzdgp2;
    }

    protected final zzfsm<zzcxn> zzc(zzfar zzfar2, Bundle bundle) {
        zzdla zzdla2 = this.zza.zzr();
        zzdam zzdam2 = this.zzc;
        zzdam2.zzf(zzfar2);
        zzdam2.zzg(bundle);
        zzdla2.zzd(zzdam2.zzh());
        zzdla2.zze(this.zzd);
        zzdla2.zzc(this.zzb);
        zzdla2.zzb(new zzcve(null));
        zzfar2 = zzdla2.zza().zzR();
        return zzfar2.zzd(zzfar2.zzc());
    }
}
