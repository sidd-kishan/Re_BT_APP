/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcla
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcla;
import java.util.HashMap;

final class zzckx
implements Runnable {
    final String zza;
    final String zzb;
    final int zzc;
    final zzcla zzd;

    zzckx(zzcla zzcla2, String string, String string2, int n) {
        this.zzd = zzcla2;
        this.zza = string;
        this.zzb = string2;
        this.zzc = n;
    }

    @Override
    public final void run() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.zza);
        hashMap.put("cachedSrc", this.zzb);
        hashMap.put("totalBytes", Integer.toString(this.zzc));
        zzcla.zzs((zzcla)this.zzd, (String)"onPrecacheEvent", hashMap);
    }
}
