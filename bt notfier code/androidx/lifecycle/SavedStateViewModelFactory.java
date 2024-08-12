/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.os.Bundle
 *  androidx.lifecycle.AndroidViewModel
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.SavedStateHandle
 *  androidx.lifecycle.SavedStateHandleController
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider$AndroidViewModelFactory
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  androidx.lifecycle.ViewModelProvider$KeyedFactory
 *  androidx.lifecycle.ViewModelProvider$NewInstanceFactory
 *  androidx.savedstate.SavedStateRegistry
 *  androidx.savedstate.SavedStateRegistryOwner
 */
package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleController;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class SavedStateViewModelFactory
extends ViewModelProvider.KeyedFactory {
    private static final Class<?>[] ANDROID_VIEWMODEL_SIGNATURE = new Class[]{Application.class, SavedStateHandle.class};
    private static final Class<?>[] VIEWMODEL_SIGNATURE = new Class[]{SavedStateHandle.class};
    private final Application mApplication;
    private final Bundle mDefaultArgs;
    private final ViewModelProvider.Factory mFactory;
    private final Lifecycle mLifecycle;
    private final SavedStateRegistry mSavedStateRegistry;

    public SavedStateViewModelFactory(Application application, SavedStateRegistryOwner savedStateRegistryOwner) {
        this(application, savedStateRegistryOwner, null);
    }

    public SavedStateViewModelFactory(Application object, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
        this.mSavedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.mLifecycle = savedStateRegistryOwner.getLifecycle();
        this.mDefaultArgs = bundle;
        this.mApplication = object;
        object = object != null ? ViewModelProvider.AndroidViewModelFactory.getInstance((Application)object) : ViewModelProvider.NewInstanceFactory.getInstance();
        this.mFactory = object;
    }

    private static <T> Constructor<T> findMatchingConstructor(Class<T> constructorArray, Class<?>[] classArray) {
        constructorArray = constructorArray.getConstructors();
        int n = constructorArray.length;
        int n2 = 0;
        while (n2 < n) {
            Constructor<?> constructor = constructorArray[n2];
            if (Arrays.equals(classArray, constructor.getParameterTypes())) {
                return constructor;
            }
            ++n2;
        }
        return null;
    }

    public <T extends ViewModel> T create(Class<T> clazz) {
        String string = clazz.getCanonicalName();
        if (string == null) throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        return this.create(string, clazz);
    }

    /*
     * Unable to fully structure code
     */
    public <T extends ViewModel> T create(String var1_1, Class<T> var2_3) {
        var3_4 = AndroidViewModel.class.isAssignableFrom(var2_3);
        var4_5 = var3_4 != false && this.mApplication != null ? SavedStateViewModelFactory.findMatchingConstructor(var2_3, SavedStateViewModelFactory.ANDROID_VIEWMODEL_SIGNATURE) : SavedStateViewModelFactory.findMatchingConstructor(var2_3, SavedStateViewModelFactory.VIEWMODEL_SIGNATURE);
        if (var4_5 == null) {
            return (T)this.mFactory.create(var2_3);
        }
        var5_8 = SavedStateHandleController.create((SavedStateRegistry)this.mSavedStateRegistry, (Lifecycle)this.mLifecycle, (String)var1_1, (Bundle)this.mDefaultArgs);
        if (!var3_4) ** GOTO lbl-1000
        try {
            if (this.mApplication != null) {
                var1_1 = (ViewModel)var4_5.newInstance(new Object[]{this.mApplication, var5_8.getHandle()});
            } else lbl-1000:
            // 2 sources

            {
                var1_1 = (ViewModel)var4_5.newInstance(new Object[]{var5_8.getHandle()});
            }
            var1_1.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", (Object)var5_8);
        }
        catch (InvocationTargetException var4_6) {
            var1_1 = new StringBuilder();
            var1_1.append("An exception happened in constructor of ");
            var1_1.append(var2_3);
            throw new RuntimeException(var1_1.toString(), var4_6.getCause());
        }
        catch (InstantiationException var1_2) {
            var4_5 = new StringBuilder();
            var4_5.append("A ");
            var4_5.append(var2_3);
            var4_5.append(" cannot be instantiated.");
            throw new RuntimeException(var4_5.toString(), var1_2);
        }
        catch (IllegalAccessException var4_7) {
            var1_1 = new StringBuilder();
            var1_1.append("Failed to access ");
            var1_1.append(var2_3);
            throw new RuntimeException(var1_1.toString(), var4_7);
        }
        return (T)var1_1;
    }

    void onRequery(ViewModel viewModel) {
        SavedStateHandleController.attachHandleIfNeeded((ViewModel)viewModel, (SavedStateRegistry)this.mSavedStateRegistry, (Lifecycle)this.mLifecycle);
    }
}
