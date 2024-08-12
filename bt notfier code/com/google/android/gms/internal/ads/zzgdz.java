/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgdy
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgdy;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzgdz {
    private final ConcurrentHashMap<zzgdy, List<Throwable>> zza = new ConcurrentHashMap(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzb = new ReferenceQueue();

    zzgdz() {
    }

    public final List<Throwable> zza(Throwable object, boolean bl) {
        Vector<Throwable> vector = this.zzb;
        while ((vector = ((ReferenceQueue)((Object)vector)).poll()) != null) {
            this.zza.remove(vector);
            vector = this.zzb;
        }
        vector = new zzgdy((Throwable)object, null);
        vector = this.zza.get(vector);
        if (!bl) {
            return vector;
        }
        if (vector != null) {
            return vector;
        }
        vector = new Vector<Throwable>(2);
        if ((object = (List)this.zza.putIfAbsent(new zzgdy((Throwable)object, this.zzb), vector)) != null) return object;
        return vector;
    }
}
