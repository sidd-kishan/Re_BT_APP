/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.internal.operators.observable.BlockingObservableNext$NextObserver
 *  io.reactivex.internal.operators.observable.ObservableMaterialize
 *  io.reactivex.internal.util.ExceptionHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.internal.operators.observable.BlockingObservableNext;
import io.reactivex.internal.operators.observable.ObservableMaterialize;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;

static final class BlockingObservableNext.NextIterator<T>
implements Iterator<T> {
    private Throwable error;
    private boolean hasNext = true;
    private boolean isNextConsumed = true;
    private final ObservableSource<T> items;
    private T next;
    private final BlockingObservableNext.NextObserver<T> observer;
    private boolean started;

    BlockingObservableNext.NextIterator(ObservableSource<T> observableSource, BlockingObservableNext.NextObserver<T> nextObserver) {
        this.items = observableSource;
        this.observer = nextObserver;
    }

    private boolean moveToNext() {
        Object object;
        if (!this.started) {
            this.started = true;
            this.observer.setWaiting();
            new ObservableMaterialize(this.items).subscribe(this.observer);
        }
        try {
            object = this.observer.takeNext();
        }
        catch (InterruptedException interruptedException) {
            this.observer.dispose();
            this.error = interruptedException;
            throw ExceptionHelper.wrapOrThrow((Throwable)interruptedException);
        }
        if (object.isOnNext()) {
            this.isNextConsumed = false;
            this.next = object.getValue();
            return true;
        }
        this.hasNext = false;
        if (object.isOnComplete()) {
            return false;
        }
        object = object.getError();
        this.error = object;
        throw ExceptionHelper.wrapOrThrow((Throwable)object);
    }

    @Override
    public boolean hasNext() {
        Throwable throwable = this.error;
        if (throwable != null) throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
        boolean bl = this.hasNext;
        boolean bl2 = false;
        if (!bl) {
            return false;
        }
        if (this.isNextConsumed) {
            if (!this.moveToNext()) return bl2;
        }
        bl2 = true;
        return bl2;
    }

    @Override
    public T next() {
        Throwable throwable = this.error;
        if (throwable != null) throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
        if (!this.hasNext()) throw new NoSuchElementException("No more elements");
        this.isNextConsumed = true;
        return this.next;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Read only iterator");
    }
}
