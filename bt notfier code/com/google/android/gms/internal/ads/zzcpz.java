/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcoj
 *  com.google.android.gms.internal.ads.zzcom
 *  com.google.android.gms.internal.ads.zzcql
 *  com.google.android.gms.internal.ads.zzcqu
 *  com.google.android.gms.internal.ads.zzcqw
 *  com.google.android.gms.internal.ads.zzcrh
 *  com.google.android.gms.internal.ads.zzfbn
 *  com.google.android.gms.internal.ads.zzfew
 *  com.google.android.gms.internal.ads.zzgli
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcoj;
import com.google.android.gms.internal.ads.zzcom;
import com.google.android.gms.internal.ads.zzcql;
import com.google.android.gms.internal.ads.zzcqu;
import com.google.android.gms.internal.ads.zzcqw;
import com.google.android.gms.internal.ads.zzcrh;
import com.google.android.gms.internal.ads.zzfbn;
import com.google.android.gms.internal.ads.zzfew;
import com.google.android.gms.internal.ads.zzgli;

public final class zzcpz {
    private zzcom zza;
    private zzcqw zzb;
    private zzfew zzc;
    private zzcrh zzd;
    private zzfbn zze;

    private zzcpz() {
    }

    /* synthetic */ zzcpz(zzcql zzcql2) {
    }

    public final zzcpz zza(zzcom zzcom2) {
        this.zza = zzcom2;
        return this;
    }

    public final zzcpz zzb(zzcqw zzcqw2) {
        this.zzb = zzcqw2;
        return this;
    }

    public final zzcoj zzc() {
        zzgli.zzc((Object)this.zza, zzcom.class);
        zzgli.zzc((Object)this.zzb, zzcqw.class);
        if (this.zzc == null) {
            this.zzc = new zzfew();
        }
        if (this.zzd == null) {
            this.zzd = new zzcrh();
        }
        if (this.zze != null) return new zzcqu(this.zza, this.zzb, this.zzc, this.zzd, this.zze, null);
        this.zze = new zzfbn();
        return new zzcqu(this.zza, this.zzb, this.zzc, this.zzd, this.zze, null);
    }
}
