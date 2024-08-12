/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.Continuation
 *  com.google.android.gms.tasks.Task
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final class zzfig
implements Continuation {
    static final Continuation zza = new zzfig();

    private zzfig() {
    }

    public final Object then(Task task) {
        return task.isSuccessful();
    }
}
