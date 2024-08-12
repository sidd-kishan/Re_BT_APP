/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfxd
 *  com.google.android.gms.internal.ads.zzfxf
 *  com.google.android.gms.internal.ads.zzfxl
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfxd;
import com.google.android.gms.internal.ads.zzfxf;
import com.google.android.gms.internal.ads.zzfxl;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfxe
extends zzgfw<zzfxf, zzfxe>
implements zzghj {
    private zzfxe() {
        super((zzgga)zzfxf.zzg());
    }

    /* synthetic */ zzfxe(zzfxd zzfxd2) {
        super((zzgga)zzfxf.zzg());
    }

    public final zzfxe zza(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzfxf.zzh((zzfxf)((zzfxf)this.zza), (int)0);
        return this;
    }

    public final zzfxe zzb(zzgex zzgex2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzfxf.zzi((zzfxf)((zzfxf)this.zza), (zzgex)zzgex2);
        return this;
    }

    public final zzfxe zzc(zzfxl zzfxl2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzfxf.zzj((zzfxf)((zzfxf)this.zza), (zzfxl)zzfxl2);
        return this;
    }
}
