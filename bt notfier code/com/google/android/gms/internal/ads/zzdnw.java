/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcmw
 *  com.google.android.gms.internal.ads.zzcua
 *  com.google.android.gms.internal.ads.zzdmu
 *  com.google.android.gms.internal.ads.zzdnq
 *  com.google.android.gms.internal.ads.zzdnr
 *  com.google.android.gms.internal.ads.zzdns
 *  com.google.android.gms.internal.ads.zzdnt
 *  com.google.android.gms.internal.ads.zzdnu
 *  com.google.android.gms.internal.ads.zzdrh
 *  com.google.android.gms.internal.ads.zzdss
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcmw;
import com.google.android.gms.internal.ads.zzcua;
import com.google.android.gms.internal.ads.zzdmu;
import com.google.android.gms.internal.ads.zzdnq;
import com.google.android.gms.internal.ads.zzdnr;
import com.google.android.gms.internal.ads.zzdns;
import com.google.android.gms.internal.ads.zzdnt;
import com.google.android.gms.internal.ads.zzdnu;
import com.google.android.gms.internal.ads.zzdrh;
import com.google.android.gms.internal.ads.zzdss;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class zzdnw {
    private final zzdss zza;
    private final zzdrh zzb;
    private final zzcua zzc;
    private final zzdmu zzd;

    public zzdnw(zzdss zzdss2, zzdrh zzdrh2, zzcua zzcua2, zzdmu zzdmu2) {
        this.zza = zzdss2;
        this.zzb = zzdrh2;
        this.zzc = zzcua2;
        this.zzd = zzdmu2;
    }

    public final View zza() throws zzcmw {
        zzcml zzcml2 = this.zza.zzb(zzbdl.zzb(), null, null);
        View view = (View)zzcml2;
        view.setVisibility(8);
        zzcml2.zzab("/sendMessageToSdk", (zzbpr)new zzdnq(this));
        zzcml2.zzab("/adMuted", (zzbpr)new zzdnr(this));
        this.zzb.zzi(new WeakReference<zzcml>(zzcml2), "/loadHtml", (zzbpr)new zzdns(this));
        this.zzb.zzi(new WeakReference<zzcml>(zzcml2), "/showOverlay", (zzbpr)new zzdnt(this));
        this.zzb.zzi(new WeakReference<zzcml>(zzcml2), "/hideOverlay", (zzbpr)new zzdnu(this));
        return view;
    }

    final /* synthetic */ void zzb(zzcml zzcml2, Map map) {
        zze.zzh((String)"Hiding native ads overlay.");
        zzcml2.zzH().setVisibility(8);
        this.zzc.zze(false);
    }

    final /* synthetic */ void zzc(zzcml zzcml2, Map map) {
        zze.zzh((String)"Showing native ads overlay.");
        zzcml2.zzH().setVisibility(0);
        this.zzc.zze(true);
    }

    final /* synthetic */ void zzd(Map map, boolean bl) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("messageType", "htmlLoaded");
        hashMap.put("id", (String)map.get("id"));
        this.zzb.zzg("sendMessageToNativeJs", hashMap);
    }

    final /* synthetic */ void zze(zzcml zzcml2, Map map) {
        this.zzd.zzw();
    }

    final /* synthetic */ void zzf(zzcml zzcml2, Map map) {
        this.zzb.zzg("sendMessageToNativeJs", map);
    }
}
