/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.appset.zzl
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.internal.appset;

import com.google.android.gms.internal.appset.zzl;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzh
implements Runnable {
    public final zzl zza;
    public final TaskCompletionSource zzb;

    public /* synthetic */ zzh(zzl zzl2, TaskCompletionSource taskCompletionSource) {
        this.zza = zzl2;
        this.zzb = taskCompletionSource;
    }

    @Override
    public final void run() {
        this.zza.zzd(this.zzb);
    }
}
