/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoader$LoadData
 */
package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;

public class StringLoader<Data>
implements ModelLoader<String, Data> {
    private final ModelLoader<Uri, Data> uriLoader;

    public StringLoader(ModelLoader<Uri, Data> modelLoader) {
        this.uriLoader = modelLoader;
    }

    private static Uri parseUri(String string) {
        Uri uri;
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        string = string.charAt(0) == '/' ? StringLoader.toFileUri(string) : ((uri = Uri.parse((String)string)).getScheme() == null ? StringLoader.toFileUri(string) : uri);
        return string;
    }

    private static Uri toFileUri(String string) {
        return Uri.fromFile((File)new File(string));
    }

    public ModelLoader.LoadData<Data> buildLoadData(String string, int n, int n2, Options options) {
        string = (string = StringLoader.parseUri(string)) == null ? null : this.uriLoader.buildLoadData((Object)string, n, n2, options);
        return string;
    }

    public boolean handles(String string) {
        return true;
    }
}
