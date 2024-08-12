/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.subjects.MaybeSubject
 */
package io.reactivex.subjects;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.MaybeSubject;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeSubject.MaybeDisposable<T>
extends AtomicReference<MaybeSubject<T>>
implements Disposable {
    private static final long serialVersionUID = -7650903191002190468L;
    final MaybeObserver<? super T> downstream;

    MaybeSubject.MaybeDisposable(MaybeObserver<? super T> maybeObserver, MaybeSubject<T> maybeSubject) {
        this.downstream = maybeObserver;
        this.lazySet(maybeSubject);
    }

    public void dispose() {
        MaybeSubject maybeSubject = this.getAndSet(null);
        if (maybeSubject == null) return;
        maybeSubject.remove(this);
    }

    public boolean isDisposed() {
        boolean bl = this.get() == null;
        return bl;
    }
}
