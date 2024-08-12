/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzcql
 *  com.google.android.gms.internal.ads.zzcqn
 *  com.google.android.gms.internal.ads.zzcqu
 *  com.google.android.gms.internal.ads.zzezs
 *  com.google.android.gms.internal.ads.zzezt
 *  com.google.android.gms.internal.ads.zzgli
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcql;
import com.google.android.gms.internal.ads.zzcqn;
import com.google.android.gms.internal.ads.zzcqu;
import com.google.android.gms.internal.ads.zzezs;
import com.google.android.gms.internal.ads.zzezt;
import com.google.android.gms.internal.ads.zzgli;

final class zzcqm
implements zzezs {
    private final zzcqu zza;
    private Context zzb;
    private String zzc;

    /* synthetic */ zzcqm(zzcqu zzcqu2, zzcql zzcql2) {
        this.zza = zzcqu2;
    }

    public final zzezt zza() {
        zzgli.zzc((Object)this.zzb, Context.class);
        return new zzcqn(this.zza, this.zzb, this.zzc, null);
    }
}
