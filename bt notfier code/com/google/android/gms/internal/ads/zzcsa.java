/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcsc
 *  com.google.android.gms.internal.ads.zzcsd
 *  com.google.android.gms.internal.ads.zzfaj
 *  com.google.android.gms.internal.ads.zzfal
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcsc;
import com.google.android.gms.internal.ads.zzcsd;
import com.google.android.gms.internal.ads.zzfaj;
import com.google.android.gms.internal.ads.zzfal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class zzcsa {
    private final Map<String, zzcsd> zza;
    private final Map<String, zzcsc> zzb;

    zzcsa(Map<String, zzcsd> map, Map<String, zzcsc> map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public final void zza(zzfal zzfal2) throws Exception {
        Iterator iterator = zzfal2.zzb.zzc.iterator();
        while (iterator.hasNext()) {
            Object object = (zzfaj)iterator.next();
            if (this.zza.containsKey(((zzfaj)object).zza)) {
                this.zza.get(((zzfaj)object).zza).zza(((zzfaj)object).zzb);
                continue;
            }
            if (!this.zzb.containsKey(((zzfaj)object).zza)) continue;
            zzfal2 = this.zzb.get(((zzfaj)object).zza);
            JSONObject jSONObject = ((zzfaj)object).zzb;
            object = new HashMap();
            Iterator iterator2 = jSONObject.keys();
            while (iterator2.hasNext()) {
                String string = (String)iterator2.next();
                String string2 = jSONObject.optString(string);
                if (string2 == null) continue;
                object.put(string, string2);
            }
            zzfal2.zza((Map)object);
        }
    }
}
