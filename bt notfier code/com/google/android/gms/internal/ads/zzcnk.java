/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcnm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcnm;

final class zzcnk
implements Runnable {
    private final zzcnm zza;
    private final String zzb;

    zzcnk(zzcnm zzcnm2, String string) {
        this.zza = zzcnm2;
        this.zzb = string;
    }

    @Override
    public final void run() {
        this.zza.zza(this.zzb);
    }
}
