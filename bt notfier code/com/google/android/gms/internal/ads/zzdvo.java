/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdvp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdvp;

final class zzdvo
implements Runnable {
    private final zzdvp zza;
    private final String zzb;

    zzdvo(zzdvp zzdvp2, String string) {
        this.zza = zzdvp2;
        this.zzb = string;
    }

    @Override
    public final void run() {
        zzdvp zzdvp2 = this.zza;
        String string = this.zzb;
        zzdvp2.zzd.zza(string);
    }
}
