/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcwp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcwp;

final class zzcwo
implements Runnable {
    private final zzcwp zza;
    private final Runnable zzb;

    zzcwo(zzcwp zzcwp2, Runnable runnable) {
        this.zza = zzcwp2;
        this.zzb = runnable;
    }

    @Override
    public final void run() {
        this.zza.zzj(this.zzb);
    }
}
