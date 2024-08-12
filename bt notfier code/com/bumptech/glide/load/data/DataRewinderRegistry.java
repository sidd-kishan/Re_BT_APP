/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.data.DataRewinder
 *  com.bumptech.glide.load.data.DataRewinder$Factory
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DataRewinderRegistry {
    private static final DataRewinder.Factory<?> DEFAULT_FACTORY = new /* Unavailable Anonymous Inner Class!! */;
    private final Map<Class<?>, DataRewinder.Factory<?>> rewinders = new HashMap();

    public <T> DataRewinder<T> build(T object) {
        synchronized (this) {
            try {
                DataRewinder.Factory<?> factory;
                Preconditions.checkNotNull(object);
                DataRewinder.Factory<?> factory2 = factory = this.rewinders.get(object.getClass());
                if (factory == null) {
                    Iterator<DataRewinder.Factory<?>> iterator = this.rewinders.values().iterator();
                    do {
                        factory2 = factory;
                    } while (iterator.hasNext() && !(factory2 = iterator.next()).getDataClass().isAssignableFrom(object.getClass()));
                }
                factory = factory2;
                if (factory2 == null) {
                    factory = DEFAULT_FACTORY;
                }
                object = factory.build(object);
                return object;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public void register(DataRewinder.Factory<?> factory) {
        synchronized (this) {
            this.rewinders.put(factory.getDataClass(), factory);
            return;
        }
    }
}
