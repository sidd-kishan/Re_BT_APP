/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfni
 *  com.google.android.gms.internal.ads.zzfnz
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzfol
 *  com.google.android.gms.internal.ads.zzfom
 *  com.google.android.gms.internal.ads.zzfop
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfni;
import com.google.android.gms.internal.ads.zzfnz;
import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzfol;
import com.google.android.gms.internal.ads.zzfom;
import com.google.android.gms.internal.ads.zzfop;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzfok<K, V>
extends zzfop<K, V> {
    public final zzfok<K, V> zza(K k, V ... object) {
        Object object2 = Arrays.asList(object);
        object = (Collection)this.zza.get(k);
        if (object != null) {
            Iterator iterator = object2.iterator();
            while (iterator.hasNext()) {
                object2 = iterator.next();
                zzfni.zza(k, (Object)object2);
                object.add(object2);
            }
            return this;
        }
        if (!(object2 = object2.iterator()).hasNext()) return this;
        object = new ArrayList();
        while (true) {
            if (!object2.hasNext()) {
                this.zza.put(k, object);
                return this;
            }
            Object e = object2.next();
            zzfni.zza(k, e);
            object.add(e);
        }
    }

    public final zzfol<K, V> zzb() {
        zzfnz zzfnz2;
        Set set = this.zza.entrySet();
        if (set.isEmpty()) {
            zzfnz2 = zzfnz.zza;
        } else {
            zzfnz2 = new zzfom(set.size());
            Iterator iterator = set.iterator();
            int n = 0;
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry)iterator.next();
                set = entry.getKey();
                if ((entry = zzfoj.zzp((Collection)((Collection)entry.getValue()))).isEmpty()) continue;
                zzfnz2.zza(set, (Object)entry);
                n += entry.size();
            }
            zzfnz2 = new zzfol(zzfnz2.zzc(), n);
        }
        return zzfnz2;
    }
}
