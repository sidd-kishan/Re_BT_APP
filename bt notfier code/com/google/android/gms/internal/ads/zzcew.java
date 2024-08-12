/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzcfa
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcfa;
import java.util.concurrent.Callable;

final class zzcew
implements Callable {
    private final zzcfa zza;
    private final Context zzb;

    zzcew(zzcfa zzcfa2, Context context) {
        this.zza = zzcfa2;
        this.zzb = context;
    }

    public final Object call() {
        return this.zza.zzt(this.zzb);
    }
}
