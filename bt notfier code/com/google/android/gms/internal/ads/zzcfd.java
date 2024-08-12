/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  com.google.android.gms.internal.ads.zzcff
 *  com.google.android.gms.internal.ads.zzcfg
 */
package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import com.google.android.gms.internal.ads.zzcff;
import com.google.android.gms.internal.ads.zzcfg;
import java.util.Map;

final class zzcfd
implements zzcff {
    private final zzcfg zza;
    private final Map zzb;

    zzcfd(zzcfg zzcfg2, Map map) {
        this.zza = zzcfg2;
        this.zzb = map;
    }

    public final void zza(SharedPreferences sharedPreferences, String string, String string2) {
        this.zza.zzd(this.zzb, sharedPreferences, string, string2);
    }
}
