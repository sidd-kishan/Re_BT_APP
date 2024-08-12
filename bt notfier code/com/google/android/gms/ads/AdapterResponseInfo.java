/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.internal.ads.zzbdp
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.ads;

import android.os.Bundle;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.internal.ads.zzbdp;
import org.json.JSONException;
import org.json.JSONObject;

public final class AdapterResponseInfo {
    private final zzbdp zza;
    private final AdError zzb;

    private AdapterResponseInfo(zzbdp object) {
        this.zza = object;
        object = object.zzc;
        object = object == null ? null : object.zza();
        this.zzb = object;
    }

    public static AdapterResponseInfo zza(zzbdp zzbdp2) {
        if (zzbdp2 == null) return null;
        return new AdapterResponseInfo(zzbdp2);
    }

    public AdError getAdError() {
        return this.zzb;
    }

    public String getAdapterClassName() {
        return this.zza.zza;
    }

    public Bundle getCredentials() {
        return this.zza.zzd;
    }

    public long getLatencyMillis() {
        return this.zza.zzb;
    }

    public String toString() {
        String string;
        try {
            string = this.zzb().toString(2);
        }
        catch (JSONException jSONException) {
            string = "Error forming toString output.";
        }
        return string;
    }

    public final JSONObject zzb() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Adapter", (Object)this.zza.zza);
        jSONObject.put("Latency", this.zza.zzb);
        JSONObject jSONObject2 = new JSONObject();
        for (String string : this.zza.zzd.keySet()) {
            jSONObject2.put(string, this.zza.zzd.get(string));
        }
        jSONObject.put("Credentials", (Object)jSONObject2);
        jSONObject2 = this.zzb;
        if (jSONObject2 == null) {
            jSONObject.put("Ad Error", (Object)"null");
        } else {
            jSONObject.put("Ad Error", (Object)jSONObject2.zzb());
        }
        return jSONObject;
    }
}
