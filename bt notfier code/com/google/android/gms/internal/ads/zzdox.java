/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzblz
 *  com.google.android.gms.internal.ads.zzbmh
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzdmm
 *  com.google.android.gms.internal.ads.zzdoy
 *  com.google.android.gms.internal.ads.zzdpl
 *  com.google.android.gms.internal.ads.zzdpp
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzblz;
import com.google.android.gms.internal.ads.zzbmh;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzdmm;
import com.google.android.gms.internal.ads.zzdoy;
import com.google.android.gms.internal.ads.zzdpl;
import com.google.android.gms.internal.ads.zzdpp;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

final class zzdox
implements Callable {
    private final zzdoy zza;
    private final zzfsm zzb;
    private final zzfsm zzc;
    private final zzfsm zzd;
    private final zzfsm zze;
    private final zzfsm zzf;
    private final JSONObject zzg;
    private final zzfsm zzh;
    private final zzfsm zzi;
    private final zzfsm zzj;
    private final zzfsm zzk;

    zzdox(zzdoy zzdoy2, zzfsm zzfsm2, zzfsm zzfsm3, zzfsm zzfsm4, zzfsm zzfsm5, zzfsm zzfsm6, JSONObject jSONObject, zzfsm zzfsm7, zzfsm zzfsm8, zzfsm zzfsm9, zzfsm zzfsm10) {
        this.zza = zzdoy2;
        this.zzb = zzfsm2;
        this.zzc = zzfsm3;
        this.zzd = zzfsm4;
        this.zze = zzfsm5;
        this.zzf = zzfsm6;
        this.zzg = jSONObject;
        this.zzh = zzfsm7;
        this.zzi = zzfsm8;
        this.zzj = zzfsm9;
        this.zzk = zzfsm10;
    }

    public final Object call() {
        zzfsm zzfsm2 = this.zzb;
        zzfsm zzfsm3 = this.zzc;
        zzfsm zzfsm4 = this.zzd;
        zzfsm zzfsm5 = this.zze;
        zzfsm zzfsm6 = this.zzf;
        JSONObject jSONObject = this.zzg;
        zzfsm zzfsm7 = this.zzh;
        zzfsm zzfsm8 = this.zzi;
        zzfsm zzfsm9 = this.zzj;
        Object object = this.zzk;
        zzfsm2 = (zzdmm)zzfsm2.get();
        zzfsm2.zzd((List)zzfsm3.get());
        zzfsm2.zzj((zzbmh)zzfsm4.get());
        zzfsm2.zzk((zzbmh)zzfsm5.get());
        zzfsm2.zzc((zzblz)zzfsm6.get());
        zzfsm2.zze(zzdpl.zzj((JSONObject)jSONObject));
        zzfsm2.zzf(zzdpl.zzi((JSONObject)jSONObject));
        zzfsm5 = (zzcml)zzfsm7.get();
        if (zzfsm5 != null) {
            zzfsm2.zzm((zzcml)zzfsm5);
            zzfsm2.zzg(zzfsm5.zzH());
            zzfsm2.zzb((zzbhc)zzfsm5.zzh());
        }
        if ((zzfsm8 = (zzcml)zzfsm8.get()) != null) {
            zzfsm2.zzn((zzcml)zzfsm8);
            zzfsm2.zzh(zzfsm8.zzH());
        }
        if ((zzfsm9 = (zzcml)zzfsm9.get()) != null) {
            zzfsm2.zzo((zzcml)zzfsm9);
        }
        object = ((List)object.get()).iterator();
        while (object.hasNext()) {
            zzfsm9 = (zzdpp)object.next();
            if (zzfsm9.zza != 1) {
                zzfsm2.zzr(zzfsm9.zzb, zzfsm9.zzd);
                continue;
            }
            zzfsm2.zzq(zzfsm9.zzb, zzfsm9.zzc);
        }
        return zzfsm2;
    }
}
