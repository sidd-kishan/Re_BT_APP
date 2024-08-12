/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.maybe.MaybeZipIterable
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeZipIterable;

final class MaybeZipIterable.SingletonArrayFunc
implements Function<T, R> {
    final MaybeZipIterable this$0;

    MaybeZipIterable.SingletonArrayFunc(MaybeZipIterable maybeZipIterable) {
        this.this$0 = maybeZipIterable;
    }

    public R apply(T t) throws Exception {
        return ObjectHelper.requireNonNull((Object)this.this$0.zipper.apply((Object)new Object[]{t}), (String)"The zipper returned a null value");
    }
}
