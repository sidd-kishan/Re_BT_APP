/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.SingleSource
 *  io.reactivex.internal.operators.single.SingleInternalHelper$ToFlowableIterator
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.SingleSource;
import io.reactivex.internal.operators.single.SingleInternalHelper;
import java.util.Iterator;

static final class SingleInternalHelper.ToFlowableIterable<T>
implements Iterable<Flowable<T>> {
    private final Iterable<? extends SingleSource<? extends T>> sources;

    SingleInternalHelper.ToFlowableIterable(Iterable<? extends SingleSource<? extends T>> iterable) {
        this.sources = iterable;
    }

    @Override
    public Iterator<Flowable<T>> iterator() {
        return new SingleInternalHelper.ToFlowableIterator(this.sources.iterator());
    }
}
