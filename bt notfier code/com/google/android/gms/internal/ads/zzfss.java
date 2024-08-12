/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfsn
 *  com.google.android.gms.internal.ads.zzfsp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfsn;
import com.google.android.gms.internal.ads.zzfsp;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

final class zzfss
extends zzfsp
implements ScheduledExecutorService,
zzfsn {
    final ScheduledExecutorService zza;

    zzfss(ScheduledExecutorService scheduledExecutorService) {
        super((ExecutorService)scheduledExecutorService);
        if (scheduledExecutorService == null) throw null;
        this.zza = scheduledExecutorService;
    }
}
