/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgeh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgeh;
import java.util.Arrays;
import java.util.RandomAccess;

final class zzghr<E>
extends zzgeh<E>
implements RandomAccess {
    private static final zzghr<Object> zza;
    private E[] zzb;
    private int zzc;

    static {
        zzghr<Object> zzghr2 = new zzghr<Object>(new Object[0], 0);
        zza = zzghr2;
        zzghr2.zzb();
    }

    zzghr() {
        this(new Object[10], 0);
    }

    private zzghr(E[] EArray, int n) {
        this.zzb = EArray;
        this.zzc = n;
    }

    public static <E> zzghr<E> zzd() {
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
        this.zzbH();
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
        this.zzbH();
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
        this.zzbH();
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
        this.zzbH();
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
