/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdp;

final class zzdi
implements Runnable {
    private final zzdp zza;
    private final long zzb;

    zzdi(zzdp zzdp2, long l) {
        this.zza = zzdp2;
        this.zzb = l;
    }

    @Override
    public final void run() {
        this.zza.zzq(this.zzb);
    }
}
