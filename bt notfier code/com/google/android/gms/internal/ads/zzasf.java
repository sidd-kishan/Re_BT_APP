/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzasl
 *  com.google.android.gms.internal.ads.zzatd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzasl;
import com.google.android.gms.internal.ads.zzatd;

final class zzasf
implements Runnable {
    final zzasl zza;

    zzasf(zzasl zzasl2) {
        this.zza = zzasl2;
    }

    @Override
    public final void run() {
        if (zzasl.zzj((zzasl)this.zza)) return;
        zzasl.zzi((zzasl)this.zza).zzbh((zzatd)this.zza);
    }
}
