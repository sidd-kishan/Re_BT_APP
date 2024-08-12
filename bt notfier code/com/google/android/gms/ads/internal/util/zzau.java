/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzav
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.util.zzav;
import com.google.android.gms.internal.ads.zzfsn;

final class zzau
implements Runnable {
    private final zzav zza;
    private final zzfsn zzb;

    zzau(zzav zzav2, zzfsn zzfsn2) {
        this.zza = zzav2;
        this.zzb = zzfsn2;
    }

    @Override
    public final void run() {
        this.zza.zzl(this.zzb);
    }
}
