/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzdqd
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzdqd;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsm;
import org.json.JSONObject;

final class zzdps
implements zzfrk {
    private final zzdqd zza;
    private final JSONObject zzb;

    zzdps(zzdqd zzdqd2, JSONObject jSONObject) {
        this.zza = zzdqd2;
        this.zzb = jSONObject;
    }

    public final zzfsm zza(Object object) {
        return this.zza.zzf(this.zzb, (zzcml)object);
    }
}
