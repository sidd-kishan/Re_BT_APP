/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzdwl
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzdwl;
import org.json.JSONException;
import org.json.JSONObject;

final class zzdwk {
    private Long zza;
    private final String zzb;
    private String zzc;
    private Integer zzd;
    private String zze;
    private Integer zzf;

    /* synthetic */ zzdwk(String string, zzdwl zzdwl2) {
        this.zzb = string;
    }

    static /* synthetic */ Long zza(zzdwk zzdwk2, Long l) {
        zzdwk2.zza = l;
        return l;
    }

    static /* synthetic */ String zzb(zzdwk zzdwk2, String string) {
        zzdwk2.zzc = string;
        return string;
    }

    static /* synthetic */ Integer zzc(zzdwk zzdwk2, Integer n) {
        zzdwk2.zzd = n;
        return n;
    }

    static /* synthetic */ String zzd(zzdwk zzdwk2, String string) {
        zzdwk2.zze = string;
        return string;
    }

    static /* synthetic */ Integer zze(zzdwk zzdwk2, Integer n) {
        zzdwk2.zzf = n;
        return n;
    }

    static /* synthetic */ String zzf(zzdwk object) {
        Object object2 = zzbjl.zzgM;
        object2 = (String)zzbet.zzc().zzc(object2);
        Object object3 = new JSONObject();
        try {
            object3.putOpt("objectId", (Object)((zzdwk)object).zza);
            object3.put("eventCategory", (Object)((zzdwk)object).zzb);
            object3.putOpt("event", (Object)((zzdwk)object).zzc);
            object3.putOpt("errorCode", (Object)((zzdwk)object).zzd);
            object3.putOpt("rewardType", (Object)((zzdwk)object).zze);
            object3.putOpt("rewardAmount", (Object)((zzdwk)object).zzf);
        }
        catch (JSONException jSONException) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"Could not convert parameters to JSON.");
        }
        object3 = object3.toString();
        object = new StringBuilder(String.valueOf(object2).length() + 16 + String.valueOf(object3).length());
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append("(\"h5adsEvent\",");
        ((StringBuilder)object).append((String)object3);
        ((StringBuilder)object).append(");");
        return ((StringBuilder)object).toString();
    }
}
