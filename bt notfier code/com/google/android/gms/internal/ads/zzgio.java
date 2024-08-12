/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfi
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzght
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfi;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzght;
import java.io.IOException;

abstract class zzgio<T, B> {
    zzgio() {
    }

    abstract boolean zza(zzght var1);

    abstract void zzb(B var1, int var2, long var3);

    abstract void zzc(B var1, int var2, int var3);

    abstract void zzd(B var1, int var2, long var3);

    abstract void zze(B var1, int var2, zzgex var3);

    abstract void zzf(B var1, int var2, T var3);

    abstract B zzg();

    abstract T zzh(B var1);

    abstract void zzi(Object var1, T var2);

    abstract T zzj(Object var1);

    abstract B zzk(Object var1);

    abstract void zzl(Object var1, B var2);

    abstract void zzm(Object var1);

    final boolean zzn(B b, zzght zzght2) throws IOException {
        int n = zzght2.zzc();
        int n2 = n >>> 3;
        if ((n &= 7) == 0) {
            this.zzb(b, n2, zzght2.zzh());
            return true;
        }
        if (n == 1) {
            this.zzd(b, n2, zzght2.zzj());
            return true;
        }
        if (n == 2) {
            this.zze(b, n2, zzght2.zzq());
            return true;
        }
        if (n != 3) {
            if (n == 4) return false;
            if (n != 5) throw zzggm.zzi();
            this.zzc(b, n2, zzght2.zzk());
            return true;
        }
        B b2 = this.zzg();
        while (zzght2.zzb() != Integer.MAX_VALUE && this.zzn(b2, zzght2)) {
        }
        if ((4 | n2 << 3) != zzght2.zzc()) throw zzggm.zzh();
        this.zzh(b2);
        this.zzf(b, n2, b2);
        return true;
    }

    abstract T zzo(T var1, T var2);

    abstract int zzp(T var1);

    abstract int zzq(T var1);

    abstract void zzr(T var1, zzgfi var2) throws IOException;
}
