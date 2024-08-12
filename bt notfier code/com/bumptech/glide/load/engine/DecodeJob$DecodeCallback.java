/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.engine.DecodeJob
 *  com.bumptech.glide.load.engine.DecodePath$DecodeCallback
 *  com.bumptech.glide.load.engine.Resource
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.Resource;

private final class DecodeJob.DecodeCallback<Z>
implements DecodePath.DecodeCallback<Z> {
    private final DataSource dataSource;
    final DecodeJob this$0;

    DecodeJob.DecodeCallback(DecodeJob decodeJob, DataSource dataSource) {
        this.this$0 = decodeJob;
        this.dataSource = dataSource;
    }

    public Resource<Z> onResourceDecoded(Resource<Z> resource) {
        return this.this$0.onResourceDecoded(this.dataSource, resource);
    }
}
