/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.SingleSource
 *  io.reactivex.internal.operators.single.SingleToFlowable
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.SingleSource;
import io.reactivex.internal.operators.single.SingleToFlowable;
import java.util.Iterator;

static final class SingleInternalHelper.ToFlowableIterator<T>
implements Iterator<Flowable<T>> {
    private final Iterator<? extends SingleSource<? extends T>> sit;

    SingleInternalHelper.ToFlowableIterator(Iterator<? extends SingleSource<? extends T>> iterator) {
        this.sit = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.sit.hasNext();
    }

    @Override
    public Flowable<T> next() {
        return new SingleToFlowable(this.sit.next());
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
