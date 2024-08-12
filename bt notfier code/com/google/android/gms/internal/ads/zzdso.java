/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzdsr
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzdsr;
import java.util.Map;

final class zzdso
implements zzbpr {
    private final zzdsr zza;
    private final zzcml zzb;

    zzdso(zzdsr zzdsr2, zzcml zzcml2) {
        this.zza = zzdsr2;
        this.zzb = zzcml2;
    }

    public final void zza(Object object, Map map) {
        this.zza.zzc(this.zzb, (zzcml)object, map);
    }
}
