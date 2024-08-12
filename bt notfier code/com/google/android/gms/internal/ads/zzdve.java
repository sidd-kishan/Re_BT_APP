/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 *  com.google.android.gms.ads.nonagon.signalgeneration.zze
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcgi
 *  com.google.android.gms.internal.ads.zzdvn
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.nonagon.signalgeneration.zze;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcgi;
import com.google.android.gms.internal.ads.zzdvn;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
public final class zzdve {
    private final ConcurrentHashMap<String, String> zza;
    private final zzcgi zzb;

    public zzdve(zzdvn zzdvn2, zzcgi zzcgi2) {
        this.zza = new ConcurrentHashMap(zzdvn2.zzb);
        this.zzb = zzcgi2;
    }

    public final void zza(zzfal object) {
        Object object2;
        if (object.zzb.zza.size() > 0) {
            switch (((zzezz)object.zzb.zza.get((int)0)).zzb) {
                default: {
                    this.zza.put("ad_format", "unknown");
                    break;
                }
                case 6: {
                    this.zza.put("ad_format", "app_open_ad");
                    ConcurrentHashMap<String, String> concurrentHashMap = this.zza;
                    object2 = true != this.zzb.zzj() ? "0" : "1";
                    concurrentHashMap.put("as", (String)object2);
                    break;
                }
                case 5: {
                    this.zza.put("ad_format", "rewarded");
                    break;
                }
                case 4: {
                    this.zza.put("ad_format", "native_advanced");
                    break;
                }
                case 3: {
                    this.zza.put("ad_format", "native_express");
                    break;
                }
                case 2: {
                    this.zza.put("ad_format", "interstitial");
                    break;
                }
                case 1: {
                    this.zza.put("ad_format", "banner");
                }
            }
        }
        if (!TextUtils.isEmpty((CharSequence)object.zzb.zzb.zzb)) {
            this.zza.put("gqi", object.zzb.zzb.zzb);
        }
        object2 = zzbjl.zzfl;
        if ((Boolean)zzbet.zzc().zzc(object2) == false) return;
        boolean bl = zze.zza((zzfal)object);
        this.zza.put("scar", String.valueOf(bl));
        if (!bl) return;
        object2 = zze.zzb((zzfal)object);
        if (!TextUtils.isEmpty((CharSequence)object2)) {
            this.zza.put("ragent", (String)object2);
        }
        if (TextUtils.isEmpty((CharSequence)(object = zze.zzc((zzfal)object)))) return;
        this.zza.put("rtype", (String)object);
    }

    public final void zzb(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zza.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (!bundle.containsKey("gnt")) return;
        this.zza.put("network_fine", Integer.toString(bundle.getInt("gnt")));
    }

    public final Map<String, String> zzc() {
        return this.zza;
    }
}
