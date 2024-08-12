/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.dynamic.DeferredLifecycleHelper
 *  com.google.android.gms.dynamic.LifecycleDelegate
 *  com.google.android.gms.dynamic.zah
 */
package com.google.android.gms.dynamic;

import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zah;

final class zaf
implements zah {
    final DeferredLifecycleHelper zaa;

    zaf(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zaa = deferredLifecycleHelper;
    }

    public final int zaa() {
        return 4;
    }

    public final void zab(LifecycleDelegate lifecycleDelegate) {
        DeferredLifecycleHelper.zac((DeferredLifecycleHelper)this.zaa).onStart();
    }
}
