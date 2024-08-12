/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfxm
 *  com.google.android.gms.internal.ads.zzfxo
 *  com.google.android.gms.internal.ads.zzfxu
 *  com.google.android.gms.internal.ads.zzgai
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfxm;
import com.google.android.gms.internal.ads.zzfxo;
import com.google.android.gms.internal.ads.zzfxu;
import com.google.android.gms.internal.ads.zzgai;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfxn
extends zzgfw<zzfxo, zzfxn>
implements zzghj {
    private zzfxn() {
        super((zzgga)zzfxo.zzg());
    }

    /* synthetic */ zzfxn(zzfxm zzfxm2) {
        super((zzgga)zzfxo.zzg());
    }

    public final zzfxn zza(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzfxo.zzh((zzfxo)((zzfxo)this.zza), (int)n);
        return this;
    }

    public final zzfxn zzb(zzfxu zzfxu2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzfxo.zzi((zzfxo)((zzfxo)this.zza), (zzfxu)zzfxu2);
        return this;
    }

    public final zzfxn zzc(zzgai zzgai2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzfxo.zzj((zzfxo)((zzfxo)this.zza), (zzgai)zzgai2);
        return this;
    }
}
