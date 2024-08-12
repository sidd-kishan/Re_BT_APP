/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcbm
 *  com.google.android.gms.internal.ads.zzebw
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcbm;
import com.google.android.gms.internal.ads.zzebw;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Callable;
import org.json.JSONObject;

final class zzebb
implements Callable {
    private final zzfsm zza;
    private final zzfsm zzb;

    zzebb(zzfsm zzfsm2, zzfsm zzfsm3) {
        this.zza = zzfsm2;
        this.zzb = zzfsm3;
    }

    public final Object call() {
        zzfsm zzfsm2 = this.zza;
        zzfsm zzfsm3 = this.zzb;
        return new zzebw((JSONObject)zzfsm2.get(), (zzcbm)zzfsm3.get());
    }
}
