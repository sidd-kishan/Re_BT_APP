/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.SparseArrayCompat
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  androidx.lifecycle.ViewModelStore
 *  androidx.loader.app.LoaderManagerImpl$LoaderInfo
 */
package androidx.loader.app;

import androidx.collection.SparseArrayCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.app.LoaderManagerImpl;
import java.io.FileDescriptor;
import java.io.PrintWriter;

static class LoaderManagerImpl.LoaderViewModel
extends ViewModel {
    private static final ViewModelProvider.Factory FACTORY = new /* Unavailable Anonymous Inner Class!! */;
    private boolean mCreatingLoader = false;
    private SparseArrayCompat<LoaderManagerImpl.LoaderInfo> mLoaders = new SparseArrayCompat();

    LoaderManagerImpl.LoaderViewModel() {
    }

    static LoaderManagerImpl.LoaderViewModel getInstance(ViewModelStore viewModelStore) {
        return (LoaderManagerImpl.LoaderViewModel)new ViewModelProvider(viewModelStore, FACTORY).get(LoaderManagerImpl.LoaderViewModel.class);
    }

    public void dump(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        if (this.mLoaders.size() <= 0) return;
        printWriter.print(string);
        printWriter.println("Loaders:");
        CharSequence charSequence = new StringBuilder();
        charSequence.append(string);
        charSequence.append("    ");
        charSequence = charSequence.toString();
        int n = 0;
        while (n < this.mLoaders.size()) {
            LoaderManagerImpl.LoaderInfo loaderInfo = (LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(n);
            printWriter.print(string);
            printWriter.print("  #");
            printWriter.print(this.mLoaders.keyAt(n));
            printWriter.print(": ");
            printWriter.println(loaderInfo.toString());
            loaderInfo.dump((String)charSequence, fileDescriptor, printWriter, stringArray);
            ++n;
        }
    }

    void finishCreatingLoader() {
        this.mCreatingLoader = false;
    }

    <D> LoaderManagerImpl.LoaderInfo<D> getLoader(int n) {
        return (LoaderManagerImpl.LoaderInfo)this.mLoaders.get(n);
    }

    boolean hasRunningLoaders() {
        int n = this.mLoaders.size();
        int n2 = 0;
        while (n2 < n) {
            if (((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(n2)).isCallbackWaitingForData()) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    boolean isCreatingLoader() {
        return this.mCreatingLoader;
    }

    void markForRedelivery() {
        int n = this.mLoaders.size();
        int n2 = 0;
        while (n2 < n) {
            ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(n2)).markForRedelivery();
            ++n2;
        }
    }

    protected void onCleared() {
        super.onCleared();
        int n = this.mLoaders.size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.mLoaders.clear();
                return;
            }
            ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(n2)).destroy(true);
            ++n2;
        }
    }

    void putLoader(int n, LoaderManagerImpl.LoaderInfo loaderInfo) {
        this.mLoaders.put(n, (Object)loaderInfo);
    }

    void removeLoader(int n) {
        this.mLoaders.remove(n);
    }

    void startCreatingLoader() {
        this.mCreatingLoader = true;
    }
}
