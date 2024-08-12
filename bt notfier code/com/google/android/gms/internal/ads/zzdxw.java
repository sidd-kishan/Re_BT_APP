/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

final class zzdxw {
    private final String zza;
    private final String zzb;
    private final int zzc;
    private final String zzd;
    private final int zze;

    public zzdxw(String string, String string2, int n, String string3, int n2) {
        this.zza = string;
        this.zzb = string2;
        this.zzc = n;
        this.zzd = string3;
        this.zze = n2;
    }

    public final JSONObject zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("adapterClassName", (Object)this.zza);
        jSONObject.put("version", (Object)this.zzb);
        jSONObject.put("status", this.zzc);
        jSONObject.put("description", (Object)this.zzd);
        jSONObject.put("initializationLatencyMillis", this.zze);
        return jSONObject;
    }
}
