/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaij
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaij;

final class zzaih
implements Runnable {
    private final zzaij zza;

    zzaih(zzaij zzaij2) {
        this.zza = zzaij2;
    }

    @Override
    public final void run() {
        zzaij.zzf((zzaij)this.zza);
    }
}
