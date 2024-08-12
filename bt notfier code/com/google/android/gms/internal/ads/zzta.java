/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zztb
 *  com.google.android.gms.internal.ads.zzuk
 *  com.google.android.gms.internal.ads.zzun
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zztb;
import com.google.android.gms.internal.ads.zzuk;
import com.google.android.gms.internal.ads.zzun;
import java.util.Collections;
import java.util.List;

public final class zzta
implements zztb {
    private final List<zzuk> zza;
    private final zzox[] zzb;
    private boolean zzc;
    private int zzd;
    private int zze;
    private long zzf;

    public zzta(List<zzuk> list) {
        this.zza = list;
        this.zzb = new zzox[list.size()];
        this.zzf = -9223372036854775807L;
    }

    private final boolean zzf(zzamf zzamf2, int n) {
        if (zzamf2.zzd() == 0) {
            return false;
        }
        if (zzamf2.zzn() != n) {
            this.zzc = false;
        }
        --this.zzd;
        return this.zzc;
    }

    public final void zza() {
        this.zzc = false;
        this.zzf = -9223372036854775807L;
    }

    public final void zzb(zznx zznx2, zzun zzun2) {
        int n = 0;
        while (n < this.zzb.length) {
            zzuk zzuk2 = this.zza.get(n);
            zzun2.zza();
            zzox zzox2 = zznx2.zzB(zzun2.zzb(), 3);
            zzaft zzaft2 = new zzaft();
            zzaft2.zzD(zzun2.zzc());
            zzaft2.zzN("application/dvbsubs");
            zzaft2.zzP(Collections.singletonList(zzuk2.zzb));
            zzaft2.zzG(zzuk2.zza);
            zzox2.zzs(zzaft2.zzah());
            this.zzb[n] = zzox2;
            ++n;
        }
    }

    public final void zzc(long l, int n) {
        if ((n & 4) == 0) {
            return;
        }
        this.zzc = true;
        if (l != -9223372036854775807L) {
            this.zzf = l;
        }
        this.zze = 0;
        this.zzd = 2;
    }

    public final void zzd(zzamf zzamf2) {
        if (!this.zzc) return;
        if (this.zzd == 2) {
            if (!this.zzf(zzamf2, 32)) return;
        }
        int n = this.zzd;
        int n2 = 0;
        if (n == 1) {
            if (!this.zzf(zzamf2, 0)) return;
        }
        int n3 = zzamf2.zzg();
        int n4 = zzamf2.zzd();
        zzox[] zzoxArray = this.zzb;
        n = zzoxArray.length;
        while (true) {
            if (n2 >= n) {
                this.zze += n4;
                return;
            }
            zzox zzox2 = zzoxArray[n2];
            zzamf2.zzh(n3);
            zzox2.zzy(zzamf2, n4);
            ++n2;
        }
    }

    public final void zze() {
        if (!this.zzc) return;
        if (this.zzf != -9223372036854775807L) {
            zzox[] zzoxArray = this.zzb;
            int n = zzoxArray.length;
            for (int i = 0; i < n; ++i) {
                zzoxArray[i].zzv(this.zzf, 1, this.zze, 0, null);
            }
        }
        this.zzc = false;
    }
}
