/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.Scheduler
 *  io.reactivex.annotations.BackpressureKind
 *  io.reactivex.annotations.BackpressureSupport
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.annotations.SchedulerSupport
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.functions.Functions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.FlowableAutoConnect
 *  io.reactivex.internal.operators.flowable.FlowablePublishAlt
 *  io.reactivex.internal.operators.flowable.FlowablePublishClassic
 *  io.reactivex.internal.operators.flowable.FlowableRefCount
 *  io.reactivex.internal.util.ConnectConsumer
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.schedulers.Schedulers
 */
package io.reactivex.flowables;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableAutoConnect;
import io.reactivex.internal.operators.flowable.FlowablePublishAlt;
import io.reactivex.internal.operators.flowable.FlowablePublishClassic;
import io.reactivex.internal.operators.flowable.FlowableRefCount;
import io.reactivex.internal.util.ConnectConsumer;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

public abstract class ConnectableFlowable<T>
extends Flowable<T> {
    private ConnectableFlowable<T> onRefCount() {
        if (!(this instanceof FlowablePublishClassic)) return this;
        FlowablePublishClassic flowablePublishClassic = (FlowablePublishClassic)this;
        return RxJavaPlugins.onAssembly((ConnectableFlowable)new FlowablePublishAlt(flowablePublishClassic.publishSource(), flowablePublishClassic.publishBufferSize()));
    }

    public Flowable<T> autoConnect() {
        return this.autoConnect(1);
    }

    public Flowable<T> autoConnect(int n) {
        return this.autoConnect(n, (Consumer<Disposable>)Functions.emptyConsumer());
    }

    public Flowable<T> autoConnect(int n, Consumer<? super Disposable> consumer) {
        if (n > 0) return RxJavaPlugins.onAssembly((Flowable)new FlowableAutoConnect(this, n, consumer));
        this.connect(consumer);
        return RxJavaPlugins.onAssembly((ConnectableFlowable)this);
    }

    public final Disposable connect() {
        ConnectConsumer connectConsumer = new ConnectConsumer();
        this.connect((Consumer<Disposable>)connectConsumer);
        return connectConsumer.disposable;
    }

    public abstract void connect(Consumer<? super Disposable> var1);

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public Flowable<T> refCount() {
        return RxJavaPlugins.onAssembly((Flowable)new FlowableRefCount(this.onRefCount()));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> refCount(int n) {
        return this.refCount(n, 0L, TimeUnit.NANOSECONDS, Schedulers.trampoline());
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<T> refCount(int n, long l, TimeUnit timeUnit) {
        return this.refCount(n, l, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> refCount(int n, long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.verifyPositive((int)n, (String)"subscriberCount");
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableRefCount(this.onRefCount(), n, l, timeUnit, scheduler));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<T> refCount(long l, TimeUnit timeUnit) {
        return this.refCount(1, l, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> refCount(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.refCount(1, l, timeUnit, scheduler);
    }
}
