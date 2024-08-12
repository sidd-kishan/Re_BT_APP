/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzgjg
 *  com.google.android.gms.internal.ads.zzgkf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzgjg;
import com.google.android.gms.internal.ads.zzgkf;

public final class zzgke
extends zzgfw<zzgkf, zzgke>
implements zzghj {
    private zzgke() {
        super((zzgga)zzgkf.zzc());
    }

    /* synthetic */ zzgke(zzgjg zzgjg2) {
        super((zzgga)zzgkf.zzc());
    }

    public final zzgke zza(String string) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgkf.zzd((zzgkf)((zzgkf)this.zza), (String)string);
        return this;
    }

    public final zzgke zzb(long l) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgkf.zze((zzgkf)((zzgkf)this.zza), (long)l);
        return this;
    }

    public final zzgke zzc(boolean bl) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgkf.zzf((zzgkf)((zzgkf)this.zza), (boolean)bl);
        return this;
    }
}
