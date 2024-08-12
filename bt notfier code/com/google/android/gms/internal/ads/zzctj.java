/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzctk
 *  com.google.android.gms.internal.ads.zzctl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzctk;
import com.google.android.gms.internal.ads.zzctl;

final class zzctj
implements Runnable {
    private final zzctk zza;

    zzctj(zzctk zzctk2) {
        this.zza = zzctk2;
    }

    @Override
    public final void run() {
        zzctl.zzb((zzctl)this.zza.zza).zzi();
    }
}
