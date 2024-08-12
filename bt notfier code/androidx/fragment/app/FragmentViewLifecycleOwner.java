/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.ContextWrapper
 *  android.os.Bundle
 *  androidx.fragment.app.Fragment
 *  androidx.lifecycle.HasDefaultViewModelProviderFactory
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LifecycleRegistry
 *  androidx.lifecycle.SavedStateViewModelFactory
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  androidx.lifecycle.ViewModelStore
 *  androidx.lifecycle.ViewModelStoreOwner
 *  androidx.savedstate.SavedStateRegistry
 *  androidx.savedstate.SavedStateRegistryController
 *  androidx.savedstate.SavedStateRegistryOwner
 */
package androidx.fragment.app;

import android.app.Application;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

class FragmentViewLifecycleOwner
implements HasDefaultViewModelProviderFactory,
SavedStateRegistryOwner,
ViewModelStoreOwner {
    private ViewModelProvider.Factory mDefaultFactory;
    private final Fragment mFragment;
    private LifecycleRegistry mLifecycleRegistry = null;
    private SavedStateRegistryController mSavedStateRegistryController = null;
    private final ViewModelStore mViewModelStore;

    FragmentViewLifecycleOwner(Fragment fragment, ViewModelStore viewModelStore) {
        this.mFragment = fragment;
        this.mViewModelStore = viewModelStore;
    }

    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Application application;
        ViewModelProvider.Factory factory = this.mFragment.getDefaultViewModelProviderFactory();
        if (!factory.equals(this.mFragment.mDefaultFactory)) {
            this.mDefaultFactory = factory;
            return factory;
        }
        if (this.mDefaultFactory != null) return this.mDefaultFactory;
        Application application2 = null;
        factory = this.mFragment.requireContext().getApplicationContext();
        while (true) {
            application = application2;
            if (!(factory instanceof ContextWrapper)) break;
            if (factory instanceof Application) {
                application = (Application)factory;
                break;
            }
            factory = ((ContextWrapper)factory).getBaseContext();
        }
        this.mDefaultFactory = new SavedStateViewModelFactory(application, (SavedStateRegistryOwner)this, this.mFragment.getArguments());
        return this.mDefaultFactory;
    }

    public Lifecycle getLifecycle() {
        this.initialize();
        return this.mLifecycleRegistry;
    }

    public SavedStateRegistry getSavedStateRegistry() {
        this.initialize();
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    public ViewModelStore getViewModelStore() {
        this.initialize();
        return this.mViewModelStore;
    }

    void handleLifecycleEvent(Lifecycle.Event event) {
        this.mLifecycleRegistry.handleLifecycleEvent(event);
    }

    void initialize() {
        if (this.mLifecycleRegistry != null) return;
        this.mLifecycleRegistry = new LifecycleRegistry((LifecycleOwner)this);
        this.mSavedStateRegistryController = SavedStateRegistryController.create((SavedStateRegistryOwner)this);
    }

    boolean isInitialized() {
        boolean bl = this.mLifecycleRegistry != null;
        return bl;
    }

    void performRestore(Bundle bundle) {
        this.mSavedStateRegistryController.performRestore(bundle);
    }

    void performSave(Bundle bundle) {
        this.mSavedStateRegistryController.performSave(bundle);
    }

    void setCurrentState(Lifecycle.State state) {
        this.mLifecycleRegistry.setCurrentState(state);
    }
}
