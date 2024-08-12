/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfxv
 *  com.google.android.gms.internal.ads.zzfxx
 *  com.google.android.gms.internal.ads.zzfya
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfxv;
import com.google.android.gms.internal.ads.zzfxx;
import com.google.android.gms.internal.ads.zzfya;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfxw
extends zzgfw<zzfxx, zzfxw>
implements zzghj {
    private zzfxw() {
        super((zzgga)zzfxx.zzg());
    }

    /* synthetic */ zzfxw(zzfxv zzfxv2) {
        super((zzgga)zzfxx.zzg());
    }

    public final zzfxw zza(zzfya zzfya2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzfxx.zzh((zzfxx)((zzfxx)this.zza), (zzfya)zzfya2);
        return this;
    }

    public final zzfxw zzb(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzfxx.zzi((zzfxx)((zzfxx)this.zza), (int)n);
        return this;
    }
}
