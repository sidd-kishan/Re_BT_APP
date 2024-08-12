/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcip
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcip;

final class zzcio
implements Runnable {
    final boolean zza;
    final zzcip zzb;

    zzcio(zzcip zzcip2, boolean bl) {
        this.zzb = zzcip2;
        this.zza = bl;
    }

    @Override
    public final void run() {
        zzcip.zzF((zzcip)this.zzb, (String)"windowVisibilityChanged", (String[])new String[]{"isVisible", String.valueOf(this.zza)});
    }
}
