/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzdmm
 *  com.google.android.gms.internal.ads.zzdow
 *  com.google.android.gms.internal.ads.zzdox
 *  com.google.android.gms.internal.ads.zzdpg
 *  com.google.android.gms.internal.ads.zzdpl
 *  com.google.android.gms.internal.ads.zzdpq
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzdmm;
import com.google.android.gms.internal.ads.zzdow;
import com.google.android.gms.internal.ads.zzdox;
import com.google.android.gms.internal.ads.zzdpg;
import com.google.android.gms.internal.ads.zzdpl;
import com.google.android.gms.internal.ads.zzdpq;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzdoy {
    private final zzfsn zza;
    private final zzdpl zzb;
    private final zzdpq zzc;

    public zzdoy(zzfsn zzfsn2, zzdpl zzdpl2, zzdpq zzdpq2) {
        this.zza = zzfsn2;
        this.zzb = zzdpl2;
        this.zzc = zzdpq2;
    }

    public final zzfsm<zzdmm> zza(zzfal zzfal2, zzezz zzezz2, JSONObject jSONObject) {
        Object object;
        zzfsm zzfsm2 = this.zza.zzb((Callable)new zzdow(this, zzfal2, zzezz2, jSONObject));
        zzfsm zzfsm3 = this.zzb.zzb(jSONObject, "images");
        zzfsm zzfsm4 = this.zzb.zzc(jSONObject, "images", zzezz2, zzfal2.zzb.zzb);
        zzfsm zzfsm5 = this.zzb.zza(jSONObject, "secondary_image");
        zzfsm zzfsm6 = this.zzb.zza(jSONObject, "app_icon");
        zzfsm zzfsm7 = this.zzb.zzd(jSONObject, "attribution");
        zzezz2 = this.zzb.zze(jSONObject, zzezz2, zzfal2.zzb.zzb);
        zzfal2 = this.zzb;
        zzfal2 = !jSONObject.optBoolean("enable_omid") ? zzfsd.zza(null) : ((object = jSONObject.optJSONObject("omid_settings")) == null ? zzfsd.zza(null) : (TextUtils.isEmpty((CharSequence)(object = object.optString("omid_html"))) ? zzfsd.zza(null) : zzfsd.zzi((zzfsm)zzfsd.zza(null), (zzfrk)new zzdpg((zzdpl)zzfal2, (String)object), (Executor)zzchg.zze)));
        object = this.zzc.zza(jSONObject, "custom_assets");
        return zzfsd.zzl((zzfsm[])new zzfsm[]{zzfsm2, zzfsm3, zzfsm4, zzfsm5, zzfsm6, zzfsm7, zzezz2, zzfal2, object}).zza((Callable)new zzdox(this, zzfsm2, zzfsm3, zzfsm6, zzfsm5, zzfsm7, jSONObject, (zzfsm)zzezz2, zzfsm4, (zzfsm)zzfal2, (zzfsm)object), (Executor)this.zza);
    }
}
