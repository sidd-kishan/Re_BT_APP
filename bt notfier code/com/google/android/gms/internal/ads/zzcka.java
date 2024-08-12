/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzatx
 *  com.google.android.gms.internal.ads.zzaty
 *  com.google.android.gms.internal.ads.zzatz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzatx;
import com.google.android.gms.internal.ads.zzaty;
import com.google.android.gms.internal.ads.zzatz;

final class zzcka
implements zzaty {
    private final byte[] zza;

    zzcka(byte[] byArray) {
        this.zza = byArray;
    }

    public final zzatz zza() {
        return new zzatx(this.zza);
    }
}
