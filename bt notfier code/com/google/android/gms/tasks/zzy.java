/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.Continuation
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.Continuation;
import java.util.Collection;
import java.util.List;

final class zzy
implements Continuation<Void, List> {
    final Collection zza;

    zzy(Collection collection) {
        this.zza = collection;
    }
}
