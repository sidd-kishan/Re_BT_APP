/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdcm
 *  com.google.android.gms.internal.ads.zzeee
 *  com.google.android.gms.internal.ads.zzeek
 *  com.google.android.gms.internal.ads.zzejc
 *  com.google.android.gms.internal.ads.zzfes
 *  com.google.android.gms.internal.ads.zzfsn
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdcm;
import com.google.android.gms.internal.ads.zzeee;
import com.google.android.gms.internal.ads.zzeek;
import com.google.android.gms.internal.ads.zzejc;
import com.google.android.gms.internal.ads.zzfes;
import com.google.android.gms.internal.ads.zzfsn;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzejd<AdT, AdapterT, ListenerT extends zzdcm>
implements zzgla<zzejc<AdT, AdapterT, ListenerT>> {
    private final zzgln<zzfes> zza;
    private final zzgln<zzfsn> zzb;
    private final zzgln<zzeee<AdapterT, ListenerT>> zzc;
    private final zzgln<zzeek<AdT, AdapterT, ListenerT>> zzd;

    public zzejd(zzgln<zzfes> zzgln2, zzgln<zzfsn> zzgln3, zzgln<zzeee<AdapterT, ListenerT>> zzgln4, zzgln<zzeek<AdT, AdapterT, ListenerT>> zzgln5) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
        this.zzc = zzgln4;
        this.zzd = zzgln5;
    }

    public final zzejc<AdT, AdapterT, ListenerT> zza() {
        return new zzejc((zzfes)this.zza.zzb(), (zzfsn)this.zzb.zzb(), (zzeee)this.zzc.zzb(), (zzeek)this.zzd.zzb());
    }
}
