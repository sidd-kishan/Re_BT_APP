/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdcm
 *  com.google.android.gms.internal.ads.zzdtf
 *  com.google.android.gms.internal.ads.zzeee
 *  com.google.android.gms.internal.ads.zzeef
 *  com.google.android.gms.internal.ads.zzefz
 *  com.google.android.gms.internal.ads.zzfaw
 *  com.google.android.gms.internal.ads.zzfbi
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdcm;
import com.google.android.gms.internal.ads.zzdtf;
import com.google.android.gms.internal.ads.zzeee;
import com.google.android.gms.internal.ads.zzeef;
import com.google.android.gms.internal.ads.zzefz;
import com.google.android.gms.internal.ads.zzfaw;
import com.google.android.gms.internal.ads.zzfbi;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class zzeif
implements zzeee<zzfbi, zzefz> {
    private final Map<String, zzeef<zzfbi, zzefz>> zza = new HashMap<String, zzeef<zzfbi, zzefz>>();
    private final zzdtf zzb;

    public zzeif(zzdtf zzdtf2) {
        this.zzb = zzdtf2;
    }

    public final zzeef<zzfbi, zzefz> zza(String string, JSONObject jSONObject) throws zzfaw {
        synchronized (this) {
            zzeef zzeef2;
            zzeef zzeef3 = zzeef2 = this.zza.get(string);
            if (zzeef2 != null) return zzeef3;
            jSONObject = this.zzb.zzb(string, jSONObject);
            zzeef2 = new zzefz();
            zzeef3 = new zzeef((Object)jSONObject, (zzdcm)zzeef2, string);
            this.zza.put(string, (zzeef<zzfbi, zzefz>)zzeef3);
            return zzeef3;
        }
    }
}
