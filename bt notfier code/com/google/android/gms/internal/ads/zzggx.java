/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgeh
 *  com.google.android.gms.internal.ads.zzggi
 *  com.google.android.gms.internal.ads.zzggk
 *  com.google.android.gms.internal.ads.zzghp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgeh;
import com.google.android.gms.internal.ads.zzggi;
import com.google.android.gms.internal.ads.zzggk;
import com.google.android.gms.internal.ads.zzghp;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzggx
extends zzgeh<Long>
implements RandomAccess,
zzggi,
zzghp {
    private static final zzggx zza;
    private long[] zzb;
    private int zzc;

    static {
        zzggx zzggx2;
        zza = zzggx2 = new zzggx(new long[0], 0);
        zzggx2.zzb();
    }

    zzggx() {
        this(new long[10], 0);
    }

    private zzggx(long[] lArray, int n) {
        this.zzb = lArray;
        this.zzc = n;
    }

    public static zzggx zzd() {
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
        this.zzbH();
        zzggk.zza(object);
        if (!(object instanceof zzggx)) {
            return super.addAll(object);
        }
        zzggx zzggx2 = (zzggx)object;
        int n = zzggx2.zzc;
        if (n == 0) {
            return false;
        }
        int n2 = this.zzc;
        if (Integer.MAX_VALUE - n2 < n) throw new OutOfMemoryError();
        object = this.zzb;
        if ((n2 += n) > ((Object)object).length) {
            this.zzb = Arrays.copyOf((long[])object, n2);
        }
        System.arraycopy(zzggx2.zzb, 0, this.zzb, this.zzc, zzggx2.zzc);
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
        if (!(object instanceof zzggx)) {
            return super.equals(object);
        }
        object = (zzggx)object;
        if (this.zzc != ((zzggx)object).zzc) {
            return false;
        }
        object = ((zzggx)object).zzb;
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
            n = n * 31 + zzggk.zze((long)this.zzb[n2]);
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
        this.zzbH();
        if (n2 < n) throw new IndexOutOfBoundsException("toIndex < fromIndex");
        long[] lArray = this.zzb;
        System.arraycopy(lArray, n2, lArray, n, this.zzc - n2);
        this.zzc -= n2 - n;
        ++this.modCount;
    }

    public final int size() {
        return this.zzc;
    }

    public final zzggi zzc(int n) {
        if (n < this.zzc) throw new IllegalArgumentException();
        return new zzggx(Arrays.copyOf(this.zzb, n), this.zzc);
    }

    public final long zzf(int n) {
        this.zzh(n);
        return this.zzb[n];
    }

    public final void zzg(long l) {
        this.zzbH();
        int n = this.zzc;
        long[] lArray = this.zzb;
        if (n == lArray.length) {
            long[] lArray2 = new long[n * 3 / 2 + 1];
            System.arraycopy(lArray, 0, lArray2, 0, n);
            this.zzb = lArray2;
        }
        lArray = this.zzb;
        n = this.zzc;
        this.zzc = n + 1;
        lArray[n] = l;
    }
}
