/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Looper
 *  android.util.Log
 *  androidx.core.util.DebugUtils
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.ViewModelStore
 *  androidx.loader.app.LoaderManager
 *  androidx.loader.app.LoaderManager$LoaderCallbacks
 *  androidx.loader.app.LoaderManagerImpl$LoaderInfo
 *  androidx.loader.app.LoaderManagerImpl$LoaderViewModel
 *  androidx.loader.content.Loader
 */
package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.app.LoaderManager;
import androidx.loader.app.LoaderManagerImpl;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/*
 * Exception performing whole class analysis ignored.
 */
class LoaderManagerImpl
extends LoaderManager {
    static boolean DEBUG = false;
    static final String TAG = "LoaderManager";
    private final LifecycleOwner mLifecycleOwner;
    private final LoaderViewModel mLoaderViewModel;

    LoaderManagerImpl(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.mLifecycleOwner = lifecycleOwner;
        this.mLoaderViewModel = LoaderViewModel.getInstance((ViewModelStore)viewModelStore);
    }

    private <D> Loader<D> createAndInstallLoader(int n, Bundle object, LoaderManager.LoaderCallbacks<D> object2, Loader<D> loader) {
        try {
            this.mLoaderViewModel.startCreatingLoader();
            Loader loader2 = object2.onCreateLoader(n, (Bundle)object);
            if (loader2 != null) {
                if (loader2.getClass().isMemberClass() && !Modifier.isStatic(loader2.getClass().getModifiers())) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Object returned from onCreateLoader must not be a non-static inner member class: ");
                    ((StringBuilder)object).append(loader2);
                    object2 = new Object(((StringBuilder)object).toString());
                    throw object2;
                }
                LoaderInfo loaderInfo = new LoaderInfo(n, (Bundle)object, loader2, loader);
                if (DEBUG) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("  Created new loader ");
                    ((StringBuilder)object).append(loaderInfo);
                    Log.v((String)"LoaderManager", (String)((StringBuilder)object).toString());
                }
                this.mLoaderViewModel.putLoader(n, loaderInfo);
                return loaderInfo.setCallback(this.mLifecycleOwner, object2);
            }
            object = new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            throw object;
        }
        finally {
            this.mLoaderViewModel.finishCreatingLoader();
        }
    }

    public void destroyLoader(int n) {
        StringBuilder stringBuilder;
        if (this.mLoaderViewModel.isCreatingLoader()) throw new IllegalStateException("Called while creating a loader");
        if (Looper.getMainLooper() != Looper.myLooper()) throw new IllegalStateException("destroyLoader must be called on the main thread");
        if (DEBUG) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("destroyLoader in ");
            stringBuilder.append((Object)this);
            stringBuilder.append(" of ");
            stringBuilder.append(n);
            Log.v((String)"LoaderManager", (String)stringBuilder.toString());
        }
        if ((stringBuilder = this.mLoaderViewModel.getLoader(n)) == null) return;
        stringBuilder.destroy(true);
        this.mLoaderViewModel.removeLoader(n);
    }

    @Deprecated
    public void dump(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        this.mLoaderViewModel.dump(string, fileDescriptor, printWriter, stringArray);
    }

    public <D> Loader<D> getLoader(int n) {
        if (this.mLoaderViewModel.isCreatingLoader()) throw new IllegalStateException("Called while creating a loader");
        Object object = this.mLoaderViewModel.getLoader(n);
        object = object != null ? object.getLoader() : null;
        return object;
    }

    public boolean hasRunningLoaders() {
        return this.mLoaderViewModel.hasRunningLoaders();
    }

    public <D> Loader<D> initLoader(int n, Bundle object, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.mLoaderViewModel.isCreatingLoader()) throw new IllegalStateException("Called while creating a loader");
        if (Looper.getMainLooper() != Looper.myLooper()) throw new IllegalStateException("initLoader must be called on the main thread");
        LoaderInfo loaderInfo = this.mLoaderViewModel.getLoader(n);
        if (DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("initLoader in ");
            stringBuilder.append((Object)this);
            stringBuilder.append(": args=");
            stringBuilder.append(object);
            Log.v((String)"LoaderManager", (String)stringBuilder.toString());
        }
        if (loaderInfo == null) {
            return this.createAndInstallLoader(n, (Bundle)object, loaderCallbacks, null);
        }
        if (!DEBUG) return loaderInfo.setCallback(this.mLifecycleOwner, loaderCallbacks);
        object = new StringBuilder();
        ((StringBuilder)object).append("  Re-using existing loader ");
        ((StringBuilder)object).append(loaderInfo);
        Log.v((String)"LoaderManager", (String)((StringBuilder)object).toString());
        return loaderInfo.setCallback(this.mLifecycleOwner, loaderCallbacks);
    }

    public void markForRedelivery() {
        this.mLoaderViewModel.markForRedelivery();
    }

    public <D> Loader<D> restartLoader(int n, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        StringBuilder stringBuilder;
        if (this.mLoaderViewModel.isCreatingLoader()) throw new IllegalStateException("Called while creating a loader");
        if (Looper.getMainLooper() != Looper.myLooper()) throw new IllegalStateException("restartLoader must be called on the main thread");
        if (DEBUG) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("restartLoader in ");
            stringBuilder.append((Object)this);
            stringBuilder.append(": args=");
            stringBuilder.append(bundle);
            Log.v((String)"LoaderManager", (String)stringBuilder.toString());
        }
        LoaderInfo loaderInfo = this.mLoaderViewModel.getLoader(n);
        stringBuilder = null;
        if (loaderInfo == null) return this.createAndInstallLoader(n, bundle, loaderCallbacks, (Loader<D>)stringBuilder);
        stringBuilder = loaderInfo.destroy(false);
        return this.createAndInstallLoader(n, bundle, loaderCallbacks, (Loader<D>)stringBuilder);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode((Object)this)));
        stringBuilder.append(" in ");
        DebugUtils.buildShortClassTag((Object)this.mLifecycleOwner, (StringBuilder)stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
