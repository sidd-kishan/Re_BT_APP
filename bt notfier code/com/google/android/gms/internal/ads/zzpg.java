/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zznj
 *  com.google.android.gms.internal.ads.zznk
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zzny
 *  com.google.android.gms.internal.ads.zzob
 *  com.google.android.gms.internal.ads.zzoc
 *  com.google.android.gms.internal.ads.zzoh
 *  com.google.android.gms.internal.ads.zzph
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zznj;
import com.google.android.gms.internal.ads.zznk;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zzny;
import com.google.android.gms.internal.ads.zzob;
import com.google.android.gms.internal.ads.zzoc;
import com.google.android.gms.internal.ads.zzoh;
import com.google.android.gms.internal.ads.zzph;
import java.io.IOException;

final class zzpg
implements zznk {
    private final zzoh zza;
    private final int zzb;
    private final zzob zzc;

    /* synthetic */ zzpg(zzoh zzoh2, int n, zzph zzph2) {
        this.zza = zzoh2;
        this.zzb = n;
        this.zzc = new zzob();
    }

    private final long zzc(zznv zznv2) throws IOException {
        long l;
        while (zznv2.zzm() < zznv2.zzo() - 6L) {
            zzoh zzoh2 = this.zza;
            int n = this.zzb;
            zzob zzob2 = this.zzc;
            l = zznv2.zzm();
            byte[] byArray = new byte[2];
            zznp zznp2 = (zznp)zznv2;
            zznp2.zzh(byArray, 0, 2, false);
            if (((byArray[0] & 0xFF) << 8 | byArray[1] & 0xFF) != n) {
                zznv2.zzl();
                zznp2.zzj((int)(l - zznv2.zzn()), false);
            } else {
                zzamf zzamf2 = new zzamf(16);
                System.arraycopy(byArray, 0, zzamf2.zzi(), 0, 2);
                zzamf2.zzf(zzny.zzb((zznv)zznv2, (byte[])zzamf2.zzi(), (int)2, (int)14));
                zznv2.zzl();
                zznp2.zzj((int)(l - zznv2.zzn()), false);
                if (zzoc.zza((zzamf)zzamf2, (zzoh)zzoh2, (int)n, (zzob)zzob2)) break;
            }
            zznp2.zzj(1, false);
        }
        if (zznv2.zzm() < zznv2.zzo() - 6L) return this.zzc.zza;
        l = zznv2.zzo();
        long l2 = zznv2.zzm();
        ((zznp)zznv2).zzj((int)(l - l2), false);
        return this.zza.zzj;
    }

    public final zznj zza(zznv zznv2, long l) throws IOException {
        long l2 = zznv2.zzn();
        long l3 = this.zzc(zznv2);
        long l4 = zznv2.zzm();
        int n = Math.max(6, this.zza.zzc);
        ((zznp)zznv2).zzj(n, false);
        long l5 = this.zzc(zznv2);
        long l6 = zznv2.zzm();
        if (l3 <= l) {
            if (l5 > l) return zznj.zzf((long)l4);
        }
        if (l5 > l) return zznj.zzd((long)l3, (long)l2);
        return zznj.zze((long)l5, (long)l6);
    }

    public final void zzb() {
    }
}
