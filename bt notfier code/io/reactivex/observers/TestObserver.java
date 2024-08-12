/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.MaybeObserver
 *  io.reactivex.Observer
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.fuseable.QueueDisposable
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.observers.BaseTestConsumer
 *  io.reactivex.observers.TestObserver$EmptyObserver
 */
package io.reactivex.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.BaseTestConsumer;
import io.reactivex.observers.TestObserver;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class TestObserver<T>
extends BaseTestConsumer<T, TestObserver<T>>
implements Observer<T>,
Disposable,
MaybeObserver<T>,
SingleObserver<T>,
CompletableObserver {
    private final Observer<? super T> downstream;
    private QueueDisposable<T> qd;
    private final AtomicReference<Disposable> upstream = new AtomicReference();

    public TestObserver() {
        this((Observer<T>)EmptyObserver.INSTANCE);
    }

    public TestObserver(Observer<? super T> observer) {
        this.downstream = observer;
    }

    public static <T> TestObserver<T> create() {
        return new TestObserver<T>();
    }

    public static <T> TestObserver<T> create(Observer<? super T> observer) {
        return new TestObserver<T>(observer);
    }

    static String fusionModeToString(int n) {
        if (n == 0) return "NONE";
        if (n == 1) return "SYNC";
        if (n == 2) return "ASYNC";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown(");
        stringBuilder.append(n);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    final TestObserver<T> assertFuseable() {
        if (this.qd == null) throw new AssertionError((Object)"Upstream is not fuseable.");
        return this;
    }

    final TestObserver<T> assertFusionMode(int n) {
        int n2 = this.establishedFusionMode;
        if (n2 == n) return this;
        if (this.qd == null) throw this.fail("Upstream is not fuseable");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fusion mode different. Expected: ");
        stringBuilder.append(TestObserver.fusionModeToString(n));
        stringBuilder.append(", actual: ");
        stringBuilder.append(TestObserver.fusionModeToString(n2));
        throw new AssertionError((Object)stringBuilder.toString());
    }

    final TestObserver<T> assertNotFuseable() {
        if (this.qd != null) throw new AssertionError((Object)"Upstream is fuseable.");
        return this;
    }

    public final TestObserver<T> assertNotSubscribed() {
        if (this.upstream.get() != null) throw this.fail("Subscribed!");
        if (!this.errors.isEmpty()) throw this.fail("Not subscribed but errors found");
        return this;
    }

    public final TestObserver<T> assertOf(Consumer<? super TestObserver<T>> consumer) {
        try {
            consumer.accept((Object)this);
            return this;
        }
        catch (Throwable throwable) {
            throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
        }
    }

    public final TestObserver<T> assertSubscribed() {
        if (this.upstream.get() == null) throw this.fail("Not subscribed!");
        return this;
    }

    public final void cancel() {
        this.dispose();
    }

    public final void dispose() {
        DisposableHelper.dispose(this.upstream);
    }

    public final boolean hasSubscription() {
        boolean bl = this.upstream.get() != null;
        return bl;
    }

    public final boolean isCancelled() {
        return this.isDisposed();
    }

    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)this.upstream.get());
    }

    public void onComplete() {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.upstream.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.lastThread = Thread.currentThread();
            ++this.completions;
            this.downstream.onComplete();
            return;
        }
        finally {
            this.done.countDown();
        }
    }

    public void onError(Throwable throwable) {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.upstream.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.lastThread = Thread.currentThread();
            if (throwable == null) {
                List list = this.errors;
                NullPointerException nullPointerException = new NullPointerException("onError received a null Throwable");
                list.add(nullPointerException);
            } else {
                this.errors.add(throwable);
            }
            this.downstream.onError(throwable);
            return;
        }
        finally {
            this.done.countDown();
        }
    }

    public void onNext(T object) {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.upstream.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.lastThread = Thread.currentThread();
        if (this.establishedFusionMode == 2) {
            try {
                while ((object = this.qd.poll()) != null) {
                    this.values.add(object);
                }
                return;
            }
            catch (Throwable throwable) {
                this.errors.add(throwable);
                this.qd.dispose();
            }
            return;
        }
        this.values.add(object);
        if (object == null) {
            this.errors.add(new NullPointerException("onNext received a null value"));
        }
        this.downstream.onNext(object);
    }

    public void onSubscribe(Disposable object) {
        this.lastThread = Thread.currentThread();
        if (object == null) {
            this.errors.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        if (!this.upstream.compareAndSet((Disposable)null, (Disposable)object)) {
            object.dispose();
            if (this.upstream.get() == DisposableHelper.DISPOSED) return;
            List list = this.errors;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onSubscribe received multiple subscriptions: ");
            stringBuilder.append(object);
            list.add(new IllegalStateException(stringBuilder.toString()));
            return;
        }
        if (this.initialFusionMode != 0 && object instanceof QueueDisposable) {
            int n;
            QueueDisposable queueDisposable;
            this.qd = queueDisposable = (QueueDisposable)object;
            this.establishedFusionMode = n = queueDisposable.requestFusion(this.initialFusionMode);
            if (n == 1) {
                this.checkSubscriptionOnce = true;
                this.lastThread = Thread.currentThread();
                try {
                    while ((object = this.qd.poll()) != null) {
                        this.values.add(object);
                    }
                    ++this.completions;
                    this.upstream.lazySet((Disposable)DisposableHelper.DISPOSED);
                }
                catch (Throwable throwable) {
                    this.errors.add(throwable);
                }
                return;
            }
        }
        this.downstream.onSubscribe(object);
    }

    public void onSuccess(T t) {
        this.onNext(t);
        this.onComplete();
    }

    final TestObserver<T> setInitialFusionMode(int n) {
        this.initialFusionMode = n;
        return this;
    }
}
