/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.HasDefaultViewModelProviderFactory
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  androidx.lifecycle.ViewModelProvider$KeyedFactory
 *  androidx.lifecycle.ViewModelProvider$NewInstanceFactory
 *  androidx.lifecycle.ViewModelProvider$OnRequeryFactory
 *  androidx.lifecycle.ViewModelStore
 *  androidx.lifecycle.ViewModelStoreOwner
 */
package androidx.lifecycle;

import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

/*
 * Exception performing whole class analysis ignored.
 */
public class ViewModelProvider {
    private static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
    private final Factory mFactory;
    private final ViewModelStore mViewModelStore;

    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory) {
        this.mFactory = factory;
        this.mViewModelStore = viewModelStore;
    }

    public ViewModelProvider(ViewModelStoreOwner object) {
        ViewModelStore viewModelStore = object.getViewModelStore();
        object = object instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory)object).getDefaultViewModelProviderFactory() : NewInstanceFactory.getInstance();
        this(viewModelStore, (Factory)object);
    }

    public ViewModelProvider(ViewModelStoreOwner viewModelStoreOwner, Factory factory) {
        this(viewModelStoreOwner.getViewModelStore(), factory);
    }

    public <T extends ViewModel> T get(Class<T> clazz) {
        String string = clazz.getCanonicalName();
        if (string == null) throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("androidx.lifecycle.ViewModelProvider.DefaultKey:");
        stringBuilder.append(string);
        return this.get(stringBuilder.toString(), clazz);
    }

    public <T extends ViewModel> T get(String string, Class<T> viewModel) {
        ViewModel viewModel2 = this.mViewModelStore.get(string);
        if (viewModel.isInstance(viewModel2)) {
            string = this.mFactory;
            if (!(string instanceof OnRequeryFactory)) return (T)viewModel2;
            ((OnRequeryFactory)string).onRequery(viewModel2);
            return (T)viewModel2;
        }
        viewModel2 = this.mFactory;
        viewModel = viewModel2 instanceof KeyedFactory ? ((KeyedFactory)viewModel2).create(string, (Class)viewModel) : viewModel2.create(viewModel);
        this.mViewModelStore.put(string, viewModel);
        return (T)viewModel;
    }
}
