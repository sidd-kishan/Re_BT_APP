/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.internal.ads.zzcsc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.internal.ads.zzcsc;
import java.util.Map;

public final class zzcsg
implements zzcsc {
    private final zzg zza;

    public zzcsg(zzg zzg2) {
        this.zza = zzg2;
    }

    public final void zza(Map<String, String> map) {
        this.zza.zzg(Boolean.parseBoolean(map.get("content_vertical_opted_out")));
    }
}
