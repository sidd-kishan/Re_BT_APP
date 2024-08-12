/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbcz
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzbcz;
import org.json.JSONException;
import org.json.JSONObject;

public class AdError {
    public static final String UNDEFINED_DOMAIN = "undefined";
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final AdError zzd;

    public AdError(int n, String string, String string2) {
        this(n, string, string2, null);
    }

    public AdError(int n, String string, String string2, AdError adError) {
        this.zza = n;
        this.zzb = string;
        this.zzc = string2;
        this.zzd = adError;
    }

    public AdError getCause() {
        return this.zzd;
    }

    public int getCode() {
        return this.zza;
    }

    public String getDomain() {
        return this.zzc;
    }

    public String getMessage() {
        return this.zzb;
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

    public final zzbcz zza() {
        AdError adError = this.zzd;
        adError = adError == null ? null : new zzbcz(adError.zza, adError.zzb, adError.zzc, null, null);
        return new zzbcz(this.zza, this.zzb, this.zzc, (zzbcz)adError, null);
    }

    public JSONObject zzb() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Code", this.zza);
        jSONObject.put("Message", (Object)this.zzb);
        jSONObject.put("Domain", (Object)this.zzc);
        AdError adError = this.zzd;
        if (adError == null) {
            jSONObject.put("Cause", (Object)"null");
        } else {
            jSONObject.put("Cause", (Object)adError.zzb());
        }
        return jSONObject;
    }
}
