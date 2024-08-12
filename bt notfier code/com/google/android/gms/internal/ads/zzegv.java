/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzegw
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegw;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Callable;
import org.json.JSONObject;

final class zzegv
implements Callable {
    private final zzegw zza;
    private final zzfsm zzb;
    private final zzfsm zzc;
    private final zzfal zzd;
    private final zzezz zze;
    private final JSONObject zzf;

    zzegv(zzegw zzegw2, zzfsm zzfsm2, zzfsm zzfsm3, zzfal zzfal2, zzezz zzezz2, JSONObject jSONObject) {
        this.zza = zzegw2;
        this.zzb = zzfsm2;
        this.zzc = zzfsm3;
        this.zzd = zzfal2;
        this.zze = zzezz2;
        this.zzf = jSONObject;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
