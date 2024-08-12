/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzdyc
 *  com.google.android.gms.internal.ads.zzepk
 *  com.google.android.gms.internal.ads.zzepm
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzdyc;
import com.google.android.gms.internal.ads.zzepk;
import com.google.android.gms.internal.ads.zzepm;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Callable;

public final class zzepl
implements zzery<zzepm> {
    private final zzfsn zza;
    private final zzdyc zzb;

    zzepl(zzfsn zzfsn2, zzdyc zzdyc2) {
        this.zza = zzfsn2;
        this.zzb = zzdyc2;
    }

    public final zzfsm<zzepm> zza() {
        return this.zza.zzb((Callable)new zzepk(this));
    }

    final /* synthetic */ zzepm zzb() throws Exception {
        return new zzepm(this.zzb.zzg(), this.zzb.zzd(), zzt.zzm().zzk());
    }
}
