/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.common.util.DefaultClock
 *  com.google.android.gms.internal.appset.zzi
 *  com.google.android.gms.internal.appset.zzl
 */
package com.google.android.gms.internal.appset;

import android.content.Context;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.appset.zzi;
import com.google.android.gms.internal.appset.zzl;

final class zzj
implements Runnable {
    final zzl zza;

    /* synthetic */ zzj(zzl zzl2, zzi zzi2) {
        this.zza = zzl2;
    }

    @Override
    public final void run() {
        long l = this.zza.zza();
        if (l == -1L) return;
        if (DefaultClock.getInstance().currentTimeMillis() <= l) return;
        zzl.zze((Context)zzl.zzb((zzl)this.zza));
    }
}
