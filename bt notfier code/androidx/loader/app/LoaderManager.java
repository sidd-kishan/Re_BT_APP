/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.ViewModelStoreOwner
 *  androidx.loader.app.LoaderManager$LoaderCallbacks
 *  androidx.loader.app.LoaderManagerImpl
 *  androidx.loader.content.Loader
 */
package androidx.loader.app;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.loader.app.LoaderManagerImpl;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class LoaderManager {
    public static void enableDebugLogging(boolean bl) {
        LoaderManagerImpl.DEBUG = bl;
    }

    public static <T extends LifecycleOwner & ViewModelStoreOwner> LoaderManager getInstance(T t) {
        return new LoaderManagerImpl(t, ((ViewModelStoreOwner)t).getViewModelStore());
    }

    public abstract void destroyLoader(int var1);

    @Deprecated
    public abstract void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4);

    public abstract <D> Loader<D> getLoader(int var1);

    public boolean hasRunningLoaders() {
        return false;
    }

    public abstract <D> Loader<D> initLoader(int var1, Bundle var2, LoaderCallbacks<D> var3);

    public abstract void markForRedelivery();

    public abstract <D> Loader<D> restartLoader(int var1, Bundle var2, LoaderCallbacks<D> var3);
}
