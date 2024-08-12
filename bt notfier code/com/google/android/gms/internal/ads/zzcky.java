/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcla
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcla;
import java.util.HashMap;

final class zzcky
implements Runnable {
    final String zza;
    final String zzb;
    final long zzc;
    final zzcla zzd;

    zzcky(zzcla zzcla2, String string, String string2, long l) {
        this.zzd = zzcla2;
        this.zza = string;
        this.zzb = string2;
        this.zzc = l;
    }

    @Override
    public final void run() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.zza);
        hashMap.put("cachedSrc", this.zzb);
        hashMap.put("totalDuration", Long.toString(this.zzc));
        zzcla.zzs((zzcla)this.zzd, (String)"onPrecacheEvent", hashMap);
    }
}
