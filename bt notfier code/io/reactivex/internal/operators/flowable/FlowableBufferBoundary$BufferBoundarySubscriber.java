/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.FlowableBufferBoundary$BufferBoundarySubscriber$BufferOpenSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableBufferBoundary$BufferCloseSubscriber
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundary;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableBufferBoundary.BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = -8466418554264089604L;
    final Function<? super Open, ? extends Publisher<? extends Close>> bufferClose;
    final Publisher<? extends Open> bufferOpen;
    final Callable<C> bufferSupplier;
    Map<Long, C> buffers;
    volatile boolean cancelled;
    volatile boolean done;
    final Subscriber<? super C> downstream;
    long emitted;
    final AtomicThrowable errors;
    long index;
    final SpscLinkedArrayQueue<C> queue;
    final AtomicLong requested;
    final CompositeDisposable subscribers;
    final AtomicReference<Subscription> upstream;

    FlowableBufferBoundary.BufferBoundarySubscriber(Subscriber<? super C> subscriber, Publisher<? extends Open> publisher, Function<? super Open, ? extends Publisher<? extends Close>> function, Callable<C> callable) {
        this.downstream = subscriber;
        this.bufferSupplier = callable;
        this.bufferOpen = publisher;
        this.bufferClose = function;
        this.queue = new SpscLinkedArrayQueue(Flowable.bufferSize());
        this.subscribers = new CompositeDisposable();
        this.requested = new AtomicLong();
        this.upstream = new AtomicReference();
        this.buffers = new LinkedHashMap<Long, C>();
        this.errors = new AtomicThrowable();
    }

    void boundaryError(Disposable disposable, Throwable throwable) {
        SubscriptionHelper.cancel(this.upstream);
        this.subscribers.delete(disposable);
        this.onError(throwable);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void cancel() {
        if (!SubscriptionHelper.cancel(this.upstream)) return;
        this.cancelled = true;
        this.subscribers.dispose();
        synchronized (this) {
            this.buffers = null;
        }
        if (this.getAndIncrement() == 0) return;
        this.queue.clear();
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    void close(FlowableBufferBoundary.BufferCloseSubscriber<T, C> bufferCloseSubscriber, long l) {
        boolean bl;
        this.subscribers.delete(bufferCloseSubscriber);
        if (this.subscribers.size() == 0) {
            SubscriptionHelper.cancel(this.upstream);
            bl = true;
        } else {
            bl = false;
        }
        // MONITORENTER : this
        if (this.buffers == null) {
            // MONITOREXIT : this
            return;
        }
        this.queue.offer(this.buffers.remove(l));
        // MONITOREXIT : this
        if (bl) {
            this.done = true;
        }
        this.drain();
    }

    void drain() {
        int n;
        if (this.getAndIncrement() != 0) {
            return;
        }
        long l = this.emitted;
        Subscriber<? super C> subscriber = this.downstream;
        SpscLinkedArrayQueue<C> spscLinkedArrayQueue = this.queue;
        int n2 = 1;
        do {
            long l2 = this.requested.get();
            while (l != l2) {
                if (this.cancelled) {
                    spscLinkedArrayQueue.clear();
                    return;
                }
                boolean bl = this.done;
                if (bl && this.errors.get() != null) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(this.errors.terminate());
                    return;
                }
                Collection collection = (Collection)spscLinkedArrayQueue.poll();
                n = collection == null ? 1 : 0;
                if (bl && n != 0) {
                    subscriber.onComplete();
                    return;
                }
                if (n != 0) break;
                subscriber.onNext((Object)collection);
                ++l;
            }
            if (l == l2) {
                if (this.cancelled) {
                    spscLinkedArrayQueue.clear();
                    return;
                }
                if (this.done) {
                    if (this.errors.get() != null) {
                        spscLinkedArrayQueue.clear();
                        subscriber.onError(this.errors.terminate());
                        return;
                    }
                    if (spscLinkedArrayQueue.isEmpty()) {
                        subscriber.onComplete();
                        return;
                    }
                }
            }
            this.emitted = l;
            n2 = n = this.addAndGet(-n2);
        } while (n != 0);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public void onComplete() {
        this.subscribers.dispose();
        synchronized (this) {
            Object object = this.buffers;
            if (object == null) {
                return;
            }
            Iterator<C> iterator = object.values().iterator();
            while (true) {
                if (!iterator.hasNext()) {
                    this.buffers = null;
                    // MONITOREXIT @DISABLED, blocks:[0, 2, 4, 5] lbl12 : MonitorExitStatement: MONITOREXIT : this
                    this.done = true;
                    this.drain();
                    return;
                }
                object = (Collection)iterator.next();
                this.queue.offer(object);
            }
            {
                catch (Throwable throwable) {}
                {
                    throw throwable;
                }
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onError(Throwable throwable) {
        if (this.errors.addThrowable(throwable)) {
            this.subscribers.dispose();
            synchronized (this) {
                this.buffers = null;
            }
            this.done = true;
            this.drain();
            return;
        }
        RxJavaPlugins.onError((Throwable)throwable);
    }

    public void onNext(T t) {
        synchronized (this) {
            try {
                Object object = this.buffers;
                if (object == null) {
                    return;
                }
                object = object.values().iterator();
                while (object.hasNext()) {
                    ((Collection)object.next()).add(t);
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.setOnce(this.upstream, (Subscription)subscription)) return;
        BufferOpenSubscriber bufferOpenSubscriber = new BufferOpenSubscriber(this);
        this.subscribers.add((Disposable)bufferOpenSubscriber);
        this.bufferOpen.subscribe((Subscriber)bufferOpenSubscriber);
        subscription.request(Long.MAX_VALUE);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void open(Open object) {
        long l;
        Collection collection;
        try {
            collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"The bufferSupplier returned a null Collection");
            object = (Publisher)ObjectHelper.requireNonNull((Object)this.bufferClose.apply(object), (String)"The bufferClose returned a null Publisher");
            l = this.index;
            this.index = 1L + l;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            SubscriptionHelper.cancel(this.upstream);
            this.onError(throwable);
            return;
        }
        synchronized (this) {
            Map<Long, C> map = this.buffers;
            if (map == null) {
                return;
            }
            map.put(l, collection);
        }
        collection = new FlowableBufferBoundary.BufferCloseSubscriber(this, l);
        this.subscribers.add((Disposable)collection);
        object.subscribe((Subscriber)collection);
    }

    void openComplete(BufferOpenSubscriber<Open> bufferOpenSubscriber) {
        this.subscribers.delete(bufferOpenSubscriber);
        if (this.subscribers.size() != 0) return;
        SubscriptionHelper.cancel(this.upstream);
        this.done = true;
        this.drain();
    }

    public void request(long l) {
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.drain();
    }
}
