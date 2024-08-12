/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservablePublish;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservablePublish.InnerDisposable<T>
extends AtomicReference<Object>
implements Disposable {
    private static final long serialVersionUID = -1100270633763673112L;
    final Observer<? super T> child;

    ObservablePublish.InnerDisposable(Observer<? super T> observer) {
        this.child = observer;
    }

    public void dispose() {
        ObservablePublish.InnerDisposable innerDisposable = this.getAndSet(this);
        if (innerDisposable == null) return;
        if (innerDisposable == this) return;
        ((ObservablePublish.PublishObserver)innerDisposable).remove(this);
    }

    public boolean isDisposed() {
        boolean bl = this.get() == this;
        return bl;
    }

    void setParent(ObservablePublish.PublishObserver<T> publishObserver) {
        if (this.compareAndSet(null, publishObserver)) return;
        publishObserver.remove(this);
    }
}
