/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleEventObserver
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.SavedStateHandleController$OnRecreation
 *  androidx.savedstate.SavedStateRegistry
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.SavedStateHandleController;
import androidx.savedstate.SavedStateRegistry;

class SavedStateHandleController.1
implements LifecycleEventObserver {
    final Lifecycle val$lifecycle;
    final SavedStateRegistry val$registry;

    SavedStateHandleController.1(Lifecycle lifecycle, SavedStateRegistry savedStateRegistry) {
        this.val$lifecycle = lifecycle;
        this.val$registry = savedStateRegistry;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_START) return;
        this.val$lifecycle.removeObserver((LifecycleObserver)this);
        this.val$registry.runOnNextRecreation(SavedStateHandleController.OnRecreation.class);
    }
}
