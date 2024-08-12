/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcip
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcip;

final class zzcin
implements Runnable {
    final zzcip zza;

    zzcin(zzcip zzcip2) {
        this.zza = zzcip2;
    }

    @Override
    public final void run() {
        zzcip.zzF((zzcip)this.zza, (String)"surfaceDestroyed", (String[])new String[0]);
    }
}
