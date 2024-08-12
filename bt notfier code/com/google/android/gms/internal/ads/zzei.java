/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  com.google.android.gms.internal.ads.zzged
 */
package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.android.gms.internal.ads.zzged;

final class zzei<T extends Exception> {
    private T zza;
    private long zzb;

    public zzei(long l) {
    }

    public final void zza(T t) throws T {
        long l = SystemClock.elapsedRealtime();
        if (this.zza == null) {
            this.zza = t;
            this.zzb = 100L + l;
        }
        if (l < this.zzb) return;
        T t2 = this.zza;
        if (t2 != t) {
            zzged.zza(t2, t);
        }
        t = this.zza;
        this.zza = null;
        throw t;
    }

    public final void zzb() {
        this.zza = null;
    }
}
