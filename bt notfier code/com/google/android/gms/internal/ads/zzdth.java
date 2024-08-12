/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdtk
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdtk;

final class zzdth
implements Runnable {
    private final zzdtk zza;

    zzdth(zzdtk zzdtk2) {
        this.zza = zzdtk2;
    }

    @Override
    public final void run() {
        this.zza.zze();
    }
}
