/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzget
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzget;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;

public class zzggq {
    private static final zzgfm zzb = zzgfm.zza();
    protected volatile zzghi zza;
    private volatile zzgex zzc;

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzggq)) {
            return false;
        }
        object = (zzggq)object;
        zzghi zzghi2 = this.zza;
        zzghi zzghi3 = ((zzggq)object).zza;
        if (zzghi2 == null) {
            if (zzghi3 == null) return this.zzb().equals((Object)((zzggq)object).zzb());
        }
        if (zzghi2 != null) {
            if (zzghi3 != null) return zzghi2.equals(zzghi3);
        }
        if (zzghi2 != null) {
            ((zzggq)object).zzc(zzghi2.zzbe());
            return zzghi2.equals(((zzggq)object).zza);
        }
        this.zzc(zzghi3.zzbe());
        return this.zza.equals(zzghi3);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzget)this.zzc).zza.length;
        }
        if (this.zza == null) return 0;
        return this.zza.zzaw();
    }

    public final zzgex zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzgex zzgex2 = this.zzc;
                return zzgex2;
            }
            this.zzc = this.zza == null ? zzgex.zzb : this.zza.zzan();
            zzgex zzgex3 = this.zzc;
            return zzgex3;
        }
    }

    protected final void zzc(zzghi zzghi2) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            zzghi zzghi3 = this.zza;
            if (zzghi3 != null) return;
            try {
                this.zza = zzghi2;
                this.zzc = zzgex.zzb;
            }
            catch (zzggm zzggm2) {
                this.zza = zzghi2;
                this.zzc = zzgex.zzb;
            }
            return;
        }
    }
}
