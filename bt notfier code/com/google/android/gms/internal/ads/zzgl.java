/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaf
 *  com.google.android.gms.internal.ads.zzafw
 *  com.google.android.gms.internal.ads.zzgm
 *  com.google.android.gms.internal.ads.zziu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaf;
import com.google.android.gms.internal.ads.zzafw;
import com.google.android.gms.internal.ads.zzgm;
import com.google.android.gms.internal.ads.zziu;
import java.io.IOException;

final class zzgl
implements zziu {
    public final zziu zza;
    final zzgm zzb;
    private boolean zzc;

    public zzgl(zzgm zzgm2, zziu zziu2) {
        this.zzb = zzgm2;
        this.zza = zziu2;
    }

    public final void zza() {
        this.zzc = false;
    }

    public final boolean zzb() {
        if (this.zzb.zzo()) return false;
        if (!this.zza.zzb()) return false;
        return true;
    }

    public final void zzc() throws IOException {
        this.zza.zzc();
    }

    public final int zzd(zzafw zzafw2, zzaf zzaf2, int n) {
        if (this.zzb.zzo()) {
            return -3;
        }
        if (this.zzc) {
            zzaf2.zzf(4);
            return -4;
        }
        if ((n = this.zza.zzd(zzafw2, zzaf2, n)) == -5) {
            zzaf2 = zzafw2.zza;
            if (zzaf2 == null) throw null;
            int n2 = zzaf2.zzB;
            int n3 = 0;
            n = n2;
            if (n2 == 0) {
                if (zzaf2.zzC == 0) return -5;
                n = 0;
            }
            if (this.zzb.zzb == Long.MIN_VALUE) {
                n3 = zzaf2.zzC;
            }
            zzaf2 = zzaf2.zza();
            zzaf2.zzad(n);
            zzaf2.zzae(n3);
            zzafw2.zza = zzaf2.zzah();
            return -5;
        }
        zzafw2 = this.zzb;
        long l = zzafw2.zzb;
        if (l == Long.MIN_VALUE) return n;
        if (n != -4 || zzaf2.zzd < l) {
            if (n != -3) return n;
            if (zzafw2.zzh() != Long.MIN_VALUE) return n;
            if (zzaf2.zzc) return n;
        }
        zzaf2.zza();
        zzaf2.zzf(4);
        this.zzc = true;
        return -4;
    }

    public final int zze(long l) {
        if (!this.zzb.zzo()) return this.zza.zze(l);
        return -3;
    }
}
