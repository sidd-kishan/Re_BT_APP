/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaqj
 *  com.google.android.gms.internal.ads.zzaqm
 *  com.google.android.gms.internal.ads.zzaux
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaqj;
import com.google.android.gms.internal.ads.zzaqm;
import com.google.android.gms.internal.ads.zzaux;

final class zzaqo
implements zzaqm {
    private final int zza;
    private final int zzb;
    private final zzaux zzc;

    public zzaqo(zzaqj zzaqj2) {
        zzaqj2 = zzaqj2.zza;
        this.zzc = zzaqj2;
        zzaqj2.zzi(12);
        this.zza = this.zzc.zzu();
        this.zzb = this.zzc.zzu();
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        int n;
        int n2 = n = this.zza;
        if (n != 0) return n2;
        n2 = this.zzc.zzu();
        return n2;
    }

    public final boolean zzc() {
        if (this.zza == 0) return false;
        return true;
    }
}
