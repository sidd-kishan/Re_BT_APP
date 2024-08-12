/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.ObservableGroupBy$GroupedUnicast
 *  io.reactivex.observables.GroupedObservable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.observables.GroupedObservable;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Exception performing whole class analysis ignored.
 */
public static final class ObservableGroupBy.GroupByObserver<T, K, V>
extends AtomicInteger
implements Observer<T>,
Disposable {
    static final Object NULL_KEY = new Object();
    private static final long serialVersionUID = -3688291656102519502L;
    final int bufferSize;
    final AtomicBoolean cancelled = new AtomicBoolean();
    final boolean delayError;
    final Observer<? super GroupedObservable<K, V>> downstream;
    final Map<Object, ObservableGroupBy.GroupedUnicast<K, V>> groups;
    final Function<? super T, ? extends K> keySelector;
    Disposable upstream;
    final Function<? super T, ? extends V> valueSelector;

    public ObservableGroupBy.GroupByObserver(Observer<? super GroupedObservable<K, V>> observer, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int n, boolean bl) {
        this.downstream = observer;
        this.keySelector = function;
        this.valueSelector = function2;
        this.bufferSize = n;
        this.delayError = bl;
        this.groups = new ConcurrentHashMap<Object, ObservableGroupBy.GroupedUnicast<K, V>>();
        this.lazySet(1);
    }

    public void cancel(K object) {
        if (object == null) {
            object = NULL_KEY;
        }
        this.groups.remove(object);
        if (this.decrementAndGet() != 0) return;
        this.upstream.dispose();
    }

    public void dispose() {
        if (!this.cancelled.compareAndSet(false, true)) return;
        if (this.decrementAndGet() != 0) return;
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.cancelled.get();
    }

    public void onComplete() {
        Object object = new ArrayList<ObservableGroupBy.GroupedUnicast<K, V>>(this.groups.values());
        this.groups.clear();
        object = object.iterator();
        while (true) {
            if (!object.hasNext()) {
                this.downstream.onComplete();
                return;
            }
            ((ObservableGroupBy.GroupedUnicast)object.next()).onComplete();
        }
    }

    public void onError(Throwable throwable) {
        Object object = new ArrayList<ObservableGroupBy.GroupedUnicast<K, V>>(this.groups.values());
        this.groups.clear();
        object = object.iterator();
        while (true) {
            if (!object.hasNext()) {
                this.downstream.onError(throwable);
                return;
            }
            ((ObservableGroupBy.GroupedUnicast)object.next()).onError(throwable);
        }
    }

    public void onNext(T object) {
        ObservableGroupBy.GroupedUnicast groupedUnicast;
        block5: {
            Object object2;
            Object object3;
            try {
                ObservableGroupBy.GroupedUnicast groupedUnicast2;
                object3 = this.keySelector.apply(object);
                object2 = object3 != null ? object3 : NULL_KEY;
                groupedUnicast = groupedUnicast2 = this.groups.get(object2);
                if (groupedUnicast2 != null) break block5;
                if (this.cancelled.get()) {
                    return;
                }
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.upstream.dispose();
                this.onError(throwable);
                return;
            }
            groupedUnicast = ObservableGroupBy.GroupedUnicast.createWith((Object)object3, (int)this.bufferSize, (ObservableGroupBy.GroupByObserver)this, (boolean)this.delayError);
            this.groups.put(object2, groupedUnicast);
            this.getAndIncrement();
            this.downstream.onNext((Object)groupedUnicast);
        }
        try {
            object = ObjectHelper.requireNonNull((Object)this.valueSelector.apply(object), (String)"The value supplied is null");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.upstream.dispose();
            this.onError(throwable);
            return;
        }
        groupedUnicast.onNext(object);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
