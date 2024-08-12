/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.util.pool.FactoryPools$Resetter
 */
package com.bumptech.glide.util.pool;

import com.bumptech.glide.util.pool.FactoryPools;
import java.util.List;

class FactoryPools.3
implements FactoryPools.Resetter<List<T>> {
    FactoryPools.3() {
    }

    public void reset(List<T> list) {
        list.clear();
    }
}
