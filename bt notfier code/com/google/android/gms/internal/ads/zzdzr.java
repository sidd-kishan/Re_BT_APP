/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdzv
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdzv;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import org.json.JSONException;
import org.json.JSONObject;

final class zzdzr
implements zzfrk {
    private final zzdzv zza;
    private final String zzb;
    private final String zzc;

    zzdzr(zzdzv zzdzv2, String string, String string2) {
        this.zza = zzdzv2;
        this.zzb = string;
        this.zzc = string2;
    }

    public final zzfsm zza(Object object) {
        String string = this.zzb;
        String string2 = this.zzc;
        object = (String)object;
        object = new JSONObject();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject2.put("headers", (Object)jSONObject3);
            jSONObject2.put("body", (Object)string);
            jSONObject.put("base_url", (Object)"");
            string = new JSONObject(string2);
            jSONObject.put("signals", (Object)string);
            object.put("request", (Object)jSONObject);
            object.put("response", (Object)jSONObject2);
            string2 = new JSONObject();
            object.put("flags", (Object)string2);
        }
        catch (JSONException jSONException) {
            String string3 = String.valueOf(jSONException.getMessage());
            string3 = string3.length() != 0 ? "Preloaded loader: ".concat(string3) : new String("Preloaded loader: ");
            throw new JSONException(string3);
        }
        return zzfsd.zza((Object)object);
    }
}
