/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaza
 *  com.google.android.gms.internal.ads.zzbao
 *  com.google.android.gms.internal.ads.zzbct
 *  com.google.android.gms.internal.ads.zzbcu
 *  com.google.android.gms.internal.ads.zzcne
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzbct;
import com.google.android.gms.internal.ads.zzbcu;
import com.google.android.gms.internal.ads.zzcne;

final class zzcnb
implements zzaza {
    private final boolean zza;
    private final int zzb;

    zzcnb(boolean bl, int n) {
        this.zza = bl;
        this.zzb = n;
    }

    public final void zza(zzbao zzbao2) {
        boolean bl = this.zza;
        int n = this.zzb;
        int n2 = zzcne.zza;
        zzbct zzbct2 = zzbcu.zzc();
        if (zzbct2.zza() != bl) {
            zzbct2.zzb(bl);
        }
        zzbct2.zzc(n);
        zzbao2.zzj((zzbcu)zzbct2.zzah());
    }
}
