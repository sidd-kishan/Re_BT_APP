/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzazg
 *  com.google.android.gms.internal.ads.zzbcu
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzazg;
import com.google.android.gms.internal.ads.zzbcu;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbct
extends zzgfw<zzbcu, zzbct>
implements zzghj {
    private zzbct() {
        super((zzgga)zzbcu.zzd());
    }

    /* synthetic */ zzbct(zzazg zzazg2) {
        super((zzgga)zzbcu.zzd());
    }

    public final boolean zza() {
        return ((zzbcu)this.zza).zza();
    }

    public final zzbct zzb(boolean bl) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzbcu.zze((zzbcu)((zzbcu)this.zza), (boolean)bl);
        return this;
    }

    public final zzbct zzc(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzbcu.zzf((zzbcu)((zzbcu)this.zza), (int)n);
        return this;
    }
}
