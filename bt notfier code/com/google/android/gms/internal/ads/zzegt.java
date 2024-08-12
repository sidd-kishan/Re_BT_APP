/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdrh
 *  com.google.android.gms.internal.ads.zzegw
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrh;
import com.google.android.gms.internal.ads.zzegw;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsm;
import org.json.JSONObject;

final class zzegt
implements zzfrk {
    private final zzegw zza;
    private final zzdrh zzb;

    zzegt(zzegw zzegw2, zzdrh zzdrh2) {
        this.zza = zzegw2;
        this.zzb = zzdrh2;
    }

    public final zzfsm zza(Object object) {
        return this.zza.zzd(this.zzb, (JSONObject)object);
    }
}
