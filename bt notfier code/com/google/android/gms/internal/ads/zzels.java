/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzelt
 *  com.google.android.gms.internal.ads.zzelx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzelt;
import com.google.android.gms.internal.ads.zzelx;

final class zzels
implements zzelx<zzcxg> {
    final zzelt zza;

    zzels(zzelt zzelt2) {
        this.zza = zzelt2;
    }

    public final void zza() {
        zzelt zzelt2 = this.zza;
        synchronized (zzelt2) {
            return;
        }
    }
}
