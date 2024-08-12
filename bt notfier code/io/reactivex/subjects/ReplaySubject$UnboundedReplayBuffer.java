/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.util.NotificationLite
 *  io.reactivex.subjects.ReplaySubject$ReplayBuffer
 *  io.reactivex.subjects.ReplaySubject$ReplayDisposable
 */
package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.ReplaySubject;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

static final class ReplaySubject.UnboundedReplayBuffer<T>
extends AtomicReference<Object>
implements ReplaySubject.ReplayBuffer<T> {
    private static final long serialVersionUID = -733876083048047795L;
    final List<Object> buffer;
    volatile boolean done;
    volatile int size;

    ReplaySubject.UnboundedReplayBuffer(int n) {
        this.buffer = new ArrayList<Object>(ObjectHelper.verifyPositive((int)n, (String)"capacityHint"));
    }

    public void add(T t) {
        this.buffer.add(t);
        ++this.size;
    }

    public void addFinal(Object object) {
        this.buffer.add(object);
        this.trimHead();
        ++this.size;
        this.done = true;
    }

    public T getValue() {
        int n = this.size;
        if (n == 0) return null;
        List<Object> list = this.buffer;
        Object object = list.get(n - 1);
        if (!NotificationLite.isComplete((Object)object)) {
            if (!NotificationLite.isError((Object)object)) return (T)object;
        }
        if (n != 1) return (T)list.get(n - 2);
        return null;
    }

    public T[] getValues(T[] TArray) {
        int n;
        Object[] objectArray;
        List<Object> list;
        int n2;
        int n3;
        block9: {
            block8: {
                n3 = this.size;
                n2 = 0;
                if (n3 == 0) {
                    if (TArray.length == 0) return TArray;
                    TArray[0] = null;
                    return TArray;
                }
                list = this.buffer;
                objectArray = list.get(n3 - 1);
                if (NotificationLite.isComplete((Object)objectArray)) break block8;
                n = n3;
                if (!NotificationLite.isError((Object)objectArray)) break block9;
            }
            n = --n3;
            if (n3 == 0) {
                if (TArray.length == 0) return TArray;
                TArray[0] = null;
                return TArray;
            }
        }
        n3 = n2;
        objectArray = TArray;
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

    public void replay(ReplaySubject.ReplayDisposable<T> replayDisposable) {
        if (replayDisposable.getAndIncrement() != 0) {
            return;
        }
        List<Object> list = this.buffer;
        Observer observer = replayDisposable.downstream;
        Object object = (Integer)replayDisposable.index;
        int n = 0;
        if (object != null) {
            n = (Integer)object;
        } else {
            replayDisposable.index = 0;
        }
        int n2 = 1;
        int n3 = n;
        n = n2;
        while (true) {
            if (replayDisposable.cancelled) {
                replayDisposable.index = null;
                return;
            }
            int n4 = this.size;
            while (n4 != n3) {
                if (replayDisposable.cancelled) {
                    replayDisposable.index = null;
                    return;
                }
                object = list.get(n3);
                n2 = n4;
                if (this.done) {
                    int n5 = n3 + 1;
                    n2 = n4;
                    if (n5 == n4) {
                        n2 = n4 = this.size;
                        if (n5 == n4) {
                            if (NotificationLite.isComplete((Object)object)) {
                                observer.onComplete();
                            } else {
                                observer.onError(NotificationLite.getError((Object)object));
                            }
                            replayDisposable.index = null;
                            replayDisposable.cancelled = true;
                            return;
                        }
                    }
                }
                observer.onNext(object);
                ++n3;
                n4 = n2;
            }
            if (n3 != this.size) continue;
            replayDisposable.index = n3;
            n = n2 = replayDisposable.addAndGet(-n);
            if (n2 == 0) return;
        }
    }

    public int size() {
        int n = this.size;
        if (n == 0) return 0;
        Object object = this.buffer;
        int n2 = n - 1;
        if (NotificationLite.isComplete((Object)(object = object.get(n2)))) return n2;
        if (!NotificationLite.isError((Object)object)) return n;
        return n2;
    }

    public void trimHead() {
    }
}
