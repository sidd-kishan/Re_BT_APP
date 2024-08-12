/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnTokenCanceledListener
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzs
implements OnTokenCanceledListener {
    final TaskCompletionSource zza;

    zzs(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void onCanceled() {
        TaskCompletionSource.zza((TaskCompletionSource)this.zza).zze();
    }
}
