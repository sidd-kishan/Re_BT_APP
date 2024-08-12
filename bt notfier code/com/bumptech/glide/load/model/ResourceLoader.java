/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.net.Uri
 *  android.util.Log
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoader$LoadData
 */
package com.bumptech.glide.load.model;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;

public class ResourceLoader<Data>
implements ModelLoader<Integer, Data> {
    private static final String TAG = "ResourceLoader";
    private final Resources resources;
    private final ModelLoader<Uri, Data> uriLoader;

    public ResourceLoader(Resources resources, ModelLoader<Uri, Data> modelLoader) {
        this.resources = resources;
        this.uriLoader = modelLoader;
    }

    private Uri getResourceUri(Integer n) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("android.resource://");
            stringBuilder.append(this.resources.getResourcePackageName(n.intValue()));
            stringBuilder.append('/');
            stringBuilder.append(this.resources.getResourceTypeName(n.intValue()));
            stringBuilder.append('/');
            stringBuilder.append(this.resources.getResourceEntryName(n.intValue()));
            stringBuilder = Uri.parse((String)stringBuilder.toString());
            return stringBuilder;
        }
        catch (Resources.NotFoundException notFoundException) {
            if (!Log.isLoggable((String)TAG, (int)5)) return null;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Received invalid resource id: ");
            stringBuilder.append(n);
            Log.w((String)TAG, (String)stringBuilder.toString(), (Throwable)notFoundException);
            return null;
        }
    }

    public ModelLoader.LoadData<Data> buildLoadData(Integer n, int n2, int n3, Options options) {
        n = (n = this.getResourceUri(n)) == null ? null : this.uriLoader.buildLoadData((Object)n, n2, n3, options);
        return n;
    }

    public boolean handles(Integer n) {
        return true;
    }
}
