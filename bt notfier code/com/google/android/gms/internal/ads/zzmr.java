/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaz
 *  com.google.android.gms.internal.ads.zzmt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaz;
import com.google.android.gms.internal.ads.zzmt;

final class zzmr
implements Runnable {
    private final zzmt zza;
    private final zzaz zzb;

    zzmr(zzmt zzmt2, zzaz zzaz2) {
        this.zza = zzmt2;
        this.zzb = zzaz2;
    }

    @Override
    public final void run() {
        this.zza.zzl(this.zzb);
    }
}
