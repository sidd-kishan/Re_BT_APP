/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzalc
 *  com.google.android.gms.internal.ads.zzale
 *  com.google.android.gms.internal.ads.zzalj
 *  com.google.android.gms.internal.ads.zzalk
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzalc;
import com.google.android.gms.internal.ads.zzale;
import com.google.android.gms.internal.ads.zzalj;
import com.google.android.gms.internal.ads.zzalk;
import javax.annotation.Nonnull;

final class zzall<T> {
    @Nonnull
    public final T zza;
    private zzalc zzb;
    private boolean zzc;
    private boolean zzd;

    public zzall(@Nonnull T t) {
        this.zza = t;
        this.zzb = new zzalc();
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() == object.getClass()) return this.zza.equals(((zzall)object).zza);
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zza(zzalk<T> zzalk2) {
        this.zzd = true;
        if (!this.zzc) return;
        zzalk2.zza(this.zza, this.zzb.zzb());
    }

    public final void zzb(int n, zzalj<T> zzalj2) {
        if (this.zzd) return;
        if (n != -1) {
            this.zzb.zza(n);
        }
        this.zzc = true;
        zzalj2.zza(this.zza);
    }

    public final void zzc(zzalk<T> zzalk2) {
        if (this.zzd) return;
        if (!this.zzc) return;
        zzale zzale2 = this.zzb.zzb();
        this.zzb = new zzalc();
        this.zzc = false;
        zzalk2.zza(this.zza, zzale2);
    }
}
