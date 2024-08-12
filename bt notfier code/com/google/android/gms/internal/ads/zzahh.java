/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzahi
 *  com.google.android.gms.internal.ads.zzalc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzahi;
import com.google.android.gms.internal.ads.zzalc;

public final class zzahh {
    private final zzalc zza = new zzalc();

    public final zzahh zza(int n) {
        this.zza.zza(n);
        return this;
    }

    public final zzahh zzb(int n, boolean bl) {
        zzalc zzalc2 = this.zza;
        if (!bl) return this;
        zzalc2.zza(n);
        return this;
    }

    public final zzahh zzc(int ... nArray) {
        zzalc zzalc2 = this.zza;
        int n = nArray.length;
        int n2 = 0;
        while (n2 < n) {
            zzalc2.zza(nArray[n2]);
            ++n2;
        }
        return this;
    }

    public final zzahh zzd(zzahi zzahi2) {
        zzalc zzalc2 = this.zza;
        zzahi2 = zzahi.zza((zzahi)zzahi2);
        int n = 0;
        while (n < zzahi2.zza()) {
            zzalc2.zza(zzahi2.zzb(n));
            ++n;
        }
        return this;
    }

    public final zzahi zze() {
        return new zzahi(this.zza.zzb(), null);
    }
}
