/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.internal.zaaa
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zaaa;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zaz
implements OnCompleteListener {
    final TaskCompletionSource zaa;
    final zaaa zab;

    zaz(zaaa zaaa2, TaskCompletionSource taskCompletionSource) {
        this.zab = zaaa2;
        this.zaa = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        zaaa.zag((zaaa)this.zab).remove(this.zaa);
    }
}
