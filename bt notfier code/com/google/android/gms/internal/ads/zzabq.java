/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzabr
 *  com.google.android.gms.internal.ads.zzbjl
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzabr;
import com.google.android.gms.internal.ads.zzbjl;

final class zzabq
implements Runnable {
    final zzabr zza;

    zzabq(zzabr zzabr2) {
        this.zza = zzabr2;
    }

    @Override
    public final void run() {
        zzbjl.zza((Context)this.zza.zza);
    }
}
