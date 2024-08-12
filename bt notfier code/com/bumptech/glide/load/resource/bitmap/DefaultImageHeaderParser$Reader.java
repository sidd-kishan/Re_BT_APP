/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load.resource.bitmap;

import java.io.IOException;

private static interface DefaultImageHeaderParser.Reader {
    public int getByte() throws IOException;

    public int getUInt16() throws IOException;

    public short getUInt8() throws IOException;

    public int read(byte[] var1, int var2) throws IOException;

    public long skip(long var1) throws IOException;
}
