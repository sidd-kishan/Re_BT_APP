/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzclj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzclj;

final class zzcli
implements Runnable {
    private final zzclj zza;

    zzcli(zzclj zzclj2) {
        this.zza = zzclj2;
    }

    @Override
    public final void run() {
        this.zza.zzk();
    }
}
