/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.EncodeStrategy
 *  com.bumptech.glide.load.Encoder
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.engine.Resource
 */
package com.bumptech.glide.load;

import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;

public interface ResourceEncoder<T>
extends Encoder<Resource<T>> {
    public EncodeStrategy getEncodeStrategy(Options var1);
}
