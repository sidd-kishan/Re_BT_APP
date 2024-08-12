/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.util.NotificationLite
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.subjects.ReplaySubject$ReplayBuffer
 *  io.reactivex.subjects.ReplaySubject$ReplayDisposable
 *  io.reactivex.subjects.ReplaySubject$SizeAndTimeBoundReplayBuffer
 *  io.reactivex.subjects.ReplaySubject$SizeBoundReplayBuffer
 *  io.reactivex.subjects.ReplaySubject$UnboundedReplayBuffer
 *  io.reactivex.subjects.Subject
 */
package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ReplaySubject<T>
extends Subject<T> {
    static final ReplayDisposable[] EMPTY = new ReplayDisposable[0];
    private static final Object[] EMPTY_ARRAY;
    static final ReplayDisposable[] TERMINATED;
    final ReplayBuffer<T> buffer;
    boolean done;
    final AtomicReference<ReplayDisposable<T>[]> observers;

    static {
        TERMINATED = new ReplayDisposable[0];
        EMPTY_ARRAY = new Object[0];
    }

    ReplaySubject(ReplayBuffer<T> replayBuffer) {
        this.buffer = replayBuffer;
        this.observers = new AtomicReference<ReplayDisposable[]>(EMPTY);
    }

    @CheckReturnValue
    public static <T> ReplaySubject<T> create() {
        return new ReplaySubject<T>(new UnboundedReplayBuffer(16));
    }

    @CheckReturnValue
    public static <T> ReplaySubject<T> create(int n) {
        return new ReplaySubject<T>(new UnboundedReplayBuffer(n));
    }

    static <T> ReplaySubject<T> createUnbounded() {
        return new ReplaySubject<T>(new SizeBoundReplayBuffer(Integer.MAX_VALUE));
    }

    @CheckReturnValue
    public static <T> ReplaySubject<T> createWithSize(int n) {
        return new ReplaySubject<T>(new SizeBoundReplayBuffer(n));
    }

    @CheckReturnValue
    public static <T> ReplaySubject<T> createWithTime(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return new ReplaySubject<T>(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, l, timeUnit, scheduler));
    }

    @CheckReturnValue
    public static <T> ReplaySubject<T> createWithTimeAndSize(long l, TimeUnit timeUnit, Scheduler scheduler, int n) {
        return new ReplaySubject<T>(new SizeAndTimeBoundReplayBuffer(n, l, timeUnit, scheduler));
    }

    boolean add(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable[] replayDisposableArray;
        ReplayDisposable<T>[] replayDisposableArray2;
        do {
            if ((replayDisposableArray2 = this.observers.get()) == TERMINATED) {
                return false;
            }
            int n = replayDisposableArray2.length;
            replayDisposableArray = new ReplayDisposable[n + 1];
            System.arraycopy(replayDisposableArray2, 0, replayDisposableArray, 0, n);
            replayDisposableArray[n] = replayDisposable;
        } while (!this.observers.compareAndSet(replayDisposableArray2, replayDisposableArray));
        return true;
    }

    public void cleanupBuffer() {
        this.buffer.trimHead();
    }

    public Throwable getThrowable() {
        Object object = this.buffer.get();
        if (!NotificationLite.isError((Object)object)) return null;
        return NotificationLite.getError((Object)object);
    }

    public T getValue() {
        return (T)this.buffer.getValue();
    }

    public Object[] getValues() {
        Object[] objectArray;
        Object[] objectArray2 = objectArray = this.getValues(EMPTY_ARRAY);
        if (objectArray != EMPTY_ARRAY) return objectArray2;
        objectArray2 = new Object[]{};
        return objectArray2;
    }

    public T[] getValues(T[] TArray) {
        return this.buffer.getValues((Object[])TArray);
    }

    public boolean hasComplete() {
        return NotificationLite.isComplete((Object)this.buffer.get());
    }

    public boolean hasObservers() {
        boolean bl = this.observers.get().length != 0;
        return bl;
    }

    public boolean hasThrowable() {
        return NotificationLite.isError((Object)this.buffer.get());
    }

    public boolean hasValue() {
        boolean bl = this.buffer.size() != 0;
        return bl;
    }

    int observerCount() {
        return this.observers.get().length;
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        ReplayDisposable<T>[] replayDisposableArray = NotificationLite.complete();
        ReplayBuffer<T> replayBuffer = this.buffer;
        replayBuffer.addFinal((Object)replayDisposableArray);
        replayDisposableArray = this.terminate(replayDisposableArray);
        int n = replayDisposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            replayBuffer.replay(replayDisposableArray[n2]);
            ++n2;
        }
    }

    public void onError(Throwable replayBuffer) {
        ObjectHelper.requireNonNull((Object)replayBuffer, (String)"onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done) {
            RxJavaPlugins.onError((Throwable)replayBuffer);
            return;
        }
        this.done = true;
        ReplayDisposable<T>[] replayDisposableArray = NotificationLite.error((Throwable)replayBuffer);
        replayBuffer = this.buffer;
        replayBuffer.addFinal((Object)replayDisposableArray);
        replayDisposableArray = this.terminate(replayDisposableArray);
        int n = replayDisposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            replayBuffer.replay(replayDisposableArray[n2]);
            ++n2;
        }
    }

    public void onNext(T object) {
        ObjectHelper.requireNonNull(object, (String)"onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done) {
            return;
        }
        ReplayBuffer<T> replayBuffer = this.buffer;
        replayBuffer.add(object);
        object = this.observers.get();
        int n = ((T)object).length;
        int n2 = 0;
        while (n2 < n) {
            replayBuffer.replay(object[n2]);
            ++n2;
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (!this.done) return;
        disposable.dispose();
    }

    void remove(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable[] replayDisposableArray;
        ReplayDisposable<T>[] replayDisposableArray2;
        do {
            int n;
            if ((replayDisposableArray2 = this.observers.get()) == TERMINATED) return;
            if (replayDisposableArray2 == EMPTY) return;
            int n2 = replayDisposableArray2.length;
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n = n3;
                if (n4 >= n2) break;
                if (replayDisposableArray2[n4] == replayDisposable) {
                    n = n4;
                    break;
                }
                ++n4;
            }
            if (n < 0) {
                return;
            }
            if (n2 == 1) {
                replayDisposableArray = EMPTY;
                continue;
            }
            replayDisposableArray = new ReplayDisposable[n2 - 1];
            System.arraycopy(replayDisposableArray2, 0, replayDisposableArray, 0, n);
            System.arraycopy(replayDisposableArray2, n + 1, replayDisposableArray, n, n2 - n - 1);
        } while (!this.observers.compareAndSet(replayDisposableArray2, replayDisposableArray));
    }

    int size() {
        return this.buffer.size();
    }

    protected void subscribeActual(Observer<? super T> observer) {
        ReplayDisposable replayDisposable = new ReplayDisposable(observer, this);
        observer.onSubscribe((Disposable)replayDisposable);
        if (replayDisposable.cancelled) return;
        if (this.add(replayDisposable) && replayDisposable.cancelled) {
            this.remove(replayDisposable);
            return;
        }
        this.buffer.replay(replayDisposable);
    }

    ReplayDisposable<T>[] terminate(Object object) {
        if (!this.buffer.compareAndSet(null, object)) return TERMINATED;
        return this.observers.getAndSet(TERMINATED);
    }
}
