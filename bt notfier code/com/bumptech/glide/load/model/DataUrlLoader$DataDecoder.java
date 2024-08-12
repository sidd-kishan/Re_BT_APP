/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load.model;

import java.io.IOException;

public static interface DataUrlLoader.DataDecoder<Data> {
    public void close(Data var1) throws IOException;

    public Data decode(String var1) throws IllegalArgumentException;

    public Class<Data> getDataClass();
}
