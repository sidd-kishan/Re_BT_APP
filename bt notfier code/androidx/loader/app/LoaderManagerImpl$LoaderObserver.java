/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.lifecycle.Observer
 *  androidx.loader.app.LoaderManager$LoaderCallbacks
 *  androidx.loader.app.LoaderManagerImpl
 *  androidx.loader.content.Loader
 */
package androidx.loader.app;

import android.util.Log;
import androidx.lifecycle.Observer;
import androidx.loader.app.LoaderManager;
import androidx.loader.app.LoaderManagerImpl;
import androidx.loader.content.Loader;
import java.io.PrintWriter;

static class LoaderManagerImpl.LoaderObserver<D>
implements Observer<D> {
    private final LoaderManager.LoaderCallbacks<D> mCallback;
    private boolean mDeliveredData = false;
    private final Loader<D> mLoader;

    LoaderManagerImpl.LoaderObserver(Loader<D> loader, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        this.mLoader = loader;
        this.mCallback = loaderCallbacks;
    }

    public void dump(String string, PrintWriter printWriter) {
        printWriter.print(string);
        printWriter.print("mDeliveredData=");
        printWriter.println(this.mDeliveredData);
    }

    boolean hasDeliveredData() {
        return this.mDeliveredData;
    }

    public void onChanged(D d) {
        if (LoaderManagerImpl.DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("  onLoadFinished in ");
            stringBuilder.append(this.mLoader);
            stringBuilder.append(": ");
            stringBuilder.append(this.mLoader.dataToString(d));
            Log.v((String)"LoaderManager", (String)stringBuilder.toString());
        }
        this.mCallback.onLoadFinished(this.mLoader, d);
        this.mDeliveredData = true;
    }

    void reset() {
        if (!this.mDeliveredData) return;
        if (LoaderManagerImpl.DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("  Resetting: ");
            stringBuilder.append(this.mLoader);
            Log.v((String)"LoaderManager", (String)stringBuilder.toString());
        }
        this.mCallback.onLoaderReset(this.mLoader);
    }

    public String toString() {
        return this.mCallback.toString();
    }
}
