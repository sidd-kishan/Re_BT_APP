/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.ResponseInfo
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.ads;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import org.json.JSONException;
import org.json.JSONObject;

public final class LoadAdError
extends AdError {
    private final ResponseInfo zza;

    public LoadAdError(int n, String string, String string2, AdError adError, ResponseInfo responseInfo) {
        super(n, string, string2, adError);
        this.zza = responseInfo;
    }

    public ResponseInfo getResponseInfo() {
        zzbjd zzbjd2 = zzbjl.zzfX;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return null;
        return this.zza;
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
        JSONObject jSONObject = super.zzb();
        ResponseInfo responseInfo = this.getResponseInfo();
        if (responseInfo == null) {
            jSONObject.put("Response Info", (Object)"null");
        } else {
            jSONObject.put("Response Info", (Object)responseInfo.zza());
        }
        return jSONObject;
    }
}
