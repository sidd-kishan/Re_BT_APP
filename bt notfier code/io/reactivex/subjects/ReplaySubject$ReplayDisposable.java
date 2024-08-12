/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.subjects.ReplaySubject
 */
package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.ReplaySubject;
import java.util.concurrent.atomic.AtomicInteger;

static final class ReplaySubject.ReplayDisposable<T>
extends AtomicInteger
implements Disposable {
    private static final long serialVersionUID = 466549804534799122L;
    volatile boolean cancelled;
    final Observer<? super T> downstream;
    Object index;
    final ReplaySubject<T> state;

    ReplaySubject.ReplayDisposable(Observer<? super T> observer, ReplaySubject<T> replaySubject) {
        this.downstream = observer;
        this.state = replaySubject;
    }

    public void dispose() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.state.remove(this);
    }

    public boolean isDisposed() {
        return this.cancelled;
    }
}
