/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbpq
 *  com.google.android.gms.internal.ads.zzbqe
 *  com.google.android.gms.internal.ads.zzbtt
 *  com.google.android.gms.internal.ads.zzbty
 *  com.google.android.gms.internal.ads.zzbtz
 *  com.google.android.gms.internal.ads.zzbuq
 *  com.google.android.gms.internal.ads.zzbur
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbqe;
import com.google.android.gms.internal.ads.zzbtt;
import com.google.android.gms.internal.ads.zzbty;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.internal.ads.zzbuq;
import com.google.android.gms.internal.ads.zzbur;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzbus<I, O>
implements zzfrk<I, O> {
    private final zzbty<O> zza;
    private final zzbtz<I> zzb;
    private final String zzc;
    private final zzfsm<zzbtt> zzd;

    zzbus(zzfsm<zzbtt> zzfsm2, String string, zzbtz<I> zzbtz2, zzbty<O> zzbty2) {
        this.zzd = zzfsm2;
        this.zzc = "google.afma.activeView.handleUpdate";
        this.zzb = zzbtz2;
        this.zza = zzbty2;
    }

    public final zzfsm<O> zza(I i) throws Exception {
        return this.zzb(i);
    }

    public final zzfsm<O> zzb(I i) {
        return zzfsd.zzi(this.zzd, (zzfrk)new zzbuq(this, i), (Executor)zzchg.zzf);
    }

    final /* synthetic */ zzfsm zzc(Object object, zzbtt zzbtt2) throws Exception {
        zzchl zzchl2 = new zzchl();
        zzt.zzc();
        String string = UUID.randomUUID().toString();
        zzbpq.zzo.zzb(string, (zzbqe)new zzbur(this, zzchl2));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", (Object)string);
        jSONObject.put("args", (Object)((JSONObject)object));
        zzbtt2.zzr(this.zzc, jSONObject);
        return zzchl2;
    }
}
