/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzfv
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfv;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzfw {
    private final ConcurrentHashMap<zzfv, List<Throwable>> zza = new ConcurrentHashMap(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzb = new ReferenceQueue();

    zzfw() {
    }

    public final List<Throwable> zza(Throwable object, boolean bl) {
        Vector<Throwable> vector = this.zzb;
        while ((vector = ((ReferenceQueue)((Object)vector)).poll()) != null) {
            this.zza.remove(vector);
            vector = this.zzb;
        }
        vector = new zzfv((Throwable)object, null);
        if ((vector = this.zza.get(vector)) != null) {
            return vector;
        }
        vector = new Vector<Throwable>(2);
        if ((object = (List)this.zza.putIfAbsent(new zzfv((Throwable)object, this.zzb), vector)) != null) return object;
        return vector;
    }
}
