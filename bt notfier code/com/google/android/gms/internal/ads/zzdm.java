/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdp;

final class zzdm
implements Runnable {
    private final zzdp zza;
    private final boolean zzb;

    zzdm(zzdp zzdp2, boolean bl) {
        this.zza = zzdp2;
        this.zzb = bl;
    }

    @Override
    public final void run() {
        this.zza.zzm(this.zzb);
    }
}
