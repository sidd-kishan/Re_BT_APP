/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchk
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcnx
 *  com.google.android.gms.internal.ads.zzdqd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchk;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcnx;
import com.google.android.gms.internal.ads.zzdqd;

final class zzdpx
implements zzcnx {
    private final zzdqd zza;
    private final zzcml zzb;
    private final zzchk zzc;

    zzdpx(zzdqd zzdqd2, zzcml zzcml2, zzchk zzchk2) {
        this.zza = zzdqd2;
        this.zzb = zzcml2;
        this.zzc = zzchk2;
    }

    public final void zza(boolean bl) {
        this.zza.zzg(this.zzb, this.zzc, bl);
    }
}
