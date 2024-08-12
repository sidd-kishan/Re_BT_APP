/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzdcq
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfar
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzdcq;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfar;

final class zzcvm
implements zzdcq {
    private final Context zza;
    private final zzcgz zzb;
    private final zzezz zzc;
    private final zzfar zzd;

    zzcvm(Context context, zzcgz zzcgz2, zzezz zzezz2, zzfar zzfar2) {
        this.zza = context;
        this.zzb = zzcgz2;
        this.zzc = zzezz2;
        this.zzd = zzfar2;
    }

    public final void zzf() {
        Context context = this.zza;
        zzcgz zzcgz2 = this.zzb;
        zzezz zzezz2 = this.zzc;
        zzfar zzfar2 = this.zzd;
        zzt.zzm().zzg(context, zzcgz2.zza, zzezz2.zzC.toString(), zzfar2.zzf);
    }
}
