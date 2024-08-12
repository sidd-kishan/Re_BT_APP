/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzazg
 *  com.google.android.gms.internal.ads.zzazt
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzazg;
import com.google.android.gms.internal.ads.zzazt;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;

public final class zzazs
extends zzgfw<zzazt, zzazs>
implements zzghj {
    private zzazs() {
        super((zzgga)zzazt.zzc());
    }

    /* synthetic */ zzazs(zzazg zzazg2) {
        super((zzgga)zzazt.zzc());
    }

    public final zzazs zza(boolean bl) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzazt.zzd((zzazt)((zzazt)this.zza), (boolean)bl);
        return this;
    }

    public final zzazs zzb(boolean bl) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzazt.zze((zzazt)((zzazt)this.zza), (boolean)bl);
        return this;
    }

    public final zzazs zzc(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzazt.zzf((zzazt)((zzazt)this.zza), (int)n);
        return this;
    }
}
