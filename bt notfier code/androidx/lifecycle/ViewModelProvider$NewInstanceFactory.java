/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider$Factory
 */
package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public static class ViewModelProvider.NewInstanceFactory
implements ViewModelProvider.Factory {
    private static ViewModelProvider.NewInstanceFactory sInstance;

    static ViewModelProvider.NewInstanceFactory getInstance() {
        if (sInstance != null) return sInstance;
        sInstance = new ViewModelProvider.NewInstanceFactory();
        return sInstance;
    }

    public <T extends ViewModel> T create(Class<T> clazz) {
        ViewModel viewModel;
        try {
            viewModel = (ViewModel)clazz.newInstance();
        }
        catch (IllegalAccessException illegalAccessException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot create an instance of ");
            stringBuilder.append(clazz);
            throw new RuntimeException(stringBuilder.toString(), illegalAccessException);
        }
        catch (InstantiationException instantiationException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot create an instance of ");
            stringBuilder.append(clazz);
            throw new RuntimeException(stringBuilder.toString(), instantiationException);
        }
        return (T)viewModel;
    }
}
