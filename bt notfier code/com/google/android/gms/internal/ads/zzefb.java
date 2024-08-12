/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzefd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzefd;

final class zzefb
implements Runnable {
    private final zzefd zza;
    private final zzcml zzb;

    zzefb(zzefd zzefd2, zzcml zzcml2) {
        this.zza = zzefd2;
        this.zzb = zzcml2;
    }

    @Override
    public final void run() {
        this.zza.zzc(this.zzb);
    }
}
