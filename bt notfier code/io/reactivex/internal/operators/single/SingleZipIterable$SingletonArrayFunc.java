/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.single.SingleZipIterable
 */
package io.reactivex.internal.operators.single;

import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleZipIterable;

final class SingleZipIterable.SingletonArrayFunc
implements Function<T, R> {
    final SingleZipIterable this$0;

    SingleZipIterable.SingletonArrayFunc(SingleZipIterable singleZipIterable) {
        this.this$0 = singleZipIterable;
    }

    public R apply(T t) throws Exception {
        return ObjectHelper.requireNonNull((Object)this.this$0.zipper.apply((Object)new Object[]{t}), (String)"The zipper returned a null value");
    }
}
