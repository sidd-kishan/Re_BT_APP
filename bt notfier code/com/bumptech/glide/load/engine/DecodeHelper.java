/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.GlideContext
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.Registry$NoModelLoaderAvailableException
 *  com.bumptech.glide.Registry$NoSourceEncoderAvailableException
 *  com.bumptech.glide.load.Encoder
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.ResourceEncoder
 *  com.bumptech.glide.load.Transformation
 *  com.bumptech.glide.load.engine.DecodeJob$DiskCacheProvider
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  com.bumptech.glide.load.engine.LoadPath
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
 *  com.bumptech.glide.load.engine.cache.DiskCache
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoader$LoadData
 *  com.bumptech.glide.load.resource.UnitTransformation
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class DecodeHelper<Transcode> {
    private final List<Key> cacheKeys;
    private DecodeJob.DiskCacheProvider diskCacheProvider;
    private DiskCacheStrategy diskCacheStrategy;
    private GlideContext glideContext;
    private int height;
    private boolean isCacheKeysSet;
    private boolean isLoadDataSet;
    private boolean isScaleOnlyOrNoTransform;
    private boolean isTransformationRequired;
    private final List<ModelLoader.LoadData<?>> loadData = new ArrayList();
    private Object model;
    private Options options;
    private Priority priority;
    private Class<?> resourceClass;
    private Key signature;
    private Class<Transcode> transcodeClass;
    private Map<Class<?>, Transformation<?>> transformations;
    private int width;

    DecodeHelper() {
        this.cacheKeys = new ArrayList<Key>();
    }

    void clear() {
        this.glideContext = null;
        this.model = null;
        this.signature = null;
        this.resourceClass = null;
        this.transcodeClass = null;
        this.options = null;
        this.priority = null;
        this.transformations = null;
        this.diskCacheStrategy = null;
        this.loadData.clear();
        this.isLoadDataSet = false;
        this.cacheKeys.clear();
        this.isCacheKeysSet = false;
    }

    ArrayPool getArrayPool() {
        return this.glideContext.getArrayPool();
    }

    List<Key> getCacheKeys() {
        if (this.isCacheKeysSet) return this.cacheKeys;
        this.isCacheKeysSet = true;
        this.cacheKeys.clear();
        List<ModelLoader.LoadData<?>> list = this.getLoadData();
        int n = list.size();
        int n2 = 0;
        while (n2 < n) {
            ModelLoader.LoadData<?> loadData = list.get(n2);
            if (!this.cacheKeys.contains(loadData.sourceKey)) {
                this.cacheKeys.add(loadData.sourceKey);
            }
            for (int i = 0; i < loadData.alternateKeys.size(); ++i) {
                if (this.cacheKeys.contains(loadData.alternateKeys.get(i))) continue;
                this.cacheKeys.add((Key)loadData.alternateKeys.get(i));
            }
            ++n2;
        }
        return this.cacheKeys;
    }

    DiskCache getDiskCache() {
        return this.diskCacheProvider.getDiskCache();
    }

    DiskCacheStrategy getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    int getHeight() {
        return this.height;
    }

    List<ModelLoader.LoadData<?>> getLoadData() {
        if (this.isLoadDataSet) return this.loadData;
        this.isLoadDataSet = true;
        this.loadData.clear();
        List list = this.glideContext.getRegistry().getModelLoaders(this.model);
        int n = 0;
        int n2 = list.size();
        while (n < n2) {
            ModelLoader.LoadData loadData = ((ModelLoader)list.get(n)).buildLoadData(this.model, this.width, this.height, this.options);
            if (loadData != null) {
                this.loadData.add(loadData);
            }
            ++n;
        }
        return this.loadData;
    }

    <Data> LoadPath<Data, ?, Transcode> getLoadPath(Class<Data> clazz) {
        return this.glideContext.getRegistry().getLoadPath(clazz, this.resourceClass, this.transcodeClass);
    }

    List<ModelLoader<File, ?>> getModelLoaders(File file) throws Registry.NoModelLoaderAvailableException {
        return this.glideContext.getRegistry().getModelLoaders((Object)file);
    }

    Options getOptions() {
        return this.options;
    }

    Priority getPriority() {
        return this.priority;
    }

    List<Class<?>> getRegisteredResourceClasses() {
        return this.glideContext.getRegistry().getRegisteredResourceClasses(this.model.getClass(), this.resourceClass, this.transcodeClass);
    }

    <Z> ResourceEncoder<Z> getResultEncoder(Resource<Z> resource) {
        return this.glideContext.getRegistry().getResultEncoder(resource);
    }

    Key getSignature() {
        return this.signature;
    }

    <X> Encoder<X> getSourceEncoder(X x) throws Registry.NoSourceEncoderAvailableException {
        return this.glideContext.getRegistry().getSourceEncoder(x);
    }

    <Z> Transformation<Z> getTransformation(Class<Z> clazz) {
        Object object;
        block3: {
            Transformation<?> transformation = this.transformations.get(clazz);
            object = transformation;
            if (transformation == null) {
                Iterator<Map.Entry<Class<?>, Transformation<?>>> iterator = this.transformations.entrySet().iterator();
                do {
                    object = transformation;
                    if (!iterator.hasNext()) break block3;
                } while (!((Class)(object = iterator.next()).getKey()).isAssignableFrom(clazz));
                object = (Transformation)object.getValue();
            }
        }
        if (object != null) return object;
        if (!this.transformations.isEmpty()) return UnitTransformation.get();
        if (!this.isTransformationRequired) {
            return UnitTransformation.get();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Missing transformation for ");
        ((StringBuilder)object).append(clazz);
        ((StringBuilder)object).append(". If you wish to ignore unknown resource types, use the optional transformation methods.");
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    int getWidth() {
        return this.width;
    }

    boolean hasLoadPath(Class<?> clazz) {
        boolean bl = this.getLoadPath(clazz) != null;
        return bl;
    }

    <R> void init(GlideContext glideContext, Object object, Key key, int n, int n2, DiskCacheStrategy diskCacheStrategy, Class<?> clazz, Class<R> clazz2, Priority priority, Options options, Map<Class<?>, Transformation<?>> map, boolean bl, boolean bl2, DecodeJob.DiskCacheProvider diskCacheProvider) {
        this.glideContext = glideContext;
        this.model = object;
        this.signature = key;
        this.width = n;
        this.height = n2;
        this.diskCacheStrategy = diskCacheStrategy;
        this.resourceClass = clazz;
        this.diskCacheProvider = diskCacheProvider;
        this.transcodeClass = clazz2;
        this.priority = priority;
        this.options = options;
        this.transformations = map;
        this.isTransformationRequired = bl;
        this.isScaleOnlyOrNoTransform = bl2;
    }

    boolean isResourceEncoderAvailable(Resource<?> resource) {
        return this.glideContext.getRegistry().isResourceEncoderAvailable(resource);
    }

    boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    boolean isSourceKey(Key key) {
        List<ModelLoader.LoadData<?>> list = this.getLoadData();
        int n = list.size();
        int n2 = 0;
        while (n2 < n) {
            if (list.get((int)n2).sourceKey.equals((Object)key)) {
                return true;
            }
            ++n2;
        }
        return false;
    }
}
