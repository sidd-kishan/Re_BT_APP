/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzazg
 *  com.google.android.gms.internal.ads.zzbbd
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzazg;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbaw
extends zzgfw<zzbbd, zzbaw>
implements zzghj {
    private zzbaw() {
        super((zzgga)zzbbd.zzf());
    }

    /* synthetic */ zzbaw(zzazg zzazg2) {
        super((zzgga)zzbbd.zzf());
    }

    public final zzbaw zza(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzbbd.zzi((zzbbd)((zzbbd)this.zza), (int)n);
        return this;
    }

    public final zzbaw zzb(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzbbd.zzj((zzbbd)((zzbbd)this.zza), (int)n);
        return this;
    }
}
