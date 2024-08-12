/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzffu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzffu;
import java.util.List;

public final class zzdis {
    private final List<String> zza;
    private final zzffu zzb;
    private boolean zzc;

    public zzdis(zzezz zzezz2, zzffu zzffu2) {
        this.zza = zzezz2.zzp;
        this.zzb = zzffu2;
    }

    public final void zza() {
        if (this.zzc) return;
        this.zzb.zza(this.zza);
        this.zzc = true;
    }
}
