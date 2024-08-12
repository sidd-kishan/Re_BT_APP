/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgbd
 *  com.google.android.gms.internal.ads.zzgbg
 *  com.google.android.gms.internal.ads.zzgbh
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgbd;
import com.google.android.gms.internal.ads.zzgbg;
import com.google.android.gms.internal.ads.zzgbh;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgbe
extends zzgfw<zzgbh, zzgbe>
implements zzghj {
    private zzgbe() {
        super((zzgga)zzgbh.zzc());
    }

    /* synthetic */ zzgbe(zzgbd zzgbd2) {
        super((zzgga)zzgbh.zzc());
    }

    public final zzgbe zza(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgbh.zzd((zzgbh)((zzgbh)this.zza), (int)n);
        return this;
    }

    public final zzgbe zzb(zzgbg zzgbg2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgbh.zze((zzgbh)((zzgbh)this.zza), (zzgbg)zzgbg2);
        return this;
    }
}
