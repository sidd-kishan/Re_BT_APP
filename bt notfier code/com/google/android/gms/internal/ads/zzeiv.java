/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbxn
 *  com.google.android.gms.internal.ads.zzdcm
 *  com.google.android.gms.internal.ads.zzeee
 *  com.google.android.gms.internal.ads.zzeef
 *  com.google.android.gms.internal.ads.zzefy
 *  com.google.android.gms.internal.ads.zzejz
 *  com.google.android.gms.internal.ads.zzfaw
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbxn;
import com.google.android.gms.internal.ads.zzdcm;
import com.google.android.gms.internal.ads.zzeee;
import com.google.android.gms.internal.ads.zzeef;
import com.google.android.gms.internal.ads.zzefy;
import com.google.android.gms.internal.ads.zzejz;
import com.google.android.gms.internal.ads.zzfaw;
import org.json.JSONObject;

public final class zzeiv
implements zzeee<zzbxn, zzefy> {
    private final zzejz zza;

    public zzeiv(zzejz zzejz2) {
        this.zza = zzejz2;
    }

    public final zzeef<zzbxn, zzefy> zza(String string, JSONObject jSONObject) throws zzfaw {
        jSONObject = this.zza.zzb(string);
        if (jSONObject != null) return new zzeef((Object)jSONObject, (zzdcm)new zzefy(), string);
        return null;
    }
}
