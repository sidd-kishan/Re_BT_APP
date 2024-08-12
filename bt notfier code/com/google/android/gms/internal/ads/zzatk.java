/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzanm
 *  com.google.android.gms.internal.ads.zzatf
 *  com.google.android.gms.internal.ads.zzati
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzanm;
import com.google.android.gms.internal.ads.zzatf;
import com.google.android.gms.internal.ads.zzati;
import java.util.Arrays;

public class zzatk {
    protected final zzatf zza;
    protected final int[] zzb;
    private final zzanm[] zzc;
    private int zzd;

    public zzatk(zzatf zzatf2, int ... nArray) {
        int n;
        if (zzatf2 == null) throw null;
        this.zza = zzatf2;
        this.zzc = new zzanm[1];
        int n2 = 0;
        for (n = 0; n <= 0; ++n) {
            this.zzc[n] = zzatf2.zza(nArray[n]);
        }
        Arrays.sort(this.zzc, new zzati(null));
        this.zzb = new int[1];
        n = n2;
        while (n <= 0) {
            this.zzb[n] = zzatf2.zzb(this.zzc[n]);
            ++n;
        }
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzatk)object;
        if (this.zza != ((zzatk)object).zza) return false;
        if (!Arrays.equals(this.zzb, ((zzatk)object).zzb)) return false;
        return true;
    }

    public final int hashCode() {
        int n;
        int n2 = n = this.zzd;
        if (n != 0) return n2;
        this.zzd = n2 = System.identityHashCode(this.zza) * 31 + Arrays.hashCode(this.zzb);
        return n2;
    }

    public final zzatf zza() {
        return this.zza;
    }

    public final int zzb() {
        int n = this.zzb.length;
        return 1;
    }

    public final zzanm zzc(int n) {
        return this.zzc[n];
    }

    public final int zzd(int n) {
        return this.zzb[0];
    }
}
