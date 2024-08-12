/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.savedstate.Recreator
 *  androidx.savedstate.SavedStateRegistry
 *  androidx.savedstate.SavedStateRegistryOwner
 */
package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

public final class SavedStateRegistryController {
    private final SavedStateRegistryOwner mOwner;
    private final SavedStateRegistry mRegistry;

    private SavedStateRegistryController(SavedStateRegistryOwner savedStateRegistryOwner) {
        this.mOwner = savedStateRegistryOwner;
        this.mRegistry = new SavedStateRegistry();
    }

    public static SavedStateRegistryController create(SavedStateRegistryOwner savedStateRegistryOwner) {
        return new SavedStateRegistryController(savedStateRegistryOwner);
    }

    public SavedStateRegistry getSavedStateRegistry() {
        return this.mRegistry;
    }

    public void performRestore(Bundle bundle) {
        Lifecycle lifecycle = this.mOwner.getLifecycle();
        if (lifecycle.getCurrentState() != Lifecycle.State.INITIALIZED) throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        lifecycle.addObserver((LifecycleObserver)new Recreator(this.mOwner));
        this.mRegistry.performRestore(lifecycle, bundle);
    }

    public void performSave(Bundle bundle) {
        this.mRegistry.performSave(bundle);
    }
}
