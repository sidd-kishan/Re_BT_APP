/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaza
 *  com.google.android.gms.internal.ads.zzazb
 *  com.google.android.gms.internal.ads.zzazu
 *  com.google.android.gms.internal.ads.zzbcv
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzdbf
 *  com.google.android.gms.internal.ads.zzdbw
 *  com.google.android.gms.internal.ads.zzdcq
 *  com.google.android.gms.internal.ads.zzddx
 *  com.google.android.gms.internal.ads.zzdgj
 *  com.google.android.gms.internal.ads.zzdua
 *  com.google.android.gms.internal.ads.zzdub
 *  com.google.android.gms.internal.ads.zzduc
 *  com.google.android.gms.internal.ads.zzdud
 *  com.google.android.gms.internal.ads.zzexu
 *  com.google.android.gms.internal.ads.zzfal
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzazu;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzdbf;
import com.google.android.gms.internal.ads.zzdbw;
import com.google.android.gms.internal.ads.zzdcq;
import com.google.android.gms.internal.ads.zzddx;
import com.google.android.gms.internal.ads.zzdgj;
import com.google.android.gms.internal.ads.zzdua;
import com.google.android.gms.internal.ads.zzdub;
import com.google.android.gms.internal.ads.zzduc;
import com.google.android.gms.internal.ads.zzdud;
import com.google.android.gms.internal.ads.zzexu;
import com.google.android.gms.internal.ads.zzfal;
import javax.annotation.Nullable;

public final class zzdue
implements zzddx,
zzdcq,
zzdbf,
zzdbw,
zzbcv,
zzdgj {
    private final zzazb zza;
    private boolean zzb = false;

    public zzdue(zzazb zzazb2, @Nullable zzexu zzexu2) {
        this.zza = zzazb2;
        zzazb2.zzc(2);
        if (zzexu2 == null) return;
        zzazb2.zzc(1101);
    }

    public final void onAdClicked() {
        synchronized (this) {
            if (!this.zzb) {
                this.zza.zzc(7);
                this.zzb = true;
                return;
            }
            this.zza.zzc(8);
            return;
        }
    }

    public final void zzbD(zzbcz zzbcz2) {
        switch (zzbcz2.zza) {
            default: {
                this.zza.zzc(4);
                return;
            }
            case 7: {
                this.zza.zzc(106);
                return;
            }
            case 6: {
                this.zza.zzc(105);
                return;
            }
            case 5: {
                this.zza.zzc(104);
                return;
            }
            case 4: {
                this.zza.zzc(103);
                return;
            }
            case 3: {
                this.zza.zzc(5);
                return;
            }
            case 2: {
                this.zza.zzc(102);
                return;
            }
            case 1: 
        }
        this.zza.zzc(101);
    }

    public final void zzbG(zzcbj zzcbj2) {
    }

    public final void zzc(zzazu zzazu2) {
        this.zza.zzb((zzaza)new zzdub(zzazu2));
        this.zza.zzc(1103);
    }

    public final void zzd(zzazu zzazu2) {
        this.zza.zzb((zzaza)new zzduc(zzazu2));
        this.zza.zzc(1102);
    }

    public final void zze(zzazu zzazu2) {
        this.zza.zzb((zzaza)new zzdud(zzazu2));
        this.zza.zzc(1104);
    }

    public final void zzf() {
        this.zza.zzc(3);
    }

    public final void zzg() {
        synchronized (this) {
            this.zza.zzc(6);
            return;
        }
    }

    public final void zzn(boolean bl) {
        zzazb zzazb2 = this.zza;
        int n = true != bl ? 1106 : 1105;
        zzazb2.zzc(n);
    }

    public final void zzo(boolean bl) {
        zzazb zzazb2 = this.zza;
        int n = true != bl ? 1108 : 1107;
        zzazb2.zzc(n);
    }

    public final void zzp() {
        this.zza.zzc(1109);
    }

    public final void zzq(zzfal zzfal2) {
        this.zza.zzb((zzaza)new zzdua(zzfal2));
    }
}
