/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzai
 *  com.google.android.gms.internal.ads.zzaj
 *  com.google.android.gms.internal.ads.zzcmb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzai;
import com.google.android.gms.internal.ads.zzaj;
import com.google.android.gms.internal.ads.zzcmb;

final class zzclt
implements zzai {
    private final zzcmb zza;
    private final String zzb;
    private final boolean zzc;

    zzclt(zzcmb zzcmb2, String string, boolean bl) {
        this.zza = zzcmb2;
        this.zzb = string;
        this.zzc = bl;
    }

    public final zzaj zza() {
        return this.zza.zzT(this.zzb, this.zzc);
    }
}
