/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchk
 *  com.google.android.gms.internal.ads.zzcnx
 *  com.google.android.gms.internal.ads.zzehs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchk;
import com.google.android.gms.internal.ads.zzcnx;
import com.google.android.gms.internal.ads.zzehs;

final class zzdpb
implements zzcnx {
    private final zzchk zza;

    zzdpb(zzchk zzchk2) {
        this.zza = zzchk2;
    }

    public final void zza(boolean bl) {
        zzchk zzchk2 = this.zza;
        if (bl) {
            zzchk2.zzb();
            return;
        }
        zzchk2.zzd((Throwable)new zzehs(1, "Image Web View failed to load."));
    }
}
