/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaud
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaud;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzclf {
    private final ArrayList<zzaud> zza = new ArrayList();
    private long zzb;

    zzclf() {
    }

    final long zza() {
        Iterator<zzaud> iterator = this.zza.iterator();
        while (iterator.hasNext()) {
            Map map = iterator.next().zze();
            if (map == null) continue;
            for (Map.Entry runtimeException : map.entrySet()) {
                try {
                    if (!"content-length".equalsIgnoreCase((String)runtimeException.getKey())) continue;
                    long l = Long.parseLong((String)((List)runtimeException.getValue()).get(0));
                    this.zzb = Math.max(this.zzb, l);
                }
                catch (RuntimeException runtimeException2) {}
            }
            iterator.remove();
        }
        return this.zzb;
    }

    final void zzb(zzaud zzaud2) {
        this.zza.add(zzaud2);
    }
}
