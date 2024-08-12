/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.lifecycle.LifecycleEventObserver
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.SavedStateHandle
 *  androidx.lifecycle.SavedStateHandleController$OnRecreation
 *  androidx.lifecycle.ViewModel
 *  androidx.savedstate.SavedStateRegistry
 */
package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleController;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.SavedStateRegistry;

final class SavedStateHandleController
implements LifecycleEventObserver {
    static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";
    private final SavedStateHandle mHandle;
    private boolean mIsAttached = false;
    private final String mKey;

    SavedStateHandleController(String string, SavedStateHandle savedStateHandle) {
        this.mKey = string;
        this.mHandle = savedStateHandle;
    }

    static void attachHandleIfNeeded(ViewModel object, SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        if ((object = (SavedStateHandleController)object.getTag(TAG_SAVED_STATE_HANDLE_CONTROLLER)) == null) return;
        if (((SavedStateHandleController)object).isAttached()) return;
        ((SavedStateHandleController)object).attachToLifecycle(savedStateRegistry, lifecycle);
        SavedStateHandleController.tryToAddRecreator(savedStateRegistry, lifecycle);
    }

    static SavedStateHandleController create(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle, String object, Bundle bundle) {
        object = new SavedStateHandleController((String)object, SavedStateHandle.createHandle((Bundle)savedStateRegistry.consumeRestoredStateForKey((String)object), (Bundle)bundle));
        ((SavedStateHandleController)object).attachToLifecycle(savedStateRegistry, lifecycle);
        SavedStateHandleController.tryToAddRecreator(savedStateRegistry, lifecycle);
        return object;
    }

    private static void tryToAddRecreator(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        Lifecycle.State state = lifecycle.getCurrentState();
        if (state != Lifecycle.State.INITIALIZED && !state.isAtLeast(Lifecycle.State.STARTED)) {
            lifecycle.addObserver((LifecycleObserver)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            savedStateRegistry.runOnNextRecreation(OnRecreation.class);
        }
    }

    void attachToLifecycle(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        if (this.mIsAttached) throw new IllegalStateException("Already attached to lifecycleOwner");
        this.mIsAttached = true;
        lifecycle.addObserver((LifecycleObserver)this);
        savedStateRegistry.registerSavedStateProvider(this.mKey, this.mHandle.savedStateProvider());
    }

    SavedStateHandle getHandle() {
        return this.mHandle;
    }

    boolean isAttached() {
        return this.mIsAttached;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_DESTROY) return;
        this.mIsAttached = false;
        lifecycleOwner.getLifecycle().removeObserver((LifecycleObserver)this);
    }
}
