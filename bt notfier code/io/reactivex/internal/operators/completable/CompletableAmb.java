/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.operators.completable.CompletableAmb$Amb
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.completable.CompletableAmb;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CompletableAmb
extends Completable {
    private final CompletableSource[] sources;
    private final Iterable<? extends CompletableSource> sourcesIterable;

    public CompletableAmb(CompletableSource[] completableSourceArray, Iterable<? extends CompletableSource> iterable) {
        this.sources = completableSourceArray;
        this.sourcesIterable = iterable;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        CompletableSource completableSource;
        int n;
        int n2;
        Object object;
        Object object2;
        Object object3;
        block13: {
            object3 = this.sources;
            if (object3 == null) {
                object2 = new CompletableSource[8];
                try {
                    object = this.sourcesIterable.iterator();
                    n2 = 0;
                    while (true) {
                        object3 = object2;
                        n = ++n2;
                        if (object.hasNext()) {
                            completableSource = (CompletableSource)object.next();
                            if (completableSource == null) {
                                object2 = new NullPointerException("One of the sources is null");
                                EmptyDisposable.error((Throwable)object2, (CompletableObserver)completableObserver);
                                return;
                            }
                            object3 = object2;
                            if (n2 == ((CompletableSource[])object2).length) {
                                object3 = new CompletableSource[(n2 >> 2) + n2];
                                System.arraycopy(object2, 0, object3, 0, n2);
                            }
                            object3[n2] = completableSource;
                            object2 = object3;
                            continue;
                        }
                        break block13;
                        break;
                    }
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    EmptyDisposable.error((Throwable)throwable, (CompletableObserver)completableObserver);
                    return;
                }
            }
            n = ((CompletableSource[])object3).length;
        }
        object = new CompositeDisposable();
        completableObserver.onSubscribe((Disposable)object);
        object2 = new AtomicBoolean();
        n2 = 0;
        while (true) {
            if (n2 >= n) {
                if (n != 0) return;
                completableObserver.onComplete();
                return;
            }
            completableSource = object3[n2];
            if (object.isDisposed()) {
                return;
            }
            if (completableSource == null) {
                object3 = new NullPointerException("One of the sources is null");
                if (((AtomicBoolean)object2).compareAndSet(false, true)) {
                    object.dispose();
                    completableObserver.onError((Throwable)object3);
                } else {
                    RxJavaPlugins.onError((Throwable)object3);
                }
                return;
            }
            completableSource.subscribe((CompletableObserver)new Amb((AtomicBoolean)object2, (CompositeDisposable)object, completableObserver));
            ++n2;
        }
    }
}
