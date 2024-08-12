/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzcpy
 *  com.google.android.gms.internal.ads.zzcql
 *  com.google.android.gms.internal.ads.zzcqu
 *  com.google.android.gms.internal.ads.zzewl
 *  com.google.android.gms.internal.ads.zzewm
 *  com.google.android.gms.internal.ads.zzgli
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzcpy;
import com.google.android.gms.internal.ads.zzcql;
import com.google.android.gms.internal.ads.zzcqu;
import com.google.android.gms.internal.ads.zzewl;
import com.google.android.gms.internal.ads.zzewm;
import com.google.android.gms.internal.ads.zzgli;

final class zzcpx
implements zzewl {
    private final zzcqu zza;
    private Context zzb;
    private String zzc;
    private zzbdl zzd;

    /* synthetic */ zzcpx(zzcqu zzcqu2, zzcql zzcql2) {
        this.zza = zzcqu2;
    }

    public final zzewm zza() {
        zzgli.zzc((Object)this.zzb, Context.class);
        zzgli.zzc((Object)this.zzc, String.class);
        zzgli.zzc((Object)this.zzd, zzbdl.class);
        return new zzcpy(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
