/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable
 *  io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservablePublish;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservablePublish.PublishSource<T>
implements ObservableSource<T> {
    private final AtomicReference<ObservablePublish.PublishObserver<T>> curr;

    ObservablePublish.PublishSource(AtomicReference<ObservablePublish.PublishObserver<T>> atomicReference) {
        this.curr = atomicReference;
    }

    public void subscribe(Observer<? super T> publishObserver) {
        ObservablePublish.InnerDisposable innerDisposable = new ObservablePublish.InnerDisposable(publishObserver);
        publishObserver.onSubscribe((Disposable)innerDisposable);
        while (true) {
            block4: {
                ObservablePublish.PublishObserver<T> publishObserver2;
                block3: {
                    if ((publishObserver2 = this.curr.get()) == null) break block3;
                    publishObserver = publishObserver2;
                    if (!publishObserver2.isDisposed()) break block4;
                }
                if (!this.curr.compareAndSet(publishObserver2, publishObserver = new ObservablePublish.PublishObserver(this.curr))) continue;
            }
            if (publishObserver.add(innerDisposable)) break;
        }
        innerDisposable.setParent(publishObserver);
    }
}
