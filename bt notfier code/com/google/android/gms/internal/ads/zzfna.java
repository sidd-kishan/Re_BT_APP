/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfmz
 *  com.google.android.gms.internal.ads.zzfnd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfmz;
import com.google.android.gms.internal.ads.zzfnd;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import javax.annotation.CheckForNull;

class zzfna
extends AbstractCollection {
    final Object zza;
    Collection zzb;
    @CheckForNull
    final zzfna zzc;
    @CheckForNull
    final Collection zzd;
    final zzfnd zze;

    zzfna(zzfnd object, Object object2, @CheckForNull Collection collection, zzfna zzfna2) {
        this.zze = object;
        this.zza = object2;
        this.zzb = collection;
        this.zzc = zzfna2;
        object = zzfna2 == null ? null : zzfna2.zzb;
        this.zzd = object;
    }

    @Override
    public final boolean add(Object object) {
        this.zza();
        boolean bl = this.zzb.isEmpty();
        boolean bl2 = this.zzb.add(object);
        if (!bl2) return bl2;
        object = this.zze;
        zzfnd.zzf((zzfnd)object, (int)(zzfnd.zze((zzfnd)object) + 1));
        if (!bl) return bl2;
        this.zzc();
        return true;
    }

    @Override
    public final boolean addAll(Collection collection) {
        boolean bl;
        if (collection.isEmpty()) {
            return false;
        }
        int n = this.size();
        boolean bl2 = bl = this.zzb.addAll(collection);
        if (!bl) return bl2;
        int n2 = this.zzb.size();
        collection = this.zze;
        zzfnd.zzf((zzfnd)collection, (int)(zzfnd.zze((zzfnd)collection) + (n2 - n)));
        bl2 = bl;
        if (n != 0) return bl2;
        this.zzc();
        bl2 = true;
        return bl2;
    }

    @Override
    public final void clear() {
        int n = this.size();
        if (n == 0) {
            return;
        }
        this.zzb.clear();
        zzfnd zzfnd2 = this.zze;
        zzfnd.zzf((zzfnd)zzfnd2, (int)(zzfnd.zze((zzfnd)zzfnd2) - n));
        this.zzb();
    }

    @Override
    public final boolean contains(@CheckForNull Object object) {
        this.zza();
        return this.zzb.contains(object);
    }

    @Override
    public final boolean containsAll(Collection<?> collection) {
        this.zza();
        return this.zzb.containsAll(collection);
    }

    @Override
    public final boolean equals(@CheckForNull Object object) {
        if (object == this) {
            return true;
        }
        this.zza();
        return this.zzb.equals(object);
    }

    @Override
    public final int hashCode() {
        this.zza();
        return this.zzb.hashCode();
    }

    @Override
    public final Iterator iterator() {
        this.zza();
        return new zzfmz(this);
    }

    @Override
    public final boolean remove(@CheckForNull Object object) {
        this.zza();
        boolean bl = this.zzb.remove(object);
        if (!bl) return bl;
        object = this.zze;
        zzfnd.zzf((zzfnd)object, (int)(zzfnd.zze((zzfnd)object) - 1));
        this.zzb();
        return bl;
    }

    @Override
    public final boolean removeAll(Collection<?> zzfnd2) {
        if (zzfnd2.isEmpty()) {
            return false;
        }
        int n = this.size();
        boolean bl = this.zzb.removeAll((Collection<?>)zzfnd2);
        if (!bl) return bl;
        int n2 = this.zzb.size();
        zzfnd2 = this.zze;
        zzfnd.zzf((zzfnd)zzfnd2, (int)(zzfnd.zze((zzfnd)zzfnd2) + (n2 - n)));
        this.zzb();
        return bl;
    }

    @Override
    public final boolean retainAll(Collection<?> zzfnd2) {
        if (zzfnd2 == null) throw null;
        int n = this.size();
        boolean bl = this.zzb.retainAll((Collection<?>)zzfnd2);
        if (!bl) return bl;
        int n2 = this.zzb.size();
        zzfnd2 = this.zze;
        zzfnd.zzf((zzfnd)zzfnd2, (int)(zzfnd.zze((zzfnd)zzfnd2) + (n2 - n)));
        this.zzb();
        return bl;
    }

    @Override
    public final int size() {
        this.zza();
        return this.zzb.size();
    }

    @Override
    public final String toString() {
        this.zza();
        return this.zzb.toString();
    }

    final void zza() {
        Collection collection = this.zzc;
        if (collection != null) {
            collection.zza();
            if (this.zzc.zzb != this.zzd) throw new ConcurrentModificationException();
        } else {
            if (!this.zzb.isEmpty()) return;
            collection = (Collection)zzfnd.zzd((zzfnd)this.zze).get(this.zza);
            if (collection == null) return;
            this.zzb = collection;
        }
    }

    final void zzb() {
        zzfna zzfna2 = this.zzc;
        if (zzfna2 != null) {
            zzfna2.zzb();
            return;
        }
        if (!this.zzb.isEmpty()) return;
        zzfnd.zzd((zzfnd)this.zze).remove(this.zza);
    }

    final void zzc() {
        zzfna zzfna2 = this.zzc;
        if (zzfna2 != null) {
            zzfna2.zzc();
            return;
        }
        zzfnd.zzd((zzfnd)this.zze).put(this.zza, this.zzb);
    }
}
