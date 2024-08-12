/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  androidx.loader.app.LoaderManagerImpl$LoaderViewModel
 */
package androidx.loader.app;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.loader.app.LoaderManagerImpl;

static final class LoaderManagerImpl.LoaderViewModel.1
implements ViewModelProvider.Factory {
    LoaderManagerImpl.LoaderViewModel.1() {
    }

    public <T extends ViewModel> T create(Class<T> clazz) {
        return (T)new LoaderManagerImpl.LoaderViewModel();
    }
}
