/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  com.google.android.gms.dynamic.DeferredLifecycleHelper
 *  com.google.android.gms.dynamic.LifecycleDelegate
 *  com.google.android.gms.dynamic.zah
 */
package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zah;

final class zab
implements zah {
    final Activity zaa;
    final Bundle zab;
    final Bundle zac;
    final DeferredLifecycleHelper zad;

    zab(DeferredLifecycleHelper deferredLifecycleHelper, Activity activity, Bundle bundle, Bundle bundle2) {
        this.zad = deferredLifecycleHelper;
        this.zaa = activity;
        this.zab = bundle;
        this.zac = bundle2;
    }

    public final int zaa() {
        return 0;
    }

    public final void zab(LifecycleDelegate lifecycleDelegate) {
        DeferredLifecycleHelper.zac((DeferredLifecycleHelper)this.zad).onInflate(this.zaa, this.zab, this.zac);
    }
}
