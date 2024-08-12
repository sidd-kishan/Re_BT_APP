/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.ads.nonagon.signalgeneration.zze
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcgi
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfac
 *  com.google.android.gms.internal.ads.zzfak
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzffg
 *  com.google.android.gms.internal.ads.zzffh
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.nonagon.signalgeneration.zze;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcgi;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfac;
import com.google.android.gms.internal.ads.zzfak;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzffg;
import com.google.android.gms.internal.ads.zzffh;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzffb {
    private final HashMap<String, String> zza = new HashMap();
    private final zzffh zzb = new zzffh(zzt.zzj());

    private zzffb() {
        this.zza.put("new_csi", "1");
    }

    public static zzffb zza(String string) {
        zzffb zzffb2 = new zzffb();
        zzffb2.zza.put("action", string);
        return zzffb2;
    }

    public static zzffb zzb(String string) {
        zzffb zzffb2 = new zzffb();
        zzffb2.zza.put("request_id", string);
        return zzffb2;
    }

    public final zzffb zzc(String string, String string2) {
        this.zza.put(string, string2);
        return this;
    }

    public final zzffb zzd(String string) {
        this.zzb.zza(string);
        return this;
    }

    public final zzffb zze(String string, String string2) {
        this.zzb.zzb(string, string2);
        return this;
    }

    public final zzffb zzf(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zza.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (!bundle.containsKey("gnt")) return this;
        this.zza.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        return this;
    }

    public final zzffb zzg(zzfal object, zzcgi object2) {
        Object object3 = object.zzb;
        this.zzh(((zzfak)object3).zzb);
        if (!((zzfak)object3).zza.isEmpty()) {
            switch (((zzezz)((zzfak)object3).zza.get((int)0)).zzb) {
                default: {
                    this.zza.put("ad_format", "unknown");
                    break;
                }
                case 6: {
                    this.zza.put("ad_format", "app_open_ad");
                    if (object2 == null) break;
                    object3 = this.zza;
                    object2 = true != object2.zzj() ? "0" : "1";
                    ((HashMap)object3).put("as", object2);
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
        object2 = zzbjl.zzfl;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)object2) == false) return this;
        boolean bl = zze.zza((zzfal)object);
        this.zza.put("scar", String.valueOf(bl));
        if (!bl) return this;
        object2 = zze.zzb((zzfal)object);
        if (!TextUtils.isEmpty((CharSequence)object2)) {
            this.zza.put("ragent", (String)object2);
        }
        if (TextUtils.isEmpty((CharSequence)(object = zze.zzc((zzfal)object)))) return this;
        this.zza.put("rtype", (String)object);
        return this;
    }

    public final zzffb zzh(zzfac zzfac2) {
        if (TextUtils.isEmpty((CharSequence)zzfac2.zzb)) return this;
        this.zza.put("gqi", zzfac2.zzb);
        return this;
    }

    public final zzffb zzi(zzezz zzezz2) {
        this.zza.put("aai", zzezz2.zzw);
        return this;
    }

    public final Map<String, String> zzj() {
        HashMap<String, String> hashMap = new HashMap<String, String>(this.zza);
        Iterator iterator = this.zzb.zzc().iterator();
        while (iterator.hasNext()) {
            zzffg zzffg2 = (zzffg)iterator.next();
            hashMap.put(zzffg2.zza, zzffg2.zzb);
        }
        return hashMap;
    }
}
