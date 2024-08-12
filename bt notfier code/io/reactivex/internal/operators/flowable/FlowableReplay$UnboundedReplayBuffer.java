/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription
 *  io.reactivex.internal.operators.flowable.FlowableReplay$ReplayBuffer
 *  io.reactivex.internal.util.NotificationLite
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.flowable.FlowableReplay;
import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;
import org.reactivestreams.Subscriber;

static final class FlowableReplay.UnboundedReplayBuffer<T>
extends ArrayList<Object>
implements FlowableReplay.ReplayBuffer<T> {
    private static final long serialVersionUID = 7063189396499112664L;
    volatile int size;

    FlowableReplay.UnboundedReplayBuffer(int n) {
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

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public void replay(FlowableReplay.InnerSubscription<T> innerSubscription) {
        Subscriber subscriber;
        synchronized (innerSubscription) {
            if (innerSubscription.emitting) {
                innerSubscription.missed = true;
                return;
            }
            innerSubscription.emitting = true;
            // MONITOREXIT @DISABLED, blocks:[0, 4] lbl8 : MonitorExitStatement: MONITOREXIT : var1_1
            subscriber = innerSubscription.child;
            {
                catch (Throwable throwable) {}
                {
                    throw throwable;
                }
            }
        }
        while (!innerSubscription.isDisposed()) {
            long l;
            int n = this.size;
            Integer n2 = (Integer)innerSubscription.index();
            int n3 = n2 != null ? n2 : 0;
            long l2 = 0L;
            for (long i = l = innerSubscription.get(); i != 0L && n3 < n; ++n3, --i, ++l2) {
                Object e = this.get(n3);
                try {
                    boolean bl = NotificationLite.accept(e, (Subscriber)subscriber);
                    if (bl) {
                        return;
                    }
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    innerSubscription.dispose();
                    if (NotificationLite.isError(e)) return;
                    if (NotificationLite.isComplete(e)) return;
                    subscriber.onError(throwable);
                    return;
                }
                if (!innerSubscription.isDisposed()) continue;
                return;
            }
            if (l2 != 0L) {
                innerSubscription.index = n3;
                if (l != Long.MAX_VALUE) {
                    innerSubscription.produced(l2);
                }
            }
            synchronized (innerSubscription) {
                if (!innerSubscription.missed) {
                    innerSubscription.emitting = false;
                    return;
                }
                innerSubscription.missed = false;
            }
        }
        return;
    }
}
