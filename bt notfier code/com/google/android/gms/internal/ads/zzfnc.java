/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfna
 *  com.google.android.gms.internal.ads.zzfnb
 *  com.google.android.gms.internal.ads.zzfnd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfna;
import com.google.android.gms.internal.ads.zzfnb;
import com.google.android.gms.internal.ads.zzfnd;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.CheckForNull;

class zzfnc
extends zzfna
implements List {
    final zzfnd zzf;

    zzfnc(zzfnd zzfnd2, Object object, @CheckForNull List list, zzfna zzfna2) {
        this.zzf = zzfnd2;
        super(zzfnd2, object, (Collection)list, zzfna2);
    }

    public final void add(int n, Object object) {
        this.zza();
        boolean bl = this.zzb.isEmpty();
        ((List)this.zzb).add(n, object);
        object = this.zzf;
        zzfnd.zzf((zzfnd)object, (int)(zzfnd.zze((zzfnd)object) + 1));
        if (!bl) return;
        this.zzc();
    }

    public final boolean addAll(int n, Collection collection) {
        boolean bl;
        if (collection.isEmpty()) {
            return false;
        }
        int n2 = this.size();
        boolean bl2 = bl = ((List)this.zzb).addAll(n, collection);
        if (!bl) return bl2;
        n = this.zzb.size();
        collection = this.zzf;
        zzfnd.zzf((zzfnd)collection, (int)(zzfnd.zze((zzfnd)collection) + (n - n2)));
        bl2 = bl;
        if (n2 != 0) return bl2;
        this.zzc();
        bl2 = true;
        return bl2;
    }

    public final Object get(int n) {
        this.zza();
        return ((List)this.zzb).get(n);
    }

    @Override
    public final int indexOf(@CheckForNull Object object) {
        this.zza();
        return ((List)this.zzb).indexOf(object);
    }

    @Override
    public final int lastIndexOf(@CheckForNull Object object) {
        this.zza();
        return ((List)this.zzb).lastIndexOf(object);
    }

    public final ListIterator listIterator() {
        this.zza();
        return new zzfnb(this);
    }

    public final ListIterator listIterator(int n) {
        this.zza();
        return new zzfnb(this, n);
    }

    public final Object remove(int n) {
        this.zza();
        Object e = ((List)this.zzb).remove(n);
        zzfnd zzfnd2 = this.zzf;
        zzfnd.zzf((zzfnd)zzfnd2, (int)(zzfnd.zze((zzfnd)zzfnd2) - 1));
        this.zzb();
        return e;
    }

    public final Object set(int n, Object object) {
        this.zza();
        return ((List)this.zzb).set(n, object);
    }

    public final List subList(int n, int n2) {
        this.zza();
        zzfnd zzfnd2 = this.zzf;
        Object object = this.zza;
        List list = ((List)this.zzb).subList(n, n2);
        zzfna zzfna2 = this.zzc;
        if (zzfna2 != null) return zzfnd2.zzj(object, list, zzfna2);
        zzfna2 = this;
        return zzfnd2.zzj(object, list, zzfna2);
    }
}
