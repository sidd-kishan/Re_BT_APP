/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzdgl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzdgl;

final class zzdgk
implements Runnable {
    private final zzdgl zza;
    private final Object zzb;

    zzdgk(zzdgl zzdgl2, Object object) {
        this.zza = zzdgl2;
        this.zzb = object;
    }

    @Override
    public final void run() {
        zzdgl zzdgl2 = this.zza;
        Object object = this.zzb;
        try {
            zzdgl2.zza(object);
            return;
        }
        catch (Throwable throwable) {
            zzt.zzg().zzl(throwable, "EventEmitter.notify");
            zze.zzb((String)"Event emitter exception.", (Throwable)throwable);
            return;
        }
    }
}
