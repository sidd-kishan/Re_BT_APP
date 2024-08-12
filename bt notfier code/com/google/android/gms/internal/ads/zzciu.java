/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcih
 *  com.google.android.gms.internal.ads.zzciv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcih;
import com.google.android.gms.internal.ads.zzciv;

final class zzciu
implements Runnable {
    final zzcih zza;

    zzciu(zzciv zzciv2, zzcih zzcih2) {
        this.zza = zzcih2;
    }

    @Override
    public final void run() {
        this.zza.zzi();
    }
}
