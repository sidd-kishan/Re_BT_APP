/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzzn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzzn;
import java.util.HashMap;

public final class zzabt
extends zzzn<Integer, Long> {
    public Long zza;
    public Long zzb;
    public Long zzc;
    public Long zzd;
    public Long zze;
    public Long zzf;
    public Long zzg;
    public Long zzh;
    public Long zzi;
    public Long zzj;
    public Long zzk;

    public zzabt() {
    }

    public zzabt(String object) {
        object = zzabt.zzb((String)object);
        if (object == null) return;
        this.zza = (Long)((HashMap)object).get(0);
        this.zzb = (Long)((HashMap)object).get(1);
        this.zzc = (Long)((HashMap)object).get(2);
        this.zzd = (Long)((HashMap)object).get(3);
        this.zze = (Long)((HashMap)object).get(4);
        this.zzf = (Long)((HashMap)object).get(5);
        this.zzg = (Long)((HashMap)object).get(6);
        this.zzh = (Long)((HashMap)object).get(7);
        this.zzi = (Long)((HashMap)object).get(8);
        this.zzj = (Long)((HashMap)object).get(9);
        this.zzk = (Long)((HashMap)object).get(10);
    }

    protected final HashMap<Integer, Long> zza() {
        HashMap<Integer, Long> hashMap = new HashMap<Integer, Long>();
        hashMap.put(0, this.zza);
        hashMap.put(1, this.zzb);
        hashMap.put(2, this.zzc);
        hashMap.put(3, this.zzd);
        hashMap.put(4, this.zze);
        hashMap.put(5, this.zzf);
        hashMap.put(6, this.zzg);
        hashMap.put(7, this.zzh);
        hashMap.put(8, this.zzi);
        hashMap.put(9, this.zzj);
        hashMap.put(10, this.zzk);
        return hashMap;
    }
}
