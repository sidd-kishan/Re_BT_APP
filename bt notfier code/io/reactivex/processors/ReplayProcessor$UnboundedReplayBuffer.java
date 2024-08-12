/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.processors.ReplayProcessor$ReplayBuffer
 *  io.reactivex.processors.ReplayProcessor$ReplaySubscription
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.processors;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.processors.ReplayProcessor;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import org.reactivestreams.Subscriber;

static final class ReplayProcessor.UnboundedReplayBuffer<T>
implements ReplayProcessor.ReplayBuffer<T> {
    final List<T> buffer;
    volatile boolean done;
    Throwable error;
    volatile int size;

    ReplayProcessor.UnboundedReplayBuffer(int n) {
        this.buffer = new ArrayList<T>(ObjectHelper.verifyPositive((int)n, (String)"capacityHint"));
    }

    public void complete() {
        this.done = true;
    }

    public void error(Throwable throwable) {
        this.error = throwable;
        this.done = true;
    }

    public Throwable getError() {
        return this.error;
    }

    public T getValue() {
        int n = this.size;
        if (n != 0) return this.buffer.get(n - 1);
        return null;
    }

    public T[] getValues(T[] TArray) {
        int n = this.size;
        int n2 = 0;
        if (n == 0) {
            if (TArray.length == 0) return TArray;
            TArray[0] = null;
            return TArray;
        }
        List<T> list = this.buffer;
        int n3 = n2;
        Object[] objectArray = TArray;
        if (TArray.length < n) {
            objectArray = (Object[])Array.newInstance(TArray.getClass().getComponentType(), n);
            n3 = n2;
        }
        while (true) {
            if (n3 >= n) {
                if (objectArray.length <= n) return objectArray;
                objectArray[n] = null;
                return objectArray;
            }
            objectArray[n3] = list.get(n3);
            ++n3;
        }
    }

    public boolean isDone() {
        return this.done;
    }

    public void next(T t) {
        this.buffer.add(t);
        ++this.size;
    }

    public void replay(ReplayProcessor.ReplaySubscription<T> object) {
        int n;
        if (object.getAndIncrement() != 0) {
            return;
        }
        List<T> list = this.buffer;
        Subscriber subscriber = object.downstream;
        Integer n2 = (Integer)object.index;
        int n3 = 0;
        if (n2 != null) {
            n3 = n2;
        } else {
            object.index = 0;
        }
        long l = object.emitted;
        int n4 = 1;
        do {
            boolean bl;
            long l2 = object.requested.get();
            while (l != l2) {
                if (object.cancelled) {
                    object.index = null;
                    return;
                }
                bl = this.done;
                n = this.size;
                if (bl && n3 == n) {
                    object.index = null;
                    object.cancelled = true;
                    object = this.error;
                    if (object == null) {
                        subscriber.onComplete();
                    } else {
                        subscriber.onError(object);
                    }
                    return;
                }
                if (n3 == n) break;
                subscriber.onNext(list.get(n3));
                ++n3;
                ++l;
            }
            if (l == l2) {
                if (object.cancelled) {
                    object.index = null;
                    return;
                }
                bl = this.done;
                n = this.size;
                if (bl && n3 == n) {
                    object.index = null;
                    object.cancelled = true;
                    object = this.error;
                    if (object == null) {
                        subscriber.onComplete();
                    } else {
                        subscriber.onError(object);
                    }
                    return;
                }
            }
            object.index = n3;
            object.emitted = l;
            n4 = n = object.addAndGet(-n4);
        } while (n != 0);
    }

    public int size() {
        return this.size;
    }

    public void trimHead() {
    }
}
