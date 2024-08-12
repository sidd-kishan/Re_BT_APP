/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzatx
 *  com.google.android.gms.internal.ads.zzaty
 *  com.google.android.gms.internal.ads.zzatz
 *  com.google.android.gms.internal.ads.zzcki
 *  com.google.android.gms.internal.ads.zzckj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzatx;
import com.google.android.gms.internal.ads.zzaty;
import com.google.android.gms.internal.ads.zzatz;
import com.google.android.gms.internal.ads.zzcki;
import com.google.android.gms.internal.ads.zzckj;

final class zzcke
implements zzaty {
    private final zzaty zza;
    private final byte[] zzb;

    zzcke(zzaty zzaty2, byte[] byArray) {
        this.zza = zzaty2;
        this.zzb = byArray;
    }

    public final zzatz zza() {
        zzaty zzaty2 = this.zza;
        byte[] byArray = this.zzb;
        int n = zzcki.zzc;
        zzaty2 = zzaty2.zza();
        return new zzckj((zzatz)new zzatx(byArray), byArray.length, (zzatz)zzaty2);
    }
}
