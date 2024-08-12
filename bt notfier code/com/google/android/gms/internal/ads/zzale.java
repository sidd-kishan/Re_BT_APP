/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseBooleanArray
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzald
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzald;
import com.google.android.gms.internal.ads.zzamq;

public final class zzale {
    private final SparseBooleanArray zza;

    /* synthetic */ zzale(SparseBooleanArray sparseBooleanArray, zzald zzald2) {
        this.zza = sparseBooleanArray;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzale)) {
            return false;
        }
        object = (zzale)object;
        if (zzamq.zza >= 24) return this.zza.equals((Object)((zzale)object).zza);
        if (this.zza.size() != ((zzale)object).zza.size()) return false;
        int n = 0;
        while (n < this.zza.size()) {
            if (this.zzb(n) != ((zzale)object).zzb(n)) {
                return false;
            }
            ++n;
        }
        return true;
    }

    public final int hashCode() {
        if (zzamq.zza >= 24) return this.zza.hashCode();
        int n = this.zza.size();
        int n2 = 0;
        while (n2 < this.zza.size()) {
            n = n * 31 + this.zzb(n2);
            ++n2;
        }
        return n;
    }

    public final int zza() {
        return this.zza.size();
    }

    public final int zzb(int n) {
        zzakt.zzc((int)n, (int)0, (int)this.zza.size());
        return this.zza.keyAt(n);
    }
}
