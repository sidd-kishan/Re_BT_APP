/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.Continuation
 *  com.google.android.gms.tasks.Task
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Collection;
import java.util.List;

final class zzz
implements Continuation<Void, Task<List<Task<?>>>> {
    final Collection zza;

    zzz(Collection collection) {
        this.zza = collection;
    }
}
