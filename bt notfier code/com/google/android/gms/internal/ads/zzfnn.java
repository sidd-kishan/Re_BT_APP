/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflx
 *  com.google.android.gms.internal.ads.zzfnq
 *  com.google.android.gms.internal.ads.zzfns
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflx;
import com.google.android.gms.internal.ads.zzfnq;
import com.google.android.gms.internal.ads.zzfns;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class zzfnn<T>
implements Iterator<T> {
    int zzb;
    int zzc;
    int zzd;
    final zzfns zze;

    /* synthetic */ zzfnn(zzfns zzfns2, zzfnq zzfnq2) {
        this.zze = zzfns2;
        this.zzb = zzfns.zzb((zzfns)this.zze);
        this.zzc = this.zze.zzm();
        this.zzd = -1;
    }

    private final void zzb() {
        if (zzfns.zzb((zzfns)this.zze) != this.zzb) throw new ConcurrentModificationException();
    }

    @Override
    public final boolean hasNext() {
        if (this.zzc < 0) return false;
        return true;
    }

    @Override
    public final T next() {
        int n;
        this.zzb();
        if (!this.hasNext()) throw new NoSuchElementException();
        this.zzd = n = this.zzc;
        T t = this.zza(n);
        this.zzc = this.zze.zzn(this.zzc);
        return t;
    }

    @Override
    public final void remove() {
        this.zzb();
        boolean bl = this.zzd >= 0;
        zzflx.zzb((boolean)bl, (Object)"no calls to next() since the last call to remove()");
        this.zzb += 32;
        zzfns zzfns2 = this.zze;
        zzfns2.remove(zzfns.zzs((zzfns)zzfns2, (int)this.zzd));
        --this.zzc;
        this.zzd = -1;
    }

    abstract T zza(int var1);
}
