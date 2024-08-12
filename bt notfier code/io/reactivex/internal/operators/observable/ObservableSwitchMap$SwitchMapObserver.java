/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.operators.observable.ObservableSwitchMap$SwitchMapInnerObserver
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableSwitchMap.SwitchMapObserver<T, R>
extends AtomicInteger
implements Observer<T>,
Disposable {
    static final ObservableSwitchMap.SwitchMapInnerObserver<Object, Object> CANCELLED;
    private static final long serialVersionUID = -3491074160481096299L;
    final AtomicReference<ObservableSwitchMap.SwitchMapInnerObserver<T, R>> active = new AtomicReference();
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final Observer<? super R> downstream;
    final AtomicThrowable errors;
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    volatile long unique;
    Disposable upstream;

    static {
        ObservableSwitchMap.SwitchMapInnerObserver switchMapInnerObserver;
        CANCELLED = switchMapInnerObserver = new ObservableSwitchMap.SwitchMapInnerObserver(null, -1L, 1);
        switchMapInnerObserver.cancel();
    }

    ObservableSwitchMap.SwitchMapObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int n, boolean bl) {
        this.downstream = observer;
        this.mapper = function;
        this.bufferSize = n;
        this.delayErrors = bl;
        this.errors = new AtomicThrowable();
    }

    public void dispose() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.upstream.dispose();
        this.disposeInner();
    }

    void disposeInner() {
        ObservableSwitchMap.SwitchMapInnerObserver<Object, Object> switchMapInnerObserver;
        ObservableSwitchMap.SwitchMapInnerObserver<T, R> switchMapInnerObserver2 = this.active.get();
        if (switchMapInnerObserver2 == (switchMapInnerObserver = CANCELLED)) return;
        if ((switchMapInnerObserver = this.active.getAndSet(switchMapInnerObserver)) == CANCELLED) return;
        if (switchMapInnerObserver == null) return;
        switchMapInnerObserver.cancel();
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        Observer<? super R> observer = this.downstream;
        AtomicReference<ObservableSwitchMap.SwitchMapInnerObserver<T, R>> atomicReference = this.active;
        boolean bl = this.delayErrors;
        int n = 1;
        block2: while (true) {
            int n2;
            block28: {
                boolean bl2;
                SimpleQueue simpleQueue;
                ObservableSwitchMap.SwitchMapInnerObserver<T, R> switchMapInnerObserver;
                Object object;
                if (this.cancelled) {
                    return;
                }
                if (this.done) {
                    n2 = atomicReference.get() == null ? 1 : 0;
                    if (bl) {
                        if (n2 != 0) {
                            object = (Throwable)this.errors.get();
                            if (object != null) {
                                observer.onError((Throwable)object);
                            } else {
                                observer.onComplete();
                            }
                            return;
                        }
                    } else {
                        if ((Throwable)this.errors.get() != null) {
                            observer.onError(this.errors.terminate());
                            return;
                        }
                        if (n2 != 0) {
                            observer.onComplete();
                            return;
                        }
                    }
                }
                if ((switchMapInnerObserver = atomicReference.get()) == null || (simpleQueue = switchMapInnerObserver.queue) == null) break block28;
                if (switchMapInnerObserver.done) {
                    bl2 = simpleQueue.isEmpty();
                    if (bl) {
                        if (bl2) {
                            atomicReference.compareAndSet(switchMapInnerObserver, null);
                            continue;
                        }
                    } else {
                        if ((Throwable)this.errors.get() != null) {
                            observer.onError(this.errors.terminate());
                            return;
                        }
                        if (bl2) {
                            atomicReference.compareAndSet(switchMapInnerObserver, null);
                            continue;
                        }
                    }
                }
                n2 = 0;
                while (true) {
                    block32: {
                        block31: {
                            boolean bl3;
                            block30: {
                                block29: {
                                    if (this.cancelled) {
                                        return;
                                    }
                                    if (switchMapInnerObserver != atomicReference.get()) break block29;
                                    if (!bl && (Throwable)this.errors.get() != null) {
                                        observer.onError(this.errors.terminate());
                                        return;
                                    }
                                    bl2 = switchMapInnerObserver.done;
                                    try {
                                        object = simpleQueue.poll();
                                    }
                                    catch (Throwable throwable) {
                                        Exceptions.throwIfFatal((Throwable)throwable);
                                        this.errors.addThrowable(throwable);
                                        atomicReference.compareAndSet(switchMapInnerObserver, null);
                                        if (!bl) {
                                            this.disposeInner();
                                            this.upstream.dispose();
                                            this.done = true;
                                        } else {
                                            switchMapInnerObserver.cancel();
                                        }
                                        object = null;
                                        n2 = 1;
                                    }
                                    bl3 = object == null;
                                    if (!bl2 || !bl3) break block30;
                                    atomicReference.compareAndSet(switchMapInnerObserver, null);
                                }
                                n2 = 1;
                                break block31;
                            }
                            if (!bl3) break block32;
                        }
                        if (n2 == 0) break;
                        continue block2;
                    }
                    observer.onNext(object);
                }
            }
            n = n2 = this.addAndGet(-n);
            if (n2 == 0) return;
        }
    }

    void innerError(ObservableSwitchMap.SwitchMapInnerObserver<T, R> switchMapInnerObserver, Throwable throwable) {
        if (switchMapInnerObserver.index == this.unique && this.errors.addThrowable(throwable)) {
            if (!this.delayErrors) {
                this.upstream.dispose();
            }
            switchMapInnerObserver.done = true;
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        if (this.done) return;
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        if (!this.done && this.errors.addThrowable(throwable)) {
            if (!this.delayErrors) {
                this.disposeInner();
            }
            this.done = true;
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T object) {
        long l;
        this.unique = l = this.unique + 1L;
        ObservableSource observableSource = this.active.get();
        if (observableSource != null) {
            observableSource.cancel();
        }
        try {
            observableSource = (ObservableSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The ObservableSource returned is null");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.upstream.dispose();
            this.onError(throwable);
            return;
        }
        ObservableSwitchMap.SwitchMapInnerObserver switchMapInnerObserver = new ObservableSwitchMap.SwitchMapInnerObserver(this, l, this.bufferSize);
        while ((object = this.active.get()) != CANCELLED) {
            if (!this.active.compareAndSet((ObservableSwitchMap.SwitchMapInnerObserver<T, R>)object, (ObservableSwitchMap.SwitchMapInnerObserver<T, R>)switchMapInnerObserver)) continue;
            observableSource.subscribe((Observer)switchMapInnerObserver);
            break;
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
