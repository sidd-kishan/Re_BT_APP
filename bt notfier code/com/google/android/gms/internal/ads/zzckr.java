/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzcks
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzcks;

final class zzckr
implements Runnable {
    final zzcks zza;

    zzckr(zzcks zzcks2) {
        this.zza = zzcks2;
    }

    @Override
    public final void run() {
        zzt.zzy().zzd(this.zza);
    }
}
