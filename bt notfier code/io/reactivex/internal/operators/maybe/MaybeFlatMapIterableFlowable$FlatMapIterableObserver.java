/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.subscriptions.BasicIntQueueSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class MaybeFlatMapIterableFlowable.FlatMapIterableObserver<T, R>
extends BasicIntQueueSubscription<R>
implements MaybeObserver<T> {
    private static final long serialVersionUID = -8938804753851907758L;
    volatile boolean cancelled;
    final Subscriber<? super R> downstream;
    volatile Iterator<? extends R> it;
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    boolean outputFused;
    final AtomicLong requested;
    Disposable upstream;

    MaybeFlatMapIterableFlowable.FlatMapIterableObserver(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.downstream = subscriber;
        this.mapper = function;
        this.requested = new AtomicLong();
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
    }

    public void clear() {
        this.it = null;
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        Subscriber<? super R> subscriber = this.downstream;
        Iterator<R> iterator = this.it;
        if (this.outputFused && iterator != null) {
            subscriber.onNext(null);
            subscriber.onComplete();
            return;
        }
        int n = 1;
        while (true) {
            int n2;
            if (iterator != null) {
                long l;
                long l2 = this.requested.get();
                if (l2 == Long.MAX_VALUE) {
                    this.fastPath(subscriber, iterator);
                    return;
                }
                for (l = 0L; l != l2; ++l) {
                    Object object;
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        object = ObjectHelper.requireNonNull(iterator.next(), (String)"The iterator returned a null value");
                    }
                    catch (Throwable throwable) {
                        Exceptions.throwIfFatal((Throwable)throwable);
                        subscriber.onError(throwable);
                        return;
                    }
                    subscriber.onNext(object);
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        boolean bl = iterator.hasNext();
                        if (bl) continue;
                    }
                    catch (Throwable throwable) {
                        Exceptions.throwIfFatal((Throwable)throwable);
                        subscriber.onError(throwable);
                        return;
                    }
                    subscriber.onComplete();
                    return;
                }
                if (l != 0L) {
                    BackpressureHelper.produced((AtomicLong)this.requested, (long)l);
                }
            }
            if ((n2 = this.addAndGet(-n)) == 0) {
                return;
            }
            n = n2;
            if (iterator != null) continue;
            iterator = this.it;
            n = n2;
        }
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    void fastPath(Subscriber<? super R> subscriber, Iterator<? extends R> iterator) {
        while (true) {
            boolean bl;
            if (this.cancelled) {
                return;
            }
            R r = iterator.next();
            subscriber.onNext(r);
            if (this.cancelled) {
                return;
            }
            if (bl = iterator.hasNext()) continue;
            break;
        }
        subscriber.onComplete();
        return;
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            subscriber.onError(throwable);
            return;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            subscriber.onError(throwable);
            return;
        }
    }

    public boolean isEmpty() {
        boolean bl = this.it == null;
        return bl;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.upstream = DisposableHelper.DISPOSED;
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Subscription)this);
    }

    public void onSuccess(T object) {
        block2: {
            try {
                object = ((Iterable)this.mapper.apply(object)).iterator();
                boolean bl = object.hasNext();
                if (bl) break block2;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.downstream.onError(throwable);
                return;
            }
            this.downstream.onComplete();
            return;
        }
        this.it = object;
        this.drain();
    }

    public R poll() throws Exception {
        Iterator<R> iterator = this.it;
        if (iterator == null) return null;
        Object object = ObjectHelper.requireNonNull(iterator.next(), (String)"The iterator returned a null value");
        if (iterator.hasNext()) return (R)object;
        this.it = null;
        return (R)object;
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.drain();
    }

    public int requestFusion(int n) {
        if ((n & 2) == 0) return 0;
        this.outputFused = true;
        return 2;
    }
}
