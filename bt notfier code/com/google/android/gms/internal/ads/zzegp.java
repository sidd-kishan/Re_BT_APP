/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdcm
 *  com.google.android.gms.internal.ads.zzdtf
 *  com.google.android.gms.internal.ads.zzeee
 *  com.google.android.gms.internal.ads.zzeef
 *  com.google.android.gms.internal.ads.zzefy
 *  com.google.android.gms.internal.ads.zzfaw
 *  com.google.android.gms.internal.ads.zzfbi
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdcm;
import com.google.android.gms.internal.ads.zzdtf;
import com.google.android.gms.internal.ads.zzeee;
import com.google.android.gms.internal.ads.zzeef;
import com.google.android.gms.internal.ads.zzefy;
import com.google.android.gms.internal.ads.zzfaw;
import com.google.android.gms.internal.ads.zzfbi;
import org.json.JSONObject;

public final class zzegp
implements zzeee<zzfbi, zzefy> {
    private final zzdtf zza;

    public zzegp(zzdtf zzdtf2) {
        this.zza = zzdtf2;
    }

    public final zzeef<zzfbi, zzefy> zza(String string, JSONObject jSONObject) throws zzfaw {
        return new zzeef((Object)this.zza.zzb(string, jSONObject), (zzdcm)new zzefy(), string);
    }
}
