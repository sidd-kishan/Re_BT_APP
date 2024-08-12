/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzcms
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzcms;

final class zzcmo
implements Runnable {
    private final String zza;

    zzcmo(String string) {
        this.zza = string;
    }

    @Override
    public final void run() {
        String string = this.zza;
        int n = zzcms.zzb;
        zzt.zzg().zze().zze(string);
    }
}
