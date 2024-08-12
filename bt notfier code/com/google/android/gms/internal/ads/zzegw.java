/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.util.PlatformVersion
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbtv
 *  com.google.android.gms.internal.ads.zzcxv
 *  com.google.android.gms.internal.ads.zzdlb
 *  com.google.android.gms.internal.ads.zzdlo
 *  com.google.android.gms.internal.ads.zzdmh
 *  com.google.android.gms.internal.ads.zzdmm
 *  com.google.android.gms.internal.ads.zzdmy
 *  com.google.android.gms.internal.ads.zzdoy
 *  com.google.android.gms.internal.ads.zzdrh
 *  com.google.android.gms.internal.ads.zzdrn
 *  com.google.android.gms.internal.ads.zzdym
 *  com.google.android.gms.internal.ads.zzegq
 *  com.google.android.gms.internal.ads.zzegr
 *  com.google.android.gms.internal.ads.zzegs
 *  com.google.android.gms.internal.ads.zzegt
 *  com.google.android.gms.internal.ads.zzegu
 *  com.google.android.gms.internal.ads.zzegv
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfbj
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbtv;
import com.google.android.gms.internal.ads.zzcxv;
import com.google.android.gms.internal.ads.zzdlb;
import com.google.android.gms.internal.ads.zzdlo;
import com.google.android.gms.internal.ads.zzdmh;
import com.google.android.gms.internal.ads.zzdmm;
import com.google.android.gms.internal.ads.zzdmy;
import com.google.android.gms.internal.ads.zzdoy;
import com.google.android.gms.internal.ads.zzdrh;
import com.google.android.gms.internal.ads.zzdrn;
import com.google.android.gms.internal.ads.zzdym;
import com.google.android.gms.internal.ads.zzegq;
import com.google.android.gms.internal.ads.zzegr;
import com.google.android.gms.internal.ads.zzegs;
import com.google.android.gms.internal.ads.zzegt;
import com.google.android.gms.internal.ads.zzegu;
import com.google.android.gms.internal.ads.zzegv;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfbj;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzegw
implements zzegq<zzdmh> {
    private final zzdlb zza;
    private final zzfsn zzb;
    private final zzdoy zzc;
    private final zzfbj<zzdrh> zzd;
    private final zzdrn zze;

    public zzegw(zzdlb zzdlb2, zzfsn zzfsn2, zzdoy zzdoy2, zzfbj<zzdrh> zzfbj2, zzdrn zzdrn2) {
        this.zza = zzdlb2;
        this.zzb = zzfsn2;
        this.zzc = zzdoy2;
        this.zzd = zzfbj2;
        this.zze = zzdrn2;
    }

    private final zzfsm<zzdmh> zzg(zzfal zzfal2, zzezz zzezz2, JSONObject jSONObject) {
        zzfsm zzfsm2 = this.zzd.zzb();
        zzfsm zzfsm3 = this.zzc.zza(zzfal2, zzezz2, jSONObject);
        return zzfsd.zzn((zzfsm[])new zzfsm[]{zzfsm2, zzfsm3}).zza((Callable)new zzegv(this, zzfsm3, zzfsm2, zzfal2, zzezz2, jSONObject), (Executor)this.zzb);
    }

    public final boolean zza(zzfal zzfal2, zzezz zzezz2) {
        zzfal2 = zzezz2.zzs;
        if (zzfal2 == null) return false;
        if (zzfal2.zzc == null) return false;
        return true;
    }

    public final zzfsm<List<zzfsm<zzdmh>>> zzb(zzfal zzfal2, zzezz zzezz2) {
        return zzfsd.zzi((zzfsm)zzfsd.zzi((zzfsm)this.zzd.zzb(), (zzfrk)new zzegr(this, zzezz2), (Executor)this.zzb), (zzfrk)new zzegs(this, zzfal2, zzezz2), (Executor)this.zzb);
    }

    final /* synthetic */ zzdmh zzc(zzfsm zzfsm2, zzfsm zzfsm3, zzfal zzfal2, zzezz zzezz2, JSONObject jSONObject) throws Exception {
        zzfsm2 = (zzdmm)zzfsm2.get();
        zzfsm3 = (zzdrh)zzfsm3.get();
        zzfal2 = this.zza.zzT(new zzcxv(zzfal2, zzezz2, null), new zzdmy((zzdmm)zzfsm2), new zzdlo(jSONObject, (zzdrh)zzfsm3));
        zzfal2.zzi().zzb();
        zzfal2.zzj().zza((zzdrh)zzfsm3);
        zzfal2.zzk().zza(zzfsm2.zzR());
        zzfal2.zzl().zza(this.zze);
        return zzfal2.zzh();
    }

    final /* synthetic */ zzfsm zzd(zzdrh zzdrh2, JSONObject jSONObject) throws Exception {
        this.zzd.zzc(zzfsd.zza((Object)zzdrh2));
        if (!jSONObject.optBoolean("success")) throw new zzbtv("process json failed");
        return zzfsd.zza((Object)jSONObject.getJSONObject("json").getJSONArray("ads"));
    }

    final /* synthetic */ zzfsm zze(zzfal zzfal2, zzezz zzezz2, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            zzfal2 = zzfsd.zzc((Throwable)new zzdym(3));
        } else {
            int n = zzfal2.zza.zza.zzk;
            if (n <= 1) {
                zzfal2 = zzfsd.zzj(this.zzg(zzfal2, zzezz2, jSONArray.getJSONObject(0)), (zzfln)zzegu.zza, (Executor)this.zzb);
            } else {
                n = jSONArray.length();
                this.zzd.zza(Math.min(n, zzfal2.zza.zza.zzk));
                ArrayList<Object> arrayList = new ArrayList<Object>(zzfal2.zza.zza.zzk);
                for (int i = 0; i < zzfal2.zza.zza.zzk; ++i) {
                    if (i < n) {
                        arrayList.add(this.zzg(zzfal2, zzezz2, jSONArray.getJSONObject(i)));
                        continue;
                    }
                    arrayList.add(zzfsd.zzc((Throwable)new zzdym(3)));
                }
                zzfal2 = zzfsd.zza(arrayList);
            }
        }
        return zzfal2;
    }

    final /* synthetic */ zzfsm zzf(zzezz zzezz2, zzdrh zzdrh2) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        zzbjd zzbjd2 = zzbjl.zzgf;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue() && PlatformVersion.isAtLeastR()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        zzbjd2 = new JSONObject();
        zzbjd2.put("response", (Object)zzezz2.zzs.zzc);
        zzbjd2.put("sdk_params", (Object)jSONObject);
        return zzfsd.zzi((zzfsm)zzdrh2.zzd("google.afma.nativeAds.preProcessJson", (JSONObject)zzbjd2), (zzfrk)new zzegt(this, zzdrh2), (Executor)this.zzb);
    }
}
