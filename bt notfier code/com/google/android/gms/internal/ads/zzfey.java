/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfez
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfez;

final class zzfey
implements Runnable {
    private final zzfez zza;
    private final String zzb;

    zzfey(zzfez zzfez2, String string) {
        this.zza = zzfez2;
        this.zzb = string;
    }

    @Override
    public final void run() {
        this.zza.zzb(this.zzb);
    }
}
