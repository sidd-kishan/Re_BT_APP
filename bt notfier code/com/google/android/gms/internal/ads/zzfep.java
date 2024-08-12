/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdgl
 *  com.google.android.gms.internal.ads.zzfdy
 *  com.google.android.gms.internal.ads.zzfem
 *  com.google.android.gms.internal.ads.zzfet
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgl;
import com.google.android.gms.internal.ads.zzfdy;
import com.google.android.gms.internal.ads.zzfem;
import com.google.android.gms.internal.ads.zzfet;

final class zzfep
implements zzdgl {
    private final zzfdy zza;
    private final Throwable zzb;

    zzfep(zzfdy zzfdy2, Throwable throwable) {
        this.zza = zzfdy2;
        this.zzb = throwable;
    }

    public final void zza(Object object) {
        Object object2 = this.zza;
        Throwable throwable = this.zzb;
        zzfet zzfet2 = (zzfet)object;
        object = object2.zza();
        object2 = object2.zzb();
        zzfet2.zzc((zzfem)object, (String)object2, throwable);
    }
}
