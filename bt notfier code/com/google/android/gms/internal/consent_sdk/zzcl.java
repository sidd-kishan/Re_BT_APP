/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.consent_sdk.zzck
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzck;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzcl {
    private final ConcurrentHashMap<zzck, List<Throwable>> zza = new ConcurrentHashMap(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzb = new ReferenceQueue();

    zzcl() {
    }

    public final List<Throwable> zza(Throwable object, boolean bl) {
        Object object2 = this.zzb.poll();
        while (object2 != null) {
            this.zza.remove(object2);
            object2 = this.zzb.poll();
        }
        object2 = new zzck((Throwable)object, null);
        if ((object2 = this.zza.get(object2)) != null) {
            return object2;
        }
        object2 = new Vector(2);
        if ((object = this.zza.putIfAbsent(new zzck((Throwable)object, this.zzb), (List<Throwable>)object2)) != null) return object;
        return object2;
    }
}
