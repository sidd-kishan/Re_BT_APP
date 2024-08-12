/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.ads.nonagon.signalgeneration.zza
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 */
package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.nonagon.signalgeneration.zza;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Map;

public final class zzb {
    private final int zza;
    private final long zzb;
    private final Map<String, Pair<Long, String>> zzc;

    public zzb() {
        zzbjd zzbjd2 = zzbjl.zzfj;
        this.zza = (Integer)zzbet.zzc().zzc(zzbjd2);
        zzbjd2 = zzbjl.zzfk;
        this.zzb = (Long)zzbet.zzc().zzc(zzbjd2);
        this.zzc = Collections.synchronizedMap(new zza(this));
    }

    static /* synthetic */ int zza(zzb zzb2) {
        return zzb2.zza;
    }

    private final void zze() {
        long l = zzt.zzj().currentTimeMillis();
        Object object = this.zzc.entrySet();
        try {
            object = object.iterator();
            while (object.hasNext()) {
                if (l - (Long)((Pair)((Map.Entry)object.next()).getValue()).first <= this.zzb) return;
                object.remove();
            }
            return;
        }
        catch (ConcurrentModificationException concurrentModificationException) {
            zzt.zzg().zzk((Throwable)concurrentModificationException, "QueryJsonMap.removeExpiredEntries");
            return;
        }
    }

    public final void zzb(String string, String string2) {
        synchronized (this) {
            Map<String, Pair<Long, String>> map = this.zzc;
            Pair pair = new Pair((Object)zzt.zzj().currentTimeMillis(), (Object)string2);
            map.put(string, (Pair<Long, String>)pair);
            this.zze();
            return;
        }
    }

    public final String zzc(String string) {
        synchronized (this) {
            Object object = this.zzc.get(string);
            if (object == null) return null;
            object = (String)object.second;
            this.zzc.remove(string);
            return object;
        }
    }

    public final void zzd(String string) {
        synchronized (this) {
            this.zzc.remove(string);
            return;
        }
    }
}
