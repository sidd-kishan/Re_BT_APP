/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzfny
 *  com.google.android.gms.internal.ads.zzjt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzfny;
import com.google.android.gms.internal.ads.zzjt;

public final class zzjl
implements Comparable<zzjl> {
    private final boolean zza;
    private final boolean zzb;

    public zzjl(zzafv zzafv2, int n) {
        int n2 = zzafv2.zzd;
        boolean bl = true;
        if (1 != (n2 & 1)) {
            bl = false;
        }
        this.zza = bl;
        this.zzb = zzjt.zzf((int)n, (boolean)false);
    }

    public final int zza(zzjl zzjl2) {
        return zzfny.zzj().zzd(this.zzb, zzjl2.zzb).zzd(this.zza, zzjl2.zza).zze();
    }
}
