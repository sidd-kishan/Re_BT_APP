/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Emitter
 *  io.reactivex.functions.BiConsumer
 *  io.reactivex.functions.BiFunction
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;

static final class ObservableInternalHelper.SimpleBiGenerator<T, S>
implements BiFunction<S, Emitter<T>, S> {
    final BiConsumer<S, Emitter<T>> consumer;

    ObservableInternalHelper.SimpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
        this.consumer = biConsumer;
    }

    public S apply(S s, Emitter<T> emitter) throws Exception {
        this.consumer.accept(s, emitter);
        return s;
    }
}
