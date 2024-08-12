/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.query.LazyList
 *  org.greenrobot.greendao.rx.RxQuery
 *  rx.Observable$OnSubscribe
 *  rx.Subscriber
 *  rx.exceptions.Exceptions
 */
package org.greenrobot.greendao.rx;

import org.greenrobot.greendao.query.LazyList;
import org.greenrobot.greendao.rx.RxQuery;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;

/*
 * Exception performing whole class analysis ignored.
 */
class RxQuery.3
implements Observable.OnSubscribe<T> {
    final RxQuery this$0;

    RxQuery.3(RxQuery rxQuery) {
        this.this$0 = rxQuery;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public void call(Subscriber<? super T> subscriber) {
        block7: {
            LazyList lazyList;
            try {
                lazyList = RxQuery.access$000((RxQuery)this.this$0).forCurrentThread().listLazyUncached();
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                subscriber.onError(throwable);
                break block7;
            }
            try {
                for (Object e : lazyList) {
                    block8: {
                        if (!subscriber.isUnsubscribed()) break block8;
                        break;
                    }
                    subscriber.onNext(e);
                }
            }
            finally {
                lazyList.close();
            }
            {
                if (subscriber.isUnsubscribed()) return;
                subscriber.onCompleted();
            }
        }
    }
}
