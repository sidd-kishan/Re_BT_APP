/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  com.bumptech.glide.load.model.DataUrlLoader$DataDecoder
 *  com.bumptech.glide.load.model.DataUrlLoader$StreamFactory
 */
package com.bumptech.glide.load.model;

import android.util.Base64;
import com.bumptech.glide.load.model.DataUrlLoader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

class DataUrlLoader.StreamFactory.1
implements DataUrlLoader.DataDecoder<InputStream> {
    final DataUrlLoader.StreamFactory this$0;

    DataUrlLoader.StreamFactory.1(DataUrlLoader.StreamFactory streamFactory) {
        this.this$0 = streamFactory;
    }

    public void close(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    public InputStream decode(String string) {
        if (!string.startsWith("data:image")) throw new IllegalArgumentException("Not a valid image data URL.");
        int n = string.indexOf(44);
        if (n == -1) throw new IllegalArgumentException("Missing comma in data URL.");
        if (!string.substring(0, n).endsWith(";base64")) throw new IllegalArgumentException("Not a base64 image data URL.");
        return new ByteArrayInputStream(Base64.decode((String)string.substring(n + 1), (int)0));
    }

    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }
}
