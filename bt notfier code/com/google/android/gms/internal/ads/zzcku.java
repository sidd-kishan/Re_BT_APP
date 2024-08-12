/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcla
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcla;
import java.util.HashMap;

final class zzcku
implements Runnable {
    final String zza;
    final String zzb;
    final int zzc;
    final int zzd;
    final zzcla zze;

    zzcku(zzcla zzcla2, String string, String string2, int n, int n2, boolean bl) {
        this.zze = zzcla2;
        this.zza = string;
        this.zzb = string2;
        this.zzc = n;
        this.zzd = n2;
    }

    @Override
    public final void run() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.zza);
        hashMap.put("cachedSrc", this.zzb);
        hashMap.put("bytesLoaded", Integer.toString(this.zzc));
        hashMap.put("totalBytes", Integer.toString(this.zzd));
        hashMap.put("cacheReady", "0");
        zzcla.zzs((zzcla)this.zze, (String)"onPrecacheEvent", hashMap);
    }
}
