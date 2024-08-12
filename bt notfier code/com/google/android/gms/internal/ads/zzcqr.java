/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzf
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzg
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzz
 *  com.google.android.gms.internal.ads.zzcql
 *  com.google.android.gms.internal.ads.zzcqs
 *  com.google.android.gms.internal.ads.zzcqu
 *  com.google.android.gms.internal.ads.zzcyl
 *  com.google.android.gms.internal.ads.zzdao
 *  com.google.android.gms.internal.ads.zzdvv
 *  com.google.android.gms.internal.ads.zzfbt
 *  com.google.android.gms.internal.ads.zzgli
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nonagon.signalgeneration.zzf;
import com.google.android.gms.ads.nonagon.signalgeneration.zzg;
import com.google.android.gms.ads.nonagon.signalgeneration.zzz;
import com.google.android.gms.internal.ads.zzcql;
import com.google.android.gms.internal.ads.zzcqs;
import com.google.android.gms.internal.ads.zzcqu;
import com.google.android.gms.internal.ads.zzcyl;
import com.google.android.gms.internal.ads.zzdao;
import com.google.android.gms.internal.ads.zzdvv;
import com.google.android.gms.internal.ads.zzfbt;
import com.google.android.gms.internal.ads.zzgli;

final class zzcqr
implements zzf {
    private final zzcqu zza;
    private zzdao zzb;
    private zzz zzc;

    /* synthetic */ zzcqr(zzcqu zzcqu2, zzcql zzcql2) {
        this.zza = zzcqu2;
    }

    public final zzg zza() {
        zzgli.zzc((Object)this.zzb, zzdao.class);
        zzgli.zzc((Object)this.zzc, zzz.class);
        return new zzcqs(this.zza, this.zzc, new zzcyl(), new zzdvv(), this.zzb, new zzfbt(), null, null, null);
    }
}
