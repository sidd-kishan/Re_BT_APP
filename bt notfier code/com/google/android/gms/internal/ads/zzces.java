/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzcez
 *  com.google.android.gms.internal.ads.zzcod
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzcez;
import com.google.android.gms.internal.ads.zzcod;

final class zzces
implements zzcez {
    private final Context zza;
    private final String zzb;

    zzces(Context context, String string) {
        this.zza = context;
        this.zzb = string;
    }

    public final void zza(zzcod zzcod2) {
        Context context = this.zza;
        String string = this.zzb;
        zzcod2.zzq(ObjectWrapper.wrap((Object)context), string, context.getPackageName());
    }
}
