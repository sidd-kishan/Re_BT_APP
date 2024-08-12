/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgdk
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgdk;

public final class zzgcx {
    private final zzgdk zza;
    private final zzgdk zzb;

    public zzgcx(byte[] byArray, byte[] byArray2) {
        this.zza = zzgdk.zza((byte[])byArray, (int)0, (int)byArray.length);
        this.zzb = zzgdk.zza((byte[])byArray2, (int)0, (int)byArray2.length);
    }

    public final byte[] zza() {
        return this.zza.zzb();
    }

    public final byte[] zzb() {
        return this.zzb.zzb();
    }
}
