/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzfkk
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzfkk;
import java.util.concurrent.Callable;

final class zzfif
implements Callable {
    private final Context zza;
    private final boolean zzb;

    zzfif(Context context, boolean bl) {
        this.zza = context;
        this.zzb = bl;
    }

    public final Object call() {
        Context context = this.zza;
        String string = true != this.zzb ? "" : "GLAS";
        return new zzfkk(context, string, null);
    }
}
