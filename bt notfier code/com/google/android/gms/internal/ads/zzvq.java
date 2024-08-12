/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzwl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwl;

public final class zzvq {
    private int zza = 2500;
    private int zzb;

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final void zzc(zzwl zzwl2) throws zzwl {
        int n;
        this.zzb = n = this.zzb + 1;
        int n2 = this.zza;
        this.zza = n2 + (int)((float)n2);
        if (n > 1) throw zzwl2;
    }
}
