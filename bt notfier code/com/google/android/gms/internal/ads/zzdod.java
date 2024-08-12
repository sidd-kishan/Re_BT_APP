/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcnx
 *  com.google.android.gms.internal.ads.zzdoe
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcnx;
import com.google.android.gms.internal.ads.zzdoe;
import java.util.Map;

final class zzdod
implements zzcnx {
    private final zzdoe zza;
    private final Map zzb;

    zzdod(zzdoe zzdoe2, Map map) {
        this.zza = zzdoe2;
        this.zzb = map;
    }

    public final void zza(boolean bl) {
        this.zza.zzc(this.zzb, bl);
    }
}
