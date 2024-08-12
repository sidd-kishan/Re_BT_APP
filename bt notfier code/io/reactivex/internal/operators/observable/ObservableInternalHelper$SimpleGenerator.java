/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Emitter
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.Consumer
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

static final class ObservableInternalHelper.SimpleGenerator<T, S>
implements BiFunction<S, Emitter<T>, S> {
    final Consumer<Emitter<T>> consumer;

    ObservableInternalHelper.SimpleGenerator(Consumer<Emitter<T>> consumer) {
        this.consumer = consumer;
    }

    public S apply(S s, Emitter<T> emitter) throws Exception {
        this.consumer.accept(emitter);
        return s;
    }
}
