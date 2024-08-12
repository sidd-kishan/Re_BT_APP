/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.functions.BooleanSupplier
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.internal.util.ObservableQueueDrain
 *  io.reactivex.internal.util.QueueDrain
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ObservableQueueDrain;
import io.reactivex.internal.util.QueueDrain;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class QueueDrainHelper {
    static final long COMPLETED_MASK = Long.MIN_VALUE;
    static final long REQUESTED_MASK = Long.MAX_VALUE;

    private QueueDrainHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> boolean checkTerminated(boolean bl, boolean bl2, Observer<?> observer, boolean bl3, SimpleQueue<?> object, Disposable disposable, ObservableQueueDrain<T, U> object2) {
        if (object2.cancelled()) {
            object.clear();
            disposable.dispose();
            return true;
        }
        if (!bl) return false;
        if (bl3) {
            if (!bl2) return false;
            if (disposable != null) {
                disposable.dispose();
            }
            if ((object = object2.error()) != null) {
                observer.onError(object);
            } else {
                observer.onComplete();
            }
            return true;
        }
        if ((object2 = object2.error()) != null) {
            object.clear();
            if (disposable != null) {
                disposable.dispose();
            }
            observer.onError(object2);
            return true;
        }
        if (!bl2) return false;
        if (disposable != null) {
            disposable.dispose();
        }
        observer.onComplete();
        return true;
    }

    public static <T, U> boolean checkTerminated(boolean bl, boolean bl2, Subscriber<?> subscriber, boolean bl3, SimpleQueue<?> object, QueueDrain<T, U> object2) {
        if (object2.cancelled()) {
            object.clear();
            return true;
        }
        if (!bl) return false;
        if (bl3) {
            if (!bl2) return false;
            object = object2.error();
            if (object != null) {
                subscriber.onError(object);
            } else {
                subscriber.onComplete();
            }
            return true;
        }
        if ((object2 = object2.error()) != null) {
            object.clear();
            subscriber.onError(object2);
            return true;
        }
        if (!bl2) return false;
        subscriber.onComplete();
        return true;
    }

    public static <T> SimpleQueue<T> createQueue(int n) {
        if (n >= 0) return new SpscArrayQueue(n);
        return new SpscLinkedArrayQueue(-n);
    }

    public static <T, U> void drainLoop(SimplePlainQueue<T> simplePlainQueue, Observer<? super U> observer, boolean bl, Disposable disposable, ObservableQueueDrain<T, U> observableQueueDrain) {
        int n = 1;
        block0: while (!QueueDrainHelper.checkTerminated(observableQueueDrain.done(), simplePlainQueue.isEmpty(), observer, bl, simplePlainQueue, disposable, observableQueueDrain)) {
            while (true) {
                Object object;
                boolean bl2;
                boolean bl3;
                if (QueueDrainHelper.checkTerminated(bl3 = observableQueueDrain.done(), bl2 = (object = simplePlainQueue.poll()) == null, observer, bl, simplePlainQueue, disposable, observableQueueDrain)) {
                    return;
                }
                if (bl2) {
                    int n2;
                    n = n2 = observableQueueDrain.leave(-n);
                    if (n2 != 0) continue block0;
                    return;
                }
                observableQueueDrain.accept(observer, object);
            }
            break;
        }
        return;
    }

    public static <T, U> void drainMaxLoop(SimplePlainQueue<T> simplePlainQueue, Subscriber<? super U> subscriber, boolean bl, Disposable disposable, QueueDrain<T, U> queueDrain) {
        int n = 1;
        while (true) {
            Object object;
            boolean bl2;
            boolean bl3;
            if (QueueDrainHelper.checkTerminated(bl3 = queueDrain.done(), bl2 = (object = simplePlainQueue.poll()) == null, subscriber, bl, simplePlainQueue, queueDrain)) {
                if (disposable == null) return;
                disposable.dispose();
                return;
            }
            if (bl2) {
                int n2;
                n = n2 = queueDrain.leave(-n);
                if (n2 != 0) continue;
                return;
            }
            long l = queueDrain.requested();
            if (l == 0L) break;
            if (!queueDrain.accept(subscriber, object) || l == Long.MAX_VALUE) continue;
            queueDrain.produced(1L);
        }
        simplePlainQueue.clear();
        if (disposable != null) {
            disposable.dispose();
        }
        subscriber.onError((Throwable)new MissingBackpressureException("Could not emit value due to lack of requests."));
    }

    static boolean isCancelled(BooleanSupplier booleanSupplier) {
        try {
            boolean bl = booleanSupplier.getAsBoolean();
            return bl;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            return true;
        }
    }

    public static <T> void postComplete(Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long l;
        long l2;
        if (queue.isEmpty()) {
            subscriber.onComplete();
            return;
        }
        if (QueueDrainHelper.postCompleteDrain(atomicLong.get(), subscriber, queue, atomicLong, booleanSupplier)) {
            return;
        }
        do {
            if (((l2 = atomicLong.get()) & Long.MIN_VALUE) == 0L) continue;
            return;
        } while (!atomicLong.compareAndSet(l2, l = l2 | Long.MIN_VALUE));
        if (l2 == 0L) return;
        QueueDrainHelper.postCompleteDrain(l, subscriber, queue, atomicLong, booleanSupplier);
    }

    static <T> boolean postCompleteDrain(long l, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long l2 = l & Long.MIN_VALUE;
        while (true) {
            long l3;
            if (l2 != l) {
                if (QueueDrainHelper.isCancelled(booleanSupplier)) {
                    return true;
                }
                T t = queue.poll();
                if (t == null) {
                    subscriber.onComplete();
                    return true;
                }
                subscriber.onNext(t);
                ++l2;
                continue;
            }
            if (QueueDrainHelper.isCancelled(booleanSupplier)) {
                return true;
            }
            if (queue.isEmpty()) {
                subscriber.onComplete();
                return true;
            }
            l = l3 = atomicLong.get();
            if (l3 != l2) continue;
            if ((Long.MAX_VALUE & (l2 = atomicLong.addAndGet(-(l2 & Long.MAX_VALUE)))) == 0L) {
                return false;
            }
            l = l2;
            l2 &= Long.MIN_VALUE;
        }
    }

    public static <T> boolean postCompleteRequest(long l, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long l2;
        while (!atomicLong.compareAndSet(l2 = atomicLong.get(), BackpressureHelper.addCap((long)(Long.MAX_VALUE & l2), (long)l) | l2 & Long.MIN_VALUE)) {
        }
        if (l2 != Long.MIN_VALUE) return false;
        QueueDrainHelper.postCompleteDrain(l | Long.MIN_VALUE, subscriber, queue, atomicLong, booleanSupplier);
        return true;
    }

    public static void request(Subscription subscription, int n) {
        long l = n < 0 ? Long.MAX_VALUE : (long)n;
        subscription.request(l);
    }
}
