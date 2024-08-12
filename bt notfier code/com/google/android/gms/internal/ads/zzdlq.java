/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdlo
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgli
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdlo;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgli;
import org.json.JSONObject;

public final class zzdlq
implements zzgla<JSONObject> {
    private final zzdlo zza;

    public zzdlq(zzdlo zzdlo2) {
        this.zza = zzdlo2;
    }

    public final JSONObject zza() {
        JSONObject jSONObject = this.zza.zza();
        zzgli.zzb((Object)jSONObject);
        return jSONObject;
    }
}
