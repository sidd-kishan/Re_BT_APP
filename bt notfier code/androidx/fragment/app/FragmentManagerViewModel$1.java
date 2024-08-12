/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.FragmentManagerViewModel
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider$Factory
 */
package androidx.fragment.app;

import androidx.fragment.app.FragmentManagerViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

class FragmentManagerViewModel.1
implements ViewModelProvider.Factory {
    FragmentManagerViewModel.1() {
    }

    public <T extends ViewModel> T create(Class<T> clazz) {
        return (T)new FragmentManagerViewModel(true);
    }
}
