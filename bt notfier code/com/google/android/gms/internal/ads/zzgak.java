/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgaj
 *  com.google.android.gms.internal.ads.zzgal
 *  com.google.android.gms.internal.ads.zzgao
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgaj;
import com.google.android.gms.internal.ads.zzgal;
import com.google.android.gms.internal.ads.zzgao;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgak
extends zzgfw<zzgal, zzgak>
implements zzghj {
    private zzgak() {
        super((zzgga)zzgal.zzg());
    }

    /* synthetic */ zzgak(zzgaj zzgaj2) {
        super((zzgga)zzgal.zzg());
    }

    public final zzgak zza(zzgao zzgao2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgal.zzh((zzgal)((zzgal)this.zza), (zzgao)zzgao2);
        return this;
    }

    public final zzgak zzb(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgal.zzi((zzgal)((zzgal)this.zza), (int)n);
        return this;
    }
}
