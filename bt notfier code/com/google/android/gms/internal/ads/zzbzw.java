/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final class zzbzw {
    public final boolean zza;
    public final String zzb;

    public zzbzw(boolean bl, String string) {
        this.zza = bl;
        this.zzb = string;
    }

    public static zzbzw zza(JSONObject jSONObject) {
        return new zzbzw(jSONObject.optBoolean("enable_prewarming", false), jSONObject.optString("prefetch_url", ""));
    }
}
