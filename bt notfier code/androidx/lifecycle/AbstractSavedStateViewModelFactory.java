/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.SavedStateHandle
 *  androidx.lifecycle.SavedStateHandleController
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider$KeyedFactory
 *  androidx.savedstate.SavedStateRegistry
 *  androidx.savedstate.SavedStateRegistryOwner
 */
package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleController;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

public abstract class AbstractSavedStateViewModelFactory
extends ViewModelProvider.KeyedFactory {
    static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";
    private final Bundle mDefaultArgs;
    private final Lifecycle mLifecycle;
    private final SavedStateRegistry mSavedStateRegistry;

    public AbstractSavedStateViewModelFactory(SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
        this.mSavedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.mLifecycle = savedStateRegistryOwner.getLifecycle();
        this.mDefaultArgs = bundle;
    }

    public final <T extends ViewModel> T create(Class<T> clazz) {
        String string = clazz.getCanonicalName();
        if (string == null) throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        return this.create(string, clazz);
    }

    public final <T extends ViewModel> T create(String string, Class<T> clazz) {
        SavedStateHandleController savedStateHandleController = SavedStateHandleController.create((SavedStateRegistry)this.mSavedStateRegistry, (Lifecycle)this.mLifecycle, (String)string, (Bundle)this.mDefaultArgs);
        string = this.create(string, clazz, savedStateHandleController.getHandle());
        string.setTagIfAbsent(TAG_SAVED_STATE_HANDLE_CONTROLLER, (Object)savedStateHandleController);
        return (T)string;
    }

    protected abstract <T extends ViewModel> T create(String var1, Class<T> var2, SavedStateHandle var3);

    void onRequery(ViewModel viewModel) {
        SavedStateHandleController.attachHandleIfNeeded((ViewModel)viewModel, (SavedStateRegistry)this.mSavedStateRegistry, (Lifecycle)this.mLifecycle);
    }
}
