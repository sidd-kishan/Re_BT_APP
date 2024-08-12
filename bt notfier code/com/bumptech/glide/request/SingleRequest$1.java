/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.request.SingleRequest
 *  com.bumptech.glide.util.pool.FactoryPools$Factory
 */
package com.bumptech.glide.request;

import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.util.pool.FactoryPools;

class SingleRequest.1
implements FactoryPools.Factory<SingleRequest<?>> {
    SingleRequest.1() {
    }

    public SingleRequest<?> create() {
        return new SingleRequest();
    }
}
