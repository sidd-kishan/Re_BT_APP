/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zzav
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzav;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfln;

final class zzczy
implements zzfln {
    private final Context zza;
    private final zzcgz zzb;
    private final zzfar zzc;

    zzczy(Context context, zzcgz zzcgz2, zzfar zzfar2) {
        this.zza = context;
        this.zzb = zzcgz2;
        this.zzc = zzfar2;
    }

    public final Object apply(Object object) {
        Context context = this.zza;
        zzcgz zzcgz2 = this.zzb;
        zzfar zzfar2 = this.zzc;
        object = (zzezz)object;
        context = new zzav(context);
        context.zze(((zzezz)object).zzB);
        context.zzf(((zzezz)object).zzC.toString());
        context.zzd(zzcgz2.zza);
        context.zzc(zzfar2.zzf);
        return context;
    }
}
