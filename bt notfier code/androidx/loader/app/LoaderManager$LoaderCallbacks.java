/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.loader.content.Loader
 */
package androidx.loader.app;

import android.os.Bundle;
import androidx.loader.content.Loader;

public static interface LoaderManager.LoaderCallbacks<D> {
    public Loader<D> onCreateLoader(int var1, Bundle var2);

    public void onLoadFinished(Loader<D> var1, D var2);

    public void onLoaderReset(Loader<D> var1);
}
