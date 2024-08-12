/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  rx.Observable
 *  rx.functions.Func0
 */
package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;
import rx.Observable;
import rx.functions.Func0;

static final class RxUtils.1
implements Func0<Observable<T>> {
    final Callable val$callable;

    RxUtils.1(Callable callable) {
        this.val$callable = callable;
    }

    public Observable<T> call() {
        Object v;
        try {
            v = this.val$callable.call();
        }
        catch (Exception exception) {
            return Observable.error((Throwable)exception);
        }
        return Observable.just(v);
    }
}
