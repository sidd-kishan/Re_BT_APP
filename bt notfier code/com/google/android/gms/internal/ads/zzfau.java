/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final class zzfau {
    private final JSONObject zza;

    public zzfau(JSONObject jSONObject) {
        this.zza = jSONObject;
    }

    public final String zza() {
        if (this.zzb() - 1 == 1) return null;
        return "javascript";
    }

    public final int zzb() {
        int n = this.zza.optInt("media_type", -1);
        if (n == 0) return 2;
        if (n == 1) return 1;
        return 3;
    }
}
