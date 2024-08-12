/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgd
 *  com.google.android.gms.internal.measurement.zzhy
 *  com.google.android.gms.internal.measurement.zzhz
 *  com.google.android.gms.internal.measurement.zzjd
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzjd;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzha
extends zzgd<Double>
implements RandomAccess,
zzhy,
zzjd {
    private static final zzha zza;
    private double[] zzb;
    private int zzc;

    static {
        zzha zzha2;
        zza = zzha2 = new zzha(new double[0], 0);
        zzha2.zzb();
    }

    zzha() {
        this(new double[10], 0);
    }

    private zzha(double[] dArray, int n) {
        this.zzb = dArray;
        this.zzc = n;
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

    public final boolean addAll(Collection<? extends Double> object) {
        this.zzbL();
        zzhz.zza(object);
        if (!(object instanceof zzha)) {
            return super.addAll(object);
        }
        object = (zzha)object;
        int n = ((zzha)object).zzc;
        if (n == 0) {
            return false;
        }
        int n2 = this.zzc;
        if (Integer.MAX_VALUE - n2 < n) throw new OutOfMemoryError();
        double[] dArray = this.zzb;
        if ((n2 += n) > dArray.length) {
            this.zzb = Arrays.copyOf(dArray, n2);
        }
        System.arraycopy(((zzha)object).zzb, 0, this.zzb, this.zzc, ((zzha)object).zzc);
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
        if (!(object instanceof zzha)) {
            return super.equals(object);
        }
        object = (zzha)object;
        if (this.zzc != ((zzha)object).zzc) {
            return false;
        }
        object = ((zzha)object).zzb;
        int n = 0;
        while (n < this.zzc) {
            if (Double.doubleToLongBits(this.zzb[n]) != Double.doubleToLongBits((double)object[n])) {
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
            n = n * 31 + zzhz.zze((long)Double.doubleToLongBits(this.zzb[n2]));
            ++n2;
        }
        return n;
    }

    public final int indexOf(Object object) {
        if (!(object instanceof Double)) {
            return -1;
        }
        double d = (Double)object;
        int n = this.zzc;
        int n2 = 0;
        while (n2 < n) {
            if (this.zzb[n2] == d) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    protected final void removeRange(int n, int n2) {
        this.zzbL();
        if (n2 < n) throw new IndexOutOfBoundsException("toIndex < fromIndex");
        double[] dArray = this.zzb;
        System.arraycopy(dArray, n2, dArray, n, this.zzc - n2);
        this.zzc -= n2 - n;
        ++this.modCount;
    }

    public final int size() {
        return this.zzc;
    }

    public final void zzd(double d) {
        double[] dArray;
        this.zzbL();
        int n = this.zzc;
        double[] dArray2 = this.zzb;
        if (n == dArray2.length) {
            dArray = new double[n * 3 / 2 + 1];
            System.arraycopy(dArray2, 0, dArray, 0, n);
            this.zzb = dArray;
        }
        dArray = this.zzb;
        n = this.zzc;
        this.zzc = n + 1;
        dArray[n] = d;
    }
}
