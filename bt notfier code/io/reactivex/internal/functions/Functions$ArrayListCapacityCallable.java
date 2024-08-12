/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.internal.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

static final class Functions.ArrayListCapacityCallable<T>
implements Callable<List<T>> {
    final int capacity;

    Functions.ArrayListCapacityCallable(int n) {
        this.capacity = n;
    }

    @Override
    public List<T> call() throws Exception {
        return new ArrayList(this.capacity);
    }
}
