/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.util.Pools$Pool
 *  com.bumptech.glide.Registry$NoImageHeaderParserException
 *  com.bumptech.glide.Registry$NoModelLoaderAvailableException
 *  com.bumptech.glide.Registry$NoResultEncoderAvailableException
 *  com.bumptech.glide.Registry$NoSourceEncoderAvailableException
 *  com.bumptech.glide.load.Encoder
 *  com.bumptech.glide.load.ImageHeaderParser
 *  com.bumptech.glide.load.ResourceDecoder
 *  com.bumptech.glide.load.ResourceEncoder
 *  com.bumptech.glide.load.data.DataRewinder
 *  com.bumptech.glide.load.data.DataRewinder$Factory
 *  com.bumptech.glide.load.data.DataRewinderRegistry
 *  com.bumptech.glide.load.engine.DecodePath
 *  com.bumptech.glide.load.engine.LoadPath
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.ModelLoaderRegistry
 *  com.bumptech.glide.load.resource.transcode.ResourceTranscoder
 *  com.bumptech.glide.load.resource.transcode.TranscoderRegistry
 *  com.bumptech.glide.provider.EncoderRegistry
 *  com.bumptech.glide.provider.ImageHeaderParserRegistry
 *  com.bumptech.glide.provider.LoadPathCache
 *  com.bumptech.glide.provider.ModelToResourceClassCache
 *  com.bumptech.glide.provider.ResourceDecoderRegistry
 *  com.bumptech.glide.provider.ResourceEncoderRegistry
 *  com.bumptech.glide.util.pool.FactoryPools
 */
package com.bumptech.glide;

