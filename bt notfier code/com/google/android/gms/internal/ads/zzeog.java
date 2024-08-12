/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzerx
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzerx;
import com.google.android.gms.internal.ads.zzfsm;

final class zzeog<S extends zzerx<?>> {
    public final zzfsm<S> zza;
    private final long zzb;
    private final Clock zzc;

    public zzeog(zzfsm<S> zzfsm2, long l, Clock clock) {
        this.zza = zzfsm2;
        this.zzc = clock;
        this.zzb = clock.elapsedRealtime() + l;
    }

    public final boolean zza() {
        if (this.zzb >= this.zzc.elapsedRealtime()) return false;
        return true;
    }
}
