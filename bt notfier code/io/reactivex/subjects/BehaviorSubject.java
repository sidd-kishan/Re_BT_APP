/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.internal.util.NotificationLite
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.subjects.BehaviorSubject$BehaviorDisposable
 *  io.reactivex.subjects.Subject
 */
package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class BehaviorSubject<T>
extends Subject<T> {
    static final BehaviorDisposable[] EMPTY;
    private static final Object[] EMPTY_ARRAY;
    static final BehaviorDisposable[] TERMINATED;
    long index;
    final ReadWriteLock lock;
    final Lock readLock;
    final AtomicReference<BehaviorDisposable<T>[]> subscribers;
    final AtomicReference<Throwable> terminalEvent;
    final AtomicReference<Object> value;
    final Lock writeLock;

    static {
        EMPTY_ARRAY = new Object[0];
        EMPTY = new BehaviorDisposable[0];
        TERMINATED = new BehaviorDisposable[0];
    }

    BehaviorSubject() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.lock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = this.lock.writeLock();
        this.subscribers = new AtomicReference<BehaviorDisposable[]>(EMPTY);
        this.value = new AtomicReference();
        this.terminalEvent = new AtomicReference();
    }

    BehaviorSubject(T t) {
        this();
        this.value.lazySet(ObjectHelper.requireNonNull(t, (String)"defaultValue is null"));
    }

    @CheckReturnValue
    public static <T> BehaviorSubject<T> create() {
        return new BehaviorSubject<T>();
    }

    @CheckReturnValue
    public static <T> BehaviorSubject<T> createDefault(T t) {
        return new BehaviorSubject<T>(t);
    }

    boolean add(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable[] behaviorDisposableArray;
        BehaviorDisposable<T>[] behaviorDisposableArray2;
        do {
            if ((behaviorDisposableArray2 = this.subscribers.get()) == TERMINATED) {
                return false;
            }
            int n = behaviorDisposableArray2.length;
            behaviorDisposableArray = new BehaviorDisposable[n + 1];
            System.arraycopy(behaviorDisposableArray2, 0, behaviorDisposableArray, 0, n);
            behaviorDisposableArray[n] = behaviorDisposable;
        } while (!this.subscribers.compareAndSet(behaviorDisposableArray2, behaviorDisposableArray));
        return true;
    }

    public Throwable getThrowable() {
        Object object = this.value.get();
        if (!NotificationLite.isError((Object)object)) return null;
        return NotificationLite.getError((Object)object);
    }

    public T getValue() {
        Object object = this.value.get();
        if (NotificationLite.isComplete((Object)object)) return null;
        if (!NotificationLite.isError((Object)object)) return (T)NotificationLite.getValue((Object)object);
        return null;
    }

    @Deprecated
    public Object[] getValues() {
        Object[] objectArray;
        Object[] objectArray2 = objectArray = this.getValues(EMPTY_ARRAY);
        if (objectArray != EMPTY_ARRAY) return objectArray2;
        objectArray2 = new Object[]{};
        return objectArray2;
    }

    @Deprecated
    public T[] getValues(T[] TArray) {
        Object[] objectArray = this.value.get();
        if (objectArray != null && !NotificationLite.isComplete((Object)objectArray) && !NotificationLite.isError((Object)objectArray)) {
            Object object = NotificationLite.getValue((Object)objectArray);
            if (TArray.length != 0) {
                TArray[0] = object;
                objectArray = TArray;
                if (TArray.length == 1) return objectArray;
                TArray[1] = null;
                objectArray = TArray;
            } else {
                objectArray = (Object[])Array.newInstance(TArray.getClass().getComponentType(), 1);
                objectArray[0] = object;
            }
            return objectArray;
        }
        if (TArray.length == 0) return TArray;
        TArray[0] = null;
        return TArray;
    }

    public boolean hasComplete() {
        return NotificationLite.isComplete((Object)this.value.get());
    }

    public boolean hasObservers() {
        boolean bl = this.subscribers.get().length != 0;
        return bl;
    }

    public boolean hasThrowable() {
        return NotificationLite.isError((Object)this.value.get());
    }

    public boolean hasValue() {
        Object object = this.value.get();
        boolean bl = object != null && !NotificationLite.isComplete((Object)object) && !NotificationLite.isError((Object)object);
        return bl;
    }

    public void onComplete() {
        if (!this.terminalEvent.compareAndSet(null, ExceptionHelper.TERMINATED)) {
            return;
        }
        Object object = NotificationLite.complete();
        BehaviorDisposable<T>[] behaviorDisposableArray = this.terminate(object);
        int n = behaviorDisposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            behaviorDisposableArray[n2].emitNext(object, this.index);
            ++n2;
        }
    }

    public void onError(Throwable object) {
        ObjectHelper.requireNonNull((Object)object, (String)"onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.terminalEvent.compareAndSet(null, (Throwable)object)) {
            RxJavaPlugins.onError((Throwable)object);
            return;
        }
        object = NotificationLite.error((Throwable)object);
        BehaviorDisposable<T>[] behaviorDisposableArray = this.terminate(object);
        int n = behaviorDisposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            behaviorDisposableArray[n2].emitNext(object, this.index);
            ++n2;
        }
    }

    public void onNext(T object) {
        ObjectHelper.requireNonNull(object, (String)"onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.terminalEvent.get() != null) {
            return;
        }
        object = NotificationLite.next(object);
        this.setCurrent(object);
        BehaviorDisposable<T>[] behaviorDisposableArray = this.subscribers.get();
        int n = behaviorDisposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            behaviorDisposableArray[n2].emitNext(object, this.index);
            ++n2;
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.terminalEvent.get() == null) return;
        disposable.dispose();
    }

    void remove(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable[] behaviorDisposableArray;
        BehaviorDisposable<T>[] behaviorDisposableArray2;
        do {
            int n;
            int n2;
            if ((n2 = (behaviorDisposableArray2 = this.subscribers.get()).length) == 0) {
                return;
            }
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n = n3;
                if (n4 >= n2) break;
                if (behaviorDisposableArray2[n4] == behaviorDisposable) {
                    n = n4;
                    break;
                }
                ++n4;
            }
            if (n < 0) {
                return;
            }
            if (n2 == 1) {
                behaviorDisposableArray = EMPTY;
                continue;
            }
            behaviorDisposableArray = new BehaviorDisposable[n2 - 1];
            System.arraycopy(behaviorDisposableArray2, 0, behaviorDisposableArray, 0, n);
            System.arraycopy(behaviorDisposableArray2, n + 1, behaviorDisposableArray, n, n2 - n - 1);
        } while (!this.subscribers.compareAndSet(behaviorDisposableArray2, behaviorDisposableArray));
    }

    void setCurrent(Object object) {
        this.writeLock.lock();
        ++this.index;
        this.value.lazySet(object);
        this.writeLock.unlock();
    }

    protected void subscribeActual(Observer<? super T> observer) {
        Object object = new BehaviorDisposable(observer, this);
        observer.onSubscribe((Disposable)object);
        if (this.add((BehaviorDisposable<T>)object)) {
            if (object.cancelled) {
                this.remove((BehaviorDisposable<T>)object);
            } else {
                object.emitFirst();
            }
        } else {
            object = this.terminalEvent.get();
            if (object == ExceptionHelper.TERMINATED) {
                observer.onComplete();
            } else {
                observer.onError((Throwable)object);
            }
        }
    }

    int subscriberCount() {
        return this.subscribers.get().length;
    }

    BehaviorDisposable<T>[] terminate(Object object) {
        BehaviorDisposable[] behaviorDisposableArray = this.subscribers.getAndSet(TERMINATED);
        if (behaviorDisposableArray == TERMINATED) return behaviorDisposableArray;
        this.setCurrent(object);
        return behaviorDisposableArray;
    }
}
