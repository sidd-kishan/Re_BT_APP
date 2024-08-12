/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.AbstractDaoSession
 *  org.greenrobot.greendao.rx.RxBase
 *  rx.Observable
 *  rx.Scheduler
 */
package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.rx.RxBase;
import rx.Observable;
import rx.Scheduler;

public class RxTransaction
extends RxBase {
    private final AbstractDaoSession daoSession;

    public RxTransaction(AbstractDaoSession abstractDaoSession) {
        this.daoSession = abstractDaoSession;
    }

    public RxTransaction(AbstractDaoSession abstractDaoSession, Scheduler scheduler) {
        super(scheduler);
        this.daoSession = abstractDaoSession;
    }

    static /* synthetic */ AbstractDaoSession access$000(RxTransaction rxTransaction) {
        return rxTransaction.daoSession;
    }

    public <T> Observable<T> call(Callable<T> callable) {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public AbstractDaoSession getDaoSession() {
        return this.daoSession;
    }

    public Observable<Void> run(Runnable runnable) {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }
}
