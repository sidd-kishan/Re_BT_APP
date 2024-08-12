/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowablePublish$InnerSubscriber
 *  io.reactivex.internal.operators.flowable.FlowablePublish$PublishSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowablePublish;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowablePublish.FlowablePublisher<T>
implements Publisher<T> {
    private final int bufferSize;
    private final AtomicReference<FlowablePublish.PublishSubscriber<T>> curr;

    FlowablePublish.FlowablePublisher(AtomicReference<FlowablePublish.PublishSubscriber<T>> atomicReference, int n) {
        this.curr = atomicReference;
        this.bufferSize = n;
    }

    public void subscribe(Subscriber<? super T> publishSubscriber) {
        FlowablePublish.InnerSubscriber innerSubscriber = new FlowablePublish.InnerSubscriber(publishSubscriber);
        publishSubscriber.onSubscribe((Subscription)innerSubscriber);
        while (true) {
            block7: {
                FlowablePublish.PublishSubscriber<T> publishSubscriber2;
                block6: {
                    if ((publishSubscriber2 = this.curr.get()) == null) break block6;
                    publishSubscriber = publishSubscriber2;
                    if (!publishSubscriber2.isDisposed()) break block7;
                }
                if (!this.curr.compareAndSet(publishSubscriber2, publishSubscriber = new FlowablePublish.PublishSubscriber(this.curr, this.bufferSize))) continue;
            }
            if (publishSubscriber.add(innerSubscriber)) break;
        }
        if (innerSubscriber.get() == Long.MIN_VALUE) {
            publishSubscriber.remove(innerSubscriber);
        } else {
            innerSubscriber.parent = publishSubscriber;
        }
        publishSubscriber.dispatch();
    }
}
