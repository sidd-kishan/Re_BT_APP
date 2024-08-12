/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.util.AppendOnlyLinkedArrayList
 *  io.reactivex.internal.util.NotificationLite
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;

public final class SerializedObserver<T>
implements Observer<T>,
Disposable {
    static final int QUEUE_LINK_SIZE = 4;
    final boolean delayError;
    volatile boolean done;
    final Observer<? super T> downstream;
    boolean emitting;
    AppendOnlyLinkedArrayList<Object> queue;
    Disposable upstream;

    public SerializedObserver(Observer<? super T> observer) {
        this(observer, false);
    }

    public SerializedObserver(Observer<? super T> observer, boolean bl) {
        this.downstream = observer;
        this.delayError = bl;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    void emitLoop() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.queue;
                if (appendOnlyLinkedArrayList == null) {
                    this.emitting = false;
                    return;
                }
                this.queue = null;
                continue;
                {
                    catch (Throwable throwable) {}
                    {
                        throw throwable;
                    }
                }
            }
        } while (!appendOnlyLinkedArrayList.accept(this.downstream));
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
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
            if (!this.emitting) {
                this.done = true;
                this.emitting = true;
                // MONITOREXIT @DISABLED, blocks:[2, 4] lbl10 : MonitorExitStatement: MONITOREXIT : this
                this.downstream.onComplete();
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
    public void onError(Throwable object) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)object);
            return;
        }
        // MONITORENTER : this
        boolean bl = this.done;
        boolean bl2 = true;
        if (!bl) {
            if (this.emitting) {
                AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
                this.done = true;
                AppendOnlyLinkedArrayList appendOnlyLinkedArrayList2 = appendOnlyLinkedArrayList = this.queue;
                if (appendOnlyLinkedArrayList == null) {
                    this.queue = appendOnlyLinkedArrayList2 = new AppendOnlyLinkedArrayList(4);
                }
                object = NotificationLite.error((Throwable)object);
                if (this.delayError) {
                    appendOnlyLinkedArrayList2.add(object);
                    return;
                }
                appendOnlyLinkedArrayList2.setFirst(object);
                // MONITOREXIT : this
                return;
            }
            this.done = true;
            this.emitting = true;
            bl2 = false;
        }
        // MONITOREXIT : this
        if (bl2) {
            RxJavaPlugins.onError((Throwable)object);
            return;
        }
        this.downstream.onError((Throwable)object);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (t == null) {
            this.upstream.dispose();
            this.onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
            if (this.done) {
                return;
            }
            if (!this.emitting) {
                this.emitting = true;
                // MONITOREXIT @DISABLED, blocks:[2, 4] lbl13 : MonitorExitStatement: MONITOREXIT : this
                this.downstream.onNext(t);
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
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
