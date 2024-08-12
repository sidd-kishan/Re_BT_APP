/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  androidx.core.app.ActivityRecreator$LifecycleCheckCallbacks
 */
package androidx.core.app;

import android.app.Application;
import androidx.core.app.ActivityRecreator;

class ActivityRecreator.2
implements Runnable {
    final Application val$application;
    final ActivityRecreator.LifecycleCheckCallbacks val$callbacks;

    ActivityRecreator.2(Application application, ActivityRecreator.LifecycleCheckCallbacks lifecycleCheckCallbacks) {
        this.val$application = application;
        this.val$callbacks = lifecycleCheckCallbacks;
    }

    @Override
    public void run() {
        this.val$application.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this.val$callbacks);
    }
}
