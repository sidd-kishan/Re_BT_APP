/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgas
 *  com.google.android.gms.internal.ads.zzgau
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgas;
import com.google.android.gms.internal.ads.zzgau;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgat
extends zzgfw<zzgau, zzgat>
implements zzghj {
    private zzgat() {
        super((zzgga)zzgau.zzf());
    }

    /* synthetic */ zzgat(zzgas zzgas2) {
        super((zzgga)zzgau.zzf());
    }

    public final zzgat zza(String string) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgau.zzg((zzgau)((zzgau)this.zza), (String)string);
        return this;
    }

    public final zzgat zzb(zzgex zzgex2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgau.zzh((zzgau)((zzgau)this.zza), (zzgex)zzgex2);
        return this;
    }

    public final zzgat zzc(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgau.zzj((zzgau)((zzgau)this.zza), (int)n);
        return this;
    }
}
