/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.observers.BasicIntQueueDisposable
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;

static final class SingleFlatMapIterableObservable.FlatMapIterableObserver<T, R>
extends BasicIntQueueDisposable<R>
implements SingleObserver<T> {
    private static final long serialVersionUID = -8938804753851907758L;
    volatile boolean cancelled;
    final Observer<? super R> downstream;
    volatile Iterator<? extends R> it;
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    boolean outputFused;
    Disposable upstream;

    SingleFlatMapIterableObservable.FlatMapIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.downstream = observer;
        this.mapper = function;
    }

    public void clear() {
        this.it = null;
    }

    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public boolean isEmpty() {
        boolean bl = this.it == null;
        return bl;
    }

    public void onError(Throwable throwable) {
        this.upstream = DisposableHelper.DISPOSED;
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public void onSuccess(T t) {
        boolean bl;
        Iterator iterator;
        Observer<? super R> observer;
        block10: {
            observer = this.downstream;
            try {
                iterator = ((Iterable)this.mapper.apply(t)).iterator();
                bl = iterator.hasNext();
                if (bl) break block10;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.downstream.onError(throwable);
                return;
            }
            observer.onComplete();
            return;
        }
        if (this.outputFused) {
            this.it = iterator;
            observer.onNext(null);
            observer.onComplete();
            return;
        }
        while (true) {
            if (this.cancelled) {
                return;
            }
            t = iterator.next();
            observer.onNext(t);
            if (this.cancelled) {
                return;
            }
            if (bl = iterator.hasNext()) continue;
            break;
        }
        observer.onComplete();
        return;
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            observer.onError(throwable);
            return;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            observer.onError(throwable);
            return;
        }
    }

    public R poll() throws Exception {
        Iterator<R> iterator = this.it;
        if (iterator == null) return null;
        Object object = ObjectHelper.requireNonNull(iterator.next(), (String)"The iterator returned a null value");
        if (iterator.hasNext()) return (R)object;
        this.it = null;
        return (R)object;
    }

    public int requestFusion(int n) {
        if ((n & 2) == 0) return 0;
        this.outputFused = true;
        return 2;
    }
}
