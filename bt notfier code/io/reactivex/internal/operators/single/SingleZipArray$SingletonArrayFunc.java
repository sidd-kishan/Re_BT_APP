/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.single.SingleZipArray
 */
package io.reactivex.internal.operators.single;

import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleZipArray;

final class SingleZipArray.SingletonArrayFunc
implements Function<T, R> {
    final SingleZipArray this$0;

    SingleZipArray.SingletonArrayFunc(SingleZipArray singleZipArray) {
        this.this$0 = singleZipArray;
    }

    public R apply(T t) throws Exception {
        return ObjectHelper.requireNonNull((Object)this.this$0.zipper.apply((Object)new Object[]{t}), (String)"The zipper returned a null value");
    }
}
