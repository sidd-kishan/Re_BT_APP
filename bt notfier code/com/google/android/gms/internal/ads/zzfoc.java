/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfod
 *  com.google.android.gms.internal.ads.zzfoe
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfod;
import com.google.android.gms.internal.ads.zzfoe;
import java.util.Arrays;

class zzfoc<E>
extends zzfod<E> {
    Object[] zza;
    int zzb;
    boolean zzc;

    zzfoc(int n) {
        this.zza = new Object[n];
        this.zzb = 0;
    }

    private final void zze(int n) {
        Object[] objectArray = this.zza;
        int n2 = objectArray.length;
        if (n2 < n) {
            this.zza = Arrays.copyOf(objectArray, zzfoc.zzd((int)n2, (int)n));
            this.zzc = false;
            return;
        }
        if (!this.zzc) return;
        this.zza = (Object[])objectArray.clone();
        this.zzc = false;
    }

    public final zzfoc<E> zza(E e) {
        if (e == null) throw null;
        this.zze(this.zzb + 1);
        Object[] objectArray = this.zza;
        int n = this.zzb;
        this.zzb = n + 1;
        objectArray[n] = e;
        return this;
    }

    public final zzfod<E> zzb(Iterable<? extends E> object) {
        this.zze(this.zzb + object.size());
        if (object instanceof zzfoe) {
            this.zzb = ((zzfoe)object).zzg(this.zza, this.zzb);
            return this;
        }
        object = object.iterator();
        while (object.hasNext()) {
            this.zzc(object.next());
        }
        return this;
    }
}
