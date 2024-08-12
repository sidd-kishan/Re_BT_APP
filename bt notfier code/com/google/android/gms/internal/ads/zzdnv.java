/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcnx
 *  com.google.android.gms.internal.ads.zzdnw
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcnx;
import com.google.android.gms.internal.ads.zzdnw;
import java.util.Map;

final class zzdnv
implements zzcnx {
    private final zzdnw zza;
    private final Map zzb;

    zzdnv(zzdnw zzdnw2, Map map) {
        this.zza = zzdnw2;
        this.zzb = map;
    }

    public final void zza(boolean bl) {
        this.zza.zzd(this.zzb, bl);
    }
}
