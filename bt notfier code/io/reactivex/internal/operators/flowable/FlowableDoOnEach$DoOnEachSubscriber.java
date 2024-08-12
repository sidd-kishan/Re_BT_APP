/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.subscribers.BasicFuseableSubscriber
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

static final class FlowableDoOnEach.DoOnEachSubscriber<T>
extends BasicFuseableSubscriber<T, T> {
    final Action onAfterTerminate;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onNext;

    FlowableDoOnEach.DoOnEachSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        super(subscriber);
        this.onNext = consumer;
        this.onError = consumer2;
        this.onComplete = action;
        this.onAfterTerminate = action2;
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        try {
            this.onComplete.run();
            this.done = true;
        }
        catch (Throwable throwable) {
            this.fail(throwable);
            return;
        }
        this.downstream.onComplete();
        try {
            this.onAfterTerminate.run();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        boolean bl = true;
        this.done = true;
        try {
            this.onError.accept((Object)throwable);
        }
        catch (Throwable throwable2) {
            Exceptions.throwIfFatal((Throwable)throwable2);
            this.downstream.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
            bl = false;
        }
        if (bl) {
            this.downstream.onError(throwable);
        }
        try {
            this.onAfterTerminate.run();
        }
        catch (Throwable throwable3) {
            Exceptions.throwIfFatal((Throwable)throwable3);
            RxJavaPlugins.onError((Throwable)throwable3);
        }
    }

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.sourceMode != 0) {
            this.downstream.onNext(null);
            return;
        }
        try {
            this.onNext.accept(t);
        }
        catch (Throwable throwable) {
            this.fail(throwable);
            return;
        }
        this.downstream.onNext(t);
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public T poll() throws Exception {
        Object object;
        block11: {
            object = this.qs.poll();
            if (object == null) break block11;
            try {
                this.onNext.accept(object);
            }
            catch (Throwable throwable) {
                try {
                    Exceptions.throwIfFatal((Throwable)throwable);
                }
                catch (Throwable throwable2) {
                    this.onAfterTerminate.run();
                    throw throwable2;
                }
                this.onError.accept((Object)throwable);
                {
                    catch (Throwable throwable3) {
                        CompositeException compositeException = new CompositeException(new Throwable[]{throwable, throwable3});
                        throw compositeException;
                    }
                }
                throw ExceptionHelper.throwIfThrowable((Throwable)throwable);
            }
            this.onAfterTerminate.run();
            return (T)object;
        }
        if (this.sourceMode != 1) return (T)object;
        this.onComplete.run();
        this.onAfterTerminate.run();
        return (T)object;
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            try {
                this.onError.accept((Object)throwable);
            }
            catch (Throwable throwable4) {
                throw new CompositeException(new Throwable[]{throwable, throwable4});
            }
            throw ExceptionHelper.throwIfThrowable((Throwable)throwable);
        }
    }

    public int requestFusion(int n) {
        return this.transitiveBoundaryFusion(n);
    }
}
