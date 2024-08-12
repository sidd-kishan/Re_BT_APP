/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.dynamic.DeferredLifecycleHelper
 *  com.google.android.gms.dynamic.LifecycleDelegate
 *  com.google.android.gms.dynamic.OnDelegateCreatedListener
 *  com.google.android.gms.dynamic.zah
 */
package com.google.android.gms.dynamic;

import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.dynamic.zah;

final class zaa
implements OnDelegateCreatedListener {
    final DeferredLifecycleHelper zaa;

    zaa(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zaa = deferredLifecycleHelper;
    }

    public final void onDelegateCreated(LifecycleDelegate object) {
        DeferredLifecycleHelper.zaa((DeferredLifecycleHelper)this.zaa, (LifecycleDelegate)object);
        object = DeferredLifecycleHelper.zab((DeferredLifecycleHelper)this.zaa).iterator();
        while (true) {
            if (!object.hasNext()) {
                DeferredLifecycleHelper.zab((DeferredLifecycleHelper)this.zaa).clear();
                DeferredLifecycleHelper.zad((DeferredLifecycleHelper)this.zaa, null);
                return;
            }
            ((zah)object.next()).zab(DeferredLifecycleHelper.zac((DeferredLifecycleHelper)this.zaa));
        }
    }
}
