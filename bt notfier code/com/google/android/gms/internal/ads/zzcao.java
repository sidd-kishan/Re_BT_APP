/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcgy
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcgy;

final class zzcao
implements Runnable {
    private final zzcgy zza;
    private final String zzb;

    zzcao(zzcgy zzcgy2, String string) {
        this.zza = zzcgy2;
        this.zzb = string;
    }

    @Override
    public final void run() {
        this.zza.zza(this.zzb);
    }
}
