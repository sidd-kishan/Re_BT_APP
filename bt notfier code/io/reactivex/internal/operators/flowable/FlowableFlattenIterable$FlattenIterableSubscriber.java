/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.QueueSubscription
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.subscriptions.BasicIntQueueSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableFlattenIterable.FlattenIterableSubscriber<T, R>
extends BasicIntQueueSubscription<R>
implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -3096000382929934955L;
    volatile boolean cancelled;
    int consumed;
    Iterator<? extends R> current;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    final AtomicReference<Throwable> error;
    int fusionMode;
    final int limit;
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    final int prefetch;
    SimpleQueue<T> queue;
    final AtomicLong requested;
    Subscription upstream;

    FlowableFlattenIterable.FlattenIterableSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function, int n) {
        this.downstream = subscriber;
        this.mapper = function;
        this.prefetch = n;
        this.limit = n - (n >> 2);
        this.error = new AtomicReference();
        this.requested = new AtomicLong();
    }

    public void cancel() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.upstream.cancel();
        if (this.getAndIncrement() != 0) return;
        this.queue.clear();
    }

    boolean checkTerminated(boolean bl, boolean bl2, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
        if (this.cancelled) {
            this.current = null;
            simpleQueue.clear();
            return true;
        }
        if (!bl) return false;
        if (this.error.get() != null) {
            Throwable throwable = ExceptionHelper.terminate(this.error);
            this.current = null;
            simpleQueue.clear();
            subscriber.onError(throwable);
            return true;
        }
        if (!bl2) return false;
        subscriber.onComplete();
        return true;
    }

    public void clear() {
        this.current = null;
        this.queue.clear();
    }

    void consumedOne(boolean bl) {
        if (!bl) return;
        int n = this.consumed + 1;
        if (n == this.limit) {
            this.consumed = 0;
            this.upstream.request((long)n);
        } else {
            this.consumed = n;
        }
    }

    /*
     * Exception decompiling
     */
    void drain() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [9[DOLOOP]], but top level block is 3[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public boolean isEmpty() {
        boolean bl = this.current == null && this.queue.isEmpty();
        return bl;
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        if (!this.done && ExceptionHelper.addThrowable(this.error, (Throwable)throwable)) {
            this.done = true;
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.fusionMode == 0 && !this.queue.offer(t)) {
            this.onError((Throwable)new MissingBackpressureException("Queue is full?!"));
            return;
        }
        this.drain();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        if (subscription instanceof QueueSubscription) {
            QueueSubscription queueSubscription = (QueueSubscription)subscription;
            int n = queueSubscription.requestFusion(3);
            if (n == 1) {
                this.fusionMode = n;
                this.queue = queueSubscription;
                this.done = true;
                this.downstream.onSubscribe((Subscription)this);
                return;
            }
            if (n == 2) {
                this.fusionMode = n;
                this.queue = queueSubscription;
                this.downstream.onSubscribe((Subscription)this);
                subscription.request((long)this.prefetch);
                return;
            }
        }
        this.queue = new SpscArrayQueue(this.prefetch);
        this.downstream.onSubscribe((Subscription)this);
        subscription.request((long)this.prefetch);
    }

    public R poll() throws Exception {
        Iterator<Object> iterator;
        Object object;
        block2: {
            object = this.current;
            while (true) {
                iterator = object;
                if (object != null) break block2;
                object = this.queue.poll();
                if (object == null) {
                    return null;
                }
                iterator = ((Iterable)this.mapper.apply(object)).iterator();
                if (iterator.hasNext()) break;
                object = null;
            }
            this.current = iterator;
        }
        object = ObjectHelper.requireNonNull(iterator.next(), (String)"The iterator returned a null value");
        if (iterator.hasNext()) return (R)object;
        this.current = null;
        return (R)object;
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.drain();
    }

    public int requestFusion(int n) {
        if ((n & 1) == 0) return 0;
        if (this.fusionMode != 1) return 0;
        return 1;
    }
}
