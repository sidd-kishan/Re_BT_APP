/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LifecycleRegistry
 *  androidx.lifecycle.ServiceLifecycleDispatcher$DispatchRunnable
 */
package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ServiceLifecycleDispatcher;

public class ServiceLifecycleDispatcher {
    private final Handler mHandler;
    private DispatchRunnable mLastDispatchRunnable;
    private final LifecycleRegistry mRegistry;

    public ServiceLifecycleDispatcher(LifecycleOwner lifecycleOwner) {
        this.mRegistry = new LifecycleRegistry(lifecycleOwner);
        this.mHandler = new Handler();
    }

    private void postDispatchRunnable(Lifecycle.Event event) {
        DispatchRunnable dispatchRunnable = this.mLastDispatchRunnable;
        if (dispatchRunnable != null) {
            dispatchRunnable.run();
        }
        event = new DispatchRunnable(this.mRegistry, event);
        this.mLastDispatchRunnable = event;
        this.mHandler.postAtFrontOfQueue((Runnable)event);
    }

    public Lifecycle getLifecycle() {
        return this.mRegistry;
    }

    public void onServicePreSuperOnBind() {
        this.postDispatchRunnable(Lifecycle.Event.ON_START);
    }

    public void onServicePreSuperOnCreate() {
        this.postDispatchRunnable(Lifecycle.Event.ON_CREATE);
    }

    public void onServicePreSuperOnDestroy() {
        this.postDispatchRunnable(Lifecycle.Event.ON_STOP);
        this.postDispatchRunnable(Lifecycle.Event.ON_DESTROY);
    }

    public void onServicePreSuperOnStart() {
        this.postDispatchRunnable(Lifecycle.Event.ON_START);
    }
}
