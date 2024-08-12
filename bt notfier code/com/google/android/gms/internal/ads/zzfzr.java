/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfzm
 *  com.google.android.gms.internal.ads.zzfzq
 *  com.google.android.gms.internal.ads.zzfzs
 *  com.google.android.gms.internal.ads.zzgab
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfzm;
import com.google.android.gms.internal.ads.zzfzq;
import com.google.android.gms.internal.ads.zzfzs;
import com.google.android.gms.internal.ads.zzgab;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfzr
extends zzgfw<zzfzs, zzfzr>
implements zzghj {
    private zzfzr() {
        super((zzgga)zzfzs.zzf());
    }

    /* synthetic */ zzfzr(zzfzq zzfzq2) {
        super((zzgga)zzfzs.zzf());
    }

    public final zzfzr zza(zzgab zzgab2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzfzs.zzg((zzfzs)((zzfzs)this.zza), (zzgab)zzgab2);
        return this;
    }

    public final zzfzr zzb(zzfzm zzfzm2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzfzs.zzh((zzfzs)((zzfzs)this.zza), (zzfzm)zzfzm2);
        return this;
    }

    public final zzfzr zzc(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzfzs.zzj((zzfzs)((zzfzs)this.zza), (int)n);
        return this;
    }
}
