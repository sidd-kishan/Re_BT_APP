/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  androidx.lifecycle.AndroidViewModel
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider$NewInstanceFactory
 */
package androidx.lifecycle;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import java.lang.reflect.InvocationTargetException;

public static class ViewModelProvider.AndroidViewModelFactory
extends ViewModelProvider.NewInstanceFactory {
    private static ViewModelProvider.AndroidViewModelFactory sInstance;
    private Application mApplication;

    public ViewModelProvider.AndroidViewModelFactory(Application application) {
        this.mApplication = application;
    }

    public static ViewModelProvider.AndroidViewModelFactory getInstance(Application application) {
        if (sInstance != null) return sInstance;
        sInstance = new ViewModelProvider.AndroidViewModelFactory(application);
        return sInstance;
    }

    public <T extends ViewModel> T create(Class<T> clazz) {
        ViewModel viewModel;
        if (!AndroidViewModel.class.isAssignableFrom(clazz)) return (T)super.create(clazz);
        try {
            viewModel = (ViewModel)clazz.getConstructor(Application.class).newInstance(this.mApplication);
        }
        catch (InvocationTargetException invocationTargetException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot create an instance of ");
            stringBuilder.append(clazz);
            throw new RuntimeException(stringBuilder.toString(), invocationTargetException);
        }
        catch (InstantiationException instantiationException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot create an instance of ");
            stringBuilder.append(clazz);
            throw new RuntimeException(stringBuilder.toString(), instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot create an instance of ");
            stringBuilder.append(clazz);
            throw new RuntimeException(stringBuilder.toString(), illegalAccessException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot create an instance of ");
            stringBuilder.append(clazz);
            throw new RuntimeException(stringBuilder.toString(), noSuchMethodException);
        }
        return (T)viewModel;
    }
}
