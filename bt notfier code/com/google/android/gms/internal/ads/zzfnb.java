/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfmz
 *  com.google.android.gms.internal.ads.zzfna
 *  com.google.android.gms.internal.ads.zzfnc
 *  com.google.android.gms.internal.ads.zzfnd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfmz;
import com.google.android.gms.internal.ads.zzfna;
import com.google.android.gms.internal.ads.zzfnc;
import com.google.android.gms.internal.ads.zzfnd;
import java.util.List;
import java.util.ListIterator;

final class zzfnb
extends zzfmz
implements ListIterator {
    final zzfnc zzd;

    zzfnb(zzfnc zzfnc2) {
        this.zzd = zzfnc2;
        super((zzfna)zzfnc2);
    }

    public zzfnb(zzfnc zzfnc2, int n) {
        this.zzd = zzfnc2;
        super((zzfna)zzfnc2, ((List)zzfnc2.zzb).listIterator(n));
    }

    public final void add(Object object) {
        boolean bl = this.zzd.isEmpty();
        this.zza();
        ((ListIterator)this.zza).add(object);
        object = this.zzd.zzf;
        zzfnd.zzf((zzfnd)object, (int)(zzfnd.zze((zzfnd)object) + 1));
        if (!bl) return;
        this.zzd.zzc();
    }

    @Override
    public final boolean hasPrevious() {
        this.zza();
        return ((ListIterator)this.zza).hasPrevious();
    }

    @Override
    public final int nextIndex() {
        this.zza();
        return ((ListIterator)this.zza).nextIndex();
    }

    public final Object previous() {
        this.zza();
        return ((ListIterator)this.zza).previous();
    }

    @Override
    public final int previousIndex() {
        this.zza();
        return ((ListIterator)this.zza).previousIndex();
    }

    public final void set(Object object) {
        this.zza();
        ((ListIterator)this.zza).set(object);
    }
}
