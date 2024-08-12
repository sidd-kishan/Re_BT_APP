/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzle
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzle;

final class zzlf
implements Runnable {
    private final zzle zza;

    public zzlf(zzle zzle2) {
        this.zza = zzle2;
    }

    @Override
    public final void run() {
        this.zza.zzv();
    }
}
