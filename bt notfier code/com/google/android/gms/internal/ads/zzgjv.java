/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzgjg
 *  com.google.android.gms.internal.ads.zzgjx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzgjg;
import com.google.android.gms.internal.ads.zzgjx;

public final class zzgjv
extends zzgfw<zzgjx, zzgjv>
implements zzghj {
    private zzgjv() {
        super((zzgga)zzgjx.zzc());
    }

    /* synthetic */ zzgjv(zzgjg zzgjg2) {
        super((zzgga)zzgjx.zzc());
    }

    public final zzgjv zza(String string) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgjx.zzd((zzgjx)((zzgjx)this.zza), (String)"image/png");
        return this;
    }

    public final zzgjv zzb(zzgex zzgex2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgjx.zze((zzgjx)((zzgjx)this.zza), (zzgex)zzgex2);
        return this;
    }

    public final zzgjv zzc(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgjx.zzf((zzgjx)((zzgjx)this.zza), (int)2);
        return this;
    }
}
