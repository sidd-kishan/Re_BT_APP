/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzcnx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzcnx;

final class zzdsp
implements zzcnx {
    private final zzchl zza;

    zzdsp(zzchl zzchl2) {
        this.zza = zzchl2;
    }

    public final void zza(boolean bl) {
        zzchl zzchl2 = this.zza;
        if (bl) {
            zzchl2.zzc(null);
            return;
        }
        zzchl2.zzd((Throwable)new Exception("Ad Web View failed to load."));
    }
}
