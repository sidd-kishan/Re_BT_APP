/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.model.FileLoader$FileOpener
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.FileLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class FileLoader.StreamFactory.1
implements FileLoader.FileOpener<InputStream> {
    FileLoader.StreamFactory.1() {
    }

    public void close(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    public InputStream open(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }
}
