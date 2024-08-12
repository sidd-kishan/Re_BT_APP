/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzawe
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzawe;

final class zzawa
implements Runnable {
    private final zzawe zza;

    zzawa(zzawe zzawe2) {
        this.zza = zzawe2;
    }

    @Override
    public final void run() {
        this.zza.zzg();
    }
}
