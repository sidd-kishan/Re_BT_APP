/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.internal.ActivityLifecycleObserver
 *  com.google.android.gms.common.api.internal.zaa
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.ActivityLifecycleObserver;
import com.google.android.gms.common.api.internal.zaa;
import java.lang.ref.WeakReference;

public final class zab
extends ActivityLifecycleObserver {
    private final WeakReference<zaa> zaa;

    zab(zaa zaa2) {
        this.zaa = new WeakReference<zaa>(zaa2);
    }

    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        zaa zaa2 = (zaa)this.zaa.get();
        if (zaa2 == null) throw new IllegalStateException("The target activity has already been GC'd");
        com.google.android.gms.common.api.internal.zaa.zab((zaa)zaa2, (Runnable)runnable);
        return this;
    }
}
