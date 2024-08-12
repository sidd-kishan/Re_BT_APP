/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzghb
 *  com.google.android.gms.internal.ads.zzghc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzghb;
import com.google.android.gms.internal.ads.zzghc;
import java.util.Map;

final class zzghd {
    zzghd() {
    }

    public static final int zza(int n, Object object, Object object2) {
        object = (zzghc)object;
        object2 = (zzghb)object2;
        if (object.isEmpty()) return 0;
        if (!(object = object.entrySet().iterator()).hasNext()) return 0;
        object = (Map.Entry)object.next();
        object.getKey();
        object.getValue();
        throw null;
    }

    public static final boolean zzb(Object object) {
        if (((zzghc)object).zze()) return false;
        return true;
    }

    public static final Object zzc(Object object, Object object2) {
        zzghc zzghc2 = (zzghc)object;
        object2 = (zzghc)object2;
        object = zzghc2;
        if (object2.isEmpty()) return object;
        object = zzghc2;
        if (!zzghc2.zze()) {
            object = zzghc2.zzc();
        }
        object.zzb((zzghc)object2);
        return object;
    }
}
