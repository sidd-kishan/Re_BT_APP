/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzegw
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONArray
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegw;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsm;
import org.json.JSONArray;

final class zzegs
implements zzfrk {
    private final zzegw zza;
    private final zzfal zzb;
    private final zzezz zzc;

    zzegs(zzegw zzegw2, zzfal zzfal2, zzezz zzezz2) {
        this.zza = zzegw2;
        this.zzb = zzfal2;
        this.zzc = zzezz2;
    }

    public final zzfsm zza(Object object) {
        return this.zza.zze(this.zzb, this.zzc, (JSONArray)object);
    }
}
