/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgfq
 *  com.google.android.gms.internal.ads.zzgfr
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzght
 *  com.google.android.gms.internal.ads.zzgio
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgfq;
import com.google.android.gms.internal.ads.zzgfr;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzght;
import com.google.android.gms.internal.ads.zzgio;
import java.io.IOException;

abstract class zzgfn<T extends zzgfq<T>> {
    zzgfn() {
    }

    abstract boolean zza(zzghi var1);

    abstract zzgfr<T> zzb(Object var1);

    abstract zzgfr<T> zzc(Object var1);

    abstract void zzd(Object var1);

    abstract <UT, UB> UB zze(zzght var1, Object var2, zzgfm var3, zzgfr<T> var4, UB var5, zzgio<UT, UB> var6) throws IOException;

    abstract Object zzf(zzgfm var1, zzghi var2, int var3);

    abstract void zzg(zzght var1, Object var2, zzgfm var3, zzgfr<T> var4) throws IOException;

    abstract void zzh(zzgex var1, Object var2, zzgfm var3, zzgfr<T> var4) throws IOException;
}
