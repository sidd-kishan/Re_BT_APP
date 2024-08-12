/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.operators.maybe.MaybeAmb$AmbMaybeObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.maybe.MaybeAmb;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public final class MaybeAmb<T>
extends Maybe<T> {
    private final MaybeSource<? extends T>[] sources;
    private final Iterable<? extends MaybeSource<? extends T>> sourcesIterable;

    public MaybeAmb(MaybeSource<? extends T>[] maybeSourceArray, Iterable<? extends MaybeSource<? extends T>> iterable) {
        this.sources = maybeSourceArray;
        this.sourcesIterable = iterable;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        MaybeSource<? extends T> maybeSource;
        int n;
        int n2;
        Iterator<? extends MaybeSource<? extends T>> iterator;
        Object object;
        Object object2;
        block13: {
            object2 = this.sources;
            if (object2 == null) {
                object = new MaybeSource[8];
                try {
                    iterator = this.sourcesIterable.iterator();
                    n2 = 0;
                    while (true) {
                        object2 = object;
                        n = ++n2;
                        if (iterator.hasNext()) {
                            maybeSource = iterator.next();
                            if (maybeSource == null) {
                                object = new NullPointerException("One of the sources is null");
                                EmptyDisposable.error((Throwable)object, maybeObserver);
                                return;
                            }
                            object2 = object;
                            if (n2 == ((MaybeSource[])object).length) {
                                object2 = new MaybeSource[(n2 >> 2) + n2];
                                System.arraycopy(object, 0, object2, 0, n2);
                            }
                            object2[n2] = maybeSource;
                            object = object2;
                            continue;
                        }
                        break block13;
                        break;
                    }
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    EmptyDisposable.error((Throwable)throwable, maybeObserver);
                    return;
                }
            }
            n = ((MaybeSource<? extends T>[])object2).length;
        }
        maybeSource = new MaybeSource<T>();
        maybeObserver.onSubscribe((Disposable)maybeSource);
        object = new AtomicBoolean();
        n2 = 0;
        while (true) {
            if (n2 >= n) {
                if (n != 0) return;
                maybeObserver.onComplete();
                return;
            }
            iterator = object2[n2];
            if (maybeSource.isDisposed()) {
                return;
            }
            if (iterator == null) {
                maybeSource.dispose();
                object2 = new NullPointerException("One of the MaybeSources is null");
                if (((AtomicBoolean)object).compareAndSet(false, true)) {
                    maybeObserver.onError(object2);
                } else {
                    RxJavaPlugins.onError(object2);
                }
                return;
            }
            iterator.subscribe((MaybeObserver)new AmbMaybeObserver(maybeObserver, maybeSource, (AtomicBoolean)object));
            ++n2;
        }
    }
}
