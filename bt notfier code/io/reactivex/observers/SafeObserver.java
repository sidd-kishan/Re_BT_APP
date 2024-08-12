/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class SafeObserver<T>
implements Observer<T>,
Disposable {
    boolean done;
    final Observer<? super T> downstream;
    Disposable upstream;

    public SafeObserver(Observer<? super T> observer) {
        this.downstream = observer;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        if (this.upstream == null) {
            this.onCompleteNoSubscription();
            return;
        }
        try {
            this.downstream.onComplete();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    void onCompleteNoSubscription() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.downstream.onSubscribe((Disposable)EmptyDisposable.INSTANCE);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{nullPointerException, throwable}));
            return;
        }
        try {
            this.downstream.onError((Throwable)nullPointerException);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{nullPointerException, throwable}));
        }
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        if (this.upstream == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.downstream.onSubscribe((Disposable)EmptyDisposable.INSTANCE);
            }
            catch (Throwable throwable2) {
                Exceptions.throwIfFatal((Throwable)throwable2);
                RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{throwable, nullPointerException, throwable2}));
                return;
            }
            try {
                Observer<? super T> observer = this.downstream;
                CompositeException compositeException = new CompositeException(new Throwable[]{throwable, nullPointerException});
                observer.onError((Throwable)compositeException);
            }
            catch (Throwable throwable3) {
                Exceptions.throwIfFatal((Throwable)throwable3);
                RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{throwable, nullPointerException, throwable3}));
            }
            return;
        }
        Throwable throwable4 = throwable;
        if (throwable == null) {
            throwable4 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        try {
            this.downstream.onError(throwable4);
        }
        catch (Throwable throwable5) {
            Exceptions.throwIfFatal((Throwable)throwable5);
            RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{throwable4, throwable5}));
        }
    }

    public void onNext(T object) {
        if (this.done) {
            return;
        }
        if (this.upstream == null) {
            this.onNextNoSubscription();
            return;
        }
        if (object == null) {
            object = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.upstream.dispose();
                this.onError((Throwable)object);
                return;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.onError((Throwable)new CompositeException(new Throwable[]{object, throwable}));
                return;
            }
        }
        try {
            this.downstream.onNext(object);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            try {
                this.upstream.dispose();
                this.onError(throwable);
            }
            catch (Throwable throwable2) {
                Exceptions.throwIfFatal((Throwable)throwable2);
                this.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
                return;
            }
        }
    }

    void onNextNoSubscription() {
        this.done = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.downstream.onSubscribe((Disposable)EmptyDisposable.INSTANCE);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{nullPointerException, throwable}));
            return;
        }
        try {
            this.downstream.onError((Throwable)nullPointerException);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{nullPointerException, throwable}));
        }
    }

    public void onSubscribe(Disposable disposable) {
        block4: {
            if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
            this.upstream = disposable;
            try {
                this.downstream.onSubscribe((Disposable)this);
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.done = true;
                try {
                    disposable.dispose();
                }
                catch (Throwable throwable2) {
                    Exceptions.throwIfFatal((Throwable)throwable2);
                    RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
                    break block4;
                }
                RxJavaPlugins.onError((Throwable)throwable);
            }
        }
    }
}
