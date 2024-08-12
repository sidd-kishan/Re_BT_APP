/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzalw
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzne
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zzpp
 *  com.google.android.gms.internal.ads.zzpq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzalw;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzne;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zzpp;
import com.google.android.gms.internal.ads.zzpq;

final class zzpr
extends zzpq {
    private final zzamf zzb = new zzamf(zzalw.zza);
    private final zzamf zzc = new zzamf(4);
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    public zzpr(zzox zzox2) {
        super(zzox2);
    }

    protected final boolean zza(zzamf object) throws zzpp {
        int n = object.zzn();
        int n2 = n >> 4;
        if ((n &= 0xF) == 7) {
            this.zzg = n2;
            if (n2 == 5) return false;
            return true;
        }
        object = new StringBuilder(39);
        ((StringBuilder)object).append("Video format not supported: ");
        ((StringBuilder)object).append(n);
        throw new zzpp(((StringBuilder)object).toString());
    }

    protected final boolean zzb(zzamf zzamf2, long l) throws zzaha {
        int n = zzamf2.zzn();
        long l2 = zzamf2.zzs();
        if (n == 0) {
            if (this.zze) return false;
            zzamf zzamf3 = new zzamf(new byte[zzamf2.zzd()]);
            zzamf2.zzm(zzamf3.zzi(), 0, zzamf2.zzd());
            zzamf2 = zzne.zza((zzamf)zzamf3);
            this.zzd = zzamf2.zzb;
            zzamf3 = new zzaft();
            zzamf3.zzN("video/avc");
            zzamf3.zzK(zzamf2.zzf);
            zzamf3.zzS(zzamf2.zzc);
            zzamf3.zzT(zzamf2.zzd);
            zzamf3.zzW(zzamf2.zze);
            zzamf3.zzP(zzamf2.zza);
            zzamf2 = zzamf3.zzah();
            this.zza.zzs((zzafv)zzamf2);
            this.zze = true;
            return false;
        }
        if (n != 1) return false;
        if (!this.zze) return false;
        n = this.zzg == 1 ? 1 : 0;
        if (!this.zzf) {
            if (n == 0) return false;
        }
        byte[] byArray = this.zzc.zzi();
        byArray[0] = 0;
        byArray[1] = 0;
        byArray[2] = 0;
        int n2 = this.zzd;
        int n3 = 0;
        while (true) {
            if (zzamf2.zzd() <= 0) {
                this.zza.zzv(l + l2 * 1000L, n, n3, 0, null);
                this.zzf = true;
                return true;
            }
            zzamf2.zzm(this.zzc.zzi(), 4 - n2, this.zzd);
            this.zzc.zzh(0);
            int n4 = this.zzc.zzB();
            this.zzb.zzh(0);
            this.zza.zzy(this.zzb, 4);
            this.zza.zzy(zzamf2, n4);
            n3 = n3 + 4 + n4;
        }
    }
}
