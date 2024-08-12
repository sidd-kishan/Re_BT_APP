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

final class zzcgn
implements zzcgr {
    private final String zza;
    private final String zzb;
    private final Map zzc;
    private final byte[] zzd;

    zzcgn(String string, String string2, Map map, byte[] byArray) {
        this.zza = string;
        this.zzb = string2;
        this.zzc = map;
        this.zzd = byArray;
    }

    public final void zza(JsonWriter jsonWriter) {
        zzcgs.zzm((String)this.zza, (String)this.zzb, (Map)this.zzc, (byte[])this.zzd, (JsonWriter)jsonWriter);
    }
}
