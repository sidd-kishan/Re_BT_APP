/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Encoder
 *  com.bumptech.glide.provider.EncoderRegistry$Entry
 */
package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.provider.EncoderRegistry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EncoderRegistry {
    private final List<Entry<?>> encoders = new ArrayList();

    public <T> void append(Class<T> clazz, Encoder<T> encoder) {
        synchronized (this) {
            List<Entry<?>> list = this.encoders;
            Entry entry = new Entry(clazz, encoder);
            list.add(entry);
            return;
        }
    }

    public <T> Encoder<T> getEncoder(Class<T> encoder) {
        synchronized (this) {
            try {
                Entry<?> entry;
                Iterator<Entry<?>> iterator = this.encoders.iterator();
                do {
                    if (!iterator.hasNext()) return null;
                } while (!(entry = iterator.next()).handles(encoder));
                encoder = entry.encoder;
                return encoder;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public <T> void prepend(Class<T> clazz, Encoder<T> encoder) {
        synchronized (this) {
            List<Entry<?>> list = this.encoders;
            Entry entry = new Entry(clazz, encoder);
            list.add(0, entry);
            return;
        }
    }
}
