/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.flowables.ConnectableFlowable
 *  io.reactivex.functions.Consumer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.ResettableConnectable
 *  io.reactivex.internal.fuseable.HasUpstreamPublisher
 *  io.reactivex.internal.operators.flowable.FlowableReplay$ConnectableFlowableReplay
 *  io.reactivex.internal.operators.flowable.FlowableReplay$DefaultUnboundedFactory
 *  io.reactivex.internal.operators.flowable.FlowableReplay$MulticastFlowable
 *  io.reactivex.internal.operators.flowable.FlowableReplay$ReplayBuffer
 *  io.reactivex.internal.operators.flowable.FlowableReplay$ReplayBufferTask
 *  io.reactivex.internal.operators.flowable.FlowableReplay$ReplayPublisher
 *  io.reactivex.internal.operators.flowable.FlowableReplay$ReplaySubscriber
 *  io.reactivex.internal.operators.flowable.FlowableReplay$ScheduledReplayBufferTask
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.operators.flowable.FlowableReplay;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableReplay<T>
extends ConnectableFlowable<T>
implements HasUpstreamPublisher<T>,
ResettableConnectable {
    static final Callable DEFAULT_UNBOUNDED_FACTORY = new DefaultUnboundedFactory();
    final Callable<? extends ReplayBuffer<T>> bufferFactory;
    final AtomicReference<ReplaySubscriber<T>> current;
    final Publisher<T> onSubscribe;
    final Flowable<T> source;

    private FlowableReplay(Publisher<T> publisher, Flowable<T> flowable, AtomicReference<ReplaySubscriber<T>> atomicReference, Callable<? extends ReplayBuffer<T>> callable) {
        this.onSubscribe = publisher;
        this.source = flowable;
        this.current = atomicReference;
        this.bufferFactory = callable;
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, int n) {
        if (n != Integer.MAX_VALUE) return FlowableReplay.create(flowable, new ReplayBufferTask(n));
        return FlowableReplay.createFrom(flowable);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, long l, TimeUnit timeUnit, Scheduler scheduler) {
        return FlowableReplay.create(flowable, l, timeUnit, scheduler, Integer.MAX_VALUE);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, long l, TimeUnit timeUnit, Scheduler scheduler, int n) {
        return FlowableReplay.create(flowable, new ScheduledReplayBufferTask(n, l, timeUnit, scheduler));
    }

    static <T> ConnectableFlowable<T> create(Flowable<T> flowable, Callable<? extends ReplayBuffer<T>> callable) {
        AtomicReference<ReplaySubscriber<T>> atomicReference = new AtomicReference<ReplaySubscriber<T>>();
        return RxJavaPlugins.onAssembly(new FlowableReplay<T>(new ReplayPublisher(atomicReference, callable), flowable, atomicReference, callable));
    }

    public static <T> ConnectableFlowable<T> createFrom(Flowable<? extends T> flowable) {
        return FlowableReplay.create(flowable, DEFAULT_UNBOUNDED_FACTORY);
    }

    public static <U, R> Flowable<R> multicastSelector(Callable<? extends ConnectableFlowable<U>> callable, Function<? super Flowable<U>, ? extends Publisher<R>> function) {
        return new MulticastFlowable(callable, function);
    }

    public static <T> ConnectableFlowable<T> observeOn(ConnectableFlowable<T> connectableFlowable, Scheduler scheduler) {
        return RxJavaPlugins.onAssembly((ConnectableFlowable)new ConnectableFlowableReplay(connectableFlowable, connectableFlowable.observeOn(scheduler)));
    }

    public void connect(Consumer<? super Disposable> consumer) {
        ReplaySubscriber replaySubscriber;
        ReplaySubscriber replaySubscriber2;
        do {
            if ((replaySubscriber2 = this.current.get()) != null) {
                replaySubscriber = replaySubscriber2;
                if (!replaySubscriber2.isDisposed()) break;
            }
            try {
                replaySubscriber = this.bufferFactory.call();
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                RuntimeException runtimeException = ExceptionHelper.wrapOrThrow((Throwable)throwable);
                throw runtimeException;
            }
        } while (!this.current.compareAndSet(replaySubscriber2, replaySubscriber = new ReplaySubscriber(replaySubscriber)));
        boolean bl = !replaySubscriber.shouldConnect.get() && replaySubscriber.shouldConnect.compareAndSet(false, true);
        try {
            consumer.accept((Object)replaySubscriber);
            if (!bl) return;
        }
        catch (Throwable throwable) {
            if (bl) {
                replaySubscriber.shouldConnect.compareAndSet(true, false);
            }
            Exceptions.throwIfFatal((Throwable)throwable);
            throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
        }
        this.source.subscribe((FlowableSubscriber)replaySubscriber);
    }

    public void resetIf(Disposable disposable) {
        this.current.compareAndSet((ReplaySubscriber)disposable, null);
    }

    public Publisher<T> source() {
        return this.source;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.onSubscribe.subscribe(subscriber);
    }
}
