/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzabr
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzabr;

final class zzabo
implements Runnable {
    final zzabr zza;

    zzabo(zzabr zzabr2) {
        this.zza = zzabr2;
    }

    @Override
    public final void run() {
        zzabr.zzr((zzabr)this.zza);
    }
}
