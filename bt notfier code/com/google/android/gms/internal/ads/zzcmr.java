/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.overlay.zzo
 *  com.google.android.gms.internal.ads.zzcml
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.internal.ads.zzcml;

final class zzcmr
implements zzo {
    private final zzcml zza;
    private final zzo zzb;

    public zzcmr(zzcml zzcml2, zzo zzo2) {
        this.zza = zzcml2;
        this.zzb = zzo2;
    }

    public final void zzbp() {
        zzo zzo2 = this.zzb;
        if (zzo2 != null) {
            zzo2.zzbp();
        }
        this.zza.zzK();
    }

    public final void zzbq() {
    }

    public final void zzbr() {
    }

    public final void zzbs(int n) {
        zzo zzo2 = this.zzb;
        if (zzo2 != null) {
            zzo2.zzbs(n);
        }
        this.zza.zzI();
    }

    public final void zzd() {
        zzo zzo2 = this.zzb;
        if (zzo2 == null) return;
        zzo2.zzd();
    }

    public final void zze() {
        zzo zzo2 = this.zzb;
        if (zzo2 == null) return;
        zzo2.zze();
    }
}
