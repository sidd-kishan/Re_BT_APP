/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzna
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zzqg
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzna;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zzqg;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class zzqh {
    private final byte[] zza = new byte[10];
    private boolean zzb;
    private int zzc;
    private long zzd;
    private int zze;
    private int zzf;
    private int zzg;

    public final void zza() {
        this.zzb = false;
        this.zzc = 0;
    }

    public final void zzb(zznv object) throws IOException {
        if (this.zzb) {
            return;
        }
        byte[] byArray = this.zza;
        ((zznp)object).zzh(byArray, 0, 10, false);
        object.zzl();
        object = this.zza;
        int n = zzna.zza;
        if (object[4] != -8) return;
        if (object[5] != 114) return;
        if (object[6] != 111) return;
        if ((object[7] & 0xFE) != 186) return;
        this.zzb = true;
    }

    @RequiresNonNull(value={"#1.output"})
    public final void zzc(zzqg zzqg2, long l, int n, int n2, int n3) {
        int n4;
        if (!this.zzb) {
            return;
        }
        int n5 = this.zzc;
        this.zzc = n4 = n5 + 1;
        if (n5 == 0) {
            this.zzd = l;
            this.zze = n;
            this.zzf = 0;
        }
        this.zzf += n2;
        this.zzg = n3;
        if (n4 < 16) return;
        this.zzd(zzqg2);
    }

    @RequiresNonNull(value={"#1.output"})
    public final void zzd(zzqg zzqg2) {
        if (this.zzc <= 0) return;
        zzqg2.zzV.zzv(this.zzd, this.zze, this.zzf, this.zzg, zzqg2.zzi);
        this.zzc = 0;
    }
}
