/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzafp
 *  com.google.android.gms.internal.ads.zzahs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzafp;
import com.google.android.gms.internal.ads.zzahs;

final class zzafg
implements Runnable {
    private final zzafp zza;
    private final zzahs zzb;

    zzafg(zzafp zzafp2, zzahs zzahs2) {
        this.zza = zzafp2;
        this.zzb = zzahs2;
    }

    @Override
    public final void run() {
        zzafp.zzr((zzahs)this.zzb);
    }
}
