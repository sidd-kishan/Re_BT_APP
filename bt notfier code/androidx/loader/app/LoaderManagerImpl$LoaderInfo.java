/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Looper
 *  android.util.Log
 *  androidx.core.util.DebugUtils
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.MutableLiveData
 *  androidx.lifecycle.Observer
 *  androidx.loader.app.LoaderManager$LoaderCallbacks
 *  androidx.loader.app.LoaderManagerImpl
 *  androidx.loader.app.LoaderManagerImpl$LoaderObserver
 *  androidx.loader.content.Loader
 *  androidx.loader.content.Loader$OnLoadCompleteListener
 */
package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.loader.app.LoaderManager;
import androidx.loader.app.LoaderManagerImpl;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public static class LoaderManagerImpl.LoaderInfo<D>
extends MutableLiveData<D>
implements Loader.OnLoadCompleteListener<D> {
    private final Bundle mArgs;
    private final int mId;
    private LifecycleOwner mLifecycleOwner;
    private final Loader<D> mLoader;
    private LoaderManagerImpl.LoaderObserver<D> mObserver;
    private Loader<D> mPriorLoader;

    LoaderManagerImpl.LoaderInfo(int n, Bundle bundle, Loader<D> loader, Loader<D> loader2) {
        this.mId = n;
        this.mArgs = bundle;
        this.mLoader = loader;
        this.mPriorLoader = loader2;
        loader.registerListener(n, (Loader.OnLoadCompleteListener)this);
    }

    Loader<D> destroy(boolean bl) {
        LoaderManagerImpl.LoaderObserver<D> loaderObserver;
        if (LoaderManagerImpl.DEBUG) {
            loaderObserver = new LoaderManagerImpl.LoaderObserver<D>();
            loaderObserver.append("  Destroying: ");
            loaderObserver.append((Object)this);
            Log.v((String)"LoaderManager", (String)loaderObserver.toString());
        }
        this.mLoader.cancelLoad();
        this.mLoader.abandon();
        loaderObserver = this.mObserver;
        if (loaderObserver != null) {
            this.removeObserver((Observer<? super D>)loaderObserver);
            if (bl) {
                loaderObserver.reset();
            }
        }
        this.mLoader.unregisterListener((Loader.OnLoadCompleteListener)this);
        if (loaderObserver == null || loaderObserver.hasDeliveredData()) {
            if (!bl) return this.mLoader;
        }
        this.mLoader.reset();
        return this.mPriorLoader;
    }

    public void dump(String string, FileDescriptor loaderObserver, PrintWriter printWriter, String[] object) {
        printWriter.print(string);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mArgs=");
        printWriter.println(this.mArgs);
        printWriter.print(string);
        printWriter.print("mLoader=");
        printWriter.println(this.mLoader);
        Loader<D> loader = this.mLoader;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("  ");
        loader.dump(stringBuilder.toString(), (FileDescriptor)loaderObserver, printWriter, (String[])object);
        if (this.mObserver != null) {
            printWriter.print(string);
            printWriter.print("mCallbacks=");
            printWriter.println(this.mObserver);
            loaderObserver = this.mObserver;
            object = new StringBuilder();
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append("  ");
            loaderObserver.dump(((StringBuilder)object).toString(), printWriter);
        }
        printWriter.print(string);
        printWriter.print("mData=");
        printWriter.println(this.getLoader().dataToString(this.getValue()));
        printWriter.print(string);
        printWriter.print("mStarted=");
        printWriter.println(this.hasActiveObservers());
    }

    Loader<D> getLoader() {
        return this.mLoader;
    }

    boolean isCallbackWaitingForData() {
        boolean bl = this.hasActiveObservers();
        boolean bl2 = false;
        if (!bl) {
            return false;
        }
        LoaderManagerImpl.LoaderObserver<D> loaderObserver = this.mObserver;
        bl = bl2;
        if (loaderObserver == null) return bl;
        bl = bl2;
        if (loaderObserver.hasDeliveredData()) return bl;
        bl = true;
        return bl;
    }

    void markForRedelivery() {
        LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
        LoaderManagerImpl.LoaderObserver<D> loaderObserver = this.mObserver;
        if (lifecycleOwner == null) return;
        if (loaderObserver == null) return;
        super.removeObserver(loaderObserver);
        this.observe(lifecycleOwner, (Observer)loaderObserver);
    }

    protected void onActive() {
        if (LoaderManagerImpl.DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("  Starting: ");
            stringBuilder.append((Object)this);
            Log.v((String)"LoaderManager", (String)stringBuilder.toString());
        }
        this.mLoader.startLoading();
    }

    protected void onInactive() {
        if (LoaderManagerImpl.DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("  Stopping: ");
            stringBuilder.append((Object)this);
            Log.v((String)"LoaderManager", (String)stringBuilder.toString());
        }
        this.mLoader.stopLoading();
    }

    public void onLoadComplete(Loader<D> object, D d) {
        if (LoaderManagerImpl.DEBUG) {
            object = new StringBuilder();
            ((StringBuilder)object).append("onLoadComplete: ");
            ((StringBuilder)object).append((Object)this);
            Log.v((String)"LoaderManager", (String)((StringBuilder)object).toString());
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.setValue(d);
        } else {
            if (LoaderManagerImpl.DEBUG) {
                Log.w((String)"LoaderManager", (String)"onLoadComplete was incorrectly called on a background thread");
            }
            this.postValue(d);
        }
    }

    public void removeObserver(Observer<? super D> observer) {
        super.removeObserver(observer);
        this.mLifecycleOwner = null;
        this.mObserver = null;
    }

    Loader<D> setCallback(LifecycleOwner lifecycleOwner, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        LoaderManagerImpl.LoaderObserver loaderObserver = new LoaderManagerImpl.LoaderObserver(this.mLoader, loaderCallbacks);
        this.observe(lifecycleOwner, (Observer)loaderObserver);
        loaderCallbacks = this.mObserver;
        if (loaderCallbacks != null) {
            this.removeObserver((Observer<? super D>)loaderCallbacks);
        }
        this.mLifecycleOwner = lifecycleOwner;
        this.mObserver = loaderObserver;
        return this.mLoader;
    }

    public void setValue(D object) {
        super.setValue(object);
        object = this.mPriorLoader;
        if (object == null) return;
        object.reset();
        this.mPriorLoader = null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("LoaderInfo{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode((Object)this)));
        stringBuilder.append(" #");
        stringBuilder.append(this.mId);
        stringBuilder.append(" : ");
        DebugUtils.buildShortClassTag(this.mLoader, (StringBuilder)stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
