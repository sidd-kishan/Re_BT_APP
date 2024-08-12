/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.resource.transcode.ResourceTranscoder
 *  com.bumptech.glide.load.resource.transcode.TranscoderRegistry$Entry
 *  com.bumptech.glide.load.resource.transcode.UnitTranscoder
 */
package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TranscoderRegistry {
    private final List<Entry<?, ?>> transcoders = new ArrayList();

    public <Z, R> ResourceTranscoder<Z, R> get(Class<Z> resourceTranscoder, Class<R> clazz) {
        synchronized (this) {
            try {
                Object object;
                if (clazz.isAssignableFrom((Class<?>)resourceTranscoder)) {
                    resourceTranscoder = UnitTranscoder.get();
                    return resourceTranscoder;
                }
                Object object2 = this.transcoders.iterator();
                do {
                    if (object2.hasNext()) continue;
                    object = new StringBuilder();
                    ((StringBuilder)object).append("No transcoder registered to transcode from ");
                    ((StringBuilder)object).append(resourceTranscoder);
                    ((StringBuilder)object).append(" to ");
                    ((StringBuilder)object).append(clazz);
                    object2 = new IllegalArgumentException(((StringBuilder)object).toString());
                    throw object2;
                } while (!(object = object2.next()).handles((Class)resourceTranscoder, clazz));
                resourceTranscoder = ((Entry)object).transcoder;
                return resourceTranscoder;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public <Z, R> List<Class<R>> getTranscodeClasses(Class<Z> clazz, Class<R> clazz2) {
        synchronized (this) {
            try {
                ArrayList<Class<R>> arrayList = new ArrayList<Class<R>>();
                if (clazz2.isAssignableFrom(clazz)) {
                    arrayList.add(clazz2);
                    return arrayList;
                }
                Iterator<Entry<?, ?>> iterator = this.transcoders.iterator();
                while (iterator.hasNext()) {
                    if (!iterator.next().handles(clazz, clazz2)) continue;
                    arrayList.add(clazz2);
                }
                return arrayList;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public <Z, R> void register(Class<Z> clazz, Class<R> clazz2, ResourceTranscoder<Z, R> resourceTranscoder) {
        synchronized (this) {
            List<Entry<?, ?>> list = this.transcoders;
            Entry entry = new Entry(clazz, clazz2, resourceTranscoder);
            list.add(entry);
            return;
        }
    }
}
