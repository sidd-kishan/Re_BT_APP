/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.ObservableWithLatestFromMany
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany;

final class ObservableWithLatestFromMany.SingletonArrayFunc
implements Function<T, R> {
    final ObservableWithLatestFromMany this$0;

    ObservableWithLatestFromMany.SingletonArrayFunc(ObservableWithLatestFromMany observableWithLatestFromMany) {
        this.this$0 = observableWithLatestFromMany;
    }

    public R apply(T t) throws Exception {
        return ObjectHelper.requireNonNull((Object)this.this$0.combiner.apply((Object)new Object[]{t}), (String)"The combiner returned a null value");
    }
}
