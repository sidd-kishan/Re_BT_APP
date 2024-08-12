/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamn
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzov
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zzua
 *  com.google.android.gms.internal.ads.zzun
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamn;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzov;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zzua;
import com.google.android.gms.internal.ads.zzun;

public final class zztr
implements zzua {
    private zzafv zza;
    private zzamn zzb;
    private zzox zzc;

    public zztr(String string) {
        zzaft zzaft2 = new zzaft();
        zzaft2.zzN(string);
        this.zza = zzaft2.zzah();
    }

    public final void zza(zzamn zzamn2, zznx zznx2, zzun zzun2) {
        this.zzb = zzamn2;
        zzun2.zza();
        zzamn2 = zznx2.zzB(zzun2.zzb(), 5);
        this.zzc = zzamn2;
        zzamn2.zzs(this.zza);
    }

    public final void zzb(zzamf zzamf2) {
        zzakt.zze((Object)this.zzb);
        int n = zzamq.zza;
        long l = this.zzb.zzb();
        long l2 = this.zzb.zzc();
        if (l == -9223372036854775807L) return;
        if (l2 == -9223372036854775807L) return;
        zzafv zzafv2 = this.zza;
        if (l2 != zzafv2.zzp) {
            zzafv2 = zzafv2.zza();
            zzafv2.zzR(l2);
            this.zza = zzafv2 = zzafv2.zzah();
            this.zzc.zzs(zzafv2);
        }
        n = zzamf2.zzd();
        zzov.zzb((zzox)this.zzc, (zzamf)zzamf2, (int)n);
        this.zzc.zzv(l, 1, n, 0, null);
    }
}
