/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzai
 *  com.google.android.gms.internal.ads.zzaj
 *  com.google.android.gms.internal.ads.zzkj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzai;
import com.google.android.gms.internal.ads.zzaj;
import com.google.android.gms.internal.ads.zzkj;

final class zzcls
implements zzai {
    private final byte[] zza;

    zzcls(byte[] byArray) {
        this.zza = byArray;
    }

    public final zzaj zza() {
        return new zzkj(this.zza);
    }
}
