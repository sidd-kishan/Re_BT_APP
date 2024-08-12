/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.operators.single.SingleAmb$AmbSingleObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.single.SingleAmb;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SingleAmb<T>
extends Single<T> {
    private final SingleSource<? extends T>[] sources;
    private final Iterable<? extends SingleSource<? extends T>> sourcesIterable;

    public SingleAmb(SingleSource<? extends T>[] singleSourceArray, Iterable<? extends SingleSource<? extends T>> iterable) {
        this.sources = singleSourceArray;
        this.sourcesIterable = iterable;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        SingleSource<? extends T> singleSource;
        int n;
        int n2;
        Iterator<? extends SingleSource<? extends T>> iterator;
        Object object;
        Object object2;
        block12: {
            object2 = this.sources;
            if (object2 == null) {
                object = new SingleSource[8];
                try {
                    iterator = this.sourcesIterable.iterator();
                    n2 = 0;
                    while (true) {
                        object2 = object;
                        n = ++n2;
                        if (iterator.hasNext()) {
                            singleSource = iterator.next();
                            if (singleSource == null) {
                                object = new NullPointerException("One of the sources is null");
                                EmptyDisposable.error((Throwable)object, singleObserver);
                                return;
                            }
                            object2 = object;
                            if (n2 == ((SingleSource[])object).length) {
                                object2 = new SingleSource[(n2 >> 2) + n2];
                                System.arraycopy(object, 0, object2, 0, n2);
                            }
                            object2[n2] = singleSource;
                            object = object2;
                            continue;
                        }
                        break block12;
                        break;
                    }
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    EmptyDisposable.error((Throwable)throwable, singleObserver);
                    return;
                }
            }
            n = ((SingleSource<? extends T>[])object2).length;
        }
        object = new AtomicBoolean();
        singleSource = new SingleSource<T>();
        singleObserver.onSubscribe((Disposable)singleSource);
        n2 = 0;
        while (n2 < n) {
            iterator = object2[n2];
            if (singleSource.isDisposed()) {
                return;
            }
            if (iterator == null) {
                singleSource.dispose();
                object2 = new NullPointerException("One of the sources is null");
                if (((AtomicBoolean)object).compareAndSet(false, true)) {
                    singleObserver.onError(object2);
                } else {
                    RxJavaPlugins.onError(object2);
                }
                return;
            }
            iterator.subscribe((SingleObserver)new AmbSingleObserver(singleObserver, singleSource, (AtomicBoolean)object));
            ++n2;
        }
    }
}
