/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  androidx.lifecycle.LifecycleDispatcher$DispatcherActivityCallback
 */
package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LifecycleDispatcher;
import java.util.concurrent.atomic.AtomicBoolean;

class LifecycleDispatcher {
    private static AtomicBoolean sInitialized = new AtomicBoolean(false);

    private LifecycleDispatcher() {
    }

    static void init(Context context) {
        if (sInitialized.getAndSet(true)) {
            return;
        }
        ((Application)context.getApplicationContext()).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new DispatcherActivityCallback());
    }
}
