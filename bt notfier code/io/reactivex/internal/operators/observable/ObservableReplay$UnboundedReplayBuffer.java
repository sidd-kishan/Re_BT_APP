/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable
 *  io.reactivex.internal.operators.observable.ObservableReplay$ReplayBuffer
 *  io.reactivex.internal.util.NotificationLite
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;

static final class ObservableReplay.UnboundedReplayBuffer<T>
extends ArrayList<Object>
implements ObservableReplay.ReplayBuffer<T> {
    private static final long serialVersionUID = 7063189396499112664L;
    volatile int size;

    ObservableReplay.UnboundedReplayBuffer(int n) {
        super(n);
    }

    public void complete() {
        this.add(NotificationLite.complete());
        ++this.size;
    }

    public void error(Throwable throwable) {
        this.add(NotificationLite.error((Throwable)throwable));
        ++this.size;
    }

    public void next(T t) {
        this.add(NotificationLite.next(t));
        ++this.size;
    }

    public void replay(ObservableReplay.InnerDisposable<T> innerDisposable) {
        int n;
        if (innerDisposable.getAndIncrement() != 0) {
            return;
        }
        Observer observer = innerDisposable.child;
        int n2 = 1;
        do {
            if (innerDisposable.isDisposed()) {
                return;
            }
            int n3 = this.size;
            for (n = (var5_6 = (Integer)innerDisposable.index()) != null ? var5_6 : 0; n < n3; ++n) {
                if (NotificationLite.accept(this.get(n), (Observer)observer)) {
                    return;
                }
                if (!innerDisposable.isDisposed()) continue;
                return;
            }
            innerDisposable.index = n;
            n2 = n = innerDisposable.addAndGet(-n2);
        } while (n != 0);
    }
}
