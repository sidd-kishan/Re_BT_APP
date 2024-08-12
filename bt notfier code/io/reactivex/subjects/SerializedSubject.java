/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.util.AppendOnlyLinkedArrayList
 *  io.reactivex.internal.util.AppendOnlyLinkedArrayList$NonThrowingPredicate
 *  io.reactivex.internal.util.NotificationLite
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.subjects.Subject
 */
package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.Subject;

final class SerializedSubject<T>
extends Subject<T>
implements AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
    final Subject<T> actual;
    volatile boolean done;
    boolean emitting;
    AppendOnlyLinkedArrayList<Object> queue;

    SerializedSubject(Subject<T> subject) {
        this.actual = subject;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    void emitLoop() {
        while (true) {
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
    }

    public Throwable getThrowable() {
        return this.actual.getThrowable();
    }

    public boolean hasComplete() {
        return this.actual.hasComplete();
    }

    public boolean hasObservers() {
        return this.actual.hasObservers();
    }

    public boolean hasThrowable() {
        return this.actual.hasThrowable();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onComplete() {
        if (this.done) {
            return;
        }
        synchronized (this) {
            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
            if (this.done) {
                return;
            }
            this.done = true;
            if (!this.emitting) {
                this.emitting = true;
                // MONITOREXIT @DISABLED, blocks:[2, 4] lbl10 : MonitorExitStatement: MONITOREXIT : this
                this.actual.onComplete();
                return;
            }
            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList2 = appendOnlyLinkedArrayList = this.queue;
            if (appendOnlyLinkedArrayList == null) {
                this.queue = appendOnlyLinkedArrayList2 = new AppendOnlyLinkedArrayList(4);
            }
            appendOnlyLinkedArrayList2.add(NotificationLite.complete());
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        // MONITORENTER : this
        boolean bl = this.done;
        boolean bl2 = true;
        if (!bl) {
            this.done = true;
            if (this.emitting) {
                AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
                AppendOnlyLinkedArrayList appendOnlyLinkedArrayList2 = appendOnlyLinkedArrayList = this.queue;
                if (appendOnlyLinkedArrayList == null) {
                    this.queue = appendOnlyLinkedArrayList2 = new AppendOnlyLinkedArrayList(4);
                }
                appendOnlyLinkedArrayList2.setFirst(NotificationLite.error((Throwable)throwable));
                // MONITOREXIT : this
                return;
            }
            this.emitting = true;
            bl2 = false;
        }
        // MONITOREXIT : this
        if (bl2) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.actual.onError(throwable);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        synchronized (this) {
            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
            if (this.done) {
                return;
            }
            if (!this.emitting) {
                this.emitting = true;
                // MONITOREXIT @DISABLED, blocks:[2, 4] lbl9 : MonitorExitStatement: MONITOREXIT : this
                this.actual.onNext(t);
                this.emitLoop();
                return;
            }
            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList2 = appendOnlyLinkedArrayList = this.queue;
            if (appendOnlyLinkedArrayList == null) {
                this.queue = appendOnlyLinkedArrayList2 = new AppendOnlyLinkedArrayList(4);
            }
            appendOnlyLinkedArrayList2.add(NotificationLite.next(t));
            return;
        }
    }

    public void onSubscribe(Disposable disposable) {
        boolean bl = this.done;
        boolean bl2 = true;
        boolean bl3 = true;
        if (!bl) {
            synchronized (this) {
                if (this.done) {
                    bl2 = bl3;
                } else {
                    if (this.emitting) {
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList2 = appendOnlyLinkedArrayList = this.queue;
                        if (appendOnlyLinkedArrayList == null) {
                            this.queue = appendOnlyLinkedArrayList2 = new AppendOnlyLinkedArrayList(4);
                        }
                        appendOnlyLinkedArrayList2.add(NotificationLite.disposable((Disposable)disposable));
                        return;
                    }
                    this.emitting = true;
                    bl2 = false;
                }
            }
        }
        if (bl2) {
            disposable.dispose();
        } else {
            this.actual.onSubscribe(disposable);
            this.emitLoop();
        }
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.actual.subscribe(observer);
    }

    public boolean test(Object object) {
        return NotificationLite.acceptFull((Object)object, this.actual);
    }
}
