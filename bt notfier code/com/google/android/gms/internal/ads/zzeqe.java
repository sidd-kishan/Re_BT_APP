/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzeqd
 *  com.google.android.gms.internal.ads.zzeqf
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzeqd;
import com.google.android.gms.internal.ads.zzeqf;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.Set;
import java.util.concurrent.Callable;

public final class zzeqe
implements zzery<zzeqf> {
    private final zzfsn zza;
    private final Context zzb;
    private final Set<String> zzc;

    public zzeqe(zzfsn zzfsn2, Context context, Set<String> set) {
        this.zza = zzfsn2;
        this.zzb = context;
        this.zzc = set;
    }

    public final zzfsm<zzeqf> zza() {
        return this.zza.zzb((Callable)new zzeqd(this));
    }

    final /* synthetic */ zzeqf zzb() throws Exception {
        Object object = zzbjl.zzdu;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)object) == false) return new zzeqf(null);
        object = this.zzc;
        if (object.contains("rewarded")) return new zzeqf(zzt.zzr().zzc(this.zzb));
        if (object.contains("interstitial")) return new zzeqf(zzt.zzr().zzc(this.zzb));
        if (object.contains("native")) return new zzeqf(zzt.zzr().zzc(this.zzb));
        if (!object.contains("banner")) return new zzeqf(null);
        return new zzeqf(zzt.zzr().zzc(this.zzb));
    }
}
