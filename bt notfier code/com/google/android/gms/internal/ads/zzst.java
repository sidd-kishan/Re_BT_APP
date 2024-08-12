/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zznd
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznu
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzoa
 *  com.google.android.gms.internal.ads.zzoq
 *  com.google.android.gms.internal.ads.zzos
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzss
 *  com.google.android.gms.internal.ads.zzsu
 *  com.google.android.gms.internal.ads.zzun
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zznd;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznu;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzoa;
import com.google.android.gms.internal.ads.zzoq;
import com.google.android.gms.internal.ads.zzos;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzss;
import com.google.android.gms.internal.ads.zzsu;
import com.google.android.gms.internal.ads.zzun;
import java.io.IOException;

public final class zzst
implements zznu {
    public static final zzoa zza = zzss.zza;
    private final zzsu zzb = new zzsu(null);
    private final zzamf zzc = new zzamf(16384);
    private boolean zzd;

    public final boolean zza(zznv zznv2) throws IOException {
        int n;
        zznp zznp2;
        byte[] byArray;
        zzamf zzamf2 = new zzamf(10);
        int n2 = 0;
        while (true) {
            byArray = zzamf2.zzi();
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
        int n3 = n2;
        block1: while (true) {
            n = 0;
            while (true) {
                byArray = zzamf2.zzi();
                int n4 = 7;
                zznp2.zzh(byArray, 0, 7, false);
                zzamf2.zzh(0);
                int n5 = zzamf2.zzo();
                if (n5 != 44096 && n5 != 44097) {
                    zznv2.zzl();
                    if (++n3 - n2 >= 8192) return false;
                    zznp2.zzj(n3, false);
                    continue block1;
                }
                int n6 = n + 1;
                if (n6 >= 4) {
                    return true;
                }
                byArray = zzamf2.zzi();
                n = zznd.zza;
                if (byArray.length < 7) {
                    n = -1;
                } else {
                    int n7 = (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
                    if (n7 == 65535) {
                        n7 = (byArray[4] & 0xFF) << 16 | (byArray[5] & 0xFF) << 8 | byArray[6] & 0xFF;
                        n = n4;
                        n4 = n7;
                    } else {
                        n = 4;
                        n4 = n7;
                    }
                    n7 = n;
                    if (n5 == 44097) {
                        n7 = n + 2;
                    }
                    n = n4 + n7;
                }
                if (n == -1) {
                    return false;
                }
                zznp2.zzj(n - 7, false);
                n = n6;
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
        int n = zznv2.zzg(this.zzc.zzi(), 0, 16384);
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
