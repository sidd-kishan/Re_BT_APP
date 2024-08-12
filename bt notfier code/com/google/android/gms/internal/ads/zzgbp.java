/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgbo
 *  com.google.android.gms.internal.ads.zzgbq
 *  com.google.android.gms.internal.ads.zzgbt
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgbo;
import com.google.android.gms.internal.ads.zzgbq;
import com.google.android.gms.internal.ads.zzgbt;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgbp
extends zzgfw<zzgbq, zzgbp>
implements zzghj {
    private zzgbp() {
        super((zzgga)zzgbq.zzf());
    }

    /* synthetic */ zzgbp(zzgbo zzgbo2) {
        super((zzgga)zzgbq.zzf());
    }

    public final zzgbp zza(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgbq.zzg((zzgbq)((zzgbq)this.zza), (int)0);
        return this;
    }

    public final zzgbp zzb(zzgbt zzgbt2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgbq.zzh((zzgbq)((zzgbq)this.zza), (zzgbt)zzgbt2);
        return this;
    }
}
