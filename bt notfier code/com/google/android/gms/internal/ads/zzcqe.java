/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzbqm
 *  com.google.android.gms.internal.ads.zzcqf
 *  com.google.android.gms.internal.ads.zzcql
 *  com.google.android.gms.internal.ads.zzcqu
 *  com.google.android.gms.internal.ads.zzdwq
 *  com.google.android.gms.internal.ads.zzdwr
 *  com.google.android.gms.internal.ads.zzgli
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbqm;
import com.google.android.gms.internal.ads.zzcqf;
import com.google.android.gms.internal.ads.zzcql;
import com.google.android.gms.internal.ads.zzcqu;
import com.google.android.gms.internal.ads.zzdwq;
import com.google.android.gms.internal.ads.zzdwr;
import com.google.android.gms.internal.ads.zzgli;

final class zzcqe
implements zzdwq {
    private final zzcqu zza;
    private Context zzb;
    private zzbqm zzc;

    /* synthetic */ zzcqe(zzcqu zzcqu2, zzcql zzcql2) {
        this.zza = zzcqu2;
    }

    public final zzdwr zza() {
        zzgli.zzc((Object)this.zzb, Context.class);
        zzgli.zzc((Object)this.zzc, zzbqm.class);
        return new zzcqf(this.zza, this.zzb, this.zzc, null);
    }
}
