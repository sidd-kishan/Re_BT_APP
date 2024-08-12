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

final class zzhk
extends zzgd<Float>
implements RandomAccess,
zzhy,
zzjd {
    private static final zzhk zza;
    private float[] zzb;
    private int zzc;

    static {
        zzhk zzhk2;
        zza = zzhk2 = new zzhk(new float[0], 0);
        zzhk2.zzb();
    }

    zzhk() {
        this(new float[10], 0);
    }

    private zzhk(float[] fArray, int n) {
        this.zzb = fArray;
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

    public final boolean addAll(Collection<? extends Float> object) {
        this.zzbL();
        zzhz.zza(object);
        if (!(object instanceof zzhk)) {
            return super.addAll(object);
        }
        zzhk zzhk2 = (zzhk)object;
        int n = zzhk2.zzc;
        if (n == 0) {
            return false;
        }
        int n2 = this.zzc;
        if (Integer.MAX_VALUE - n2 < n) throw new OutOfMemoryError();
        object = this.zzb;
        if ((n = n2 + n) > ((Object)object).length) {
            this.zzb = Arrays.copyOf((float[])object, n);
        }
        System.arraycopy(zzhk2.zzb, 0, this.zzb, this.zzc, zzhk2.zzc);
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
        if (!(object instanceof zzhk)) {
            return super.equals(object);
        }
        object = (zzhk)object;
        if (this.zzc != ((zzhk)object).zzc) {
            return false;
        }
        object = ((zzhk)object).zzb;
        int n = 0;
        while (n < this.zzc) {
            if (Float.floatToIntBits(this.zzb[n]) != Float.floatToIntBits((float)object[n])) {
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
            n = n * 31 + Float.floatToIntBits(this.zzb[n2]);
            ++n2;
        }
        return n;
    }

    public final int indexOf(Object object) {
        if (!(object instanceof Float)) {
            return -1;
        }
        float f = ((Float)object).floatValue();
        int n = this.zzc;
        int n2 = 0;
        while (n2 < n) {
            if (this.zzb[n2] == f) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    protected final void removeRange(int n, int n2) {
        this.zzbL();
        if (n2 < n) throw new IndexOutOfBoundsException("toIndex < fromIndex");
        float[] fArray = this.zzb;
        System.arraycopy(fArray, n2, fArray, n, this.zzc - n2);
        this.zzc -= n2 - n;
        ++this.modCount;
    }

    public final int size() {
        return this.zzc;
    }

    public final void zzd(float f) {
        float[] fArray;
        this.zzbL();
        int n = this.zzc;
        float[] fArray2 = this.zzb;
        if (n == fArray2.length) {
            fArray = new float[n * 3 / 2 + 1];
            System.arraycopy(fArray2, 0, fArray, 0, n);
            this.zzb = fArray;
        }
        fArray = this.zzb;
        n = this.zzc;
        this.zzc = n + 1;
        fArray[n] = f;
    }
}
