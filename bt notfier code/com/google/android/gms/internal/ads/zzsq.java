/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzna
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznu
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzoa
 *  com.google.android.gms.internal.ads.zzoq
 *  com.google.android.gms.internal.ads.zzos
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzsp
 *  com.google.android.gms.internal.ads.zzsr
 *  com.google.android.gms.internal.ads.zzun
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzna;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznu;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzoa;
import com.google.android.gms.internal.ads.zzoq;
import com.google.android.gms.internal.ads.zzos;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzsp;
import com.google.android.gms.internal.ads.zzsr;
import com.google.android.gms.internal.ads.zzun;
import java.io.IOException;

public final class zzsq
implements zznu {
    public static final zzoa zza = zzsp.zza;
    private final zzsr zzb = new zzsr(null);
    private final zzamf zzc = new zzamf(2786);
    private boolean zzd;

    public final boolean zza(zznv zznv2) throws IOException {
        int n;
        zznp zznp2;
        zzamf zzamf2 = new zzamf(10);
        int n2 = 0;
        while (true) {
            byte[] byArray = zzamf2.zzi();
            zznp2 = (zznp)zznv2;
            zznp2.zzh(byArray, 0, 10, false);
            zzamf2.zzh(0);
            if (zzamf2.zzr() != 0x494433) break;
            zzamf2.zzk(3);
            n = zzamf2.zzA();
            n2 += n + 10;
            zznp2.zzj(n, false);
        }
        zznv2.zzl();
        zznp2.zzj(n2, false);
        n = n2;
        block1: while (true) {
            int n3 = 0;
            while (true) {
                zznp2.zzh(zzamf2.zzi(), 0, 6, false);
                zzamf2.zzh(0);
                if (zzamf2.zzo() != 2935) {
                    zznv2.zzl();
                    if (++n - n2 >= 8192) return false;
                    zznp2.zzj(n, false);
                    continue block1;
                }
                if (++n3 >= 4) {
                    return true;
                }
                int n4 = zzna.zzd((byte[])zzamf2.zzi());
                if (n4 == -1) {
                    return false;
                }
                zznp2.zzj(n4 - 6, false);
            }
            break;
        }
    }

    public final void zzb(zznx zznx2) {
        this.zzb.zzb(zznx2, new zzun(Integer.MIN_VALUE, 0, 1));
        zznx2.zzC();
        zznx2.zzD((zzot)new zzos(-9223372036854775807L, 0L));
    }

    public final int zzc(zznv zznv2, zzoq zzoq2) throws IOException {
        int n = zznv2.zzg(this.zzc.zzi(), 0, 2786);
        if (n == -1) {
            return -1;
        }
        this.zzc.zzh(0);
        this.zzc.zzf(n);
        if (!this.zzd) {
            this.zzb.zzc(0L, 4);
            this.zzd = true;
        }
        this.zzb.zzd(this.zzc);
        return 0;
    }

    public final void zzd(long l, long l2) {
        this.zzd = false;
        this.zzb.zza();
    }
}
