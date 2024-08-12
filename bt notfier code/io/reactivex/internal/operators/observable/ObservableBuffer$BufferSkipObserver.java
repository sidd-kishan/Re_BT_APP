/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

static final class ObservableBuffer.BufferSkipObserver<T, U extends Collection<? super T>>
extends AtomicBoolean
implements Observer<T>,
Disposable {
    private static final long serialVersionUID = -8223395059921494546L;
    final Callable<U> bufferSupplier;
    final ArrayDeque<U> buffers;
    final int count;
    final Observer<? super U> downstream;
    long index;
    final int skip;
    Disposable upstream;

    ObservableBuffer.BufferSkipObserver(Observer<? super U> observer, int n, int n2, Callable<U> callable) {
        this.downstream = observer;
        this.count = n;
        this.skip = n2;
        this.bufferSupplier = callable;
        this.buffers = new ArrayDeque();
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        while (true) {
            if (this.buffers.isEmpty()) {
                this.downstream.onComplete();
                return;
            }
            this.downstream.onNext(this.buffers.poll());
        }
    }

    public void onError(Throwable throwable) {
        this.buffers.clear();
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        Object object;
        long l = this.index;
        this.index = 1L + l;
        if (l % (long)this.skip == 0L) {
            try {
                object = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
                this.buffers.offer(object);
            }
            catch (Throwable throwable) {
                this.buffers.clear();
                this.upstream.dispose();
                this.downstream.onError(throwable);
                return;
            }
        }
        object = this.buffers.iterator();
        while (object.hasNext()) {
            Collection collection = (Collection)object.next();
            collection.add(t);
            if (this.count > collection.size()) continue;
            object.remove();
            this.downstream.onNext((Object)collection);
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
