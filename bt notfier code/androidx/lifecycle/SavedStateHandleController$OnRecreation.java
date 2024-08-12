/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.SavedStateHandleController
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelStore
 *  androidx.lifecycle.ViewModelStoreOwner
 *  androidx.savedstate.SavedStateRegistry
 *  androidx.savedstate.SavedStateRegistry$AutoRecreated
 *  androidx.savedstate.SavedStateRegistryOwner
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandleController;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.Iterator;

/*
 * Exception performing whole class analysis ignored.
 */
static final class SavedStateHandleController.OnRecreation
implements SavedStateRegistry.AutoRecreated {
    SavedStateHandleController.OnRecreation() {
    }

    public void onRecreated(SavedStateRegistryOwner object) {
        if (!(object instanceof ViewModelStoreOwner)) {
            object = new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
            throw object;
        }
        ViewModelStore viewModelStore = ((ViewModelStoreOwner)object).getViewModelStore();
        SavedStateRegistry savedStateRegistry = object.getSavedStateRegistry();
        Iterator iterator = viewModelStore.keys().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                if (viewModelStore.keys().isEmpty()) return;
                savedStateRegistry.runOnNextRecreation(SavedStateHandleController.OnRecreation.class);
                return;
            }
            SavedStateHandleController.attachHandleIfNeeded((ViewModel)viewModelStore.get((String)iterator.next()), (SavedStateRegistry)savedStateRegistry, (Lifecycle)object.getLifecycle());
        }
    }
}
