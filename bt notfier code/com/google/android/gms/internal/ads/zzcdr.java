/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcds
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcds;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsm;

final class zzcdr
implements zzfrz<Void> {
    final zzfsm zza;

    zzcdr(zzcds zzcds2, zzfsm zzfsm2) {
        this.zza = zzfsm2;
    }

    public final void zza(Throwable throwable) {
        zzcds.zza().remove(this.zza);
    }
}
