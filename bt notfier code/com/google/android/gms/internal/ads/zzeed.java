/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzeec
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzeec;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;

public final class zzeed<DelegateT, AdapterT>
implements zzeec<AdapterT> {
    public final zzeec<DelegateT> zza;
    private final zzfln<DelegateT, AdapterT> zzb;

    public zzeed(zzeec<DelegateT> zzeec2, zzfln<DelegateT, AdapterT> zzfln2) {
        this.zza = zzeec2;
        this.zzb = zzfln2;
    }

    public final boolean zza(zzfal zzfal2, zzezz zzezz2) {
        return this.zza.zza(zzfal2, zzezz2);
    }

    public final zzfsm<AdapterT> zzb(zzfal zzfal2, zzezz zzezz2) {
        return zzfsd.zzj((zzfsm)this.zza.zzb(zzfal2, zzezz2), this.zzb, (Executor)zzchg.zza);
    }
}
