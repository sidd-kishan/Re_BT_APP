/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdp;

final class zzdk
implements Runnable {
    private final zzdp zza;
    private final String zzb;

    zzdk(zzdp zzdp2, String string) {
        this.zza = zzdp2;
        this.zzb = string;
    }

    @Override
    public final void run() {
        this.zza.zzo(this.zzb);
    }
}
