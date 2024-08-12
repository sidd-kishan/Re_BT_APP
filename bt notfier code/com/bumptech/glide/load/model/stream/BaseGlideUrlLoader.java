/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.model.GlideUrl
 *  com.bumptech.glide.load.model.Headers
 *  com.bumptech.glide.load.model.ModelCache
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoader$LoadData
 */
package com.bumptech.glide.load.model.stream;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class BaseGlideUrlLoader<Model>
implements ModelLoader<Model, InputStream> {
    private final ModelLoader<GlideUrl, InputStream> concreteLoader;
    private final ModelCache<Model, GlideUrl> modelCache;

    protected BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this(modelLoader, null);
    }

    protected BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader, ModelCache<Model, GlideUrl> modelCache) {
        this.concreteLoader = modelLoader;
        this.modelCache = modelCache;
    }

    private static List<Key> getAlternateKeys(Collection<String> object) {
        ArrayList<Key> arrayList = new ArrayList<Key>(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            arrayList.add((Key)new GlideUrl((String)object.next()));
        }
        return arrayList;
    }

    public ModelLoader.LoadData<InputStream> buildLoadData(Model object, int n, int n2, Options options) {
        Object object2 = this.modelCache;
        object2 = object2 != null ? (GlideUrl)object2.get(object, n, n2) : null;
        GlideUrl glideUrl = object2;
        if (object2 == null) {
            object2 = this.getUrl(object, n, n2, options);
            if (TextUtils.isEmpty((CharSequence)object2)) {
                return null;
            }
            glideUrl = new GlideUrl((String)object2, this.getHeaders(object, n, n2, options));
            object2 = this.modelCache;
            if (object2 != null) {
                object2.put(object, n, n2, (Object)glideUrl);
            }
        }
        object = this.getAlternateUrls(object, n, n2, options);
        if ((options = this.concreteLoader.buildLoadData((Object)glideUrl, n, n2, options)) == null) return options;
        if (!object.isEmpty()) return new ModelLoader.LoadData(options.sourceKey, BaseGlideUrlLoader.getAlternateKeys((Collection<String>)object), options.fetcher);
        return options;
    }

    protected List<String> getAlternateUrls(Model Model, int n, int n2, Options options) {
        return Collections.emptyList();
    }

    protected Headers getHeaders(Model Model, int n, int n2, Options options) {
        return Headers.DEFAULT;
    }

    protected abstract String getUrl(Model var1, int var2, int var3, Options var4);
}
