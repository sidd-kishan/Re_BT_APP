/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.appset.zzr
 *  com.google.android.gms.tasks.Continuation
 *  com.google.android.gms.tasks.Task
 */
package com.google.android.gms.internal.appset;

import com.google.android.gms.internal.appset.zzr;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final class zzq
implements Continuation {
    public final zzr zza;

    public /* synthetic */ zzq(zzr zzr2) {
        this.zza = zzr2;
    }

    public final Object then(Task task) {
        return zzr.zza((zzr)this.zza, (Task)task);
    }
}
