/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zzny
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zzny;
import java.io.IOException;

final class zzsg {
    public int zza;
    public long zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public final int[] zzf = new int[255];
    private final zzamf zzg = new zzamf(255);

    zzsg() {
    }

    public final void zza() {
        this.zza = 0;
        this.zzb = 0L;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = 0;
    }

    public final boolean zzb(zznv zznv2, long l) throws IOException {
        boolean bl = zznv2.zzn() == zznv2.zzm();
        zzakt.zza((boolean)bl);
        this.zzg.zza(4);
        while ((l == -1L || zznv2.zzn() + 4L < l) && zzny.zze((zznv)zznv2, (byte[])this.zzg.zzi(), (int)0, (int)4, (boolean)true)) {
            this.zzg.zzh(0);
            if (this.zzg.zzt() == 1332176723L) {
                zznv2.zzl();
                return true;
            }
            ((zznp)zznv2).zzd(1, false);
        }
        do {
            if (l == -1L) continue;
            if (zznv2.zzn() >= l) return false;
        } while (zznv2.zzc(1) != -1);
        return false;
    }

    public final boolean zzc(zznv zznv2, boolean bl) throws IOException {
        int n;
        this.zza();
        this.zzg.zza(27);
        byte[] byArray = this.zzg.zzi();
        int n2 = 0;
        if (!zzny.zze((zznv)zznv2, (byte[])byArray, (int)0, (int)27, (boolean)bl)) return false;
        if (this.zzg.zzt() != 1332176723L) {
            return false;
        }
        if (this.zzg.zzn() != 0) {
            if (!bl) throw zzaha.zzc((String)"unsupported bit stream revision");
            return false;
        }
        this.zza = this.zzg.zzn();
        this.zzb = this.zzg.zzy();
        this.zzg.zzu();
        this.zzg.zzu();
        this.zzg.zzu();
        this.zzc = n = this.zzg.zzn();
        this.zzd = n + 27;
        this.zzg.zza(n);
        if (!zzny.zze((zznv)zznv2, (byte[])this.zzg.zzi(), (int)0, (int)this.zzc, (boolean)bl)) return false;
        while (n2 < this.zzc) {
            this.zzf[n2] = this.zzg.zzn();
            this.zze += this.zzf[n2];
            ++n2;
        }
        return true;
    }
}
