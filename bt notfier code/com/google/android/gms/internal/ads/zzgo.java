/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzfa
 *  com.google.android.gms.internal.ads.zzfb
 *  com.google.android.gms.internal.ads.zzgq
 *  com.google.android.gms.internal.ads.zzgx
 *  com.google.android.gms.internal.ads.zzhc
 *  com.google.android.gms.internal.ads.zzhf
 *  com.google.android.gms.internal.ads.zzho
 *  com.google.android.gms.internal.ads.zzhp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzfa;
import com.google.android.gms.internal.ads.zzfb;
import com.google.android.gms.internal.ads.zzgq;
import com.google.android.gms.internal.ads.zzgx;
import com.google.android.gms.internal.ads.zzhc;
import com.google.android.gms.internal.ads.zzhf;
import com.google.android.gms.internal.ads.zzho;
import com.google.android.gms.internal.ads.zzhp;
import java.io.IOException;

final class zzgo
implements zzhp,
zzfb {
    final zzgq zza;
    private final Object zzb;
    private zzho zzc;
    private zzfa zzd;

    public zzgo(zzgq zzgq2, Object object) {
        this.zza = zzgq2;
        this.zzc = zzgq2.zzf(null);
        this.zzd = zzgq2.zzh(null);
        this.zzb = object;
    }

    private final boolean zza(int n, zzhf zzhf2) {
        if (zzhf2 != null) {
            if ((zzhf2 = this.zza.zzx(this.zzb, zzhf2)) == null) return false;
        } else {
            zzhf2 = null;
        }
        zzho zzho2 = this.zzc;
        if (zzho2.zza != n || !zzamq.zzc((Object)zzho2.zzb, (Object)zzhf2)) {
            this.zzc = this.zza.zzg(n, zzhf2, 0L);
        }
        zzho2 = this.zzd;
        if (zzho2.zza == n) {
            if (zzamq.zzc((Object)zzho2.zzb, (Object)zzhf2)) return true;
        }
        this.zzd = this.zza.zzi(n, zzhf2);
        return true;
    }

    public final void zzC(int n, zzhf zzhf2, zzgx zzgx2, zzhc zzhc2) {
        if (!this.zza(n, zzhf2)) return;
        this.zzc.zze(zzgx2, zzhc2);
    }

    public final void zzD(int n, zzhf zzhf2, zzgx zzgx2, zzhc zzhc2) {
        if (!this.zza(n, zzhf2)) return;
        this.zzc.zzg(zzgx2, zzhc2);
    }

    public final void zzE(int n, zzhf zzhf2, zzgx zzgx2, zzhc zzhc2) {
        if (!this.zza(n, zzhf2)) return;
        this.zzc.zzi(zzgx2, zzhc2);
    }

    public final void zzF(int n, zzhf zzhf2, zzgx zzgx2, zzhc zzhc2, IOException iOException, boolean bl) {
        if (!this.zza(n, zzhf2)) return;
        this.zzc.zzk(zzgx2, zzhc2, iOException, bl);
    }

    public final void zzG(int n, zzhf zzhf2, zzhc zzhc2) {
        if (!this.zza(n, zzhf2)) return;
        this.zzc.zzm(zzhc2);
    }
}
