/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzfql
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzfql;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import javax.annotation.CheckForNull;

public abstract class zzfoe<E>
extends AbstractCollection<E>
implements Serializable {
    private static final Object[] zza = new Object[0];

    zzfoe() {
    }

    @Override
    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public abstract boolean contains(@CheckForNull Object var1);

    @Override
    @Deprecated
    public final boolean remove(@CheckForNull Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Object[] toArray() {
        return this.toArray(zza);
    }

    @Override
    public final <T> T[] toArray(T[] TArray) {
        Object[] objectArray;
        if (TArray == null) throw null;
        int n = TArray.length;
        int n2 = this.size();
        if (n < n2) {
            objectArray = this.zzb();
            if (objectArray != null) return Arrays.copyOfRange(objectArray, this.zzc(), this.zzd(), TArray.getClass());
            objectArray = (Object[])Array.newInstance(TArray.getClass().getComponentType(), n2);
        } else {
            objectArray = TArray;
            if (n > n2) {
                TArray[n2] = null;
                objectArray = TArray;
            }
        }
        this.zzg(objectArray, 0);
        return objectArray;
    }

    public abstract zzfql<E> zza();

    @CheckForNull
    Object[] zzb() {
        return null;
    }

    int zzc() {
        throw new UnsupportedOperationException();
    }

    int zzd() {
        throw new UnsupportedOperationException();
    }

    public zzfoj<E> zze() {
        zzfoj zzfoj2 = this.isEmpty() ? zzfoj.zzi() : zzfoj.zzr((Object[])this.toArray(zza));
        return zzfoj2;
    }

    abstract boolean zzf();

    int zzg(Object[] objectArray, int n) {
        throw null;
    }
}
