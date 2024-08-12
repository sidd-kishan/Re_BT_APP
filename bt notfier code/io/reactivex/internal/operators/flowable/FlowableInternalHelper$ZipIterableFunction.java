/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.functions.Function
 *  org.reactivestreams.Publisher
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.List;
import org.reactivestreams.Publisher;

static final class FlowableInternalHelper.ZipIterableFunction<T, R>
implements Function<List<Publisher<? extends T>>, Publisher<? extends R>> {
    private final Function<? super Object[], ? extends R> zipper;

    FlowableInternalHelper.ZipIterableFunction(Function<? super Object[], ? extends R> function) {
        this.zipper = function;
    }

    public Publisher<? extends R> apply(List<Publisher<? extends T>> list) {
        return Flowable.zipIterable(list, this.zipper, (boolean)false, (int)Flowable.bufferSize());
    }
}
