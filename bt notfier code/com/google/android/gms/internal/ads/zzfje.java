/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfjc
 *  com.google.android.gms.internal.ads.zzfjf
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfjc;
import com.google.android.gms.internal.ads.zzfjf;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfje
extends zzgfw<zzfjf, zzfje>
implements zzghj {
    private zzfje() {
        super((zzgga)zzfjf.zzc());
    }

    /* synthetic */ zzfje(zzfjc zzfjc2) {
        super((zzgga)zzfjf.zzc());
    }

    public final zzfje zza(String string) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzfjf.zzd((zzfjf)((zzfjf)this.zza), (String)string);
        return this;
    }

    public final zzfje zzb(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzfjf.zze((zzfjf)((zzfjf)this.zza), (int)2);
        return this;
    }
}
