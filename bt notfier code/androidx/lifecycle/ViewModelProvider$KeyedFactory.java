/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  androidx.lifecycle.ViewModelProvider$OnRequeryFactory
 */
package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

static abstract class ViewModelProvider.KeyedFactory
extends ViewModelProvider.OnRequeryFactory
implements ViewModelProvider.Factory {
    ViewModelProvider.KeyedFactory() {
    }

    public <T extends ViewModel> T create(Class<T> clazz) {
        throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
    }

    public abstract <T extends ViewModel> T create(String var1, Class<T> var2);
}
