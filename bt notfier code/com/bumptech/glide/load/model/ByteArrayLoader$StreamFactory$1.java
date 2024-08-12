/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.model.ByteArrayLoader$Converter
 *  com.bumptech.glide.load.model.ByteArrayLoader$StreamFactory
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.ByteArrayLoader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class ByteArrayLoader.StreamFactory.1
implements ByteArrayLoader.Converter<InputStream> {
    final ByteArrayLoader.StreamFactory this$0;

    ByteArrayLoader.StreamFactory.1(ByteArrayLoader.StreamFactory streamFactory) {
        this.this$0 = streamFactory;
    }

    public InputStream convert(byte[] byArray) {
        return new ByteArrayInputStream(byArray);
    }

    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }
}
