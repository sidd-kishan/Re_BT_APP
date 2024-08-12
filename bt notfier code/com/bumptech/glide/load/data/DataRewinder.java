/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load.data;

import java.io.IOException;

public interface DataRewinder<T> {
    public void cleanup();

    public T rewindAndGet() throws IOException;
}
