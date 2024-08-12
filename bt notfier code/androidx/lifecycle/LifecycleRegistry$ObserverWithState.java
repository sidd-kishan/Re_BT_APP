/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.lifecycle.LifecycleEventObserver
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LifecycleRegistry
 *  androidx.lifecycle.Lifecycling
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.Lifecycling;

/*
 * Exception performing whole class analysis ignored.
 */
static class LifecycleRegistry.ObserverWithState {
    LifecycleEventObserver mLifecycleObserver;
    Lifecycle.State mState;

    LifecycleRegistry.ObserverWithState(LifecycleObserver lifecycleObserver, Lifecycle.State state) {
        this.mLifecycleObserver = Lifecycling.lifecycleEventObserver((Object)lifecycleObserver);
        this.mState = state;
    }

    void dispatchEvent(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Lifecycle.State state = event.getTargetState();
        this.mState = LifecycleRegistry.min((Lifecycle.State)this.mState, (Lifecycle.State)state);
        this.mLifecycleObserver.onStateChanged(lifecycleOwner, event);
        this.mState = state;
    }
}
