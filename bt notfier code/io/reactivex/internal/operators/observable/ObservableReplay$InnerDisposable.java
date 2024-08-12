/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableReplay;
import java.util.concurrent.atomic.AtomicInteger;

static final class ObservableReplay.InnerDisposable<T>
extends AtomicInteger
implements Disposable {
    private static final long serialVersionUID = 2728361546769921047L;
    volatile boolean cancelled;
    final Observer<? super T> child;
    Object index;
    final ObservableReplay.ReplayObserver<T> parent;

    ObservableReplay.InnerDisposable(ObservableReplay.ReplayObserver<T> replayObserver, Observer<? super T> observer) {
        this.parent = replayObserver;
        this.child = observer;
    }

    public void dispose() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.parent.remove(this);
        this.index = null;
    }

    <U> U index() {
        return (U)this.index;
    }

    public boolean isDisposed() {
        return this.cancelled;
    }
}
