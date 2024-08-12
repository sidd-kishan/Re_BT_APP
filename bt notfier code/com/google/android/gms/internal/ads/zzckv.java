/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcla
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcla;
import java.util.HashMap;

final class zzckv
implements Runnable {
    final String zza;
    final String zzb;
    final long zzc;
    final long zzd;
    final long zze;
    final long zzf;
    final long zzg;
    final boolean zzh;
    final int zzi;
    final int zzj;
    final zzcla zzk;

    zzckv(zzcla zzcla2, String string, String string2, long l, long l2, long l3, long l4, long l5, boolean bl, int n, int n2) {
        this.zzk = zzcla2;
        this.zza = string;
        this.zzb = string2;
        this.zzc = l;
        this.zzd = l2;
        this.zze = l3;
        this.zzf = l4;
        this.zzg = l5;
        this.zzh = bl;
        this.zzi = n;
        this.zzj = n2;
    }

    @Override
    public final void run() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.zza);
        hashMap.put("cachedSrc", this.zzb);
        hashMap.put("bufferedDuration", Long.toString(this.zzc));
        hashMap.put("totalDuration", Long.toString(this.zzd));
        Object object = zzbjl.zzbl;
        if (((Boolean)zzbet.zzc().zzc(object)).booleanValue()) {
            hashMap.put("qoeLoadedBytes", Long.toString(this.zze));
            hashMap.put("qoeCachedBytes", Long.toString(this.zzf));
            hashMap.put("totalBytes", Long.toString(this.zzg));
            hashMap.put("reportTime", Long.toString(zzt.zzj().currentTimeMillis()));
        }
        object = true != this.zzh ? "0" : "1";
        hashMap.put("cacheReady", (String)object);
        hashMap.put("playerCount", Integer.toString(this.zzi));
        hashMap.put("playerPreparedCount", Integer.toString(this.zzj));
        zzcla.zzs((zzcla)this.zzk, (String)"onPrecacheEvent", hashMap);
    }
}
