/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgx
 *  com.google.android.gms.internal.ads.zzhc
 *  com.google.android.gms.internal.ads.zzho
 *  com.google.android.gms.internal.ads.zzhp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgx;
import com.google.android.gms.internal.ads.zzhc;
import com.google.android.gms.internal.ads.zzho;
import com.google.android.gms.internal.ads.zzhp;

final class zzhk
implements Runnable {
    private final zzho zza;
    private final zzhp zzb;
    private final zzgx zzc;
    private final zzhc zzd;

    zzhk(zzho zzho2, zzhp zzhp2, zzgx zzgx2, zzhc zzhc2) {
        this.zza = zzho2;
        this.zzb = zzhp2;
        this.zzc = zzgx2;
        this.zzd = zzhc2;
    }

    @Override
    public final void run() {
        zzho zzho2 = this.zza;
        zzhp zzhp2 = this.zzb;
        zzgx zzgx2 = this.zzc;
        zzhc zzhc2 = this.zzd;
        zzhp2.zzE(zzho2.zza, zzho2.zzb, zzgx2, zzhc2);
    }
}
