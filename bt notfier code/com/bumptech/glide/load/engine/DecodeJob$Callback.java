/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.engine.DecodeJob
 *  com.bumptech.glide.load.engine.GlideException
 *  com.bumptech.glide.load.engine.Resource
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;

static interface DecodeJob.Callback<R> {
    public void onLoadFailed(GlideException var1);

    public void onResourceReady(Resource<R> var1, DataSource var2);

    public void reschedule(DecodeJob<?> var1);
}
