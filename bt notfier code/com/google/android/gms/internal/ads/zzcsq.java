/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzced
 *  com.google.android.gms.internal.ads.zzcsd
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzced;
import com.google.android.gms.internal.ads.zzcsd;
import org.json.JSONObject;

final class zzcsq
implements zzcsd {
    private final zzced zza;

    zzcsq(zzced zzced2) {
        this.zza = zzced2;
    }

    public final void zza(JSONObject jSONObject) {
        long l = jSONObject.optLong("timestamp");
        int n = jSONObject.optBoolean("npa_reset") ? -1 : (int)(jSONObject.optBoolean("npa") ? 1 : 0);
        this.zza.zzd(n, l);
    }
}
