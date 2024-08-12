/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgbz
 *  com.google.android.gms.internal.ads.zzgcb
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgbz;
import com.google.android.gms.internal.ads.zzgcb;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgca
extends zzgfw<zzgcb, zzgca>
implements zzghj {
    private zzgca() {
        super((zzgga)zzgcb.zzf());
    }

    /* synthetic */ zzgca(zzgbz zzgbz2) {
        super((zzgga)zzgcb.zzf());
    }

    public final zzgca zza(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgcb.zzg((zzgcb)((zzgcb)this.zza), (int)0);
        return this;
    }

    public final zzgca zzb(zzgex zzgex2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgcb.zzh((zzgcb)((zzgcb)this.zza), (zzgex)zzgex2);
        return this;
    }
}
