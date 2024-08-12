/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.util.Pools$Pool
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.data.DataRewinder
 *  com.bumptech.glide.load.engine.DecodePath
 *  com.bumptech.glide.load.engine.DecodePath$DecodeCallback
 *  com.bumptech.glide.load.engine.GlideException
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadPath<Data, ResourceType, Transcode> {
    private final Class<Data> dataClass;
    private final List<? extends DecodePath<Data, ResourceType, Transcode>> decodePaths;
    private final String failureMessage;
    private final Pools.Pool<List<Throwable>> listPool;

    public LoadPath(Class<Data> clazz, Class<ResourceType> clazz2, Class<Transcode> clazz3, List<DecodePath<Data, ResourceType, Transcode>> object, Pools.Pool<List<Throwable>> pool) {
        this.dataClass = clazz;
        this.listPool = pool;
        this.decodePaths = (List)Preconditions.checkNotEmpty(object);
        object = new StringBuilder();
        ((StringBuilder)object).append("Failed LoadPath{");
        ((StringBuilder)object).append(clazz.getSimpleName());
        ((StringBuilder)object).append("->");
        ((StringBuilder)object).append(clazz2.getSimpleName());
        ((StringBuilder)object).append("->");
        ((StringBuilder)object).append(clazz3.getSimpleName());
        ((StringBuilder)object).append("}");
        this.failureMessage = ((StringBuilder)object).toString();
    }

    private Resource<Transcode> loadWithExceptionList(DataRewinder<Data> object, Options options, int n, int n2, DecodePath.DecodeCallback<ResourceType> decodeCallback, List<Throwable> list) throws GlideException {
        Resource resource;
        int n3 = this.decodePaths.size();
        Resource resource2 = null;
        int n4 = 0;
        while (true) {
            resource = resource2;
            if (n4 >= n3) break;
            resource = this.decodePaths.get(n4);
            try {
                resource2 = resource = resource.decode(object, n, n2, options, decodeCallback);
            }
            catch (GlideException glideException) {
                list.add(glideException);
            }
            if (resource2 != null) {
                resource = resource2;
                break;
            }
            ++n4;
        }
        if (resource != null) {
            return resource;
        }
        object = new GlideException(this.failureMessage, new ArrayList<Throwable>(list));
        throw object;
    }

    public Class<Data> getDataClass() {
        return this.dataClass;
    }

    public Resource<Transcode> load(DataRewinder<Data> dataRewinder, Options options, int n, int n2, DecodePath.DecodeCallback<ResourceType> decodeCallback) throws GlideException {
        List list = (List)Preconditions.checkNotNull((Object)this.listPool.acquire());
        try {
            dataRewinder = this.loadWithExceptionList(dataRewinder, options, n, n2, decodeCallback, list);
            return dataRewinder;
        }
        finally {
            this.listPool.release((Object)list);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LoadPath{decodePaths=");
        stringBuilder.append(Arrays.toString(this.decodePaths.toArray()));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
