/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzeog
 *  com.google.android.gms.internal.ads.zzerx
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzeog;
import com.google.android.gms.internal.ads.zzerx;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.atomic.AtomicReference;

public final class zzeoh<S extends zzerx>
implements zzery<S> {
    private final AtomicReference<zzeog<S>> zza = new AtomicReference();
    private final Clock zzb;
    private final zzery<S> zzc;
    private final long zzd;

    public zzeoh(zzery<S> zzery2, long l, Clock clock) {
        this.zzb = clock;
        this.zzc = zzery2;
        this.zzd = l;
    }

    public final zzfsm<S> zza() {
        zzeog zzeog2;
        zzeog zzeog3 = this.zza.get();
        if (zzeog3 != null) {
            zzeog2 = zzeog3;
            if (!zzeog3.zza()) return zzeog2.zza;
        }
        zzeog2 = new zzeog(this.zzc.zza(), this.zzd, this.zzb);
        this.zza.set(zzeog2);
        return zzeog2.zza;
    }
}
