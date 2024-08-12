/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.GenericLifecycleObserver
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.savedstate.SavedStateRegistry
 */
package androidx.savedstate;

import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;

class SavedStateRegistry.1
implements GenericLifecycleObserver {
    final SavedStateRegistry this$0;

    SavedStateRegistry.1(SavedStateRegistry savedStateRegistry) {
        this.this$0 = savedStateRegistry;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_START) {
            this.this$0.mAllowingSavingState = true;
        } else {
            if (event != Lifecycle.Event.ON_STOP) return;
            this.this$0.mAllowingSavingState = false;
        }
    }
}
