/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.subjects.CompletableSubject
 */
package io.reactivex.subjects;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.CompletableSubject;
import java.util.concurrent.atomic.AtomicReference;

static final class CompletableSubject.CompletableDisposable
extends AtomicReference<CompletableSubject>
implements Disposable {
    private static final long serialVersionUID = -7650903191002190468L;
    final CompletableObserver downstream;

    CompletableSubject.CompletableDisposable(CompletableObserver completableObserver, CompletableSubject completableSubject) {
        this.downstream = completableObserver;
        this.lazySet(completableSubject);
    }

    public void dispose() {
        CompletableSubject completableSubject = this.getAndSet(null);
        if (completableSubject == null) return;
        completableSubject.remove(this);
    }

    public boolean isDisposed() {
        boolean bl = this.get() == null;
        return bl;
    }
}
