/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzyi
 *  com.google.android.gms.internal.ads.zzzm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzyi;
import com.google.android.gms.internal.ads.zzzm;

public final class zzzl
extends zzgfw<zzzm, zzzl>
implements zzghj {
    private zzzl() {
        super((zzgga)zzzm.zzc());
    }

    /* synthetic */ zzzl(zzyi zzyi2) {
        super((zzgga)zzzm.zzc());
    }

    public final zzzl zza(zzgex zzgex2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzzm.zzd((zzzm)((zzzm)this.zza), (zzgex)zzgex2);
        return this;
    }

    public final zzzl zzb(zzgex zzgex2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzzm.zze((zzzm)((zzzm)this.zza), (zzgex)zzgex2);
        return this;
    }

    public final zzzl zzc(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzzm.zzf((zzzm)((zzzm)this.zza), (int)n);
        return this;
    }
}
