/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzazg
 *  com.google.android.gms.internal.ads.zzbah
 *  com.google.android.gms.internal.ads.zzbbz
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzazg;
import com.google.android.gms.internal.ads.zzbah;
import com.google.android.gms.internal.ads.zzbbz;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbag
extends zzgfw<zzbah, zzbag>
implements zzghj {
    private zzbag() {
        super((zzgga)zzbah.zzc());
    }

    /* synthetic */ zzbag(zzazg zzazg2) {
        super((zzgga)zzbah.zzc());
    }

    public final zzbag zza(String string) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzbah.zzd((zzbah)((zzbah)this.zza), (String)string);
        return this;
    }

    public final zzbag zzb(zzbbz zzbbz2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzbah.zze((zzbah)((zzbah)this.zza), (zzbbz)zzbbz2);
        return this;
    }
}
