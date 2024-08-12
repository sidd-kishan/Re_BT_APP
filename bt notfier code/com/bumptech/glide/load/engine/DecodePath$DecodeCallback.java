/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.Resource
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.Resource;

static interface DecodePath.DecodeCallback<ResourceType> {
    public Resource<ResourceType> onResourceDecoded(Resource<ResourceType> var1);
}
