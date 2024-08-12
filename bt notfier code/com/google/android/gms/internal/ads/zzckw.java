/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcla
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcla;
import java.util.HashMap;

final class zzckw
implements Runnable {
    final String zza;
    final String zzb;
    final int zzc;
    final int zzd;
    final long zze;
    final long zzf;
    final boolean zzg;
    final int zzh;
    final int zzi;
    final zzcla zzj;

    zzckw(zzcla zzcla2, String string, String string2, int n, int n2, long l, long l2, boolean bl, int n3, int n4) {
        this.zzj = zzcla2;
        this.zza = string;
        this.zzb = string2;
        this.zzc = n;
        this.zzd = n2;
        this.zze = l;
        this.zzf = l2;
        this.zzg = bl;
        this.zzh = n3;
        this.zzi = n4;
    }

    @Override
    public final void run() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.zza);
        hashMap.put("cachedSrc", this.zzb);
        hashMap.put("bytesLoaded", Integer.toString(this.zzc));
        hashMap.put("totalBytes", Integer.toString(this.zzd));
        hashMap.put("bufferedDuration", Long.toString(this.zze));
        hashMap.put("totalDuration", Long.toString(this.zzf));
        String string = true != this.zzg ? "0" : "1";
        hashMap.put("cacheReady", string);
        hashMap.put("playerCount", Integer.toString(this.zzh));
        hashMap.put("playerPreparedCount", Integer.toString(this.zzi));
        zzcla.zzs((zzcla)this.zzj, (String)"onPrecacheEvent", hashMap);
    }
}
