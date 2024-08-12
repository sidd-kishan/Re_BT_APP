/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.common.zzk
 *  com.google.android.gms.internal.common.zzl
 *  com.google.android.gms.internal.common.zzq
 *  com.google.android.gms.internal.common.zzr
 *  com.google.android.gms.internal.common.zzs
 *  com.google.android.gms.internal.common.zzt
 *  com.google.android.gms.internal.common.zzv
 *  com.google.android.gms.internal.common.zzw
 *  com.google.android.gms.internal.common.zzx
 *  com.google.android.gms.internal.common.zzy
 *  org.checkerframework.checker.nullness.compatqual.NullableDecl
 */
package com.google.android.gms.internal.common;

import com.google.android.gms.internal.common.zzk;
import com.google.android.gms.internal.common.zzl;
import com.google.android.gms.internal.common.zzq;
import com.google.android.gms.internal.common.zzr;
import com.google.android.gms.internal.common.zzs;
import com.google.android.gms.internal.common.zzt;
import com.google.android.gms.internal.common.zzv;
import com.google.android.gms.internal.common.zzw;
import com.google.android.gms.internal.common.zzx;
import com.google.android.gms.internal.common.zzy;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzu<E>
extends zzq<E>
implements List<E>,
RandomAccess {
    private static final zzy<Object> zza = new zzs(zzw.zza, 0);

    zzu() {
    }

    public static <E> zzu<E> zzi() {
        return zzw.zza;
    }

    public static <E> zzu<E> zzj(E e) {
        Object[] objectArray = new Object[]{e};
        zzv.zza((Object[])objectArray, (int)1);
        return zzu.zzn(objectArray, 1);
    }

    public static <E> zzu<E> zzk(E e, E e2) {
        Object[] objectArray = new Object[]{e, e2};
        zzv.zza((Object[])objectArray, (int)2);
        return zzu.zzn(objectArray, 2);
    }

    public static <E> zzu<E> zzl(Iterable<? extends E> zzu2) {
        if (zzu2 == null) throw null;
        if (zzu2 instanceof Collection) {
            zzu2 = zzu.zzm((Collection)zzu2);
        } else {
            Iterator<E> iterator = zzu2.iterator();
            if (!iterator.hasNext()) {
                zzu2 = zzw.zza;
            } else {
                zzu2 = iterator.next();
                if (!iterator.hasNext()) {
                    zzu2 = zzu.zzj(zzu2);
                } else {
                    zzr zzr2 = new zzr(4);
                    zzr2.zzb(zzu2);
                    zzr2.zzc(iterator);
                    zzr2.zzc = true;
                    zzu2 = zzu.zzn(zzr2.zza, zzr2.zzb);
                }
            }
        }
        return zzu2;
    }

    public static <E> zzu<E> zzm(Collection<? extends E> object) {
        if (object instanceof zzq) {
            zzu zzu2 = ((zzq)object).zze();
            object = zzu2;
            if (!zzu2.zzf()) return object;
            object = zzu2.toArray();
            object = zzu.zzn(object, ((Object[])object).length);
            return object;
        }
        object = object.toArray();
        int n = ((Object[])object).length;
        zzv.zza((Object[])object, (int)n);
        return zzu.zzn(object, n);
    }

    static <E> zzu<E> zzn(Object[] objectArray, int n) {
        if (n != 0) return new zzw(objectArray, n);
        return zzw.zza;
    }

    @Override
    @Deprecated
    public final void add(int n, E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean addAll(int n, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean contains(@NullableDecl Object object) {
        if (this.indexOf(object) < 0) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    @Override
    public final boolean equals(@NullableDecl Object iterator) {
        boolean bl = true;
        if (iterator == this) {
            return bl;
        }
        if (!(iterator instanceof List)) return false;
        Object object = (List)((Object)iterator);
        int n = this.size();
        if (n != object.size()) return false;
        if (!(object instanceof RandomAccess)) {
            iterator = this.iterator();
            object = object.iterator();
        } else {
            int n2 = 0;
            while (true) {
                boolean bl2 = bl;
                if (n2 >= n) return bl2;
                if (!zzk.zza(this.get(n2), object.get(n2))) return false;
                ++n2;
            }
        }
        while (iterator.hasNext()) {
            if (object.hasNext() && zzk.zza(iterator.next(), object.next())) continue;
            return false;
        }
        if (!object.hasNext()) return bl;
        return false;
    }

    @Override
    public final int hashCode() {
        int n = this.size();
        int n2 = 1;
        int n3 = 0;
        while (n3 < n) {
            n2 = n2 * 31 + this.get(n3).hashCode();
            ++n3;
        }
        return n2;
    }

    @Override
    public final int indexOf(@NullableDecl Object object) {
        int n = -1;
        if (object == null) {
            return -1;
        }
        int n2 = this.size();
        int n3 = 0;
        while (true) {
            int n4 = n;
            if (n3 >= n2) return n4;
            if (object.equals(this.get(n3))) {
                n4 = n3;
                return n4;
            }
            ++n3;
        }
    }

    @Override
    public final int lastIndexOf(@NullableDecl Object object) {
        int n = -1;
        if (object == null) {
            return -1;
        }
        int n2 = this.size() - 1;
        while (true) {
            int n3 = n;
            if (n2 < 0) return n3;
            if (object.equals(this.get(n2))) {
                n3 = n2;
                return n3;
            }
            --n2;
        }
    }

    @Override
    @Deprecated
    public final E remove(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final E set(int n, E e) {
        throw new UnsupportedOperationException();
    }

    public final zzx<E> zza() {
        return this.zzo(0);
    }

    public final zzu<E> zze() {
        return this;
    }

    int zzg(Object[] objectArray, int n) {
        int n2 = this.size();
        n = 0;
        while (n < n2) {
            objectArray[n] = this.get(n);
            ++n;
        }
        return n2;
    }

    public zzu<E> zzh(int n, int n2) {
        zzl.zzc((int)n, (int)n2, (int)this.size());
        if ((n2 -= n) == this.size()) {
            return this;
        }
        if (n2 != 0) return new zzt(this, n, n2);
        return zzw.zza;
    }

    public final zzy<E> zzo(int n) {
        zzl.zzb((int)n, (int)this.size(), (String)"index");
        if (!this.isEmpty()) return new zzs(this, n);
        return zza;
    }
}
