/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfii
 *  com.google.android.gms.internal.ads.zzfjl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfii;
import com.google.android.gms.internal.ads.zzfjl;

final class zzaai
implements zzfjl {
    final zzfii zza;

    zzaai(zzfii zzfii2) {
        this.zza = zzfii2;
    }

    public final void zza(int n, long l) {
        this.zza.zzb(n, System.currentTimeMillis() - l);
    }

    public final void zzb(int n, long l, String string) {
        this.zza.zzf(n, System.currentTimeMillis() - l, string);
    }
}
