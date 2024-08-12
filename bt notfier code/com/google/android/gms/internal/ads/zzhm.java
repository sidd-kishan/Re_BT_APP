/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzhc
 *  com.google.android.gms.internal.ads.zzho
 *  com.google.android.gms.internal.ads.zzhp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzhc;
import com.google.android.gms.internal.ads.zzho;
import com.google.android.gms.internal.ads.zzhp;

final class zzhm
implements Runnable {
    private final zzho zza;
    private final zzhp zzb;
    private final zzhc zzc;

    zzhm(zzho zzho2, zzhp zzhp2, zzhc zzhc2) {
        this.zza = zzho2;
        this.zzb = zzhp2;
        this.zzc = zzhc2;
    }

    @Override
    public final void run() {
        zzho zzho2 = this.zza;
        zzhp zzhp2 = this.zzb;
        zzhc zzhc2 = this.zzc;
        zzhp2.zzG(zzho2.zza, zzho2.zzb, zzhc2);
    }
}
