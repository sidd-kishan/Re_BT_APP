/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzmt
 *  com.google.android.gms.internal.ads.zzy
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzmt;
import com.google.android.gms.internal.ads.zzy;

final class zzmo
implements Runnable {
    private final zzmt zza;
    private final zzy zzb;

    zzmo(zzmt zzmt2, zzy zzy2) {
        this.zza = zzmt2;
        this.zzb = zzy2;
    }

    @Override
    public final void run() {
        this.zza.zzo(this.zzb);
    }
}
