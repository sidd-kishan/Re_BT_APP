/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load.model;

public static interface ByteArrayLoader.Converter<Data> {
    public Data convert(byte[] var1);

    public Class<Data> getDataClass();
}
