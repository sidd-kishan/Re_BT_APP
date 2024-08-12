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

final class zzgh
extends zzgd<Boolean>
implements RandomAccess,
zzhy,
zzjd {
    private static final zzgh zza;
    private boolean[] zzb;
    private int zzc;

    static {
        zzgh zzgh2;
        zza = zzgh2 = new zzgh(new boolean[0], 0);
        zzgh2.zzb();
    }

    zzgh() {
        this(new boolean[10], 0);
    }

    private zzgh(boolean[] blArray, int n) {
        this.zzb = blArray;
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

    public final boolean addAll(Collection<? extends Boolean> object) {
        this.zzbL();
        zzhz.zza(object);
        if (!(object instanceof zzgh)) {
            return super.addAll(object);
        }
        object = (zzgh)object;
        int n = ((zzgh)object).zzc;
        if (n == 0) {
            return false;
        }
        int n2 = this.zzc;
        if (Integer.MAX_VALUE - n2 < n) throw new OutOfMemoryError();
        boolean[] blArray = this.zzb;
        if ((n2 += n) > blArray.length) {
            this.zzb = Arrays.copyOf(blArray, n2);
        }
        System.arraycopy(((zzgh)object).zzb, 0, this.zzb, this.zzc, ((zzgh)object).zzc);
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
        if (!(object instanceof zzgh)) {
            return super.equals(object);
        }
        object = (zzgh)object;
        if (this.zzc != ((zzgh)object).zzc) {
            return false;
        }
        object = ((zzgh)object).zzb;
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
            n = n * 31 + zzhz.zzf((boolean)this.zzb[n2]);
            ++n2;
        }
        return n;
    }

    public final int indexOf(Object object) {
        if (!(object instanceof Boolean)) {
            return -1;
        }
        boolean bl = (Boolean)object;
        int n = this.zzc;
        int n2 = 0;
        while (n2 < n) {
            if (this.zzb[n2] == bl) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    protected final void removeRange(int n, int n2) {
        this.zzbL();
        if (n2 < n) throw new IndexOutOfBoundsException("toIndex < fromIndex");
        boolean[] blArray = this.zzb;
        System.arraycopy(blArray, n2, blArray, n, this.zzc - n2);
        this.zzc -= n2 - n;
        ++this.modCount;
    }

    public final int size() {
        return this.zzc;
    }

    public final void zzd(boolean bl) {
        this.zzbL();
        int n = this.zzc;
        boolean[] blArray = this.zzb;
        if (n == blArray.length) {
            boolean[] blArray2 = new boolean[n * 3 / 2 + 1];
            System.arraycopy(blArray, 0, blArray2, 0, n);
            this.zzb = blArray2;
        }
        blArray = this.zzb;
        n = this.zzc;
        this.zzc = n + 1;
        blArray[n] = bl;
    }
}
