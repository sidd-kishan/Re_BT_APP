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

final class zzgft
extends zzgeh<Float>
implements RandomAccess,
zzggj,
zzghp {
    private static final zzgft zza;
    private float[] zzb;
    private int zzc;

    static {
        zzgft zzgft2;
        zza = zzgft2 = new zzgft(new float[0], 0);
        zzgft2.zzb();
    }

    zzgft() {
        this(new float[10], 0);
    }

    private zzgft(float[] fArray, int n) {
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
        this.zzbH();
        zzggk.zza(object);
        if (!(object instanceof zzgft)) {
            return super.addAll(object);
        }
        object = (zzgft)object;
        int n = ((zzgft)object).zzc;
        if (n == 0) {
            return false;
        }
        int n2 = this.zzc;
        if (Integer.MAX_VALUE - n2 < n) throw new OutOfMemoryError();
        float[] fArray = this.zzb;
        if ((n2 += n) > fArray.length) {
            this.zzb = Arrays.copyOf(fArray, n2);
        }
        System.arraycopy(((zzgft)object).zzb, 0, this.zzb, this.zzc, ((zzgft)object).zzc);
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
        if (!(object instanceof zzgft)) {
            return super.equals(object);
        }
        object = (zzgft)object;
        if (this.zzc != ((zzgft)object).zzc) {
            return false;
        }
        object = ((zzgft)object).zzb;
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
        this.zzbH();
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
        this.zzbH();
        int n = this.zzc;
        float[] fArray = this.zzb;
        if (n == fArray.length) {
            float[] fArray2 = new float[n * 3 / 2 + 1];
            System.arraycopy(fArray, 0, fArray2, 0, n);
            this.zzb = fArray2;
        }
        fArray = this.zzb;
        n = this.zzc;
        this.zzc = n + 1;
        fArray[n] = f;
    }
}
