/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.ResourceEncoder
 *  com.bumptech.glide.provider.ResourceEncoderRegistry$Entry
 */
package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import java.util.ArrayList;
import java.util.List;

public class ResourceEncoderRegistry {
    private final List<Entry<?>> encoders = new ArrayList();

    public <Z> void append(Class<Z> clazz, ResourceEncoder<Z> resourceEncoder) {
        synchronized (this) {
            List<Entry<?>> list = this.encoders;
            Entry entry = new Entry(clazz, resourceEncoder);
            list.add(entry);
            return;
        }
    }

    public <Z> ResourceEncoder<Z> get(Class<Z> resourceEncoder) {
        synchronized (this) {
            int n = 0;
            try {
                int n2 = this.encoders.size();
                while (n < n2) {
                    Entry<?> entry = this.encoders.get(n);
                    if (entry.handles(resourceEncoder)) {
                        resourceEncoder = entry.encoder;
                        return resourceEncoder;
                    }
                    ++n;
                }
                return null;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public <Z> void prepend(Class<Z> clazz, ResourceEncoder<Z> resourceEncoder) {
        synchronized (this) {
            List<Entry<?>> list = this.encoders;
            Entry entry = new Entry(clazz, resourceEncoder);
            list.add(0, entry);
            return;
        }
    }
}
