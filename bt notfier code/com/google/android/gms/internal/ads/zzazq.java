/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzazg
 *  com.google.android.gms.internal.ads.zzazr
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzazg;
import com.google.android.gms.internal.ads.zzazr;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;

public final class zzazq
extends zzgfw<zzazr, zzazq>
implements zzghj {
    private zzazq() {
        super((zzgga)zzazr.zzd());
    }

    /* synthetic */ zzazq(zzazg zzazg2) {
        super((zzgga)zzazr.zzd());
    }

    public final zzazq zza(boolean bl) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzazr.zze((zzazr)((zzazr)this.zza), (boolean)bl);
        return this;
    }

    public final zzazq zzb(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzazr.zzf((zzazr)((zzazr)this.zza), (int)n);
        return this;
    }
}
