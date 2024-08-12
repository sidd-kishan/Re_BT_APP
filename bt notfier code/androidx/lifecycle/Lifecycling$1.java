/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.GenericLifecycleObserver
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleEventObserver
 *  androidx.lifecycle.LifecycleOwner
 */
package androidx.lifecycle;

import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

class Lifecycling.1
implements GenericLifecycleObserver {
    final LifecycleEventObserver val$observer;

    Lifecycling.1(LifecycleEventObserver lifecycleEventObserver) {
        this.val$observer = lifecycleEventObserver;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.val$observer.onStateChanged(lifecycleOwner, event);
    }
}
