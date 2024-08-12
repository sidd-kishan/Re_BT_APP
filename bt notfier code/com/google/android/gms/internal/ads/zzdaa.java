/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdac
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdac;

final class zzdaa
implements Runnable {
    private final zzdac zza;

    zzdaa(zzdac zzdac2) {
        this.zza = zzdac2;
    }

    @Override
    public final void run() {
        this.zza.zzf();
    }
}
