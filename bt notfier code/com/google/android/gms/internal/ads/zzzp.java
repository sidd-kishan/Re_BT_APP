/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzzn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzzn;
import java.util.HashMap;

public final class zzzp
extends zzzn<Integer, Object> {
    public String zza;
    public long zzb;
    public String zzc;
    public String zzd;
    public String zze;

    public zzzp() {
        this.zza = "E";
        this.zzb = -1L;
        this.zzc = "E";
        this.zzd = "E";
        this.zze = "E";
    }

    public zzzp(String object) {
        String string = "E";
        this.zza = "E";
        long l = -1L;
        this.zzb = -1L;
        this.zzc = "E";
        this.zzd = "E";
        this.zze = "E";
        HashMap hashMap = zzzp.zzb((String)object);
        if (hashMap == null) return;
        object = 0;
        object = hashMap.get(object) == null ? "E" : (String)hashMap.get(object);
        this.zza = object;
        object = 1;
        if (hashMap.get(object) != null) {
            l = (Long)hashMap.get(object);
        }
        this.zzb = l;
        object = 2;
        object = hashMap.get(object) == null ? "E" : (String)hashMap.get(object);
        this.zzc = object;
        object = 3;
        object = hashMap.get(object) == null ? "E" : (String)hashMap.get(object);
        this.zzd = object;
        object = 4;
        object = hashMap.get(object) == null ? string : (String)hashMap.get(object);
        this.zze = object;
    }

    protected final HashMap<Integer, Object> zza() {
        HashMap<Integer, Object> hashMap = new HashMap<Integer, Object>();
        hashMap.put(0, this.zza);
        hashMap.put(4, this.zze);
        hashMap.put(3, this.zzd);
        hashMap.put(2, this.zzc);
        hashMap.put(1, this.zzb);
        return hashMap;
    }
}
