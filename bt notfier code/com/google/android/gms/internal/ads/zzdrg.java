/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzdre
 *  com.google.android.gms.internal.ads.zzdrh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzdre;
import com.google.android.gms.internal.ads.zzdrh;
import java.lang.ref.WeakReference;
import java.util.Map;

final class zzdrg<T>
implements zzbpr<Object> {
    final zzdrh zza;
    private final WeakReference<T> zzb;
    private final String zzc;
    private final zzbpr<T> zzd;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    /* synthetic */ zzdrg(zzdrh zzdrh2, WeakReference weakReference, String string, zzbpr zzbpr2, zzdre zzdre2) {
        this.zza = zzdrh2;
        this.zzb = weakReference;
        this.zzc = string;
        this.zzd = zzbpr2;
    }

    public final void zza(Object object, Map<String, String> map) {
        object = this.zzb.get();
        if (object == null) {
            this.zza.zzf(this.zzc, (zzbpr)this);
            return;
        }
        this.zzd.zza(object, map);
    }
}
