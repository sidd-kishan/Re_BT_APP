/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgeh
 *  com.google.android.gms.internal.ads.zzggj
 *  com.google.android.gms.internal.ads.zzggk
 *  com.google.android.gms.internal.ads.zzghp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgeh;
import com.google.android.gms.internal.ads.zzggj;
import com.google.android.gms.internal.ads.zzggk;
import com.google.android.gms.internal.ads.zzghp;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzgel
extends zzgeh<Boolean>
implements RandomAccess,
zzggj,
zzghp {
    private static final zzgel zza;
    private boolean[] zzb;
    private int zzc;

    static {
        zzgel zzgel2;
        zza = zzgel2 = new zzgel(new boolean[0], 0);
        zzgel2.zzb();
    }

    zzgel() {
        this(new boolean[10], 0);
    }

    private zzgel(boolean[] blArray, int n) {
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
        this.zzbH();
        zzggk.zza(object);
        if (!(object instanceof zzgel)) {
            return super.addAll(object);
        }
        zzgel zzgel2 = (zzgel)object;
        int n = zzgel2.zzc;
        if (n == 0) {
            return false;
        }
        int n2 = this.zzc;
        if (Integer.MAX_VALUE - n2 < n) throw new OutOfMemoryError();
        object = this.zzb;
        if ((n = n2 + n) > ((Object)object).length) {
            this.zzb = Arrays.copyOf((boolean[])object, n);
        }
        System.arraycopy(zzgel2.zzb, 0, this.zzb, this.zzc, zzgel2.zzc);
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
        if (!(object instanceof zzgel)) {
            return super.equals(object);
        }
        object = (zzgel)object;
        if (this.zzc != ((zzgel)object).zzc) {
            return false;
        }
        object = ((zzgel)object).zzb;
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
            n = n * 31 + zzggk.zzf((boolean)this.zzb[n2]);
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
        this.zzbH();
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
        this.zzbH();
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
