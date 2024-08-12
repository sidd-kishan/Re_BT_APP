/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzi
 *  com.google.android.gms.internal.ads.zzfjl
 */
package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.internal.ads.zzfjl;

final class zzh
implements zzfjl {
    final zzi zza;

    zzh(zzi zzi2) {
        this.zza = zzi2;
    }

    public final void zza(int n, long l) {
        zzi.zza((zzi)this.zza).zzb(n, System.currentTimeMillis() - l);
    }

    public final void zzb(int n, long l, String string) {
        zzi.zza((zzi)this.zza).zzf(n, System.currentTimeMillis() - l, string);
    }
}
