/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcvh
 *  com.google.android.gms.internal.ads.zzeko
 *  com.google.android.gms.internal.ads.zzelx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcvh;
import com.google.android.gms.internal.ads.zzeko;
import com.google.android.gms.internal.ads.zzelx;

final class zzekn
implements zzelx<zzcvh> {
    final zzeko zza;

    zzekn(zzeko zzeko2) {
        this.zza = zzeko2;
    }

    public final void zza() {
        zzeko zzeko2 = this.zza;
        synchronized (zzeko2) {
            zzeko.zzc((zzeko)this.zza, null);
            return;
        }
    }
}
