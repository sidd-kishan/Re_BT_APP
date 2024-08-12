/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzcpt
 *  com.google.android.gms.internal.ads.zzcql
 *  com.google.android.gms.internal.ads.zzcqu
 *  com.google.android.gms.internal.ads.zzeux
 *  com.google.android.gms.internal.ads.zzeuy
 *  com.google.android.gms.internal.ads.zzgli
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcpt;
import com.google.android.gms.internal.ads.zzcql;
import com.google.android.gms.internal.ads.zzcqu;
import com.google.android.gms.internal.ads.zzeux;
import com.google.android.gms.internal.ads.zzeuy;
import com.google.android.gms.internal.ads.zzgli;

final class zzcps
implements zzeux {
    private final zzcqu zza;
    private Context zzb;
    private String zzc;

    /* synthetic */ zzcps(zzcqu zzcqu2, zzcql zzcql2) {
        this.zza = zzcqu2;
    }

    public final zzeuy zza() {
        zzgli.zzc((Object)this.zzb, Context.class);
        zzgli.zzc((Object)this.zzc, String.class);
        return new zzcpt(this.zza, this.zzb, this.zzc, null);
    }
}
