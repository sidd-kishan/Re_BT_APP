/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.app.ActivityRecreator$LifecycleCheckCallbacks
 */
package androidx.core.app;

import androidx.core.app.ActivityRecreator;

class ActivityRecreator.1
implements Runnable {
    final ActivityRecreator.LifecycleCheckCallbacks val$callbacks;
    final Object val$token;

    ActivityRecreator.1(ActivityRecreator.LifecycleCheckCallbacks lifecycleCheckCallbacks, Object object) {
        this.val$callbacks = lifecycleCheckCallbacks;
        this.val$token = object;
    }

    @Override
    public void run() {
        this.val$callbacks.currentlyRecreatingToken = this.val$token;
    }
}
