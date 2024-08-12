/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.JsonWriter
 *  com.google.android.gms.internal.ads.zzcgr
 *  com.google.android.gms.internal.ads.zzcgs
 */
package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import com.google.android.gms.internal.ads.zzcgr;
import com.google.android.gms.internal.ads.zzcgs;
import java.util.Map;

final class zzcgo
implements zzcgr {
    private final int zza;
    private final Map zzb;

    zzcgo(int n, Map map) {
        this.zza = n;
        this.zzb = map;
    }

    public final void zza(JsonWriter jsonWriter) {
        zzcgs.zzl((int)this.zza, (Map)this.zzb, (JsonWriter)jsonWriter);
    }
}
