/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzdrh
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzdrh;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsm;
import org.json.JSONObject;

final class zzdqv
implements zzfrk {
    private final zzdrh zza;
    private final String zzb;
    private final JSONObject zzc;

    zzdqv(zzdrh zzdrh2, String string, JSONObject jSONObject) {
        this.zza = zzdrh2;
        this.zzb = string;
        this.zzc = jSONObject;
    }

    public final zzfsm zza(Object object) {
        return this.zza.zzj(this.zzb, this.zzc, (zzcml)object);
    }
}
