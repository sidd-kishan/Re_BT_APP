/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.subscribers.BasicFuseableSubscriber
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import org.reactivestreams.Subscriber;

static final class FlowableDistinct.DistinctSubscriber<T, K>
extends BasicFuseableSubscriber<T, T> {
    final Collection<? super K> collection;
    final Function<? super T, K> keySelector;

    FlowableDistinct.DistinctSubscriber(Subscriber<? super T> subscriber, Function<? super T, K> function, Collection<? super K> collection) {
        super(subscriber);
        this.keySelector = function;
        this.collection = collection;
    }

    public void clear() {
        this.collection.clear();
        super.clear();
    }

    public void onComplete() {
        if (this.done) return;
        this.done = true;
        this.collection.clear();
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
        } else {
            this.done = true;
            this.collection.clear();
            this.downstream.onError(throwable);
        }
    }

    public void onNext(T t) {
        block5: {
            block4: {
                block3: {
                    if (this.done) {
                        return;
                    }
                    if (this.sourceMode != 0) break block4;
                    try {
                        Object object = ObjectHelper.requireNonNull((Object)this.keySelector.apply(t), (String)"The keySelector returned a null key");
                        boolean bl = this.collection.add(object);
                        if (!bl) break block3;
                    }
                    catch (Throwable throwable) {
                        this.fail(throwable);
                        return;
                    }
                    this.downstream.onNext(t);
                    break block5;
                }
                this.upstream.request(1L);
                break block5;
            }
            this.downstream.onNext(null);
        }
    }

    public T poll() throws Exception {
        Object object;
        while ((object = this.qs.poll()) != null) {
            if (this.collection.add(ObjectHelper.requireNonNull((Object)this.keySelector.apply(object), (String)"The keySelector returned a null key"))) {
                return (T)object;
            }
            if (this.sourceMode != 2) continue;
            this.upstream.request(1L);
        }
        return (T)object;
    }

    public int requestFusion(int n) {
        return this.transitiveBoundaryFusion(n);
    }
}
