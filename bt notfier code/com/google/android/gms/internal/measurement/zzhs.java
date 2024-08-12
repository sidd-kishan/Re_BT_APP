/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgd
 *  com.google.android.gms.internal.measurement.zzhw
 *  com.google.android.gms.internal.measurement.zzhz
 *  com.google.android.gms.internal.measurement.zzjd
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzhw;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzjd;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzhs
extends zzgd<Integer>
implements RandomAccess,
zzhw,
zzjd {
    private static final zzhs zza;
    private int[] zzb;
    private int zzc;

    static {
        zzhs zzhs2;
        zza = zzhs2 = new zzhs(new int[0], 0);
        zzhs2.zzb();
    }

    zzhs() {
        this(new int[10], 0);
    }

    private zzhs(int[] nArray, int n) {
        this.zzb = nArray;
        this.zzc = n;
    }

    public static zzhs zzd() {
        return zza;
    }

    private final void zzi(int n) {
        if (n < 0) throw new IndexOutOfBoundsException(this.zzj(n));
        if (n >= this.zzc) throw new IndexOutOfBoundsException(this.zzj(n));
    }

    private final String zzj(int n) {
        int n2 = this.zzc;
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Index:");
        stringBuilder.append(n);
        stringBuilder.append(", Size:");
        stringBuilder.append(n2);
        return stringBuilder.toString();
    }

    public final boolean addAll(Collection<? extends Integer> object) {
        this.zzbL();
        zzhz.zza(object);
        if (!(object instanceof zzhs)) {
            return super.addAll(object);
        }
        zzhs zzhs2 = (zzhs)object;
        int n = zzhs2.zzc;
        if (n == 0) {
            return false;
        }
        int n2 = this.zzc;
        if (Integer.MAX_VALUE - n2 < n) throw new OutOfMemoryError();
        object = this.zzb;
        if ((n = n2 + n) > ((Object)object).length) {
            this.zzb = Arrays.copyOf((int[])object, n);
        }
        System.arraycopy(zzhs2.zzb, 0, this.zzb, this.zzc, zzhs2.zzc);
        this.zzc = n;
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
        if (!(object instanceof zzhs)) {
            return super.equals(object);
        }
        object = (zzhs)object;
        if (this.zzc != ((zzhs)object).zzc) {
            return false;
        }
        object = ((zzhs)object).zzb;
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
            n = n * 31 + this.zzb[n2];
            ++n2;
        }
        return n;
    }

    public final int indexOf(Object object) {
        if (!(object instanceof Integer)) {
            return -1;
        }
        int n = (Integer)object;
        int n2 = this.zzc;
        int n3 = 0;
        while (n3 < n2) {
            if (this.zzb[n3] == n) {
                return n3;
            }
            ++n3;
        }
        return -1;
    }

    protected final void removeRange(int n, int n2) {
        this.zzbL();
        if (n2 < n) throw new IndexOutOfBoundsException("toIndex < fromIndex");
        int[] nArray = this.zzb;
        System.arraycopy(nArray, n2, nArray, n, this.zzc - n2);
        this.zzc -= n2 - n;
        ++this.modCount;
    }

    public final int size() {
        return this.zzc;
    }

    public final zzhw zzf(int n) {
        if (n < this.zzc) throw new IllegalArgumentException();
        return new zzhs(Arrays.copyOf(this.zzb, n), this.zzc);
    }

    public final int zzg(int n) {
        this.zzi(n);
        return this.zzb[n];
    }

    public final void zzh(int n) {
        int[] nArray;
        this.zzbL();
        int n2 = this.zzc;
        int[] nArray2 = this.zzb;
        if (n2 == nArray2.length) {
            nArray = new int[n2 * 3 / 2 + 1];
            System.arraycopy(nArray2, 0, nArray, 0, n2);
            this.zzb = nArray;
        }
        nArray = this.zzb;
        n2 = this.zzc;
        this.zzc = n2 + 1;
        nArray[n2] = n;
    }
}
