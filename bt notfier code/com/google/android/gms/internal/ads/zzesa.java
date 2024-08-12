/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzerx
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzerx;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.List;
import java.util.concurrent.Callable;

final class zzesa
implements Callable {
    private final List zza;
    private final Object zzb;

    zzesa(List list, Object object) {
        this.zza = list;
        this.zzb = object;
    }

    public final Object call() {
        Object object = this.zza;
        Object object2 = this.zzb;
        object = object.iterator();
        while (object.hasNext()) {
            zzerx zzerx2 = (zzerx)((zzfsm)object.next()).get();
            if (zzerx2 == null) continue;
            zzerx2.zzf(object2);
        }
        return object2;
    }
}
