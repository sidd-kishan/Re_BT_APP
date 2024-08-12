/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.util.AppendOnlyLinkedArrayList
 *  io.reactivex.internal.util.AppendOnlyLinkedArrayList$NonThrowingPredicate
 *  io.reactivex.internal.util.NotificationLite
 *  io.reactivex.subjects.BehaviorSubject
 */
package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.BehaviorSubject;
import java.util.concurrent.locks.Lock;

static final class BehaviorSubject.BehaviorDisposable<T>
implements Disposable,
AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
    volatile boolean cancelled;
    final Observer<? super T> downstream;
    boolean emitting;
    boolean fastPath;
    long index;
    boolean next;
    AppendOnlyLinkedArrayList<Object> queue;
    final BehaviorSubject<T> state;

    BehaviorSubject.BehaviorDisposable(Observer<? super T> observer, BehaviorSubject<T> behaviorSubject) {
        this.downstream = observer;
        this.state = behaviorSubject;
    }

    public void dispose() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.state.remove(this);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void emitFirst() {
        Object object;
        if (this.cancelled) {
            return;
        }
        synchronized (this) {
            if (this.cancelled) {
                return;
            }
            if (this.next) {
                return;
            }
            object = this.state;
            Lock lock = object.readLock;
            lock.lock();
            this.index = object.index;
            object = object.value.get();
            lock.unlock();
            boolean bl = object != null;
            this.emitting = bl;
            this.next = true;
        }
        if (object == null) return;
        if (this.test(object)) {
            return;
        }
        this.emitLoop();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    void emitLoop() {
        while (!this.cancelled) {
            AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
            synchronized (this) {
                appendOnlyLinkedArrayList = this.queue;
                if (appendOnlyLinkedArrayList == null) {
                    this.emitting = false;
                    return;
                }
                this.queue = null;
                {
                    catch (Throwable throwable) {}
                    {
                        throw throwable;
                    }
                }
            }
            appendOnlyLinkedArrayList.forEachWhile((AppendOnlyLinkedArrayList.NonThrowingPredicate)this);
        }
        return;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void emitNext(Object object, long l) {
        if (this.cancelled) {
            return;
        }
        if (!this.fastPath) {
            synchronized (this) {
                if (this.cancelled) {
                    return;
                }
                if (this.index == l) {
                    return;
                }
                if (this.emitting) {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList2 = appendOnlyLinkedArrayList = this.queue;
                    if (appendOnlyLinkedArrayList == null) {
                        this.queue = appendOnlyLinkedArrayList2 = new AppendOnlyLinkedArrayList(4);
                    }
                    appendOnlyLinkedArrayList2.add(object);
                    return;
                }
                this.next = true;
            }
            this.fastPath = true;
        }
        this.test(object);
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public boolean test(Object object) {
        boolean bl = this.cancelled || NotificationLite.accept((Object)object, this.downstream);
        return bl;
    }
}
