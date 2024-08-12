/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcip
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcip;

final class zzcim
implements Runnable {
    final zzcip zza;

    zzcim(zzcip zzcip2) {
        this.zza = zzcip2;
    }

    @Override
    public final void run() {
        zzcip.zzF((zzcip)this.zza, (String)"surfaceCreated", (String[])new String[0]);
    }
}
