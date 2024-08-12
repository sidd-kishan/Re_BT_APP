/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.functions.Functions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.observers.BlockingObserver
 *  io.reactivex.internal.observers.LambdaObserver
 *  io.reactivex.internal.util.BlockingHelper
 *  io.reactivex.internal.util.BlockingIgnoringReceiver
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.internal.util.NotificationLite
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BlockingObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.BlockingIgnoringReceiver;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

public final class ObservableBlockingSubscribe {
    private ObservableBlockingSubscribe() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> void subscribe(ObservableSource<? extends T> object) {
        BlockingIgnoringReceiver blockingIgnoringReceiver = new BlockingIgnoringReceiver();
        LambdaObserver lambdaObserver = new LambdaObserver(Functions.emptyConsumer(), (Consumer)blockingIgnoringReceiver, (Action)blockingIgnoringReceiver, Functions.emptyConsumer());
        object.subscribe((Observer)lambdaObserver);
        BlockingHelper.awaitForComplete((CountDownLatch)blockingIgnoringReceiver, (Disposable)lambdaObserver);
        object = blockingIgnoringReceiver.error;
        if (object != null) throw ExceptionHelper.wrapOrThrow(object);
    }

    public static <T> void subscribe(ObservableSource<? extends T> observableSource, Observer<? super T> observer) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        BlockingObserver blockingObserver = new BlockingObserver(linkedBlockingQueue);
        observer.onSubscribe((Disposable)blockingObserver);
        observableSource.subscribe((Observer)blockingObserver);
        while (!blockingObserver.isDisposed()) {
            Object e;
            Object e2 = e = linkedBlockingQueue.poll();
            if (e == null) {
                try {
                    e2 = linkedBlockingQueue.take();
                }
                catch (InterruptedException interruptedException) {
                    blockingObserver.dispose();
                    observer.onError((Throwable)interruptedException);
                    return;
                }
            }
            if (blockingObserver.isDisposed()) return;
            if (observableSource == BlockingObserver.TERMINATED) return;
            if (!NotificationLite.acceptFull(e2, observer)) continue;
        }
    }

    public static <T> void subscribe(ObservableSource<? extends T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObjectHelper.requireNonNull(consumer, (String)"onNext is null");
        ObjectHelper.requireNonNull(consumer2, (String)"onError is null");
        ObjectHelper.requireNonNull((Object)action, (String)"onComplete is null");
        ObservableBlockingSubscribe.subscribe(observableSource, new LambdaObserver(consumer, consumer2, action, Functions.emptyConsumer()));
    }
}
