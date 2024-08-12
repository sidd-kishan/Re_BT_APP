/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.flowables.ConnectableFlowable
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.disposables.ResettableConnectable
 *  io.reactivex.internal.fuseable.HasUpstreamPublisher
 *  io.reactivex.internal.operators.flowable.FlowablePublishAlt$InnerSubscription
 *  io.reactivex.internal.operators.flowable.FlowablePublishAlt$PublishConnection
 *  io.reactivex.internal.util.ExceptionHelper
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.operators.flowable.FlowablePublishAlt;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowablePublishAlt<T>
extends ConnectableFlowable<T>
implements HasUpstreamPublisher<T>,
ResettableConnectable {
    final int bufferSize;
    final AtomicReference<PublishConnection<T>> current;
    final Publisher<T> source;

    public FlowablePublishAlt(Publisher<T> publisher, int n) {
        this.source = publisher;
        this.bufferSize = n;
        this.current = new AtomicReference();
    }

    public void connect(Consumer<? super Disposable> consumer) {
        PublishConnection publishConnection;
        PublishConnection publishConnection2;
        do {
            if ((publishConnection2 = this.current.get()) == null) continue;
            publishConnection = publishConnection2;
            if (!publishConnection2.isDisposed()) break;
        } while (!this.current.compareAndSet(publishConnection2, publishConnection = new PublishConnection(this.current, this.bufferSize)));
        boolean bl = publishConnection.connect.get();
        boolean bl2 = true;
        if (bl || !publishConnection.connect.compareAndSet(false, true)) {
            bl2 = false;
        }
        try {
            consumer.accept((Object)publishConnection);
            if (!bl2) return;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RuntimeException runtimeException = ExceptionHelper.wrapOrThrow((Throwable)throwable);
            throw runtimeException;
        }
        this.source.subscribe((Subscriber)publishConnection);
    }

    public int publishBufferSize() {
        return this.bufferSize;
    }

    public void resetIf(Disposable disposable) {
        this.current.compareAndSet((PublishConnection)disposable, null);
    }

    public Publisher<T> source() {
        return this.source;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        Object object;
        InnerSubscription innerSubscription;
        do {
            object = innerSubscription = this.current.get();
        } while (innerSubscription == null && !this.current.compareAndSet((PublishConnection<T>)innerSubscription, (PublishConnection<T>)(object = new PublishConnection(this.current, this.bufferSize))));
        innerSubscription = new InnerSubscription(subscriber, object);
        subscriber.onSubscribe((Subscription)innerSubscription);
        if (object.add(innerSubscription)) {
            if (innerSubscription.isCancelled()) {
                object.remove(innerSubscription);
            } else {
                object.drain();
            }
            return;
        }
        object = object.error;
        if (object != null) {
            subscriber.onError((Throwable)object);
        } else {
            subscriber.onComplete();
        }
    }
}
