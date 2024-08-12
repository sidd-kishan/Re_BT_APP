/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgd
 *  com.google.android.gms.internal.measurement.zzhx
 *  com.google.android.gms.internal.measurement.zzhz
 *  com.google.android.gms.internal.measurement.zzjd
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzhx;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzjd;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzil
extends zzgd<Long>
implements RandomAccess,
zzhx,
zzjd {
    private static final zzil zza;
    private long[] zzb;
    private int zzc;

    static {
        zzil zzil2;
        zza = zzil2 = new zzil(new long[0], 0);
        zzil2.zzb();
    }

    zzil() {
        this(new long[10], 0);
    }

    private zzil(long[] lArray, int n) {
        this.zzb = lArray;
        this.zzc = n;
    }

    public static zzil zzf() {
        return zza;
    }

    private final void zzh(int n) {
        if (n < 0) throw new IndexOutOfBoundsException(this.zzi(n));
        if (n >= this.zzc) throw new IndexOutOfBoundsException(this.zzi(n));
    }

    private final String zzi(int n) {
        int n2 = this.zzc;
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Index:");
        stringBuilder.append(n);
        stringBuilder.append(", Size:");
        stringBuilder.append(n2);
        return stringBuilder.toString();
    }

    public final boolean addAll(Collection<? extends Long> object) {
        this.zzbL();
        zzhz.zza(object);
        if (!(object instanceof zzil)) {
            return super.addAll(object);
        }
        zzil zzil2 = (zzil)object;
        int n = zzil2.zzc;
        if (n == 0) {
            return false;
        }
        int n2 = this.zzc;
        if (Integer.MAX_VALUE - n2 < n) throw new OutOfMemoryError();
        object = this.zzb;
        if ((n2 += n) > ((Object)object).length) {
            this.zzb = Arrays.copyOf((long[])object, n2);
        }
        System.arraycopy(zzil2.zzb, 0, this.zzb, this.zzc, zzil2.zzc);
        this.zzc = n2;
        ++this.modCount;
        return true;
    }

    public final boolean contains(Object object) {
        if (this.indexOf(object) == -1) return false;
        return true;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzil)) {
            return super.equals(object);
        }
        object = (zzil)object;
        if (this.zzc != ((zzil)object).zzc) {
            return false;
        }
        object = ((zzil)object).zzb;
        int n = 0;
        while (n < this.zzc) {
            if (this.zzb[n] != object[n]) {
                return false;
            }
            ++n;
        }
        return true;
    }

    public final int hashCode() {
        int n = 1;
        int n2 = 0;
        while (n2 < this.zzc) {
            n = n * 31 + zzhz.zze((long)this.zzb[n2]);
            ++n2;
        }
        return n;
    }

    public final int indexOf(Object object) {
        if (!(object instanceof Long)) {
            return -1;
        }
        long l = (Long)object;
        int n = this.zzc;
        int n2 = 0;
        while (n2 < n) {
            if (this.zzb[n2] == l) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    protected final void removeRange(int n, int n2) {
        this.zzbL();
        if (n2 < n) throw new IndexOutOfBoundsException("toIndex < fromIndex");
        long[] lArray = this.zzb;
        System.arraycopy(lArray, n2, lArray, n, this.zzc - n2);
        this.zzc -= n2 - n;
        ++this.modCount;
    }

    public final int size() {
        return this.zzc;
    }

    public final long zzc(int n) {
        this.zzh(n);
        return this.zzb[n];
    }

    public final zzhx zzd(int n) {
        if (n < this.zzc) throw new IllegalArgumentException();
        return new zzil(Arrays.copyOf(this.zzb, n), this.zzc);
    }

    public final void zzg(long l) {
        long[] lArray;
        this.zzbL();
        int n = this.zzc;
        long[] lArray2 = this.zzb;
        if (n == lArray2.length) {
            lArray = new long[n * 3 / 2 + 1];
            System.arraycopy(lArray2, 0, lArray, 0, n);
            this.zzb = lArray;
        }
        lArray = this.zzb;
        n = this.zzc;
        this.zzc = n + 1;
        lArray[n] = l;
    }
}
