/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzcgz
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcgz;
import java.lang.ref.WeakReference;

public final class zzcok {
    private zzcgz zza;
    private Context zzb;
    private WeakReference<Context> zzc;

    static /* synthetic */ zzcgz zza(zzcok zzcok2) {
        return zzcok2.zza;
    }

    static /* synthetic */ Context zzb(zzcok zzcok2) {
        return zzcok2.zzb;
    }

    static /* synthetic */ WeakReference zzc(zzcok zzcok2) {
        return zzcok2.zzc;
    }

    public final zzcok zzd(zzcgz zzcgz2) {
        this.zza = zzcgz2;
        return this;
    }

    public final zzcok zze(Context context) {
        this.zzc = new WeakReference<Context>(context);
        Context context2 = context;
        if (context.getApplicationContext() != null) {
            context2 = context.getApplicationContext();
        }
        this.zzb = context2;
        return this;
    }
}
