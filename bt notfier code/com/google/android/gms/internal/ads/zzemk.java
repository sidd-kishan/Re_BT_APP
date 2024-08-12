/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzeml
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzeml;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;

public final class zzemk
implements zzery<zzeml> {
    private final Clock zza;
    private final zzfar zzb;

    zzemk(Clock clock, zzfar zzfar2) {
        this.zza = clock;
        this.zzb = zzfar2;
    }

    public final zzfsm<zzeml> zza() {
        return zzfsd.zza((Object)new zzeml(this.zzb, this.zza.currentTimeMillis()));
    }
}
