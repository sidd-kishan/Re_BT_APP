/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.util.Pools$Pool
 *  com.bumptech.glide.Registry$NoModelLoaderAvailableException
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory$EmptyModelLoader
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory$Entry
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory$Factory
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MultiModelLoaderFactory {
    private static final Factory DEFAULT_FACTORY = new Factory();
    private static final ModelLoader<Object, Object> EMPTY_MODEL_LOADER = new EmptyModelLoader();
    private final Set<Entry<?, ?>> alreadyUsedEntries;
    private final List<Entry<?, ?>> entries = new ArrayList();
    private final Factory factory;
    private final Pools.Pool<List<Throwable>> throwableListPool;

    public MultiModelLoaderFactory(Pools.Pool<List<Throwable>> pool) {
        this(pool, DEFAULT_FACTORY);
    }

    MultiModelLoaderFactory(Pools.Pool<List<Throwable>> pool, Factory factory) {
        this.alreadyUsedEntries = new HashSet();
        this.throwableListPool = pool;
        this.factory = factory;
    }

    private <Model, Data> void add(Class<Model> entry, Class<Data> object, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory, boolean bl) {
        entry = new Entry(entry, object, modelLoaderFactory);
        object = this.entries;
        int n = bl ? object.size() : 0;
        object.add(n, entry);
    }

    private <Model, Data> ModelLoader<Model, Data> build(Entry<?, ?> entry) {
        return (ModelLoader)Preconditions.checkNotNull((Object)entry.factory.build(this));
    }

    private static <Model, Data> ModelLoader<Model, Data> emptyModelLoader() {
        return EMPTY_MODEL_LOADER;
    }

    private <Model, Data> ModelLoaderFactory<Model, Data> getFactory(Entry<?, ?> entry) {
        return entry.factory;
    }

    <Model, Data> void append(Class<Model> clazz, Class<Data> clazz2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        synchronized (this) {
            this.add(clazz, clazz2, modelLoaderFactory, true);
            return;
        }
    }

    public <Model, Data> ModelLoader<Model, Data> build(Class<Model> modelLoader, Class<Data> clazz) {
        synchronized (this) {
            try {
                ArrayList<ModelLoader<Model, Data>> arrayList = new ArrayList<ModelLoader<Model, Data>>();
                Registry.NoModelLoaderAvailableException noModelLoaderAvailableException = this.entries.iterator();
                boolean bl = false;
                while (noModelLoaderAvailableException.hasNext()) {
                    Entry<?, ?> entry = noModelLoaderAvailableException.next();
                    if (this.alreadyUsedEntries.contains(entry)) {
                        bl = true;
                        continue;
                    }
                    if (!entry.handles(modelLoader, clazz)) continue;
                    this.alreadyUsedEntries.add(entry);
                    arrayList.add(this.build(entry));
                    this.alreadyUsedEntries.remove(entry);
                }
                if (arrayList.size() > 1) {
                    modelLoader = this.factory.build(arrayList, this.throwableListPool);
                    return modelLoader;
                }
                if (arrayList.size() == 1) {
                    modelLoader = (ModelLoader)arrayList.get(0);
                    return modelLoader;
                }
                if (bl) {
                    modelLoader = MultiModelLoaderFactory.emptyModelLoader();
                    return modelLoader;
                }
                noModelLoaderAvailableException = new Registry.NoModelLoaderAvailableException((Class)modelLoader, clazz);
                throw noModelLoaderAvailableException;
            }
            catch (Throwable throwable) {
                try {
                    this.alreadyUsedEntries.clear();
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    throw throwable2;
                }
            }
        }
    }

    <Model> List<ModelLoader<Model, ?>> build(Class<Model> clazz) {
        synchronized (this) {
            try {
                ArrayList arrayList = new ArrayList();
                Iterator<Entry<?, ?>> iterator = this.entries.iterator();
                while (iterator.hasNext()) {
                    Entry<?, ?> entry = iterator.next();
                    if (this.alreadyUsedEntries.contains(entry) || !entry.handles(clazz)) continue;
                    this.alreadyUsedEntries.add(entry);
                    arrayList.add(this.build(entry));
                    this.alreadyUsedEntries.remove(entry);
                }
                return arrayList;
            }
            catch (Throwable throwable) {
                try {
                    this.alreadyUsedEntries.clear();
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    throw throwable2;
                }
            }
        }
    }

    List<Class<?>> getDataClasses(Class<?> clazz) {
        synchronized (this) {
            try {
                ArrayList arrayList = new ArrayList();
                Iterator<Entry<?, ?>> iterator = this.entries.iterator();
                while (iterator.hasNext()) {
                    Entry<?, ?> entry = iterator.next();
                    if (arrayList.contains(entry.dataClass) || !entry.handles(clazz)) continue;
                    arrayList.add(entry.dataClass);
                }
                return arrayList;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    <Model, Data> void prepend(Class<Model> clazz, Class<Data> clazz2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        synchronized (this) {
            this.add(clazz, clazz2, modelLoaderFactory, false);
            return;
        }
    }

    <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> remove(Class<Model> clazz, Class<Data> clazz2) {
        synchronized (this) {
            try {
                ArrayList<ModelLoaderFactory<Model, Data>> arrayList = new ArrayList<ModelLoaderFactory<Model, Data>>();
                Iterator<Entry<?, ?>> iterator = this.entries.iterator();
                while (iterator.hasNext()) {
                    Entry<?, ?> entry = iterator.next();
                    if (!entry.handles(clazz, clazz2)) continue;
                    iterator.remove();
                    arrayList.add(this.getFactory(entry));
                }
                return arrayList;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> replace(Class<Model> clazz, Class<Data> clazz2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        synchronized (this) {
            List<ModelLoaderFactory<? extends Model, ? extends Data>> list = this.remove(clazz, clazz2);
            this.append(clazz, clazz2, modelLoaderFactory);
            return list;
        }
    }
}
