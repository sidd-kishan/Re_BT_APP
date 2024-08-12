/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Scheduler
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.annotations.SchedulerSupport
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.functions.Functions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.ObservableAutoConnect
 *  io.reactivex.internal.operators.observable.ObservablePublishAlt
 *  io.reactivex.internal.operators.observable.ObservablePublishClassic
 *  io.reactivex.internal.operators.observable.ObservableRefCount
 *  io.reactivex.internal.util.ConnectConsumer
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.schedulers.Schedulers
 */
package io.reactivex.observables;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableAutoConnect;
import io.reactivex.internal.operators.observable.ObservablePublishAlt;
import io.reactivex.internal.operators.observable.ObservablePublishClassic;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import io.reactivex.internal.util.ConnectConsumer;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

public abstract class ConnectableObservable<T>
extends Observable<T> {
    private ConnectableObservable<T> onRefCount() {
        if (!(this instanceof ObservablePublishClassic)) return this;
        return RxJavaPlugins.onAssembly((ConnectableObservable)new ObservablePublishAlt(((ObservablePublishClassic)this).publishSource()));
    }

    public Observable<T> autoConnect() {
        return this.autoConnect(1);
    }

    public Observable<T> autoConnect(int n) {
        return this.autoConnect(n, (Consumer<Disposable>)Functions.emptyConsumer());
    }

    public Observable<T> autoConnect(int n, Consumer<? super Disposable> consumer) {
        if (n > 0) return RxJavaPlugins.onAssembly((Observable)new ObservableAutoConnect(this, n, consumer));
        this.connect(consumer);
        return RxJavaPlugins.onAssembly((ConnectableObservable)this);
    }

    public final Disposable connect() {
        ConnectConsumer connectConsumer = new ConnectConsumer();
        this.connect((Consumer<Disposable>)connectConsumer);
        return connectConsumer.disposable;
    }

    public abstract void connect(Consumer<? super Disposable> var1);

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public Observable<T> refCount() {
        return RxJavaPlugins.onAssembly((Observable)new ObservableRefCount(this.onRefCount()));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> refCount(int n) {
        return this.refCount(n, 0L, TimeUnit.NANOSECONDS, Schedulers.trampoline());
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<T> refCount(int n, long l, TimeUnit timeUnit) {
        return this.refCount(n, l, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> refCount(int n, long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.verifyPositive((int)n, (String)"subscriberCount");
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableRefCount(this.onRefCount(), n, l, timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<T> refCount(long l, TimeUnit timeUnit) {
        return this.refCount(1, l, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> refCount(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.refCount(1, l, timeUnit, scheduler);
    }
}
