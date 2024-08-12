/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.maybe.MaybeZipArray
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeZipArray;

final class MaybeZipArray.SingletonArrayFunc
implements Function<T, R> {
    final MaybeZipArray this$0;

    MaybeZipArray.SingletonArrayFunc(MaybeZipArray maybeZipArray) {
        this.this$0 = maybeZipArray;
    }

    public R apply(T t) throws Exception {
        return ObjectHelper.requireNonNull((Object)this.this$0.zipper.apply((Object)new Object[]{t}), (String)"The zipper returned a null value");
    }
}
