/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.flowables.ConnectableFlowable
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.fuseable.HasUpstreamPublisher
 *  io.reactivex.internal.operators.flowable.FlowablePublish$FlowablePublisher
 *  io.reactivex.internal.operators.flowable.FlowablePublish$PublishSubscriber
 *  io.reactivex.internal.operators.flowable.FlowablePublishClassic
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.operators.flowable.FlowablePublish;
import io.reactivex.internal.operators.flowable.FlowablePublishClassic;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowablePublish<T>
extends ConnectableFlowable<T>
implements HasUpstreamPublisher<T>,
FlowablePublishClassic<T> {
    static final long CANCELLED = Long.MIN_VALUE;
    final int bufferSize;
    final AtomicReference<PublishSubscriber<T>> current;
    final Publisher<T> onSubscribe;
    final Flowable<T> source;

    private FlowablePublish(Publisher<T> publisher, Flowable<T> flowable, AtomicReference<PublishSubscriber<T>> atomicReference, int n) {
        this.onSubscribe = publisher;
        this.source = flowable;
        this.current = atomicReference;
        this.bufferSize = n;
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, int n) {
        AtomicReference<PublishSubscriber<T>> atomicReference = new AtomicReference<PublishSubscriber<T>>();
        return RxJavaPlugins.onAssembly(new FlowablePublish<T>(new FlowablePublisher(atomicReference, n), flowable, atomicReference, n));
    }

    public void connect(Consumer<? super Disposable> consumer) {
        PublishSubscriber publishSubscriber;
        PublishSubscriber publishSubscriber2;
        do {
            if ((publishSubscriber2 = this.current.get()) == null) continue;
            publishSubscriber = publishSubscriber2;
            if (!publishSubscriber2.isDisposed()) break;
        } while (!this.current.compareAndSet(publishSubscriber2, publishSubscriber = new PublishSubscriber(this.current, this.bufferSize)));
        boolean bl = publishSubscriber.shouldConnect.get();
        boolean bl2 = true;
        if (bl || !publishSubscriber.shouldConnect.compareAndSet(false, true)) {
            bl2 = false;
        }
        try {
            consumer.accept((Object)publishSubscriber);
            if (!bl2) return;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RuntimeException runtimeException = ExceptionHelper.wrapOrThrow((Throwable)throwable);
            throw runtimeException;
        }
        this.source.subscribe((FlowableSubscriber)publishSubscriber);
    }

    public int publishBufferSize() {
        return this.bufferSize;
    }

    public Publisher<T> publishSource() {
        return this.source;
    }

    public Publisher<T> source() {
        return this.source;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.onSubscribe.subscribe(subscriber);
    }
}
