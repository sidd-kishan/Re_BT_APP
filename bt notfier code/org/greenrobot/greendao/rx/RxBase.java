/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.rx.RxUtils
 *  rx.Observable
 *  rx.Scheduler
 */
package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;
import org.greenrobot.greendao.rx.RxUtils;
import rx.Observable;
import rx.Scheduler;

class RxBase {
    protected final Scheduler scheduler;

    RxBase() {
        this.scheduler = null;
    }

    RxBase(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public Scheduler getScheduler() {
        return this.scheduler;
    }

    protected <R> Observable<R> wrap(Callable<R> callable) {
        return this.wrap(RxUtils.fromCallable(callable));
    }

    protected <R> Observable<R> wrap(Observable<R> observable) {
        Scheduler scheduler = this.scheduler;
        Observable observable2 = observable;
        if (scheduler == null) return observable2;
        observable2 = observable.subscribeOn(scheduler);
        return observable2;
    }
}
