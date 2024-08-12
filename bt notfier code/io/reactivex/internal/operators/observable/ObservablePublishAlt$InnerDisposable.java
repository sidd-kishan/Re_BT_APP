/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.observable.ObservablePublishAlt$PublishConnection
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservablePublishAlt;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservablePublishAlt.InnerDisposable<T>
extends AtomicReference<ObservablePublishAlt.PublishConnection<T>>
implements Disposable {
    private static final long serialVersionUID = 7463222674719692880L;
    final Observer<? super T> downstream;

    public ObservablePublishAlt.InnerDisposable(Observer<? super T> observer, ObservablePublishAlt.PublishConnection<T> publishConnection) {
        this.downstream = observer;
        this.lazySet(publishConnection);
    }

    public void dispose() {
        ObservablePublishAlt.PublishConnection publishConnection = this.getAndSet(null);
        if (publishConnection == null) return;
        publishConnection.remove(this);
    }

    public boolean isDisposed() {
        boolean bl = this.get() == null;
        return bl;
    }
}
