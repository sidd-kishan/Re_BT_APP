/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzzn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzzn;
import java.util.HashMap;

public final class zzabv
extends zzzn<Integer, Long> {
    public Long zza;
    public Long zzb;
    public Long zzc;
    public Long zzd;

    public zzabv() {
    }

    public zzabv(String object) {
        object = zzabv.zzb((String)object);
        if (object == null) return;
        this.zza = (Long)((HashMap)object).get(0);
        this.zzb = (Long)((HashMap)object).get(1);
        this.zzc = (Long)((HashMap)object).get(2);
        this.zzd = (Long)((HashMap)object).get(3);
    }

    protected final HashMap<Integer, Long> zza() {
        HashMap<Integer, Long> hashMap = new HashMap<Integer, Long>();
        hashMap.put(0, this.zza);
        hashMap.put(1, this.zzb);
        hashMap.put(2, this.zzc);
        hashMap.put(3, this.zzd);
        return hashMap;
    }
}
