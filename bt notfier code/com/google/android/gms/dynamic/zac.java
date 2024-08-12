/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.dynamic.DeferredLifecycleHelper
 *  com.google.android.gms.dynamic.LifecycleDelegate
 *  com.google.android.gms.dynamic.zah
 */
package com.google.android.gms.dynamic;

import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zah;

final class zac
implements zah {
    final Bundle zaa;
    final DeferredLifecycleHelper zab;

    zac(DeferredLifecycleHelper deferredLifecycleHelper, Bundle bundle) {
        this.zab = deferredLifecycleHelper;
        this.zaa = bundle;
    }

    public final int zaa() {
        return 1;
    }

    public final void zab(LifecycleDelegate lifecycleDelegate) {
        DeferredLifecycleHelper.zac((DeferredLifecycleHelper)this.zab).onCreate(this.zaa);
    }
}
