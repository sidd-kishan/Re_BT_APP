/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.subjects.SingleSubject
 */
package io.reactivex.subjects;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.SingleSubject;
import java.util.concurrent.atomic.AtomicReference;

static final class SingleSubject.SingleDisposable<T>
extends AtomicReference<SingleSubject<T>>
implements Disposable {
    private static final long serialVersionUID = -7650903191002190468L;
    final SingleObserver<? super T> downstream;

    SingleSubject.SingleDisposable(SingleObserver<? super T> singleObserver, SingleSubject<T> singleSubject) {
        this.downstream = singleObserver;
        this.lazySet(singleSubject);
    }

    public void dispose() {
        SingleSubject singleSubject = this.getAndSet(null);
        if (singleSubject == null) return;
        singleSubject.remove(this);
    }

    public boolean isDisposed() {
        boolean bl = this.get() == null;
        return bl;
    }
}
