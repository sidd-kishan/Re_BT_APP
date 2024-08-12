/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.common.zzp
 */
package com.google.android.gms.internal.common;

import com.google.android.gms.internal.common.zzp;
import java.util.Arrays;

class zzo<E>
extends zzp<E> {
    Object[] zza = new Object[4];
    int zzb = 0;
    boolean zzc;

    zzo(int n) {
    }

    private final void zzb(int n) {
        int n2;
        Object[] objectArray = this.zza;
        int n3 = objectArray.length;
        if (n3 >= n) {
            if (!this.zzc) return;
            this.zza = (Object[])objectArray.clone();
            this.zzc = false;
            return;
        }
        n3 = n2 = n3 + (n3 >> 1) + 1;
        if (n2 < n) {
            n = Integer.highestOneBit(n - 1);
            n3 = n + n;
        }
        n = n3;
        if (n3 < 0) {
            n = Integer.MAX_VALUE;
        }
        this.zza = Arrays.copyOf(objectArray, n);
        this.zzc = false;
    }

    public final zzo<E> zza(E e) {
        if (e == null) throw null;
        this.zzb(this.zzb + 1);
        Object[] objectArray = this.zza;
        int n = this.zzb;
        this.zzb = n + 1;
        objectArray[n] = e;
        return this;
    }
}
