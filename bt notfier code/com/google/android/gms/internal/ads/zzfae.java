/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.JsonReader
 *  com.google.android.gms.ads.internal.util.zzbx
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.ads.internal.util.zzbx;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzfae {
    public final String zza;
    public final String zzb;
    public final JSONObject zzc;
    public final JSONObject zzd;

    zzfae(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        jsonReader = zzbx.zzc((JsonReader)jsonReader);
        this.zzd = jsonReader;
        this.zza = jsonReader.optString("ad_html", null);
        this.zzb = this.zzd.optString("ad_base_url", null);
        this.zzc = this.zzd.optJSONObject("ad_json");
    }
}
