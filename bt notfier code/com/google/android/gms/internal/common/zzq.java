/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.common.zzu
 *  com.google.android.gms.internal.common.zzx
 *  org.checkerframework.checker.nullness.compatqual.NullableDecl
 */
package com.google.android.gms.internal.common;

import com.google.android.gms.internal.common.zzu;
import com.google.android.gms.internal.common.zzx;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzq<E>
extends AbstractCollection<E>
implements Serializable {
    private static final Object[] zza = new Object[0];

    zzq() {
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
    @Deprecated
    public final boolean remove(Object object) {
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

    public abstract zzx<E> zza();

    @NullableDecl
    Object[] zzb() {
        throw null;
    }

    int zzc() {
        throw null;
    }

    int zzd() {
        throw null;
    }

    public zzu<E> zze() {
        throw null;
    }

    abstract boolean zzf();

    int zzg(Object[] objectArray, int n) {
        throw null;
    }
}
