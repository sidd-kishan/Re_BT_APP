/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzai
 *  com.google.android.gms.internal.ads.zzaj
 *  com.google.android.gms.internal.ads.zzclq
 *  com.google.android.gms.internal.ads.zzcmb
 *  com.google.android.gms.internal.ads.zzkj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzai;
import com.google.android.gms.internal.ads.zzaj;
import com.google.android.gms.internal.ads.zzclq;
import com.google.android.gms.internal.ads.zzcmb;
import com.google.android.gms.internal.ads.zzkj;

final class zzclw
implements zzai {
    private final zzai zza;
    private final byte[] zzb;

    zzclw(zzai zzai2, byte[] byArray) {
        this.zza = zzai2;
        this.zzb = byArray;
    }

    public final zzaj zza() {
        zzai zzai2 = this.zza;
        byte[] byArray = this.zzb;
        int n = zzcmb.zzc;
        zzai2 = zzai2.zza();
        return new zzclq((zzaj)new zzkj(byArray), byArray.length, (zzaj)zzai2);
    }
}
