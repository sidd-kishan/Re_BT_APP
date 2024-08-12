/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgbd
 *  com.google.android.gms.internal.ads.zzgbg
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgbd;
import com.google.android.gms.internal.ads.zzgbg;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgbf
extends zzgfw<zzgbg, zzgbf>
implements zzghj {
    private zzgbf() {
        super((zzgga)zzgbg.zzc());
    }

    /* synthetic */ zzgbf(zzgbd zzgbd2) {
        super((zzgga)zzgbg.zzc());
    }

    public final zzgbf zza(String string) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgbg.zzd((zzgbg)((zzgbg)this.zza), (String)string);
        return this;
    }

    public final zzgbf zzb(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgbg.zze((zzgbg)((zzgbg)this.zza), (int)n);
        return this;
    }

    public final zzgbf zzc(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgbg.zzf((zzgbg)((zzgbg)this.zza), (int)n);
        return this;
    }

    public final zzgbf zzd(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgbg.zzg((zzgbg)((zzgbg)this.zza), (int)n);
        return this;
    }
}
