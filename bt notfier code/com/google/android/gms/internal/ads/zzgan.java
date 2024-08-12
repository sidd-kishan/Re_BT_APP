/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgam
 *  com.google.android.gms.internal.ads.zzgao
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgam;
import com.google.android.gms.internal.ads.zzgao;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgan
extends zzgfw<zzgao, zzgan>
implements zzghj {
    private zzgan() {
        super((zzgga)zzgao.zze());
    }

    /* synthetic */ zzgan(zzgam zzgam2) {
        super((zzgga)zzgao.zze());
    }

    public final zzgan zza(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgao.zzf((zzgao)((zzgao)this.zza), (int)n);
        return this;
    }

    public final zzgan zzb(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgao.zzh((zzgao)((zzgao)this.zza), (int)n);
        return this;
    }
}
