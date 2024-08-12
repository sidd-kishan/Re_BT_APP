/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfdy
 *  com.google.android.gms.internal.ads.zzfej
 *  com.google.android.gms.internal.ads.zzfek
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfdy;
import com.google.android.gms.internal.ads.zzfej;
import com.google.android.gms.internal.ads.zzfek;

final class zzfeh
implements Runnable {
    private final zzfej zza;
    private final zzfdy zzb;

    zzfeh(zzfej zzfej2, zzfdy zzfdy2) {
        this.zza = zzfej2;
        this.zzb = zzfdy2;
    }

    @Override
    public final void run() {
        zzfej zzfej2 = this.zza;
        zzfdy zzfdy2 = this.zzb;
        zzfek.zzd((zzfek)zzfej2.zza).zzb(zzfdy2);
    }
}
