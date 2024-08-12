/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzwx
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzwx;
import java.io.File;

final class zzxi
implements zzwx {
    final Context zza;
    private File zzb;

    zzxi(Context context) {
        this.zza = context;
        this.zzb = null;
    }

    public final File zza() {
        if (this.zzb != null) return this.zzb;
        this.zzb = new File(this.zza.getCacheDir(), "volley");
        return this.zzb;
    }
}
