/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgd
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgd;
import java.util.Arrays;
import java.util.RandomAccess;

final class zzjf<E>
extends zzgd<E>
implements RandomAccess {
    private static final zzjf<Object> zza;
    private E[] zzb;
    private int zzc;

    static {
        zzjf<Object> zzjf2 = new zzjf<Object>(new Object[0], 0);
        zza = zzjf2;
        zzjf2.zzb();
    }

    zzjf() {
        this(new Object[10], 0);
    }

    private zzjf(E[] EArray, int n) {
        this.zzb = EArray;
        this.zzc = n;
    }

    public static <E> zzjf<E> zzd() {
        return zza;
    }

    private final void zzf(int n) {
        if (n < 0) throw new IndexOutOfBoundsException(this.zzg(n));
        if (n >= this.zzc) throw new IndexOutOfBoundsException(this.zzg(n));
    }

    private final String zzg(int n) {
        int n2 = this.zzc;
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Index:");
        stringBuilder.append(n);
        stringBuilder.append(", Size:");
        stringBuilder.append(n2);
        return stringBuilder.toString();
    }

    public final void add(int n, E e) {
        this.zzbL();
        if (n < 0) throw new IndexOutOfBoundsException(this.zzg(n));
        int n2 = this.zzc;
        if (n > n2) throw new IndexOutOfBoundsException(this.zzg(n));
        E[] EArray = this.zzb;
        if (n2 < EArray.length) {
            System.arraycopy(EArray, n, EArray, n + 1, n2 - n);
        } else {
            Object[] objectArray = new Object[n2 * 3 / 2 + 1];
            System.arraycopy(EArray, 0, objectArray, 0, n);
            System.arraycopy(this.zzb, n, objectArray, n + 1, this.zzc - n);
            this.zzb = objectArray;
        }
        this.zzb[n] = e;
        ++this.zzc;
        ++this.modCount;
    }

    public final boolean add(E e) {
        this.zzbL();
        int n = this.zzc;
        E[] EArray = this.zzb;
        if (n == EArray.length) {
            this.zzb = Arrays.copyOf(EArray, n * 3 / 2 + 1);
        }
        EArray = this.zzb;
        n = this.zzc;
        this.zzc = n + 1;
        EArray[n] = e;
        ++this.modCount;
        return true;
    }

    public final E get(int n) {
        this.zzf(n);
        return this.zzb[n];
    }

    public final E remove(int n) {
        this.zzbL();
        this.zzf(n);
        E[] EArray = this.zzb;
        E e = EArray[n];
        int n2 = this.zzc;
        if (n < n2 - 1) {
            System.arraycopy(EArray, n + 1, EArray, n, n2 - n - 1);
        }
        --this.zzc;
        ++this.modCount;
        return e;
    }

    public final E set(int n, E e) {
        this.zzbL();
        this.zzf(n);
        E[] EArray = this.zzb;
        E e2 = EArray[n];
        EArray[n] = e;
        ++this.modCount;
        return e2;
    }

    public final int size() {
        return this.zzc;
    }
}
