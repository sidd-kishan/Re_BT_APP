/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  com.google.android.gms.internal.ads.zzadn
 *  com.google.android.gms.internal.ads.zzado
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.internal.ads.zzadn;
import com.google.android.gms.internal.ads.zzado;

final class zzadp {
    private final Context zza;
    private final zzadn zzb;

    public zzadp(Context context, Handler handler, zzado zzado2) {
        this.zza = context.getApplicationContext();
        this.zzb = new zzadn(this, handler, zzado2);
    }
}
