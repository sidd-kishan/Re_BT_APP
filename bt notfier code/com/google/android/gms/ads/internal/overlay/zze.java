/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.overlay.zzl
 */
package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.ads.internal.overlay.zzl;

final class zze
implements Runnable {
    private final zzl zza;

    zze(zzl zzl2) {
        this.zza = zzl2;
    }

    @Override
    public final void run() {
        this.zza.zzA();
    }
}
