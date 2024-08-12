/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzav
 */
package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.util.zzav;

final class zzal
implements Runnable {
    private final zzav zza;

    zzal(zzav zzav2) {
        this.zza = zzav2;
    }

    @Override
    public final void run() {
        this.zza.zzm();
    }
}
