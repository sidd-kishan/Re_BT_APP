/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.util.Pools$Pool
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.ModelLoaderRegistry$ModelLoaderCache
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory
 */
package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModelLoaderRegistry {
    private final ModelLoaderCache cache = new ModelLoaderCache();
    private final MultiModelLoaderFactory multiModelLoaderFactory;

    public ModelLoaderRegistry(Pools.Pool<List<Throwable>> pool) {
        this(new MultiModelLoaderFactory(pool));
    }

    private ModelLoaderRegistry(MultiModelLoaderFactory multiModelLoaderFactory) {
        this.multiModelLoaderFactory = multiModelLoaderFactory;
    }

    private static <A> Class<A> getClass(A a) {
        return a.getClass();
    }

    private <A> List<ModelLoader<A, ?>> getModelLoadersForClass(Class<A> clazz) {
        List list;
        List list2 = list = this.cache.get(clazz);
        if (list != null) return list2;
        list2 = Collections.unmodifiableList(this.multiModelLoaderFactory.build(clazz));
        this.cache.put(clazz, list2);
        return list2;
    }

    private <Model, Data> void tearDown(List<ModelLoaderFactory<? extends Model, ? extends Data>> object) {
        object = object.iterator();
        while (object.hasNext()) {
            ((ModelLoaderFactory)object.next()).teardown();
        }
    }

    public <Model, Data> void append(Class<Model> clazz, Class<Data> clazz2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        synchronized (this) {
            this.multiModelLoaderFactory.append(clazz, clazz2, modelLoaderFactory);
            this.cache.clear();
            return;
        }
    }

    public <Model, Data> ModelLoader<Model, Data> build(Class<Model> modelLoader, Class<Data> clazz) {
        synchronized (this) {
            modelLoader = this.multiModelLoaderFactory.build(modelLoader, clazz);
            return modelLoader;
        }
    }

    public List<Class<?>> getDataClasses(Class<?> object) {
        synchronized (this) {
            object = this.multiModelLoaderFactory.getDataClasses(object);
            return object;
        }
    }

    public <A> List<ModelLoader<A, ?>> getModelLoaders(A a) {
        synchronized (this) {
            try {
                List<ModelLoader<A, ?>> list = this.getModelLoadersForClass(ModelLoaderRegistry.getClass(a));
                int n = list.size();
                ArrayList arrayList = new ArrayList(n);
                int n2 = 0;
                while (n2 < n) {
                    ModelLoader<A, ?> modelLoader = list.get(n2);
                    if (modelLoader.handles(a)) {
                        arrayList.add(modelLoader);
                    }
                    ++n2;
                }
                return arrayList;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public <Model, Data> void prepend(Class<Model> clazz, Class<Data> clazz2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        synchronized (this) {
            this.multiModelLoaderFactory.prepend(clazz, clazz2, modelLoaderFactory);
            this.cache.clear();
            return;
        }
    }

    public <Model, Data> void remove(Class<Model> clazz, Class<Data> clazz2) {
        synchronized (this) {
            this.tearDown(this.multiModelLoaderFactory.remove(clazz, clazz2));
            this.cache.clear();
            return;
        }
    }

    public <Model, Data> void replace(Class<Model> clazz, Class<Data> clazz2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        synchronized (this) {
            this.tearDown(this.multiModelLoaderFactory.replace(clazz, clazz2, modelLoaderFactory));
            this.cache.clear();
            return;
        }
    }
}
