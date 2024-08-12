/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public static interface FileLoader.FileOpener<Data> {
    public void close(Data var1) throws IOException;

    public Class<Data> getDataClass();

    public Data open(File var1) throws FileNotFoundException;
}
