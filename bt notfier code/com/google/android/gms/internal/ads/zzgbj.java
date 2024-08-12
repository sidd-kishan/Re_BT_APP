/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgbi
 *  com.google.android.gms.internal.ads.zzgbk
 *  com.google.android.gms.internal.ads.zzgbn
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgbi;
import com.google.android.gms.internal.ads.zzgbk;
import com.google.android.gms.internal.ads.zzgbn;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgbj
extends zzgfw<zzgbk, zzgbj>
implements zzghj {
    private zzgbj() {
        super((zzgga)zzgbk.zzf());
    }

    /* synthetic */ zzgbj(zzgbi zzgbi2) {
        super((zzgga)zzgbk.zzf());
    }

    public final zzgbj zza(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgbk.zzg((zzgbk)((zzgbk)this.zza), (int)0);
        return this;
    }

    public final zzgbj zzb(zzgbn zzgbn2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgbk.zzh((zzgbk)((zzgbk)this.zza), (zzgbn)zzgbn2);
        return this;
    }
}
