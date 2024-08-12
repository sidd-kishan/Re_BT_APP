/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.functions.Functions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.subscribers.BlockingSubscriber
 *  io.reactivex.internal.subscribers.BoundedSubscriber
 *  io.reactivex.internal.subscribers.LambdaSubscriber
 *  io.reactivex.internal.util.BlockingHelper
 *  io.reactivex.internal.util.BlockingIgnoringReceiver
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.internal.util.NotificationLite
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.BlockingSubscriber;
import io.reactivex.internal.subscribers.BoundedSubscriber;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.BlockingIgnoringReceiver;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableBlockingSubscribe {
    private FlowableBlockingSubscribe() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> void subscribe(Publisher<? extends T> object) {
        BlockingIgnoringReceiver blockingIgnoringReceiver = new BlockingIgnoringReceiver();
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(Functions.emptyConsumer(), (Consumer)blockingIgnoringReceiver, (Action)blockingIgnoringReceiver, Functions.REQUEST_MAX);
        object.subscribe((Subscriber)lambdaSubscriber);
        BlockingHelper.awaitForComplete((CountDownLatch)blockingIgnoringReceiver, (Disposable)lambdaSubscriber);
        object = blockingIgnoringReceiver.error;
        if (object != null) throw ExceptionHelper.wrapOrThrow(object);
    }

    public static <T> void subscribe(Publisher<? extends T> publisher, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObjectHelper.requireNonNull(consumer, (String)"onNext is null");
        ObjectHelper.requireNonNull(consumer2, (String)"onError is null");
        ObjectHelper.requireNonNull((Object)action, (String)"onComplete is null");
        FlowableBlockingSubscribe.subscribe(publisher, new LambdaSubscriber(consumer, consumer2, action, Functions.REQUEST_MAX));
    }

    public static <T> void subscribe(Publisher<? extends T> publisher, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, int n) {
        ObjectHelper.requireNonNull(consumer, (String)"onNext is null");
        ObjectHelper.requireNonNull(consumer2, (String)"onError is null");
        ObjectHelper.requireNonNull((Object)action, (String)"onComplete is null");
        ObjectHelper.verifyPositive((int)n, (String)"number > 0 required");
        FlowableBlockingSubscribe.subscribe(publisher, new BoundedSubscriber(consumer, consumer2, action, Functions.boundedConsumer((int)n), n));
    }

    public static <T> void subscribe(Publisher<? extends T> object, Subscriber<? super T> subscriber) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        BlockingSubscriber blockingSubscriber = new BlockingSubscriber(linkedBlockingQueue);
        object.subscribe((Subscriber)blockingSubscriber);
        try {
            while (!blockingSubscriber.isCancelled()) {
                Object e = linkedBlockingQueue.poll();
                object = e;
                if (e == null) {
                    if (blockingSubscriber.isCancelled()) return;
                    BlockingHelper.verifyNonBlocking();
                    object = linkedBlockingQueue.take();
                }
                if (blockingSubscriber.isCancelled()) return;
                if (object == BlockingSubscriber.TERMINATED) return;
                boolean bl = NotificationLite.acceptFull(object, subscriber);
                if (!bl) continue;
                break;
            }
        }
        catch (InterruptedException interruptedException) {
            blockingSubscriber.cancel();
            subscriber.onError((Throwable)interruptedException);
        }
    }
}
