/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zznf
 *  com.google.android.gms.internal.ads.zznh
 *  com.google.android.gms.internal.ads.zzni
 *  com.google.android.gms.internal.ads.zznj
 *  com.google.android.gms.internal.ads.zznk
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zzoq
 *  com.google.android.gms.internal.ads.zzot
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zznf;
import com.google.android.gms.internal.ads.zznh;
import com.google.android.gms.internal.ads.zzni;
import com.google.android.gms.internal.ads.zznj;
import com.google.android.gms.internal.ads.zznk;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zzoq;
import com.google.android.gms.internal.ads.zzot;
import java.io.IOException;

public class zznl {
    protected final zznf zza;
    protected final zznk zzb;
    protected zznh zzc;
    private final int zzd;

    protected zznl(zzni zzni2, zznk zznk2, long l, long l2, long l3, long l4, long l5, long l6, int n) {
        this.zzb = zznk2;
        this.zzd = n;
        this.zza = new zznf(zzni2, l, 0L, l3, l4, l5, l6);
    }

    protected static final int zzf(zznv zznv2, long l, zzoq zzoq2) {
        if (l == zznv2.zzn()) {
            return 0;
        }
        zzoq2.zza = l;
        return 1;
    }

    protected static final boolean zzg(zznv zznv2, long l) throws IOException {
        if ((l -= zznv2.zzn()) < 0L) return false;
        if (l > 262144L) return false;
        ((zznp)zznv2).zzd((int)l, false);
        return true;
    }

    public final zzot zza() {
        return this.zza;
    }

    public final void zzb(long l) {
        zznh zznh2 = this.zzc;
        if (zznh2 != null && zznh.zze((zznh)zznh2) == l) {
            return;
        }
        this.zzc = new zznh(l, this.zza.zzh(l), 0L, zznf.zza((zznf)this.zza), zznf.zzb((zznf)this.zza), zznf.zzc((zznf)this.zza), zznf.zzd((zznf)this.zza));
    }

    public final boolean zzc() {
        if (this.zzc == null) return false;
        return true;
    }

    public final int zzd(zznv zznv2, zzoq zzoq2) throws IOException {
        while (true) {
            zznh zznh2 = this.zzc;
            zzakt.zze((Object)zznh2);
            long l = zznh.zzb((zznh)zznh2);
            long l2 = zznh.zzc((zznh)zznh2);
            long l3 = zznh.zzh((zznh)zznh2);
            if (l2 - l <= (long)this.zzd) {
                this.zze(false, l);
                return zznl.zzf(zznv2, l, zzoq2);
            }
            if (!zznl.zzg(zznv2, l3)) {
                return zznl.zzf(zznv2, l3, zzoq2);
            }
            zznv2.zzl();
            zznj zznj2 = this.zzb.zza(zznv2, zznh.zzd((zznh)zznh2));
            int n = zznj.zza((zznj)zznj2);
            if (n == -3) {
                this.zze(false, l3);
                return zznl.zzf(zznv2, l3, zzoq2);
            }
            if (n != -2) {
                if (n != -1) {
                    zznl.zzg(zznv2, zznj.zzc((zznj)zznj2));
                    this.zze(true, zznj.zzc((zznj)zznj2));
                    return zznl.zzf(zznv2, zznj.zzc((zznj)zznj2), zzoq2);
                }
                zznh.zzg((zznh)zznh2, (long)zznj.zzb((zznj)zznj2), (long)zznj.zzc((zznj)zznj2));
                continue;
            }
            zznh.zzf((zznh)zznh2, (long)zznj.zzb((zznj)zznj2), (long)zznj.zzc((zznj)zznj2));
        }
    }

    protected final void zze(boolean bl, long l) {
        this.zzc = null;
        this.zzb.zzb();
    }
}
