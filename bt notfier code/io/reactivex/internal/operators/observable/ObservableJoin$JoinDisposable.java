/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.ObservableGroupJoin$JoinSupport
 *  io.reactivex.internal.operators.observable.ObservableGroupJoin$LeftRightEndObserver
 *  io.reactivex.internal.operators.observable.ObservableGroupJoin$LeftRightObserver
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableJoin.JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R>
extends AtomicInteger
implements Disposable,
ObservableGroupJoin.JoinSupport {
    static final Integer LEFT_CLOSE;
    static final Integer LEFT_VALUE;
    static final Integer RIGHT_CLOSE;
    static final Integer RIGHT_VALUE;
    private static final long serialVersionUID = -6071216598687999801L;
    final AtomicInteger active;
    volatile boolean cancelled;
    final CompositeDisposable disposables;
    final Observer<? super R> downstream;
    final AtomicReference<Throwable> error;
    final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> leftEnd;
    int leftIndex;
    final Map<Integer, TLeft> lefts;
    final SpscLinkedArrayQueue<Object> queue;
    final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
    final Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd;
    int rightIndex;
    final Map<Integer, TRight> rights;

    static {
        LEFT_VALUE = 1;
        RIGHT_VALUE = 2;
        LEFT_CLOSE = 3;
        RIGHT_CLOSE = 4;
    }

    ObservableJoin.JoinDisposable(Observer<? super R> observer, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        this.downstream = observer;
        this.disposables = new CompositeDisposable();
        this.queue = new SpscLinkedArrayQueue(Observable.bufferSize());
        this.lefts = new LinkedHashMap<Integer, TLeft>();
        this.rights = new LinkedHashMap<Integer, TRight>();
        this.error = new AtomicReference();
        this.leftEnd = function;
        this.rightEnd = function2;
        this.resultSelector = biFunction;
        this.active = new AtomicInteger(2);
    }

    void cancelAll() {
        this.disposables.dispose();
    }

    public void dispose() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.cancelAll();
        if (this.getAndIncrement() != 0) return;
        this.queue.clear();
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
        Observer<? super R> observer = this.downstream;
        int n = 1;
        block8: while (true) {
            Object object;
            if (this.cancelled) {
                spscLinkedArrayQueue.clear();
                return;
            }
            if (this.error.get() != null) {
                spscLinkedArrayQueue.clear();
                this.cancelAll();
                this.errorAll(observer);
                return;
            }
            int n2 = this.active.get() == 0 ? 1 : 0;
            Iterator<TLeft> iterator = (Integer)spscLinkedArrayQueue.poll();
            boolean bl = iterator == null;
            if (n2 != 0 && bl) {
                this.lefts.clear();
                this.rights.clear();
                this.disposables.dispose();
                observer.onComplete();
                return;
            }
            if (bl) {
                n = n2 = this.addAndGet(-n);
                if (n2 != 0) continue;
                return;
            }
            Object object2 = spscLinkedArrayQueue.poll();
            if (iterator == LEFT_VALUE) {
                n2 = this.leftIndex;
                this.leftIndex = n2 + 1;
                this.lefts.put(n2, object2);
                try {
                    object = (ObservableSource)ObjectHelper.requireNonNull((Object)this.leftEnd.apply(object2), (String)"The leftEnd returned a null ObservableSource");
                }
                catch (Throwable throwable) {
                    this.fail(throwable, observer, spscLinkedArrayQueue);
                    return;
                }
                iterator = new ObservableGroupJoin.LeftRightEndObserver((ObservableGroupJoin.JoinSupport)this, true, n2);
                this.disposables.add((Disposable)iterator);
                object.subscribe((Observer)iterator);
                if (this.error.get() != null) {
                    spscLinkedArrayQueue.clear();
                    this.cancelAll();
                    this.errorAll(observer);
                    return;
                }
                iterator = this.rights.values().iterator();
                while (true) {
                    if (!iterator.hasNext()) continue block8;
                    object = iterator.next();
                    try {
                        object = ObjectHelper.requireNonNull((Object)this.resultSelector.apply(object2, object), (String)"The resultSelector returned a null value");
                    }
                    catch (Throwable throwable) {
                        this.fail(throwable, observer, spscLinkedArrayQueue);
                        return;
                    }
                    observer.onNext(object);
                }
            }
            if (iterator == RIGHT_VALUE) {
                n2 = this.rightIndex;
                this.rightIndex = n2 + 1;
                this.rights.put(n2, object2);
                try {
                    object = (ObservableSource)ObjectHelper.requireNonNull((Object)this.rightEnd.apply(object2), (String)"The rightEnd returned a null ObservableSource");
                }
                catch (Throwable throwable) {
                    this.fail(throwable, observer, spscLinkedArrayQueue);
                    return;
                }
                iterator = new ObservableGroupJoin.LeftRightEndObserver((ObservableGroupJoin.JoinSupport)this, false, n2);
                this.disposables.add((Disposable)iterator);
                object.subscribe((Observer)iterator);
                if (this.error.get() != null) {
                    spscLinkedArrayQueue.clear();
                    this.cancelAll();
                    this.errorAll(observer);
                    return;
                }
                iterator = this.lefts.values().iterator();
                while (true) {
                    if (!iterator.hasNext()) continue block8;
                    object = iterator.next();
                    try {
                        object = ObjectHelper.requireNonNull((Object)this.resultSelector.apply(object, object2), (String)"The resultSelector returned a null value");
                    }
                    catch (Throwable throwable) {
                        this.fail(throwable, observer, spscLinkedArrayQueue);
                        return;
                    }
                    observer.onNext(object);
                }
            }
            if (iterator == LEFT_CLOSE) {
                object2 = (ObservableGroupJoin.LeftRightEndObserver)object2;
                this.lefts.remove(((ObservableGroupJoin.LeftRightEndObserver)object2).index);
                this.disposables.remove((Disposable)object2);
                continue;
            }
            object2 = (ObservableGroupJoin.LeftRightEndObserver)object2;
            this.rights.remove(((ObservableGroupJoin.LeftRightEndObserver)object2).index);
            this.disposables.remove((Disposable)object2);
        }
    }

    void errorAll(Observer<?> observer) {
        Throwable throwable = ExceptionHelper.terminate(this.error);
        this.lefts.clear();
        this.rights.clear();
        observer.onError(throwable);
    }

    void fail(Throwable throwable, Observer<?> observer, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
        Exceptions.throwIfFatal((Throwable)throwable);
        ExceptionHelper.addThrowable(this.error, (Throwable)throwable);
        spscLinkedArrayQueue.clear();
        this.cancelAll();
        this.errorAll(observer);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void innerClose(boolean bl, ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver) {
        synchronized (this) {
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            Integer n = bl ? LEFT_CLOSE : RIGHT_CLOSE;
            spscLinkedArrayQueue.offer((Object)n, (Object)leftRightEndObserver);
        }
        this.drain();
    }

    public void innerCloseError(Throwable throwable) {
        if (ExceptionHelper.addThrowable(this.error, (Throwable)throwable)) {
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void innerComplete(ObservableGroupJoin.LeftRightObserver leftRightObserver) {
        this.disposables.delete((Disposable)leftRightObserver);
        this.active.decrementAndGet();
        this.drain();
    }

    public void innerError(Throwable throwable) {
        if (ExceptionHelper.addThrowable(this.error, (Throwable)throwable)) {
            this.active.decrementAndGet();
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void innerValue(boolean bl, Object object) {
        synchronized (this) {
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            Integer n = bl ? LEFT_VALUE : RIGHT_VALUE;
            spscLinkedArrayQueue.offer((Object)n, object);
        }
        this.drain();
    }

    public boolean isDisposed() {
        return this.cancelled;
    }
}
