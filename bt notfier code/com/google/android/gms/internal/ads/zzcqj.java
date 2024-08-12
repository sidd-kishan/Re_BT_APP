/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzcqk
 *  com.google.android.gms.internal.ads.zzcql
 *  com.google.android.gms.internal.ads.zzcqu
 *  com.google.android.gms.internal.ads.zzeye
 *  com.google.android.gms.internal.ads.zzeyf
 *  com.google.android.gms.internal.ads.zzgli
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzcqk;
import com.google.android.gms.internal.ads.zzcql;
import com.google.android.gms.internal.ads.zzcqu;
import com.google.android.gms.internal.ads.zzeye;
import com.google.android.gms.internal.ads.zzeyf;
import com.google.android.gms.internal.ads.zzgli;

final class zzcqj
implements zzeye {
    private final zzcqu zza;
    private Context zzb;
    private String zzc;
    private zzbdl zzd;

    /* synthetic */ zzcqj(zzcqu zzcqu2, zzcql zzcql2) {
        this.zza = zzcqu2;
    }

    public final zzeyf zza() {
        zzgli.zzc((Object)this.zzb, Context.class);
        zzgli.zzc((Object)this.zzc, String.class);
        zzgli.zzc((Object)this.zzd, zzbdl.class);
        return new zzcqk(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
