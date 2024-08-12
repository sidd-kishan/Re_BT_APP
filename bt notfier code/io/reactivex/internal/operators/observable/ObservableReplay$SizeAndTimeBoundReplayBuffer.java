/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.observable.ObservableReplay$BoundedReplayBuffer
 *  io.reactivex.internal.operators.observable.ObservableReplay$Node
 *  io.reactivex.internal.util.NotificationLite
 *  io.reactivex.schedulers.Timed
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Scheduler;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;

static final class ObservableReplay.SizeAndTimeBoundReplayBuffer<T>
extends ObservableReplay.BoundedReplayBuffer<T> {
    private static final long serialVersionUID = 3457957419649567404L;
    final int limit;
    final long maxAge;
    final Scheduler scheduler;
    final TimeUnit unit;

    ObservableReplay.SizeAndTimeBoundReplayBuffer(int n, long l, TimeUnit timeUnit, Scheduler scheduler) {
        this.scheduler = scheduler;
        this.limit = n;
        this.maxAge = l;
        this.unit = timeUnit;
    }

    Object enterTransform(Object object) {
        return new Timed(object, this.scheduler.now(this.unit), this.unit);
    }

    ObservableReplay.Node getHead() {
        long l = this.scheduler.now(this.unit);
        long l2 = this.maxAge;
        ObservableReplay.Node node = (ObservableReplay.Node)this.get();
        ObservableReplay.Node node2 = (ObservableReplay.Node)node.get();
        while (node2 != null) {
            Timed timed = (Timed)node2.value;
            if (NotificationLite.isComplete((Object)timed.value())) return node;
            if (NotificationLite.isError((Object)timed.value())) return node;
            if (timed.time() > l - l2) return node;
            timed = (ObservableReplay.Node)node2.get();
            node = node2;
            node2 = timed;
        }
        return node;
    }

    Object leaveTransform(Object object) {
        return ((Timed)object).value();
    }

    void truncate() {
        long l = this.scheduler.now(this.unit);
        long l2 = this.maxAge;
        ObservableReplay.Node node = (ObservableReplay.Node)this.get();
        ObservableReplay.Node node2 = (ObservableReplay.Node)node.get();
        int n = 0;
        while (node2 != null) {
            ObservableReplay.Node node3;
            if (this.size > this.limit) {
                ++n;
                --this.size;
                node3 = (ObservableReplay.Node)node2.get();
                node = node2;
                node2 = node3;
                continue;
            }
            if (((Timed)node2.value).time() > l - l2) break;
            ++n;
            --this.size;
            node3 = (ObservableReplay.Node)node2.get();
            node = node2;
            node2 = node3;
        }
        if (n == 0) return;
        this.setFirst(node);
    }

    void truncateFinal() {
        long l = this.scheduler.now(this.unit);
        long l2 = this.maxAge;
        ObservableReplay.Node node = (ObservableReplay.Node)this.get();
        ObservableReplay.Node node2 = (ObservableReplay.Node)node.get();
        int n = 0;
        while (node2 != null && this.size > 1 && ((Timed)node2.value).time() <= l - l2) {
            ++n;
            --this.size;
            ObservableReplay.Node node3 = (ObservableReplay.Node)node2.get();
            node = node2;
            node2 = node3;
        }
        if (n == 0) return;
        this.setFirst(node);
    }
}
