/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflt
 *  com.google.android.gms.internal.ads.zzflx
 *  com.google.android.gms.internal.ads.zzfoe
 *  com.google.android.gms.internal.ads.zzfog
 *  com.google.android.gms.internal.ads.zzfoh
 *  com.google.android.gms.internal.ads.zzfoi
 *  com.google.android.gms.internal.ads.zzfpv
 *  com.google.android.gms.internal.ads.zzfpx
 *  com.google.android.gms.internal.ads.zzfql
 *  com.google.android.gms.internal.ads.zzfqm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflt;
import com.google.android.gms.internal.ads.zzflx;
import com.google.android.gms.internal.ads.zzfoe;
import com.google.android.gms.internal.ads.zzfog;
import com.google.android.gms.internal.ads.zzfoh;
import com.google.android.gms.internal.ads.zzfoi;
import com.google.android.gms.internal.ads.zzfpv;
import com.google.android.gms.internal.ads.zzfpx;
import com.google.android.gms.internal.ads.zzfql;
import com.google.android.gms.internal.ads.zzfqm;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

public abstract class zzfoj<E>
extends zzfoe<E>
implements List<E>,
RandomAccess {
    private static final zzfqm<Object> zza = new zzfoh(zzfpx.zza, 0);

    zzfoj() {
    }

    public static <E> zzfoj<E> zzi() {
        return zzfpx.zza;
    }

    public static <E> zzfoj<E> zzj(E e) {
        Object[] objectArray = new Object[]{e};
        zzfpv.zza((Object[])objectArray, (int)1);
        return zzfoj.zzs(objectArray, 1);
    }

    public static <E> zzfoj<E> zzk(E e, E e2) {
        Object[] objectArray = new Object[]{e, e2};
        zzfpv.zza((Object[])objectArray, (int)2);
        return zzfoj.zzs(objectArray, 2);
    }

    public static <E> zzfoj<E> zzl(E object, E e, E e2) {
        object = new Object[]{"2011", "1009", "3010"};
        zzfpv.zza(object, (int)3);
        return zzfoj.zzs(object, 3);
    }

    public static <E> zzfoj<E> zzm(E e, E e2, E e3, E e4, E e5) {
        Object[] objectArray = new Object[]{e, e2, e3, e4, e5};
        zzfpv.zza((Object[])objectArray, (int)5);
        return zzfoj.zzs(objectArray, 5);
    }

    public static <E> zzfoj<E> zzn(E e, E e2, E e3, E e4, E e5, E e6) {
        Object[] objectArray = new Object[]{e, e2, e3, e4, e5, e6};
        zzfpv.zza((Object[])objectArray, (int)6);
        return zzfoj.zzs(objectArray, 6);
    }

    public static <E> zzfoj<E> zzo(Iterable<? extends E> iterable) {
        if (iterable == null) throw null;
        return zzfoj.zzp(iterable);
    }

    public static <E> zzfoj<E> zzp(Collection<? extends E> object) {
        if (object instanceof zzfoe) {
            zzfoj zzfoj2 = ((zzfoe)object).zze();
            object = zzfoj2;
            if (!zzfoj2.zzf()) return object;
            object = zzfoj2.toArray();
            object = zzfoj.zzs(object, ((Object[])object).length);
            return object;
        }
        object = object.toArray();
        int n = ((Object[])object).length;
        zzfpv.zza((Object[])object, (int)n);
        return zzfoj.zzs(object, n);
    }

    public static <E> zzfoj<E> zzq(E[] objectArray) {
        objectArray = (Object[])objectArray.clone();
        int n = objectArray.length;
        zzfpv.zza((Object[])objectArray, (int)n);
        return zzfoj.zzs(objectArray, n);
    }

    static <E> zzfoj<E> zzr(Object[] objectArray) {
        return zzfoj.zzs(objectArray, objectArray.length);
    }

    static <E> zzfoj<E> zzs(Object[] objectArray, int n) {
        if (n != 0) return new zzfpx(objectArray, n);
        return zzfpx.zza;
    }

    public static <E> zzfog<E> zzu() {
        return new zzfog(4);
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
    public final boolean contains(@CheckForNull Object object) {
        if (this.indexOf(object) < 0) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    @Override
    public final boolean equals(@CheckForNull Object iterator) {
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
                if (!zzflt.zza(this.get(n2), object.get(n2))) return false;
                ++n2;
            }
        }
        while (iterator.hasNext()) {
            if (object.hasNext() && zzflt.zza(iterator.next(), object.next())) continue;
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
    public final int indexOf(@CheckForNull Object object) {
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
    public final int lastIndexOf(@CheckForNull Object object) {
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

    public final zzfql<E> zza() {
        return this.zzt(0);
    }

    @Deprecated
    public final zzfoj<E> zze() {
        return this;
    }

    int zzg(Object[] objectArray, int n) {
        int n2 = this.size();
        int n3 = 0;
        while (n3 < n2) {
            objectArray[n + n3] = this.get(n3);
            ++n3;
        }
        return n + n2;
    }

    public zzfoj<E> zzh(int n, int n2) {
        zzflx.zzg((int)n, (int)n2, (int)this.size());
        if ((n2 -= n) == this.size()) {
            return this;
        }
        if (n2 != 0) return new zzfoi(this, n, n2);
        return zzfpx.zza;
    }

    public final zzfqm<E> zzt(int n) {
        zzflx.zzf((int)n, (int)this.size(), (String)"index");
        if (!this.isEmpty()) return new zzfoh(this, n);
        return zza;
    }
}
