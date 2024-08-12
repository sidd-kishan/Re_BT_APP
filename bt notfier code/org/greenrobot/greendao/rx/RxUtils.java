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

class RxUtils {
    RxUtils() {
    }

    static <T> Observable<T> fromCallable(Callable<T> callable) {
        return Observable.defer((Func0)new /* Unavailable Anonymous Inner Class!! */);
    }
}
