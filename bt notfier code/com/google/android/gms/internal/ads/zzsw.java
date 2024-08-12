/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzame
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznu
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzoa
 *  com.google.android.gms.internal.ads.zzoq
 *  com.google.android.gms.internal.ads.zzos
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzsv
 *  com.google.android.gms.internal.ads.zzsx
 *  com.google.android.gms.internal.ads.zzun
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzame;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznu;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzoa;
import com.google.android.gms.internal.ads.zzoq;
import com.google.android.gms.internal.ads.zzos;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzsv;
import com.google.android.gms.internal.ads.zzsx;
import com.google.android.gms.internal.ads.zzun;
import java.io.IOException;

public final class zzsw
implements zznu {
    public static final zzoa zza = zzsv.zza;
    private final zzsx zzb = new zzsx(true, null);
    private final zzamf zzc = new zzamf(2048);
    private final zzamf zzd;
    private final zzame zze;
    private zznx zzf;
    private long zzg;
    private long zzh = -1L;
    private boolean zzi;
    private boolean zzj;

    public zzsw() {
        this(0);
    }

    public zzsw(int n) {
        Object object;
        this.zzd = object = new zzamf(10);
        object = object.zzi();
        this.zze = new zzame((byte[])object, ((zzamf)object).length);
    }

    public final boolean zza(zznv zznv2) throws IOException {
        int n;
        zznp zznp2;
        int n2 = 0;
        while (true) {
            byte[] byArray = this.zzd.zzi();
            zznp2 = (zznp)zznv2;
            zznp2.zzh(byArray, 0, 10, false);
            this.zzd.zzh(0);
            if (this.zzd.zzr() != 0x494433) {
                zznv2.zzl();
                zznp2.zzj(n2, false);
                if (this.zzh == -1L) {
                    this.zzh = n2;
                }
                break;
            }
            this.zzd.zzk(3);
            n = this.zzd.zzA();
            n2 += n + 10;
            zznp2.zzj(n, false);
        }
        n = n2;
        block1: while (true) {
            int n3 = 0;
            int n4 = 0;
            while (true) {
                zznp2.zzh(this.zzd.zzi(), 0, 2, false);
                this.zzd.zzh(0);
                if (!zzsx.zzf((int)this.zzd.zzo())) {
                    zznv2.zzl();
                    if (++n - n2 >= 8192) return false;
                    zznp2.zzj(n, false);
                    continue block1;
                }
                if (++n3 >= 4) {
                    if (n4 > 188) return true;
                }
                zznp2.zzh(this.zzd.zzi(), 0, 4, false);
                this.zze.zzd(14);
                int n5 = this.zze.zzh(13);
                if (n5 <= 6) {
                    return false;
                }
                zznp2.zzj(n5 - 6, false);
                n4 += n5;
            }
            break;
        }
    }

    public final void zzb(zznx zznx2) {
        this.zzf = zznx2;
        this.zzb.zzb(zznx2, new zzun(Integer.MIN_VALUE, 0, 1));
        zznx2.zzC();
    }

    public final int zzc(zznv zznv2, zzoq zzoq2) throws IOException {
        zzakt.zze((Object)this.zzf);
        int n = zznv2.zzg(this.zzc.zzi(), 0, 2048);
        if (!this.zzj) {
            this.zzf.zzD((zzot)new zzos(-9223372036854775807L, 0L));
            this.zzj = true;
        }
        if (n == -1) {
            return -1;
        }
        this.zzc.zzh(0);
        this.zzc.zzf(n);
        if (!this.zzi) {
            this.zzb.zzc(this.zzg, 4);
            this.zzi = true;
        }
        this.zzb.zzd(this.zzc);
        return 0;
    }

    public final void zzd(long l, long l2) {
        this.zzi = false;
        this.zzb.zza();
        this.zzg = l2;
    }
}
