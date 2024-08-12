/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleRegistry
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;

static class ServiceLifecycleDispatcher.DispatchRunnable
implements Runnable {
    final Lifecycle.Event mEvent;
    private final LifecycleRegistry mRegistry;
    private boolean mWasExecuted = false;

    ServiceLifecycleDispatcher.DispatchRunnable(LifecycleRegistry lifecycleRegistry, Lifecycle.Event event) {
        this.mRegistry = lifecycleRegistry;
        this.mEvent = event;
    }

    @Override
    public void run() {
        if (this.mWasExecuted) return;
        this.mRegistry.handleLifecycleEvent(this.mEvent);
        this.mWasExecuted = true;
    }
}
