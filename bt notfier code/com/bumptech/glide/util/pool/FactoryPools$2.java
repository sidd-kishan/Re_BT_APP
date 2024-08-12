/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.util.pool.FactoryPools$Factory
 */
package com.bumptech.glide.util.pool;

import com.bumptech.glide.util.pool.FactoryPools;
import java.util.ArrayList;
import java.util.List;

class FactoryPools.2
implements FactoryPools.Factory<List<T>> {
    FactoryPools.2() {
    }

    public List<T> create() {
        return new ArrayList();
    }
}
