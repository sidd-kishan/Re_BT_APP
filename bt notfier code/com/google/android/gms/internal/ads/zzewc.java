/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcva
 *  com.google.android.gms.internal.ads.zzelx
 *  com.google.android.gms.internal.ads.zzewd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcva;
import com.google.android.gms.internal.ads.zzelx;
import com.google.android.gms.internal.ads.zzewd;

final class zzewc
implements zzelx<zzcva> {
    final zzewd zza;

    zzewc(zzewd zzewd2) {
        this.zza = zzewd2;
    }

    public final void zza() {
        zzewd zzewd2 = this.zza;
        synchronized (zzewd2) {
            this.zza.zza = null;
            return;
        }
    }
}