import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.provider.EncoderRegistry;
import com.bumptech.glide.provider.ImageHeaderParserRegistry;
import com.bumptech.glide.provider.LoadPathCache;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Registry {
    private static final String BUCKET_APPEND_ALL = "legacy_append";
    public static final String BUCKET_BITMAP = "Bitmap";
    public static final String BUCKET_BITMAP_DRAWABLE = "BitmapDrawable";
    public static final String BUCKET_GIF = "Gif";
    private static final String BUCKET_PREPEND_ALL = "legacy_prepend_all";
    private final DataRewinderRegistry dataRewinderRegistry;
    private final ResourceDecoderRegistry decoderRegistry;
    private final EncoderRegistry encoderRegistry;
    private final ImageHeaderParserRegistry imageHeaderParserRegistry;
    private final LoadPathCache loadPathCache;
    private final ModelLoaderRegistry modelLoaderRegistry;
    private final ModelToResourceClassCache modelToResourceClassCache = new ModelToResourceClassCache();
    private final ResourceEncoderRegistry resourceEncoderRegistry;
    private final Pools.Pool<List<Throwable>> throwableListPool;
    private final TranscoderRegistry transcoderRegistry;

    public Registry() {
        Pools.Pool pool;
        this.loadPathCache = new LoadPathCache();
        this.throwableListPool = pool = FactoryPools.threadSafeList();
        this.modelLoaderRegistry = new ModelLoaderRegistry(pool);
        this.encoderRegistry = new EncoderRegistry();
        this.decoderRegistry = new ResourceDecoderRegistry();
        this.resourceEncoderRegistry = new ResourceEncoderRegistry();
        this.dataRewinderRegistry = new DataRewinderRegistry();
        this.transcoderRegistry = new TranscoderRegistry();
        this.imageHeaderParserRegistry = new ImageHeaderParserRegistry();
        this.setResourceDecoderBucketPriorityList(Arrays.asList(BUCKET_GIF, BUCKET_BITMAP, BUCKET_BITMAP_DRAWABLE));
    }

    private <Data, TResource, Transcode> List<DecodePath<Data, TResource, Transcode>> getDecodePaths(Class<Data> clazz, Class<TResource> clazz2, Class<Transcode> clazz3) {
        ArrayList<DecodePath<Data, TResource, Transcode>> arrayList = new ArrayList<DecodePath<Data, TResource, Transcode>>();
        Iterator iterator = this.decoderRegistry.getResourceClasses(clazz, clazz2).iterator();
        block0: while (iterator.hasNext()) {
            clazz2 = (Class)iterator.next();
            Iterator iterator2 = this.transcoderRegistry.getTranscodeClasses(clazz2, clazz3).iterator();
            while (true) {
                if (!iterator2.hasNext()) continue block0;
                Class clazz4 = (Class)iterator2.next();
                arrayList.add(new DecodePath(clazz, clazz2, clazz4, this.decoderRegistry.getDecoders(clazz, clazz2), this.transcoderRegistry.get(clazz2, clazz4), this.throwableListPool));
            }
            break;
        }
        return arrayList;
    }

    public <Data> Registry append(Class<Data> clazz, Encoder<Data> encoder) {
        this.encoderRegistry.append(clazz, encoder);
        return this;
    }

    public <TResource> Registry append(Class<TResource> clazz, ResourceEncoder<TResource> resourceEncoder) {
        this.resourceEncoderRegistry.append(clazz, resourceEncoder);
        return this;
    }

    public <Data, TResource> Registry append(Class<Data> clazz, Class<TResource> clazz2, ResourceDecoder<Data, TResource> resourceDecoder) {
        this.append(BUCKET_APPEND_ALL, clazz, clazz2, resourceDecoder);
        return this;
    }

    public <Model, Data> Registry append(Class<Model> clazz, Class<Data> clazz2, ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        this.modelLoaderRegistry.append(clazz, clazz2, modelLoaderFactory);
        return this;
    }

    public <Data, TResource> Registry append(String string, Class<Data> clazz, Class<TResource> clazz2, ResourceDecoder<Data, TResource> resourceDecoder) {
        this.decoderRegistry.append(string, resourceDecoder, clazz, clazz2);
        return this;
    }

    public List<ImageHeaderParser> getImageHeaderParsers() {
        List list = this.imageHeaderParserRegistry.getParsers();
        if (list.isEmpty()) throw new NoImageHeaderParserException();
        return list;
    }

    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> getLoadPath(Class<Data> clazz, Class<TResource> clazz2, Class<Transcode> clazz3) {
        LoadPath loadPath = this.loadPathCache.get(clazz, clazz2, clazz3);
        if (this.loadPathCache.isEmptyLoadPath(loadPath)) {
            return null;
        }
        Object object = loadPath;
        if (loadPath != null) return object;
        object = this.getDecodePaths(clazz, clazz2, clazz3);
        object = object.isEmpty() ? null : new LoadPath(clazz, clazz2, clazz3, (List)object, this.throwableListPool);
        this.loadPathCache.put(clazz, clazz2, clazz3, (LoadPath)object);
        return object;
    }

    public <Model> List<ModelLoader<Model, ?>> getModelLoaders(Model Model) {
        List list = this.modelLoaderRegistry.getModelLoaders(Model);
        if (list.isEmpty()) throw new NoModelLoaderAvailableException(Model);
        return list;
    }

    public <Model, TResource, Transcode> List<Class<?>> getRegisteredResourceClasses(Class<Model> clazz, Class<TResource> clazz2, Class<Transcode> clazz3) {
        Object object = this.modelToResourceClassCache.get(clazz, clazz2);
        ArrayList<Class> arrayList = object;
        if (object != null) return arrayList;
        arrayList = new ArrayList<Class>();
        object = this.modelLoaderRegistry.getDataClasses(clazz).iterator();
        block0: while (true) {
            if (!object.hasNext()) {
                this.modelToResourceClassCache.put(clazz, clazz2, Collections.unmodifiableList(arrayList));
                return arrayList;
            }
            Object object2 = (Class)object.next();
            object2 = this.decoderRegistry.getResourceClasses((Class)object2, clazz2).iterator();
            while (true) {
                if (!object2.hasNext()) continue block0;
                Class clazz4 = (Class)object2.next();
                if (this.transcoderRegistry.getTranscodeClasses(clazz4, clazz3).isEmpty() || arrayList.contains(clazz4)) continue;
                arrayList.add(clazz4);
            }
            break;
        }
    }

    public <X> ResourceEncoder<X> getResultEncoder(Resource<X> resource) throws NoResultEncoderAvailableException {
        ResourceEncoder resourceEncoder = this.resourceEncoderRegistry.get(resource.getResourceClass());
        if (resourceEncoder == null) throw new NoResultEncoderAvailableException(resource.getResourceClass());
        return resourceEncoder;
    }

    public <X> DataRewinder<X> getRewinder(X x) {
        return this.dataRewinderRegistry.build(x);
    }

    public <X> Encoder<X> getSourceEncoder(X x) throws NoSourceEncoderAvailableException {
        Encoder encoder = this.encoderRegistry.getEncoder(x.getClass());
        if (encoder == null) throw new NoSourceEncoderAvailableException(x.getClass());
        return encoder;
    }

    public boolean isResourceEncoderAvailable(Resource<?> resource) {
        boolean bl = this.resourceEncoderRegistry.get(resource.getResourceClass()) != null;
        return bl;
    }

    public <Data> Registry prepend(Class<Data> clazz, Encoder<Data> encoder) {
        this.encoderRegistry.prepend(clazz, encoder);
        return this;
    }

    public <TResource> Registry prepend(Class<TResource> clazz, ResourceEncoder<TResource> resourceEncoder) {
        this.resourceEncoderRegistry.prepend(clazz, resourceEncoder);
        return this;
    }

    public <Data, TResource> Registry prepend(Class<Data> clazz, Class<TResource> clazz2, ResourceDecoder<Data, TResource> resourceDecoder) {
        this.prepend(BUCKET_PREPEND_ALL, clazz, clazz2, resourceDecoder);
        return this;
    }

    public <Model, Data> Registry prepend(Class<Model> clazz, Class<Data> clazz2, ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        this.modelLoaderRegistry.prepend(clazz, clazz2, modelLoaderFactory);
        return this;
    }

    public <Data, TResource> Registry prepend(String string, Class<Data> clazz, Class<TResource> clazz2, ResourceDecoder<Data, TResource> resourceDecoder) {
        this.decoderRegistry.prepend(string, resourceDecoder, clazz, clazz2);
        return this;
    }

    public Registry register(ImageHeaderParser imageHeaderParser) {
        this.imageHeaderParserRegistry.add(imageHeaderParser);
        return this;
    }

    public Registry register(DataRewinder.Factory<?> factory) {
        this.dataRewinderRegistry.register(factory);
        return this;
    }

    @Deprecated
    public <Data> Registry register(Class<Data> clazz, Encoder<Data> encoder) {
        return this.append(clazz, encoder);
    }

    @Deprecated
    public <TResource> Registry register(Class<TResource> clazz, ResourceEncoder<TResource> resourceEncoder) {
        return this.append(clazz, resourceEncoder);
    }

    public <TResource, Transcode> Registry register(Class<TResource> clazz, Class<Transcode> clazz2, ResourceTranscoder<TResource, Transcode> resourceTranscoder) {
        this.transcoderRegistry.register(clazz, clazz2, resourceTranscoder);
        return this;
    }

    public <Model, Data> Registry replace(Class<Model> clazz, Class<Data> clazz2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.modelLoaderRegistry.replace(clazz, clazz2, modelLoaderFactory);
        return this;
    }

    public final Registry setResourceDecoderBucketPriorityList(List<String> list) {
        list = new ArrayList<String>(list);
        list.add(0, BUCKET_PREPEND_ALL);
        list.add(BUCKET_APPEND_ALL);
        this.decoderRegistry.setBucketPriorityList(list);
        return this;
    }
}
