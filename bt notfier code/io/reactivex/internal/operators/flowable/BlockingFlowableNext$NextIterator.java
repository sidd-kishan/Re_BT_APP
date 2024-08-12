/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.internal.operators.flowable.BlockingFlowableNext$NextSubscriber
 *  io.reactivex.internal.util.ExceptionHelper
 *  org.reactivestreams.Publisher
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.operators.flowable.BlockingFlowableNext;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;

static final class BlockingFlowableNext.NextIterator<T>
implements Iterator<T> {
    private Throwable error;
    private boolean hasNext = true;
    private boolean isNextConsumed = true;
    private final Publisher<? extends T> items;
    private T next;
    private boolean started;
    private final BlockingFlowableNext.NextSubscriber<T> subscriber;

    BlockingFlowableNext.NextIterator(Publisher<? extends T> publisher, BlockingFlowableNext.NextSubscriber<T> nextSubscriber) {
        this.items = publisher;
        this.subscriber = nextSubscriber;
    }

    private boolean moveToNext() {
        try {
            Object object;
            if (!this.started) {
                this.started = true;
                this.subscriber.setWaiting();
                Flowable.fromPublisher(this.items).materialize().subscribe(this.subscriber);
            }
            if ((object = this.subscriber.takeNext()).isOnNext()) {
                this.isNextConsumed = false;
                this.next = object.getValue();
                return true;
            }
            this.hasNext = false;
            if (object.isOnComplete()) {
                return false;
            }
            if (object.isOnError()) {
                object = object.getError();
                this.error = object;
                throw ExceptionHelper.wrapOrThrow((Throwable)object);
            }
            object = new IllegalStateException("Should not reach here");
            throw object;
        }
        catch (InterruptedException interruptedException) {
            this.subscriber.dispose();
            this.error = interruptedException;
            throw ExceptionHelper.wrapOrThrow((Throwable)interruptedException);
        }
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
