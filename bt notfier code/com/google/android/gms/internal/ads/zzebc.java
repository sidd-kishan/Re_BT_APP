/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcbm
 *  com.google.android.gms.internal.ads.zzebp
 *  com.google.android.gms.internal.ads.zzebt
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcbm;
import com.google.android.gms.internal.ads.zzebp;
import com.google.android.gms.internal.ads.zzebt;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Callable;
import org.json.JSONObject;

final class zzebc
implements Callable {
    private final zzfsm zza;
    private final zzfsm zzb;
    private final zzfsm zzc;

    zzebc(zzfsm zzfsm2, zzfsm zzfsm3, zzfsm zzfsm4) {
        this.zza = zzfsm2;
        this.zzb = zzfsm3;
        this.zzc = zzfsm4;
    }

    public final Object call() {
        zzfsm zzfsm2 = this.zza;
        zzfsm zzfsm3 = this.zzb;
        zzfsm zzfsm4 = this.zzc;
        return new zzebp((zzebt)zzfsm2.get(), (JSONObject)zzfsm3.get(), (zzcbm)zzfsm4.get());
    }
}
