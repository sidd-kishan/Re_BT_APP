/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.google.android.gms.common.api.internal.LifecycleCallback
 *  com.google.android.gms.common.api.internal.LifecycleFragment
 */
package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import java.util.ArrayList;
import java.util.List;

final class zaa
extends LifecycleCallback {
    private List<Runnable> zaa = new ArrayList<Runnable>();

    private zaa(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", (LifecycleCallback)this);
    }

    static /* synthetic */ zaa zaa(Activity activity) {
        synchronized (activity) {
            zaa zaa2;
            LifecycleFragment lifecycleFragment = com.google.android.gms.common.api.internal.zaa.getFragment((Activity)activity);
            zaa zaa3 = zaa2 = (zaa)lifecycleFragment.getCallbackOrNull("LifecycleObserverOnStop", zaa.class);
            if (zaa2 != null) return zaa3;
            zaa3 = new zaa(lifecycleFragment);
            return zaa3;
        }
    }

    static /* synthetic */ void zab(zaa zaa2, Runnable runnable) {
        zaa2.zac(runnable);
    }

    private final void zac(Runnable runnable) {
        synchronized (this) {
            this.zaa.add(runnable);
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public final void onStop() {
        Object object;
        synchronized (this) {
            object = this.zaa;
            ArrayList<Runnable> arrayList = new ArrayList<Runnable>();
            this.zaa = arrayList;
            // MONITOREXIT @DISABLED, blocks:[0, 2] lbl6 : MonitorExitStatement: MONITOREXIT : this
            object = object.iterator();
            {
                catch (Throwable throwable) {}
                {
                    throw throwable;
                }
            }
        }
        while (object.hasNext()) {
            ((Runnable)object.next()).run();
        }
    }
}
