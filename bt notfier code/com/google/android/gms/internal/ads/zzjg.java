/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzjf
 *  com.google.android.gms.internal.ads.zzq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzjf;
import com.google.android.gms.internal.ads.zzq;
import java.util.Arrays;

public class zzjg {
    protected final zzq zza;
    protected final int zzb;
    protected final int[] zzc;
    private final zzafv[] zzd;
    private int zze;

    public zzjg(zzq zzq2, int[] nArray, int n) {
        n = nArray.length;
        int n2 = 0;
        boolean bl = n > 0;
        zzakt.zzd((boolean)bl);
        if (zzq2 == null) throw null;
        this.zza = zzq2;
        this.zzb = n;
        this.zzd = new zzafv[n];
        for (n = 0; n < nArray.length; ++n) {
            this.zzd[n] = zzq2.zza(nArray[n]);
        }
        Arrays.sort(this.zzd, zzjf.zza);
        this.zzc = new int[this.zzb];
        n = n2;
        while (n < this.zzb) {
            this.zzc[n] = zzq2.zzb(this.zzd[n]);
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
        object = (zzjg)object;
        if (this.zza != ((zzjg)object).zza) return false;
        if (!Arrays.equals(this.zzc, ((zzjg)object).zzc)) return false;
        return true;
    }

    public final int hashCode() {
        int n;
        int n2 = n = this.zze;
        if (n != 0) return n2;
        this.zze = n2 = System.identityHashCode(this.zza) * 31 + Arrays.hashCode(this.zzc);
        return n2;
    }

    public final zzq zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzc.length;
    }

    public final zzafv zzd(int n) {
        return this.zzd[n];
    }

    public final int zze(int n) {
        return this.zzc[0];
    }
}
