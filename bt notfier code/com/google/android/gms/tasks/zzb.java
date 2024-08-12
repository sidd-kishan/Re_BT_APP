/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.CancellationToken
 *  com.google.android.gms.tasks.OnSuccessListener
 *  com.google.android.gms.tasks.OnTokenCanceledListener
 *  com.google.android.gms.tasks.TaskExecutors
 *  com.google.android.gms.tasks.zza
 *  com.google.android.gms.tasks.zzw
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zza;
import com.google.android.gms.tasks.zzw;

final class zzb
extends CancellationToken {
    private final zzw<Void> zza = new zzw();

    zzb() {
    }

    public final boolean isCancellationRequested() {
        return this.zza.isComplete();
    }

    public final CancellationToken onCanceledRequested(OnTokenCanceledListener onTokenCanceledListener) {
        zzw<Void> zzw2 = this.zza;
        onTokenCanceledListener = new zza(this, onTokenCanceledListener);
        zzw2.addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener)onTokenCanceledListener);
        return this;
    }

    public final void zza() {
        this.zza.zzb(null);
    }
}
