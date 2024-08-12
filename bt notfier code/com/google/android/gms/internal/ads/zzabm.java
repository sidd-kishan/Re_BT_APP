/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzzn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzzn;
import java.util.HashMap;

public final class zzabm
extends zzzn<Integer, Long> {
    public Long zza;
    public Long zzb;

    public zzabm() {
    }

    public zzabm(String object) {
        object = zzabm.zzb((String)object);
        if (object == null) return;
        this.zza = (Long)((HashMap)object).get(0);
        this.zzb = (Long)((HashMap)object).get(1);
    }

    protected final HashMap<Integer, Long> zza() {
        HashMap<Integer, Long> hashMap = new HashMap<Integer, Long>();
        hashMap.put(0, this.zza);
        hashMap.put(1, this.zzb);
        return hashMap;
    }
}
