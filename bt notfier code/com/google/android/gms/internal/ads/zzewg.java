/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzeli
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeli;

final class zzewg
implements Runnable {
    private final zzeli zza;

    private zzewg(zzeli zzeli2) {
        this.zza = zzeli2;
    }

    static Runnable zza(zzeli zzeli2) {
        return new zzewg(zzeli2);
    }

    @Override
    public final void run() {
        this.zza.zzf();
    }
}
