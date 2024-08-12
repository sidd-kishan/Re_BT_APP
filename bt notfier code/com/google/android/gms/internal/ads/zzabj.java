/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzzn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzzn;
import java.util.HashMap;

public final class zzabj
extends zzzn<Integer, Object> {
    public Long zza;
    public Boolean zzb;
    public Boolean zzc;

    public zzabj() {
    }

    public zzabj(String object) {
        object = zzabj.zzb((String)object);
        if (object == null) return;
        this.zza = (Long)((HashMap)object).get(0);
        this.zzb = (Boolean)((HashMap)object).get(1);
        this.zzc = (Boolean)((HashMap)object).get(2);
    }

    protected final HashMap<Integer, Object> zza() {
        HashMap<Integer, Object> hashMap = new HashMap<Integer, Object>();
        hashMap.put(0, this.zza);
        hashMap.put(1, this.zzb);
        hashMap.put(2, this.zzc);
        return hashMap;
    }
}
