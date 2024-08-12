/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.query.Query
 *  org.greenrobot.greendao.rx.RxBase
 *  rx.Observable
 *  rx.Observable$OnSubscribe
 *  rx.Scheduler
 */
package org.greenrobot.greendao.rx;

import java.util.List;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.rx.RxBase;
import rx.Observable;
import rx.Scheduler;

public class RxQuery<T>
extends RxBase {
    private final Query<T> query;

    public RxQuery(Query<T> query) {
        this.query = query;
    }

    public RxQuery(Query<T> query, Scheduler scheduler) {
        super(scheduler);
        this.query = query;
    }

    static /* synthetic */ Query access$000(RxQuery rxQuery) {
        return rxQuery.query;
    }

    public Observable<List<T>> list() {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Observable<T> oneByOne() {
        return this.wrap(Observable.create((Observable.OnSubscribe)new /* Unavailable Anonymous Inner Class!! */));
    }

    public Observable<T> unique() {
        return this.wrap((Callable)new /* Unavailable Anonymous Inner Class!! */);
    }
}
